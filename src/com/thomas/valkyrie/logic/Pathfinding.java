package com.thomas.valkyrie.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 2016-01-18.
 */
public class Pathfinding
{
    private static List<Integer> openList = new ArrayList<Integer>(81);
    private static List<Integer> closedList = new ArrayList<Integer>();

    private static int heuristic;

    public static void calculateHeuristic()
    {
        System.out.println(openList.size());
    }
}
