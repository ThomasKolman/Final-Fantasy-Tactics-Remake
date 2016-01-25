package com.thomas.valkyrie.utils;

/**
 * Created by Thomas on 2016-01-25.
 */
public class ThreadUtils
{
    public static void sleepThread(long time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException ex)
        {
            System.out.println("Error sleeping thread");
            ex.printStackTrace();
        }
    }
}
