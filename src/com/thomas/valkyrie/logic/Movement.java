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
    private static Graph jagd = new Graph(18, 18);

    public static void checkMovementSpace(int mobility, int xPos, int yPos)
    {
        Map<Integer, Map<Integer, Integer>> nodeMap = new HashMap<>(jagd.mapAllNodes(xPos, yPos));

        //System.out.println(nodeMap.get(3));
    }
}
