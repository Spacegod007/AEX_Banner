package logic.aexbanner;

import logic.shared.IFonds;
import logic.effectenbeurs.IEffectenbeurs;
import logic.effectenbeurs.MockEffectenbeurs;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * BannerController gets fonts at an interval of 2 seconds
 */
public class BannerController
{

    private final IEffectenbeurs effectenbeurs;
    private final Timer refreshTimer;

    public BannerController(AEXBanner banner) throws RemoteException
    {
        ClientRMI client = new ClientRMI();
        this.effectenbeurs = client.getEffectenbeurs();

        refreshTimer = new Timer();
        refreshTimer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                List<IFonds> fondsen = null;
                try
                {
                    fondsen = effectenbeurs.getKoersen();
                    banner.setKoersen(convertkoersListToString(fondsen));
                } catch (RemoteException e)
                {
                    e.printStackTrace();
                }
            }
        }, 0, 2000);
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

    public void stop()
    {
        refreshTimer.cancel();
    }
}
