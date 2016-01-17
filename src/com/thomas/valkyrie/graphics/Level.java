package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.maths.Matrix4f;

/**
 * Created by Thomas on 2016-01-16.
 */
public class Level
{
    private Tile[] tile = new Tile[5 * 2];
    private Background background = new Background();

    public Level()
    {
        createBackground();
        createTiles();
    }

    public void createBackground()
    {
        Background.create();
        background.uploadAsEntity();
    }

    private void createTiles()
    {
        Tile.create();
        float increment = 0;

        for (int i = 0; i < 5 * 2; i++)
        {
            increment += 0.01f;
            tile[i] = new Tile(0.0f, 0.0f, 1.0f);
            tile[i].uploadAsEntity();
        }
    }

    public void render()
    {
        renderBackground();
        Background.getTexture().unbind();
        renderTiles();
        //Tile.getTexture().unbind();
    }

    public void renderTiles()
    {
        for (int i = 0; i < 5 * 2; i++)
        {
            tile[i].getEntity().render();
        }
    }

    public void renderBackground()
    {
        background.getEntity().render();
    }
}