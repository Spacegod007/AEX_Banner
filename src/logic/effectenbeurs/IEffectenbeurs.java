package logic.effectenbeurs;

import logic.IFonds;

import java.util.List;

/**
 * The stock exchange, where all sorts of interesting things happen
 */
public interface IEffectenbeurs
{
    List<IFonds> getKoersen();
}
