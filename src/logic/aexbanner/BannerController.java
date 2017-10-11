package logic.aexbanner;

import logic.effectenbeurs.IEffectenbeurs;
import sample.AEXBanner;

/**
 * Created by Jordi van Roij on 11-Oct-17.
 */
public class BannerController {

    private IEffectenbeurs effectenbeurs;
    private AEXBanner banner;

    public BannerController(AEXBanner banner)
    {
        this.banner = banner;
    }

    public void stop()
    {

    }
}
