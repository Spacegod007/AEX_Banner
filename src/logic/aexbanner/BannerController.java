package logic.aexbanner;

import logic.fontyspublisher.IRemotePropertyListener;
import logic.fontyspublisher.IRemotePublisherForListener;
import logic.shared.IFonds;

import java.beans.PropertyChangeEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * BannerController gets fonts at an interval of 2 seconds
 */
public class BannerController extends UnicastRemoteObject implements IRemotePropertyListener
{
    private IRemotePublisherForListener publisher;
    private AEXBanner banner;

    public BannerController(AEXBanner banner) throws RemoteException, NotBoundException
    {
        this.banner = banner;

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
        publisher = (IRemotePublisherForListener) registry.lookup("FondsenPublisher");
        publisher.subscribeRemoteListener(this, "fondsen");
    }

    private String convertkoersListToString(List<IFonds> koersen)
    {
        StringBuilder koersString = new StringBuilder();

        for (IFonds koers : koersen)
        {
            String koersname = koers.getName();
            String koersvalue = Double.toString(Math.floor(koers.getKoers() * 100));
            koersvalue = koersvalue.substring(0, koersvalue.length() - 2);
            koersvalue = koersvalue.substring(0, koersvalue.length() - 2) + "." + koersvalue.substring(koersvalue.length() - 2);
            koersString.append(koersname).append(": ").append(koersvalue).append(" ");
        }

        return koersString.toString();
    }

    public void stop() throws RemoteException
    {
            publisher.unsubscribeRemoteListener(this, "fondsen");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) throws RemoteException
    {
        List fondsen = (List<IFonds>) evt.getNewValue();
        banner.setKoersen(convertkoersListToString(fondsen));
    }
}
