package com.thomas.valkyrie.maths;

/**
 * Created by Thomas on 2016-01-25.
 */
public class CoordMath
{
    public static int floatToInt(float position)
    {
        int result = (int) position * 10;
        return result;
    }

    public static float intToFloat(int position)
    {
        float copy = (float) position;
        float result = copy / 10;
        return result;
    }
}
