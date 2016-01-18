package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Entity;
import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.maths.Matrix4f;
import com.thomas.valkyrie.maths.Vector3f;

import java.util.Random;

/**
 * Created by Thomas on 2016-01-17.
 */
public class Tile
{
    private Vector3f position = new Vector3f();
    private static VertexArray vertexArray;
    private static Texture grass_texture;
    private static Texture dirt_texture;
    private Entity entity;

    public Tile(float x, float y, float z)
    {
        position.x = x;
        position.y = y;
        position.z = z;
    }

    public static void create()
    {
        // The vertices of our Triangle
        float[] vertices = new float[]
                {
                        -0.9f, 0.9f, 0.0f,
                        -0.9f, 0.7f, 0.0f,
                        -0.7f, 0.7f, 0.0f,
                        -0.7f, 0.9f, 0.0f
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
        grass_texture = new Texture("tile_grass.png");
        dirt_texture = new Texture("dirt.png");
    }

    public void uploadAsEntity(Texture texture)
    {
        entity = new Entity(vertexArray, texture, position, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public Texture randomTextureGeneration()
    {
        if (Math.random() < 0.3)
        {
            return dirt_texture;
        }
        else
        {
            return grass_texture;
        }
    }

    public Entity getEntity()
    {
        return entity;
    }
}
