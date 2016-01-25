package com.thomas.valkyrie.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 2016-01-23.
 */
public class Map
{
    final public Node[][] nodeMap;
    final private int rows;
    final private int columns;

    public Map(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;

        // Sets map size
        nodeMap = new Node[rows][columns];

        float xCoord = -0.9f;
        float yCoord = 0.9f;

        // Fills nodeMap objects with positional data
        for (int i = 0; i < nodeMap[0].length; i++)
        {
            for (int j = 0; j < nodeMap[1].length; j++)
            {
                nodeMap[i][j] = new Node(i, j, xCoord, yCoord);
                xCoord += 0.1f;
            }
            xCoord = -0.9f;
            yCoord -= 0.1f;
        }
    }

    /**
     *
     */
    public void updateNodeData(int xPos, int yPos)
    {
        for (int i = 0; i < nodeMap[0].length; i++)
        {
            for (int j = 0; j < nodeMap[1].length; j++)
            {
                nodeMap[i][j].changeHeuristic(calculateManhattanDistance(xPos, yPos, i, j));
            }
        }
    }

    public int getNodeData(int xPos, int yPos)
    {
        return nodeMap[xPos][yPos].getHeuristic();
    }

    /**
     * Calculates the Manhattan distance between the position
     * of the player and the target position of the player
     *
     * @param xPos takes in the x position of the player
     * @param yPos takes in the y position of the player
     * @param targetXPos takes in the target x position of the player
     * @param targetYPos takes in the target y position of the player
     * @return heuristic between the player position and the target position
     */
    private int calculateManhattanDistance(int xPos, int yPos, int targetXPos, int targetYPos)
    {
        int heuristic = Math.abs(xPos - targetXPos) + Math.abs(yPos - targetYPos);
        return heuristic;
    }

    public int swapXCoordForInt(float coord)
    {
        for (int i = 0; i < nodeMap[0].length; i++)
        {
            for (int j = 0; j < nodeMap[1].length; j++)
            {
                if (coord == nodeMap[i][j].getxCoord())
                {
                    return nodeMap[i][j].getxPosition();
                }
            }
        }

        return -1;
    }

    public int swapYCoordForInt(float coord)
    {
        for (int i = 0; i < nodeMap[0].length; i++)
        {
            for (int j = 0; j < nodeMap[1].length; j++)
            {
                if (coord == nodeMap[i][j].getyCoord())
                {
                    return nodeMap[i][j].getyPosition();
                }
            }
        }

        return -1;
    }

    public int getRows()
    {
        return rows;
    }

    public int getColumns()
    {
        return columns;
    }
}
