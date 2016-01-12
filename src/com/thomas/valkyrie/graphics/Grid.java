package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;

/**
 * Created by Thomas on 2016-01-06.
 */
public class Grid {
    VertexArray vertexArray;
    Texture texture;

    public void generateGrid() {
        // The vertices of our Triangle
        float[] vertices = new float[]
                {
                        -0.8f, +0.8f,  // ID 0: Top left vertex
                        +0.8f, +0.8f,  // ID 1: Top right vertex
                        -0.8f, -0.8f,  // ID 2: Bottom left vertex
                        +0.8f, -0.8f   // ID 3: Bottom right vertex
                };

        float[] textureCoordinates = new float[]
                {
                        0, 0,
                        0, 1,
                        1, 1,
                        1, 0
                };

        // The indices that form the rectangle
        short[] indices = new short[]
                {
                        0, 1, 2,  // The indices for the left triangle
                        1, 2, 3   // The indices for the right triangle
                };

        vertexArray = new VertexArray(vertices, textureCoordinates, indices);
        texture = new Texture("res/facebook.png");
    }

    public void render() {
        vertexArray.render();
        texture.bind();
    }
}