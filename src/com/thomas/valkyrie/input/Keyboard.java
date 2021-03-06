package com.thomas.valkyrie.input;

import org.lwjgl.glfw.GLFWKeyCallback;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

/**
 * Created by Thomas on 2016-01-17.
 */
public class Keyboard extends GLFWKeyCallback
{
    private static boolean[] keys = new boolean[65536];

    public void invoke(long window, int key, int scancode, int action, int mods)
    {
        keys[key] = action != GLFW_RELEASE;
    }

    public static boolean isKeyDown(int keycode)
    {
        return keys[keycode];
    }
}
