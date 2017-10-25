package logic.aexbanner;

import logic.effectenbeurs.IEffectenbeurs;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI
{
    private IEffectenbeurs effectenbeurs;
    private Registry registry = null;
    private String bindingName = "effectenbeursBinding";
    private String ipAddress = "localhost";
    private int portNumber = 1099;

    public ClientRMI()
    {
        // Locate registry at IP address and port number
        try
        {
            registry = LocateRegistry.getRegistry(ipAddress, portNumber);
        } catch (RemoteException ex)
        {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: RemoteException: " + ex.getMessage());
            registry = null;
        }

        // Bind Stock exchange using registry
        if (registry != null) {
            try {
                effectenbeurs = (IEffectenbeurs) registry.lookup(bindingName);
            } catch (RemoteException ex) {
                System.out.println("Client: Cannot bind student administration");
                System.out.println("Client: RemoteException: " + ex.getMessage());
                effectenbeurs = null;
            } catch (NotBoundException ex) {
                System.out.println("Client: Cannot bind student administration");
                System.out.println("Client: NotBoundException: " + ex.getMessage());
                effectenbeurs = null;
            }
        }
    }

    public IEffectenbeurs getEffectenbeurs()
    {
        return effectenbeurs;
    }
}
