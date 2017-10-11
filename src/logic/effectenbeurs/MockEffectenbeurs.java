package logic.effectenbeurs;

import logic.shared.Fonds;
import logic.shared.IFonds;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 * The stock exchange, where all sorts of interesting things happen
 */
public class MockEffectenbeurs extends UnicastRemoteObject implements IEffectenbeurs
{
    private final List<IFonds> fondsen;
    private final Random random;

    public MockEffectenbeurs() throws RemoteException
    {
        random = new Random();

        fondsen = new ArrayList<>();
        fondsen.add(new Fonds("A", 25));
        fondsen.add(new Fonds("B", 50));
        fondsen.add(new Fonds("C", 75));

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                for (IFonds fonds : fondsen)
                {
                    ((Fonds)fonds).setKoers(fonds.getKoers() + (random.nextDouble()-0.5f));
                }
            }
        }, 0, 256);
    }

    @Override
    public List<IFonds> getKoersen()
    {
         return Collections.unmodifiableList(fondsen);
    }
}
