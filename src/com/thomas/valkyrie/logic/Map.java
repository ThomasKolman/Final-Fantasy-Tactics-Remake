package com.thomas.valkyrie.logic;

/**
 * Created by Thomas on 2016-01-23.
 */
public class Map
{
    private int rows;
    private int columns;

    private Node<Integer, Integer, Integer>[] nodeMap;
    private int nodeMapCounter = 0;

    public Map(Integer heuristic, Integer xPosition, Integer yPosition)
    {

    }

    public Map(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;

        nodeMap = new Node[rows * columns];
    }
}
