package com.thomas.valkyrie.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 2016-01-23.
 */
public class Map
{
    private Node[][] nodeMap;

    public Map(int rows, int columns)
    {
        // Sets map size
        nodeMap = new Node[rows][columns];

        // Fills nodeMap objects with positional data
        for (int i = 0; i < nodeMap[0].length; i++)
        {
            for (int j = 0; j < nodeMap[1].length; i++)
            {
                nodeMap[i][j] = new Node(i, j);
            }
        }
    }

    /**
     *
     */
    public void fillNodeData(int xPos, int yPos)
    {
        for (int i = 0; i < nodeMap[0].length; i++)
        {
            for (int j = 0; j < nodeMap[1].length; i++)
            {
                nodeMap[i][j].changeHeuristic(calculateManhattanDistance(xPos, yPos, i, j));
            }
        }
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
}
