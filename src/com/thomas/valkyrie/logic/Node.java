package com.thomas.valkyrie.logic;

/**
 * Created by Thomas on 2016-01-23.
 */
public class Node
{
    private int heuristic;

    final private int xPosition;
    final private int yPosition;
    private float xCoord;
    private float yCoord;

    public Node(int xPosition, int yPosition, float xCoord, float yCoord)
    {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xCoord = xCoord;
        this.yCoord = yCoord;

        fixFloatingPointError();
    }

    public void fixFloatingPointError()
    {
        if (xCoord == 0.09999993)
        {
            xCoord = 0.0f;
        }

        if (yCoord < -7.4505806E-8)
        {
            xCoord = 0.0f;
        }
    }

    public void changeHeuristic(int heuristic)
    {
        this.heuristic = heuristic;
    }

    public int getHeuristic()
    {
        return heuristic;
    }

    public float getxCoord() {
        return xCoord;
    }

    public float getyCoord() {
        return yCoord;
    }
}
