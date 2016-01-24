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

    public static void setIndicators(Map indicators)
    {
        DynamicGraphics.indicators = indicators;
        Indicators.create();
    }

    public static void createNewIndicators(int row, int column, int incrementList, int xPosition, int yPosition)
    {
        float rowCopy = row;
        float columnCopy = column;

        System.out.println();

        float xIncrement = 0.0f;
        float yIncrement = 0.0f;

        if (row > xPosition)
            xIncrement = (rowCopy / 10);
        else
            xIncrement = -(rowCopy / 10);

        if (column < yPosition)
            yIncrement = (columnCopy / 10);
        else
            yIncrement = -(columnCopy / 10);

        indicators.put(incrementList, new Indicators(0.0f + xIncrement, 0.0f + yIncrement, 0.0f));
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
}
