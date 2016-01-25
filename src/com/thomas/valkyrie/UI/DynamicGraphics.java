package com.thomas.valkyrie.UI;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.graphics.Indicators;
import com.thomas.valkyrie.maths.CoordMath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Thomas on 2016-01-24.
 */
public class DynamicGraphics
{
    // Dynamic graphics
    private static Map<Integer, Indicators> indicators = new HashMap<>();

    // Stores x and y coords for input handling
    private static List<Integer> xPositions = new ArrayList<>();
    private static List<Integer> yPositions = new ArrayList<>();

    public static void setIndicators(Map indicators)
    {
        DynamicGraphics.indicators = indicators;
    }

    public static void clearAll()
    {
        indicators.clear();
        xPositions.clear();
        yPositions.clear();
    }

    public static void createNewIndicators(int row, int column, int indexer, float xPosition, float yPosition, int state)
    {
        float xIncrement;
        float yIncrement;

        xPositions.add(row);
        yPositions.add(column);

        if (row > xPosition)
        {
            xIncrement = CoordMath.intToFloat(row);
        }
        else
        {
            xIncrement = -(CoordMath.intToFloat(row));
        }

        if (column < yPosition)
        {
            yIncrement = CoordMath.intToFloat(column);
        }
        else
        {
            yIncrement = -(CoordMath.intToFloat(column));
        }

        String texture = null;

        if (state == 0)
            texture = "blue_texture";
        else if (state == 1)
            texture = "red_texture";
        else
            texture = "pink_texture";

        indicators.put(indexer, new Indicators(0.0f + xIncrement, 0.0f + yIncrement, 0.0f, texture));
    }

    public static void renderIndicators()
    {
        Shader.INDICATOR.enable();

        if (indicators.size() != 0)
        {
            for (int i = 0; i < indicators.size(); i++)
            {
                indicators.get(i).getEntity().render("transformationMatrix");
            }
        }

        Shader.INDICATOR.disable();
    }

    public static List<Integer> getxPositions()
    {
        return xPositions;
    }

    public static List<Integer> getyPositions()
    {
        return yPositions;
    }
}
