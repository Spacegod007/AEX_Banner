package logic.effectenbeurs;

import logic.Fonds;
import logic.IFonds;

import java.util.ArrayList;
import java.util.Collections;
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
            IFonds fondsA = new Fonds("A", 25);
            IFonds fondsB = new Fonds("B", 50);
            IFonds fondsC = new Fonds("C", 75);
        };
    }

    @Override
    public List<IFonds> getKoersen()
    {
        return Collections.unmodifiableList(fondsen);
    }
}
