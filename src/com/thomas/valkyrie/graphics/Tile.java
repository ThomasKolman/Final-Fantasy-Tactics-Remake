package com.thomas.valkyrie.graphics;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.thomas.valkyrie.engine.Entity;
import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.maths.Matrix4f;
import com.thomas.valkyrie.maths.Vector3f;

import java.util.List;
import java.util.Random;

/**
 * Created by Thomas on 2016-01-17.
 */
public class Tile
{
    private Vector3f position = new Vector3f();
    private Entity entity;

    private static VertexArray vertexArray;
    private static Texture grass_texture;
    private static Texture dirt_texture;
    private static Texture stone_texture;

    private int countInpassableNodes = 0;

    public Tile(float x, float y, float z, int i, int j)
    {
        position.x = x;
        position.y = y;
        position.z = z;

        entity = new Entity(vertexArray, randomTextureGeneration(i, j), position, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    /**
     * NEEDS TO BE MOVED
     *
     * @param i
     * @param j
     * @return
     */
    public Texture randomTextureGeneration(int i, int j)
    {
        double random = Math.random();

        if (i > 1 && i < 10 && j > 1 && j < 10)
        {
            if (random < 0.2)
            {
                return dirt_texture;
            }
            else if (random > 0.2 && random < 0.4)
            {
                countInpassableNodes += 1;
                return stone_texture;
            }
            else
            {
                return grass_texture;
            }
        }
        else
        {
            if (random < 0.2)
            {
                return dirt_texture;
            }
            else
            {
                return grass_texture;
            }
        }
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
        grass_texture = new Texture("tile_grass.png");
        dirt_texture = new Texture("dirt.png");
        stone_texture = new Texture("stone.jpg");
    }

    public Entity getEntity()
    {
        return entity;
    }

    public int getCountInpassableNodes()
    {
        return countInpassableNodes;
    }
}
