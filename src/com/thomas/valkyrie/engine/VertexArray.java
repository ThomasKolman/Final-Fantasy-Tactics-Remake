package com.thomas.valkyrie.engine;

import com.thomas.valkyrie.utils.BufferUtils;
import sun.security.provider.certpath.Vertex;

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
    private static List<Integer> allVAOs = new ArrayList<Integer>();
    private static List<Integer> allVBOs = new ArrayList<Integer>();

    private int vaoID, vboVertID, vboTexID, iboID;
    private int count;

    public VertexArray(float[] vertices, float[] textureCoordinates, short[] indices)
    {
        count = indices.length;

        // Generate and bind a Vertex Array
        vaoID = glGenVertexArrays();
        allVAOs.add(vaoID);
        glBindVertexArray(vaoID);

        // Create a Buffer Object and upload the vertices buffer
        vboVertID = glGenBuffers();
        allVBOs.add(vboVertID);
        glBindBuffer(GL_ARRAY_BUFFER, vboVertID);
        glBufferData(GL_ARRAY_BUFFER, BufferUtils.createFloatBuffer(vertices), GL_STATIC_DRAW);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(0);

        // Create a Buffer Object and upload the colors buffer
        vboTexID = glGenBuffers();
        allVBOs.add(vboTexID);
        glBindBuffer(GL_ARRAY_BUFFER, vboTexID);
        glBufferData(GL_ARRAY_BUFFER, BufferUtils.createFloatBuffer(textureCoordinates), GL_STATIC_DRAW);
        glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0);
        glEnableVertexAttribArray(1);

        // Create a FloatBuffer of indices
        iboID = glGenBuffers();
        allVBOs.add(iboID);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, iboID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, BufferUtils.createShortBuffer(indices), GL_STATIC_DRAW);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);
    }

    public void render()
    {
        // Bind the vertex array and enable our location
        glBindVertexArray(vaoID);

        // Draw a rectangle of 4 vertices, so it is 6 indices
        glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_SHORT, 0);

        // Disable our location
        glBindVertexArray(0);
    }

    public static void dispose()
    {
        for (int vao:allVAOs)
        {
            glDeleteVertexArrays(vao);
        }

        for (int vbo:allVBOs)
        {
            glDeleteBuffers(vbo);
        }
    }
}
