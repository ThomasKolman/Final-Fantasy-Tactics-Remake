package com.thomas.valkyrie.level;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.graphics.*;
import com.thomas.valkyrie.logic.Map;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 2016-01-21.
 */
public class Jagd
{
    // Constants
    final static public int row = 12;
    final static public int column = 12;

    // Logic
    private Map map = new Map(row, column);

    // Static graphics
    private Tile[][] tile = new Tile[row][column];
    private Background background;
    private Sprite sprite;

    // Dynamic graphics
    private List<Indicators> indicators = new ArrayList<>();

    /**
     * Constructs game field
     */
    public Jagd()
    {
        createBackground();
        createTiles();
        createCharacter();
    }

    public void render()
    {
        renderBackground();
        renderTiles();
        renderCharacter();
    }

    public void createBackground()
    {
        Shader.BG.enable();
        Background.create();
        background = new Background();
        Shader.BG.disable();
    }

    private void createTiles()
    {
        Shader.TILE.enable();
        Tile.create();

        float xIncrement = 0.0f;
        float yIncrement = 0.0f;

        for (int i = 0; i < tile[0].length; i++)
        {
            for (int j = 0; j < tile[1].length; j++)
            {
                String texture;
                double random = Math.random();

                if (i > 1 && i < 10 && j > 1 && j < 10)
                {
                    if (random < 0.2)
                    {
                        texture = "dirt_texture";
                    }
                    else if (random > 0.2 && random < 0.4)
                    {
                        texture = "stone_texture";
                    }
                    else
                    {
                        texture = "grass_texture";
                    }
                }
                else
                {
                    if (random < 0.2)
                    {
                        texture = "dirt_texture";
                    }
                    else
                    {
                        texture = "grass_texture";
                    }
                }

                tile[i][j] = new Tile(xIncrement + 0.0f, yIncrement + 0.0f, 1.0f, texture);
                xIncrement += 0.1f;
            }
            xIncrement = 0.0f;
            yIncrement -= 0.1f;
        }

        Shader.TILE.disable();
    }

    public void createCharacter()
    {
        Shader.SPRITE.enable();
        Sprite.create();
        sprite = new Sprite(0.0f, 0.0f, 1.0f);
        Shader.SPRITE.disable();
    }

    public void renderTiles()
    {
        Shader.TILE.enable();
        for (int i = 0; i < tile[0].length; i++)
        {
            for (int j = 0; j < tile[1].length; j++)
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

    public void renderCharacter()
    {
        Shader.SPRITE.enable();
        sprite.getEntity().render("transformationMatrix");
        sprite.getEntity().increasePosition(0.1f, 0.0f, 0.0f);
        sprite.getEntity().increasePosition(-0.1f, 0.0f, 0.0f);
        Shader.SPRITE.disable();
    }
}
