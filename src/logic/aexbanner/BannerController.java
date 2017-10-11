package logic.aexbanner;

import logic.IFonds;
import logic.effectenbeurs.IEffectenbeurs;
import sample.AEXBanner;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Jordi van Roij on 11-Oct-17.
 */
public class BannerController {

    private IEffectenbeurs effectenbeurs;
    private AEXBanner banner;
    private Timer refreshTimer;

    public BannerController(AEXBanner banner)
    {
        this.banner = banner;
        refreshTimer = new Timer();
        refreshTimer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                List<IFonds> koersen = effectenbeurs.getKoersen();

            }
        }, 0, 2000);
    }

    public void stop()
    {

    }
}
