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
                        -0.5f, 0.5f,
                        -0.5f, -0.5f,
                        0.5f, -0.5f,
                        0.5f, 0.5f
                };

        float[] textureCoordinates = new float[]
                {
                        0, 0,   //VO
                        0, 1,   //V1
                        1, 1,   //V2
                        1, 0,   //V3
                };

        // The indices that form the rectangle
        short[] indices = new short[]
                {
                        0,1,3,
                        3,1,2
                };

        vertexArray = new VertexArray(vertices, textureCoordinates, indices);
        texture = new Texture("res/image.png");
    }

    public void render() {
        vertexArray.render();
        texture.bind();
    }
}