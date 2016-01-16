package com.thomas.valkyrie.engine;

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

    private int vaoID, vboVertID, vboTexID, iboID;
    private int count;

    public VertexArray()
    {
        System.out.println("Reg. constructor");
        System.out.println("Reg. constructor END");
    }

    public VertexArray(float[] vertices, float[] textureCoordinates, short[] indices)
    {
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
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(0);

        // Create a FloatBuffer of colors
        FloatBuffer colorsBuffer = BufferUtils.createFloatBuffer(textureCoordinates);

        // Create a Buffer Object and upload the colors buffer
        vboTexID = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboTexID);
        glBufferData(GL_ARRAY_BUFFER, colorsBuffer, GL_STATIC_DRAW);
        glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(1);

        // Create a FloatBuffer of indices
        ShortBuffer indicesBuffer = BufferUtils.createShortBuffer(indices);

        iboID = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, iboID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);
    }

    public void render()
    {
        // Clear the screen
        glClearColor(0.3f, 0.4f, 0.1f,1.0f);
        glClear(GL_COLOR_BUFFER_BIT);

        // Use our program
        // shaderUtils.bind();

        // Bind the vertex array and enable our location
        glBindVertexArray(vaoID);

        // Draw a rectangle of 4 vertices, so it is 6 indices
        glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_SHORT, 0);

        // Disable our location
        glBindVertexArray(0);

        // Un-bind our program
//        shaderUtils.unbind();
    }

    public void dispose()
    {
        System.out.println("Disposing of vertex array");

        // Dispose the program
        // shaderUtils.dispose();

        // Dispose the vertex array
        glBindVertexArray(0);
        glDeleteVertexArrays(vaoID);

        // Dispose the buffer object
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glDeleteBuffers(vboVertID);
        glDeleteBuffers(vboTexID);
    }
}
