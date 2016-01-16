package com.thomas.valkyrie.main;

import com.thomas.valkyrie.audio.Audio;
import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.graphics.Grid;
import com.thomas.valkyrie.input.Input;
import com.thomas.valkyrie.maths.Matrix4f;
import com.thomas.valkyrie.maths.Vector3f;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL20.*;

import java.awt.Toolkit;
import java.awt.Dimension;

import static org.lwjgl.glfw.GLFW.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * Created by Thomas on 2015-12-13.
 *
 * This class has been equally contributed to by Thomas Kolman and Nawab Ali
 *
 * This codebase is the source code for Final Fantasy Tactics Advance Remastered, jointly created
 * by Thomas Kolman and Nawab Ali. The game self-identifies as a turn-based strategy game that pits
 * two players together against each other on a grid. Every player has the right to pick their own
 * party. The objective of the game is to wipe out the other players party.
 *
 * This class handles all the main processes that take up the game, including the initial setup, the
 * game loop, and the disposal of resources allocated during the game
 */
public class Main implements Runnable
{
    private long windowID;

    private Input input;
    private Grid grid;
    private VertexArray vertexArray;
    private Thread thread;

    /**
     * Hosts initial method calls and game loop
     *
     * <p> Method runs indefinitely until program execution ends </p>
     */
    private void start()
    {
        // Variables to monitor FPS
        float now, last, delta;
        last = 0;

        // Initializes program
        init();

        Shader.BG.loadAll();
        Shader.BG.enable();

        // Initializes all objects needed during render/update cycle
        vertexArray = new VertexArray();
        grid = new Grid();

//        thread = new Thread(this, "Game");
//        thread.start();

        grid.generateGrid();
        Shader.BG.setUniformMat4("gWorld", Matrix4f.translate(new Vector3f(0.0f, 1.0f, 1.0f)));

        // Game loop
        while (glfwWindowShouldClose(windowID) != GL_TRUE)
        {
            // Get the time
            now = (float) glfwGetTime();
            delta = now - last;
            last = now;

//            float timeValue = (float) glfwGetTime();
//            float greenValue = (float) ((Math.sin((timeValue) / 2) + 0.5));
//            int vertexColorLocation = Shader.BG.getUniformLocation("vColor");
//            glUniform4f(vertexColorLocation, 0.0f, greenValue, 0.0f, 1.0f);

            // Update and render
            update(delta);
            render(delta);

            glfwPollEvents();
            glfwSwapBuffers(windowID);
        }

        // Ends program
        end();
    }

    public void run()
    {
        System.out.println("hey");
        Audio.loadMP3File();

        while (true)
        {
            Audio.playMP3File();
        }
    }

    /**
     * Ends program
     *
     * <p> Terminates all existing resources </p>
     */
    public void end()
    {
        // Dispose the game
        vertexArray.dispose();

        // Destroy the window
        glfwDestroyWindow(windowID);
        glfwTerminate();

        System.exit(0);
    }

    /**
     * Updates game input and logic
     *
     * @param delta takes in FPS time
     */
    private void update(float delta) {
        if (Input.isKeyDown(GLFW_KEY_SPACE))
        {
            System.out.println(delta);
        }
        else if (Input.isKeyDown(GLFW_KEY_ESCAPE))
        {
            end();
        }
    }

    /**
     * Renders graphics
     *
     * @param delta takes in FPS time
     */
    private void render(float delta)
    {
        grid.render();
    }

    private void dispose()
    {
        // TODO Auto-generated method stub

    }

    /**
     * Initializes GLFW window processes and OpenGL states
     *
     * <p> Creates new window </p>
     *
     * <p> Handles failed window creation attempts </p>
     *
     * <p> Sets GLContext to this thread </p>
     */
    private void init()
    {
        // Initializes GLFW background processes and throws
        // exception if GLFW cannot be initialized
        if (glfwInit() != GL_TRUE)
        {
            System.err.println("Error initializing GLFW");
            System.exit(1);
        }

        // Specifies version of OpenGL we are using and
        // how GLFW should adapt to the version
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);

        // Gets screen resolution
        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) resolution.getHeight();
        int width = (int) resolution.getWidth();

        // Creates window that resizes itself to fullscreen,
        // has no title text, and will only be shared on one monitor
        windowID = glfwCreateWindow(width, height, "", glfwGetPrimaryMonitor(), NULL);

        // Throws exception if window creation failed
        if (windowID == NULL)
        {
            System.err.println("Error creating a window");
            System.exit(1);
        }

        // Initializes a new OpenGL/GLFW context
        glfwMakeContextCurrent(windowID);
        GL.createCapabilities();
        glfwSwapInterval(1);

        // Sets event listener for the new window
        input = new Input();
        glfwSetKeyCallback(windowID, input);

        // Prints out OpenGL version being used
        System.out.println(glGetString(GL_VERSION));
    }

    /**
     * Called when program begins execution
     *
     * <p> Immediately calls start method </p>
     *
     * @param args takes in command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("GAME");
        new Main().start();
    }
}

