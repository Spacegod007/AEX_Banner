package logic.effectenbeurs;

import logic.IFonds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jordi van Roij on 11-Oct-17.
 */
public class MockEffectenbeurs implements IEffectenbeurs
{
    private List<IFonds> fondsen;

    public MockEffectenbeurs()
    {
        fondsen = new ArrayList<IFonds>(){
            
        };
    }

    @Override
    public List<IFonds> getKoersen()
    {
        return null;
    }
}
