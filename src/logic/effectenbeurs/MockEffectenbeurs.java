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
        fondsen = new ArrayList<>();
        fondsen.add(new Fonds("A", 25));
        fondsen.add(new Fonds("B", 50));
        fondsen.add(new Fonds("C", 75));
    }

    @Override
    public List<IFonds> getKoersen()
    {
         return Collections.unmodifiableList(fondsen);
    }
}
