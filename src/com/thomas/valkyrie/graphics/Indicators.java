package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Entity;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.maths.Vector3f;

/**
 * Created by Thomas on 2016-01-20.
 */
public class Indicators
{
    private Vector3f position = new Vector3f();
    private Entity entity;

    private static VertexArray vertexArray;
    private static Texture blue_indicator_texture;
    private static Texture red_indicator_texture;
    private static Texture pink_indicator_texture;

    public Indicators(float x, float y, float z, String texture)
    {
        position.x = x;
        position.y = y;
        position.z = z;

        switch (texture)
        {
            case "blue_texture" :
                entity = new Entity(vertexArray, blue_indicator_texture, position, 0.0f, 0.0f, 0.0f, 0.0f);
                break;
            case "red_texture" :
                entity = new Entity(vertexArray, red_indicator_texture, position, 0.0f, 0.0f, 0.0f, 0.0f);
                break;
            case "pink_texture" :
                entity = new Entity(vertexArray, pink_indicator_texture, position, 0.0f, 0.0f, 0.0f, 0.0f);
                break;
        }
    }

    public Entity getEntity()
    {
        return entity;
    }

    public static void create()
    {
        // The vertices of our Triangle
        final float[] vertices = new float[]
                {
                        -0.9f, 0.9f, 0.0f,
                        -0.9f, 0.8f, 0.0f,
                        -0.8f, 0.8f, 0.0f,
                        -0.8f, 0.9f, 0.0f
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
        blue_indicator_texture = new Texture("blue_indicator_tile.png");
        red_indicator_texture = new Texture("red_indicator_tile.png");
        pink_indicator_texture = new Texture("pink_indicator_tile.png");
    }
}
