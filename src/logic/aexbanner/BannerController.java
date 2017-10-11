package logic.aexbanner;

import logic.IFonds;
import logic.effectenbeurs.IEffectenbeurs;
import logic.effectenbeurs.MockEffectenbeurs;
import sample.AEXBanner;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Jordi van Roij on 11-Oct-17.
 */
public class BannerController
{

    private IEffectenbeurs effectenbeurs;
    private AEXBanner banner;
    private Timer refreshTimer;

    public BannerController(AEXBanner banner)
    {
        this.banner = banner;

        effectenbeurs = new MockEffectenbeurs();

        refreshTimer = new Timer();
        refreshTimer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                List<IFonds> fondsen = effectenbeurs.getKoersen();
                banner.setKoersen(convertkoersListToString(fondsen));
            }
        }, 0, 2000);
    }

    private String convertkoersListToString(List<IFonds> koersen)
    {
        String koersString = "";

        for (IFonds koers : koersen)
        {
            koersString += koers.toString() + " ";
        }

        return koersString;
    }

    public void stop()
    {
        refreshTimer.cancel();
    }
}
