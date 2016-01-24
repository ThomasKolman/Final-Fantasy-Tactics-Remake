package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Entity;
import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.maths.Matrix4f;
import com.thomas.valkyrie.maths.Vector3f;

/**
 * Created by Thomas on 2016-01-17.
 */
public class Background
{
    private static VertexArray vertexArray;
    private static Texture texture;
    private Vector3f vector3f = new Vector3f(0, 0, 0);
    private Entity entity;

    public Background()
    {
        entity = new Entity(vertexArray, texture, vector3f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public static void create()
    {
        final float[] vertices = new float[]
                {
                        -1.0f, 1.0f, 0.0f,
                        -1.0f, -1.0f, 0.0f,
                        1.0f, -1.0f, 0.0f,
                        1.0f, 1.0f, 0.0f
                };

        final float[] textureCoordinates = new float[]
                {
                        0, 0,   //VO
                        0, 1,   //V1
                        1, 1,   //V2
                        1, 0,   //V3
                };

        // The indices that form the rectangle
        final short[] indices = new short[]
                {
                        0,1,3,
                        3,1,2
                };

        vertexArray = new VertexArray(vertices, textureCoordinates, indices);
        texture = new Texture("background.png");
    }

    public Entity getEntity()
    {
        return entity;
    }
}
