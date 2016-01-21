package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.logic.Movement;

/**
 * Created by Thomas on 2016-01-16.
 */
public class Level
{
    private Tile[][] tile = new Tile[9][9];
    private Background background = new Background();
    private Character character;
    private Indicators indicators;

    public Level()
    {
        createBackground();
        createTiles();
        createCharacter();
        createIndicator();
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
                tile[i][j] = new Tile(xIncrement + 0.0f, yIncrement + 0.0f, 1.0f, i, j);
                xIncrement += 0.2f;
            }
            xIncrement = 0.0f;
            yIncrement -= 0.2f;
        }

        Shader.TILE.disable();
    }

    public void createCharacter()
    {
        Shader.CHARACTER.enable();
        Character.create();
        character = new Character(0.0f, 0.0f, 1.0f);
        Shader.CHARACTER.disable();
    }

    public void createIndicator()
    {
        Shader.INDICATOR.enable();
        Movement.checkMovementSpace(3, 0, 0);
        int[][] xyMovableNodeCoords = new int[Movement.getxMovableNodes().size()][Movement.getyMovableNodes().size()];

        for (int i = 0; i < xyMovableNodeCoords[0].length; i++)
        {
            for (int j = 0; j < xyMovableNodeCoords[1].length; j++)
            {

            }
        }
        Indicators.create();
        indicators = new Indicators(0.0f, 0.0f, 0.0f);
        Shader.INDICATOR.disable();
    }

    public void render()
    {
        renderBackground();
        renderTiles();
        renderIndicator();
        renderCharacter();
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

    public void renderCharacter()
    {
        Shader.CHARACTER.enable();
        character.getEntity().render("transformationMatrix");
        Shader.CHARACTER.disable();
    }

    public void renderIndicator()
    {
        Shader.INDICATOR.enable();
        indicators.getEntity().render("transformationMatrix");
        Shader.INDICATOR.disable();
    }
}