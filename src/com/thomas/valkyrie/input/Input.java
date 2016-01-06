package com.thomas.valkyrie.input;

import org.lwjgl.glfw.GLFWKeyCallback;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

/**
 * Created by Thomas on 2015-12-13.
 */
public class Input extends GLFWKeyCallback {
    public static boolean[] keys = new boolean[65536];

    public void invoke(long window, int key, int scancode, int action, int mods) {
        keys[key] = action != GLFW_RELEASE;
    }

    public static boolean isKeyDown(int keycode) {
        return keys[keycode];
    }
}
