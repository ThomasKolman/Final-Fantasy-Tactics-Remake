package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Entity;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.maths.Vector3f;

/**
 * Created by Thomas on 2016-01-23.
 */
public class Healthbar
{
    private Vector3f position = new Vector3f();
    private Entity entity;
    private static VertexArray vertexArray;
    private static Texture healthbar_texture;

    public Healthbar(float x, float y, float z)
    {
        position.x = x;
        position.y = y;
        position.z = z;

        entity = new Entity(vertexArray, healthbar_texture, position, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public Entity getEntity()
    {
        return entity;
    }

    public static void create()
    {
        final float[] vertices = new float[]
                {
                        -0.9f, -0.8f, 0.0f,
                        -0.9f, -0.9f, 0.0f,
                        -0.5f, -0.9f, 0.0f,
                        -0.5f, -0.8f, 0.0f
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
        healthbar_texture = new Texture("healthbar.png");
    }
}
