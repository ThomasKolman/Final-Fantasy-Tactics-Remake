package com.thomas.valkyrie.engine;

import com.thomas.valkyrie.utils.ShaderUtils;
import com.thomas.valkyrie.utils.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

/**
 * Created by Thomas on 2015-12-13.
 */
public class VertexArray
{
    private List<Integer> vaos = new ArrayList<Integer>();
    private List<Integer> vbos = new ArrayList<Integer>();
    private List<Integer> textures = new ArrayList<Integer>();

    private ShaderUtils shaderUtils = new ShaderUtils();

    private int vaoID, vboVertID, vboColID, eboID;
    private int count;

    public VertexArray()
    {
        System.out.println("Reg. constructor");
        System.out.println("Reg. constructor END");
    }

    public VertexArray(float[] vertices, float[] textureCoords, short[] indices)
    {
        shaderUtils.attachVertexShader("com/thomas/valkyrie/shaders/triangle.vert");
        shaderUtils.attachFragmentShader("com/thomas/valkyrie/shaders/triangle.frag");
        shaderUtils.link();

        count = indices.length;

        // Generate and bind a Vertex Array
        vaoID = glGenVertexArrays();
        glBindVertexArray(vaoID);

        // Create a FloatBuffer of vertices
        FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices);

        // Create a Buffer Object and upload the vertices buffer
        vboVertID = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboVertID);
        glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);

        // Point the buffer at location 0, the location we set
        // inside the vertex shader. You can use any location
        // but the locations should match
        glVertexAttribPointer(0, 2, GL_FLOAT, false, 0, 0);

        // Enable the vertex attribute locations
        glEnableVertexAttribArray(0);

//        // Create a FloatBuffer of colors
//        FloatBuffer colorsBuffer = BufferUtils.createFloatBuffer(colors);
//
//        // Create a Buffer Object and upload the colors buffer
//        vboColID = glGenBuffers();
//        glBindBuffer(GL_ARRAY_BUFFER, vboColID);
//        glBufferData(GL_ARRAY_BUFFER, colorsBuffer, GL_STATIC_DRAW);
//
//        // Point the buffer at location 1, the location we set
//        // inside the vertex shader. You can use any location
//        // but the locations should match
//        glVertexAttribPointer(1, 4, GL_FLOAT, false, 0, 0);
//
//        // Enable the vertex attribute locations
//        glEnableVertexAttribArray(1);

        // Create a FloatBuffer of indices
        ShortBuffer indicesBuffer = BufferUtils.createShortBuffer(indices);

        eboID = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, eboID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);

        glBindVertexArray(0);
    }

    public void render()
    {
        // Clear the screen
        glClearColor(0.3f, 0.4f, 0.1f,1.0f);
        glClear(GL_COLOR_BUFFER_BIT);

        // Use our program
        shaderUtils.bind();

        // Bind the vertex array and enable our location
        glBindVertexArray(vaoID);

        // Draw a rectangle of 4 vertices, so it is 6 indices
        glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_SHORT, 0);

        // Disable our location
        glBindVertexArray(0);

        // Un-bind our program
        shaderUtils.unbind();
    }

    public void dispose()
    {
        System.out.println("Disposing of vertex array");

        // Dispose the program

        // Dispose the vertex array
        glBindVertexArray(0);
        glDeleteVertexArrays(vaoID);

        // Dispose the buffer object
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glDeleteBuffers(vboVertID);
        glDeleteBuffers(vboColID);
    }
}
