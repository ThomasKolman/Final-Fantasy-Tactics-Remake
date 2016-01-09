package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;

/**
 * Created by Thomas on 2016-01-07.
 */
public class Sample
{

    public void generateSample()
    {
        float[] vertices = new float[]
                {
                        -0.9f, +0.9f,  // ID 0: Top left vertex
                        -0.8f, +0.9f,  // ID 1: Top right vertex
                        -0.9f, +0.8f,  // ID 2: Bottom left vertex
                        -0.8f, +0.8f   // ID 3: Bottom right vertex
                };

        // The indices that form the rectangle
        short[] indices = new short[]
                {
                        0, 1, 2,  // The indices for the left triangle
                        1, 2, 3   // The indices for the right triangle
                };

        VertexArray vertexArray = new VertexArray();
        Texture texture = new Texture();

        texture.render();
        vertexArray.render();
    }
}
