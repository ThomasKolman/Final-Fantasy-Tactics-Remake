package com.thomas.valkyrie.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Thomas on 2016-01-18.
 */
public class Movement
{
    final private static Byte[][] grid = new Byte[9][9];
    private static List<Integer> xMovableNodes = new ArrayList<>();
    private static List<Integer> yMovableNodes = new ArrayList<>();

    public static void checkMovementSpace(int mobility, int xpos, int ypos)
    {
        xpos = 0;
        ypos = 0;

        xMovableNodes.clear();
        yMovableNodes.clear();

        for (int i = 0; i < grid[0].length; i++)
        {
            for (int j = 0; j < grid[1].length; j++)
            {
                if (calculateManhattanDistance(xpos, ypos, i, j) < 4)
                {
                    xMovableNodes.add(i);
                    yMovableNodes.add(j);
                }
            }
        }
    }

    private static int calculateManhattanDistance(int xPos, int yPos, int targetXPos, int targetYPos)
    {
        // Calculates the Manhattan distance between starting point and target point
        int heuristic = Math.abs(xPos - targetXPos) + Math.abs(yPos - targetYPos);
        return heuristic;
    }

    public static List<Integer> getxMovableNodes()
    {
        return xMovableNodes;
    }

    public static List<Integer> getyMovableNodes()
    {
        return yMovableNodes;
    }
}
