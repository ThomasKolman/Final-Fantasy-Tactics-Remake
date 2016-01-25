package com.thomas.valkyrie.input;

import com.thomas.valkyrie.main.Main;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWCursorPosCallback;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.glfwGetCursorPos;

/**
 * Created by Thomas on 2016-01-18.
 */
public class MousePosition extends GLFWCursorPosCallback
{
    private Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
    private static double xCartesian;
    private static double yCartesian;

    public void invoke(long window, double xpos, double ypos)
    {
        int height = (int) resolution.getHeight();
        int width = (int) resolution.getWidth();

        float xCartesian = (float) ((xpos - width / 2) / width) * 2;
        float yCartesian = (float) ((-ypos + height / 2) / height) * 2;

        this.xCartesian = xCartesian;
        this.yCartesian = yCartesian;
    }

    public static double getxCartesian() {
        return xCartesian;
    }

    public static double getyCartesian() {
        return yCartesian;
    }
}
