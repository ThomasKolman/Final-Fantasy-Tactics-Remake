package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.VertexArray;

/**
 * Created by Thomas on 2016-01-06.
 */
public class Grid
{
    VertexArray vertexArray;

    public void generateGrid()
    {


        // The vertices of our Triangle
//        float[] vertices = new float[]
//                {
//                        -0.9f, +0.9f,  // ID 0: Top left vertex
//                        -0.8f, +0.9f,  // ID 1: Top right vertex
//                        -0.9f, +0.8f,  // ID 2: Bottom left vertex
//                        -0.8f, +0.8f   // ID 3: Bottom right vertex
//                };
        float[] vertices = new float[100];
        int index = 0;

//        for (float row = 0.0f; row < 1.0f; row += 0.1f)
//        {
//            for (float column = 0.0f; column < 1.0f; column += 0.1f)
//            {
//                index = (int) column * 1;
//
//                vertices[column] = - (row + 0.9f), + (column + 0.9f);
//                vertices[] = - (row + 0.8f), + (column + 0.9f);
//                vertices[] = - (row + 0.9f), + (column + 0.8f);
//                vertices[] = - (row + 0.8f), + (column + 0.8f)
//
//            }
//        }

        float[] colors = new float[]
                {
                        0, 1, 0, 1,    // Red color for top left vertex
                        0, 1, 0, 1,    // Green color for top right vertex
                        1, 0, 1, 0,    // Blue color for bottom left vertex
                        0, 1, 0, 1
                };

        // The indices that form the rectangle
        short[] indices = new short[]
                {
                        0, 1, 2,  // The indices for the left triangle
                        1, 2, 3   // The indices for the right triangle
                };

        vertexArray = new VertexArray(vertices, colors, indices);
    }

    public void render()
    {
        vertexArray.render();
    }
}