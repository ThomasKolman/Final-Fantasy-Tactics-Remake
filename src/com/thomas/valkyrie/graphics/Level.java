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
    private Tile[][] tile = new Tile[9][9];
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
        float xIncrement = 0.0f;
        float yIncrement = 0.0f;

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                tile[i][j] = new Tile(xIncrement + 0.0f, yIncrement + 0.0f, 1.0f);
                tile[i][j].uploadAsEntity();
                xIncrement += 0.2f;
            }
            xIncrement = 0.0f;
            yIncrement -= 0.2f;
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
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                tile[i][j].getEntity().render("transformationMatrix");
            }
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