package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;

/**
 * Created by Thomas on 2016-01-07.
 */
public class Sample
{
    VertexArray vertexArray;
    Texture textures;

    public void generateSample()
    {
        float[] vertices = new float[]
                {
                        -10.0f, -10.0f * 9.0f / 16.0f, 0.0f,
                        -10.0f,  10.0f * 9.0f / 16.0f, 0.0f,
                        0.0f,  10.0f * 9.0f / 16.0f, 0.0f,
                        0.0f, -10.0f * 9.0f / 16.0f, 0.0f,
                };

        byte[] indices = new byte[]
                {
                        0, 1, 2,
                        2, 3, 0
                };

        float[] tcs = new float[]
                {
                        0, 1,
                        0, 0,
                        1, 0,
                        1, 1
                };

        vertexArray = new VertexArray();
        textures = new Texture("res/image.png");
    }

    public void render()
    {
        vertexArray.render();
        textures.bind();
    }
}
