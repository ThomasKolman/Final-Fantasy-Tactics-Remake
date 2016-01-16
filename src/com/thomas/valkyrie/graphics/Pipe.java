package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.maths.Matrix4f;
import com.thomas.valkyrie.maths.Vector3f;

/**
 * Created by Thomas on 2016-01-16.
 */
public class Pipe
{

    private static float width = 1.5f, height = 8.0f;
    private static Texture texture;
    private static VertexArray mesh;

    public static void create()
    {
        float[] vertices = new float[] {
                0.0f, 0.0f, 0.1f,
                0.0f, height, 0.1f,
                width, height, 0.1f,
                width, 0.0f, 0.1f
        };

        short[] indices = new short[] {
                0, 1, 2,
                2, 3, 0
        };

        float[] tcs = new float[] {
                0, 1,
                0, 0,
                1, 0,
                1, 1
        };

        mesh = new VertexArray(vertices, tcs, indices);
        texture = new Texture("pipe");
        Shader.BG.setUniformMat4("transformationMatrix", Matrix4f.translate(new Vector3f(1.0f, 0.0f, 0.0f)));
    }

    public static void render()
    {
        mesh.render();
        texture.bind();
    }
}
