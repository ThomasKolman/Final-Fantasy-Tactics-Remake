package com.thomas.valkyrie.logic;

import java.util.*;

/**
 * Created by Thomas on 2016-01-18.
 */
public class Graph
{
    private int[][] grid = new int[9][9];
    private Map<Integer, Integer> nodeCache = new HashMap<Integer, Integer>();

    private int targetXPos;
    private int targetYPos;

    public Graph()
    {

    }

    public Graph(int xPos, int yPos, int targetXPos, int targetYPos)
    {
        this.targetXPos = targetXPos;
        this.targetYPos = targetYPos;

        // Fills up grid with index values
        for (int i = 0; i < grid[0].length; i++)
        {
            for (int j = 0; j < grid[1].length; j++)
            {
                grid[i][j] = i + 1;
            }
        }

        // Delcares open and closed lists
        List<Integer> openList = new ArrayList<>();
        List<Integer> closedList = new ArrayList<>();

        int topChildNodeHeuristic = calculateHeuristic(xPos - 1, yPos);
        int bottomChildNodeHeuristic = calculateHeuristic(xPos + 1, yPos);
        int leftChildNodeHeuristic = calculateHeuristic(xPos, yPos - 1);
        int rightChildNodeHeuristic = calculateHeuristic(xPos, yPos - 1);

        for (int i = 0; i < 4; i++)
        {
            getSmallerHeuristic(topChildNodeHeuristic, bottomChildNodeHeuristic);
        }
    }

    public int calculateHeuristic(int xPos, int yPos)
    {
        // Calculates the Manhattan distance between starting point and target point
        int heuristic = Math.abs(xPos - targetXPos) + Math.abs(yPos - targetYPos);
        return heuristic;
    }

    public int getSmallerHeuristic(int minValue, int value)
    {
        if (value < minValue)
        {
            return value;
        }
        return minValue;
    }
}
