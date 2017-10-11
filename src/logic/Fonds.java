package logic;

import java.util.Random;

public class Fonds implements IFonds
{
    private String name;
    private double koers;

    public Fonds(String name, double koers)
    {
        this.name = name;
        this.koers = koers;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public double getKoers()
    {
        Random rnd = new Random();
        koers += (rnd.nextDouble() - 0.5f);
        return koers;
    }

    @Override
    public String toString()
    {
        double koers = Math.floor(getKoers() * 100) / 100;
        return getName() + ": " + koers;
    }
}
