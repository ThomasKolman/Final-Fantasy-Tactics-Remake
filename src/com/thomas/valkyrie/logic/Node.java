package com.thomas.valkyrie.logic;

/**
 * Created by Thomas on 2016-01-23.
 */
public class Node<Heuristic, XPosition, YPosition> extends Map
{
    final public Heuristic heuristic;
    final public XPosition xPosition;
    final public YPosition yPosition;

    public Node(Heuristic heuristic, XPosition xPosition, YPosition yPosition)
    {
        super((Integer) heuristic, (Integer) xPosition, (Integer) yPosition);

        this.heuristic = heuristic;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
}
