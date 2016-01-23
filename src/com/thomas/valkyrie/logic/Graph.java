package com.thomas.valkyrie.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Thomas on 2016-01-18.
 */
public class Graph
{
    private int[][] graph;

    /**
     * Instantiates new level map with appropriate sizes
     *
     * @param row takes in the row size of the map
     * @param column takes in the column size of the map
     */
    public Graph(int row, int column)
    {
        graph = new int[row][column];
    }

    /**
     * Maps all nodes with appropriate heuristic, x and y
     * positions
     *
     * @param xPos takes in x position of the player
     * @param yPos takes in y position of the player
     */
    public Map mapAllNodes(int xPos, int yPos)
    {
        // Stores heuristic, x and y position of node
        Map<Map<Integer, Integer>, Integer> heuristic = new HashMap<>();
        Map<Integer, Integer> positions = new HashMap<>();

        for (int i = 0; i < graph[0].length; i++)
        {
            for (int j = 0; j < graph[1].length; j++)
            {
                if (i != xPos && j != yPos)
                {
                    positions.put(i, j);
                    heuristic.put(positions, calculateManhattanDistance(xPos, yPos, i, j));
                    System.out.println(heuristic.get(new HashMap<>(i, j)));
                    System.out.println(heuristic.containsKey(new HashMap<>()));
                }
            }
        }

        return heuristic;
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
