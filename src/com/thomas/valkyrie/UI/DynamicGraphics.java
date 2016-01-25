package com.thomas.valkyrie.UI;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.graphics.Indicators;

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
    private static List<Float> xPositions = new ArrayList<>();
    private static List<Float> yPositions = new ArrayList<>();

    public static void setIndicators(Map indicators)
    {
        DynamicGraphics.indicators = indicators;
        Indicators.create();
    }

    public static void clearIndicators()
    {
        indicators.clear();
    }

    public static void createNewIndicators(int row, int column, int indexer, int xPosition, int yPosition, int state)
    {
        float rowCopy = row;
        float columnCopy = column;
        float xIncrement;
        float yIncrement;

        if (row > xPosition)
        {
            xIncrement = (rowCopy / 10);
        }
        else
        {
            xIncrement = -(rowCopy / 10);
        }

        if (column < yPosition)
        {
            yIncrement = (columnCopy / 10);
        }
        else
        {
            yIncrement = -(columnCopy / 10);
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

        for (int i = 0; i < indicators.size(); i++)
        {
            indicators.get(i).getEntity().render("transformationMatrix");
        }

        Shader.INDICATOR.disable();
    }

    public static List<Float> getxPositions()
    {
        return xPositions;
    }

    public static List<Float> getyPositions()
    {
        return yPositions;
    }
}
