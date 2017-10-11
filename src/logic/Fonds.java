package logic;

import java.util.Random;

public class Fonds implements IFonds
{
    private final String name;
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
        return koers;
    }
}
