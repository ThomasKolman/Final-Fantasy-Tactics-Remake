package com.thomas.valkyrie.level;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.graphics.Background;
import com.thomas.valkyrie.graphics.Character;
import com.thomas.valkyrie.graphics.Indicators;
import com.thomas.valkyrie.graphics.Tile;
import com.thomas.valkyrie.logic.Movement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 2016-01-21.
 */
public class Jagd
{
    final public int rows = 18;
    final public int columns = 18;

    // Static graphics
    private Tile[][] tile = new Tile[18][18];
    private Background background = new Background();
    private Character character;

    // Dynamic graphics
    private List<Indicators> indicators = new ArrayList<>();

    public Jagd()
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

        for (int i = 0; i < tile[0].length; i++)
        {
            for (int j = 0; j < tile[1].length; j++)
            {
                tile[i][j] = new Tile(xIncrement + 0.0f, yIncrement + 0.0f, 1.0f, i, j);
                xIncrement += 0.1f;
            }
            xIncrement = 0.0f;
            yIncrement -= 0.1f;
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
        // TODO
        Shader.INDICATOR.disable();
    }

    public void render()
    {
        renderBackground();
        renderTiles();
        //renderIndicator();
        renderCharacter();
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
        Shader.CHARACTER.enable();
        character.getEntity().render("transformationMatrix");
        character.getEntity().increasePosition(0.1f, 0.0f, 0.0f);

        character.getEntity().increasePosition(-0.1f, 0.0f, 0.0f);
        Shader.CHARACTER.disable();
    }

    public void renderIndicator()
    {
        Shader.INDICATOR.enable();
        // TODO
        Shader.INDICATOR.disable();
    }
}
