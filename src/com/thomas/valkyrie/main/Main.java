package com.thomas.valkyrie.main;

import com.thomas.valkyrie.characters.BlackMage;
import com.thomas.valkyrie.engine.Entity;
import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.graphics.Level;
import com.thomas.valkyrie.input.Keyboard;
import com.thomas.valkyrie.input.MouseClick;
import com.thomas.valkyrie.input.MousePosition;
import com.thomas.valkyrie.input.MouseScroll;
import com.thomas.valkyrie.logic.Graph;
import com.thomas.valkyrie.logic.Movement;
import com.thomas.valkyrie.logic.Pathfinding;
import org.lwjgl.opengl.GL;

import java.awt.*;

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

    private Keyboard keyboard;
    private MouseClick mouseClick;
    private MousePosition mousePosition;
    private MouseScroll mouseScroll;

    private Level level;
    private Thread thread;
    private Entity entity;

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

        // Starts audio
        thread = new Thread(this, "Game");
        thread.start();

        // Loads all public shader classes
        Shader.loadAll();

        //grid = new Grid(0.0f, 0.0f, 0.0f);
        level = new Level();

        Graph graph = new Graph(2, 1, 5, 4);
        Graph graph2 = new Graph(5, 4, 2, 1);

        // Game loop
        while (glfwWindowShouldClose(windowID) != GL_TRUE)
        {
            // Get the time
            now = (float) glfwGetTime();
            delta = now - last;
            last = now;

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
//        Audio.loadMP3File("ZHU - FADED");

        while (true)
        {
            //Audio.playMP3File();
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
        VertexArray.dispose();
        Texture.dispose();

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
        if (Keyboard.isKeyDown(GLFW_KEY_SPACE))
        {
            System.out.println(delta);
        }
        else if (Keyboard.isKeyDown(GLFW_KEY_ESCAPE))
        {
            end();
        }
        else if (MouseClick.isMouseDown(GLFW_MOUSE_BUTTON_1))
        {
            boolean check = false;
            System.out.println(MousePosition.getxCartesian());
            if (MousePosition.getxCartesian() > -0.9f && MousePosition.getxCartesian() < -0.7f)
            {
                check = true;
                if (MousePosition.getyCartesian() > 0.7f && MousePosition.getyCartesian() < 0.9f)
                {

                }
            }

            System.out.println(check);
        }
    }

    /**
     * Renders graphics
     *
     * @param delta takes in FPS time
     */
    private void render(float delta)
    {
        // Clear the screen
        glClearColor(0.3f, 0.4f, 0.1f,1.0f);
        glClear(GL_COLOR_BUFFER_BIT);

        level.render();
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

        System.out.println(width + "   " + height);

//        if (height < width)
//        {
//            //noinspection SuspiciousNameCombination
//            width = height;
//        }
//        else
//        {
//            //noinspection SuspiciousNameCombination
//            height = width;
//        }

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

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        // Sets event listener for the new window
        keyboard = new Keyboard();
        mouseClick = new MouseClick();
        mousePosition = new MousePosition();

        glfwSetKeyCallback(windowID, keyboard);
        glfwSetMouseButtonCallback(windowID, mouseClick);
        glfwSetCursorPosCallback(windowID, mousePosition);

        // Prints out OpenGL version being used
        System.out.println(glGetString(GL_VERSION));
    }

    public long getWindowID() {
        return windowID;
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

