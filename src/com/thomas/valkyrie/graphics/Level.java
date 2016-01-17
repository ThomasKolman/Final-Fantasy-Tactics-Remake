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
        Shader.BG.enable();
        Background.create();
        background.uploadAsEntity();
        Shader.BG.disable();
    }

    private void createTiles()
    {
        Shader.TILE.enable();
        Tile.create();
        float increment = 0;

        for (int i = 0; i < 5 * 2; i++)
        {
            increment += 0.1f;
            tile[i] = new Tile(increment + 0.0f, 0.0f, 1.0f);
            tile[i].uploadAsEntity();
        }
        Shader.TILE.disable();
    }

    public void render()
    {
        renderBackground();
        renderTiles();
    }

    public void renderTiles()
    {
        Shader.TILE.enable();
        for (int i = 0; i < 5 * 2; i++)
        {
            tile[i].getEntity().render("transformationMatrix");
        }
        Shader.TILE.disable();
    }

    public void renderBackground()
    {
        Shader.BG.enable();
        background.getEntity().render();
        Shader.BG.disable();
    }
}