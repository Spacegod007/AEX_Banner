package logic.effectenbeurs;

import logic.IFonds;

import java.rmi.Remote;
import java.util.List;

/**
 * The stock exchange, where all sorts of interesting things happen
 */
public interface IEffectenbeurs extends Remote
{
    List<IFonds> getKoersen();
}
