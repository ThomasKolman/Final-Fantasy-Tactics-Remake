package com.thomas.valkyrie.input;

import org.lwjgl.glfw.GLFWMouseButtonCallback;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

/**
 * Created by Thomas on 2016-01-17.
 */
public class MouseClick extends GLFWMouseButtonCallback
{
    public static boolean[] keys = new boolean[65536];

    public void invoke(long window, int button, int action, int mods)
    {
        keys[button] = action != GLFW_RELEASE;
    }

    public static boolean isMouseDown(int keycode)
    {
        return keys[keycode];
    }
}
