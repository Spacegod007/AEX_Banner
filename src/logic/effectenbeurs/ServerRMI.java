package logic.effectenbeurs;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI
{
    private MockEffectenbeurs effectenbeurs;
    private Registry registry = null;
    private static final String bindingName = "effectenbeursBinding";
    private int portNumber = 1099;

    public ServerRMI()
    {
        // Create student administration
        try {
            effectenbeurs = new MockEffectenbeurs();
            System.out.println("Server: effectenbeurs created");
        } catch (RemoteException ex) {
            System.out.println("Server: Cannot create effectenbeurs");
            System.out.println("Server: RemoteException: " + ex.getMessage());
            effectenbeurs = null;
        }

        // Create registry at port number
        try {
            registry = LocateRegistry.createRegistry(portNumber);
            System.out.println("Server: Registry created on port number " + portNumber);
        } catch (RemoteException ex) {
            System.out.println("Server: Cannot create registry");
            System.out.println("Server: RemoteException: " + ex.getMessage());
            registry = null;
        }

        // Bind student administration using registry
        try {
            assert registry != null;
            registry.rebind(bindingName, effectenbeurs);
        } catch (RemoteException ex) {
            System.out.println("Server: Cannot bind effectenbeurs");
            System.out.println("Server: RemoteException: " + ex.getMessage());
        }
    }

    public static void main(String[] args) throws RemoteException
    {
        System.out.println("Server starting");

//        ServerRMI server = new ServerRMI();
        IEffectenbeurs beurs = new MockEffectenbeurs();
    }
}
