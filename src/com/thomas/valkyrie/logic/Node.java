package com.thomas.valkyrie.logic;

import java.math.BigDecimal;

/**
 * Created by Thomas on 2016-01-23.
 */
public class Node
{
    private int heuristic;

    final private int xPosition;
    final private int yPosition;
    final private float xCoord;
    final private float yCoord;

    public Node(int xPosition, int yPosition, float xCoord, float yCoord)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xCoord = fixFloatingPointError(xCoord);
        this.yCoord = fixFloatingPointError(yCoord);
    }

    private float fixFloatingPointError(Float d)
    {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(2, BigDecimal.ROUND_UP);
        return bd.floatValue();
    }

    public void changeHeuristic(int heuristic)
    {
        this.heuristic = heuristic;
    }

    public int getHeuristic()
    {
        return heuristic;
    }

    public int getyPosition()
    {
        return yPosition;
    }

    public int getxPosition()
    {
        return xPosition;
    }

    public float getxCoord()
    {
        return xCoord;
    }

    public float getyCoord()
    {
        return yCoord;
    }
}
