package com.thomas.valkyrie.level;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.graphics.*;
import com.thomas.valkyrie.graphics.Character;
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
    private Image[] image  = new Image[4];
    private Healthbar[] healthbar = new Healthbar[4];
    private Background background = new Background();
    private Character character;
    private Menu menu;

    // Dynamic graphics
    private List<Indicators> indicators = new ArrayList<>();

    public Jagd()
    {
        createBackground();
        createTiles();
        createCharacter();
        createImage();
        createHealthbar();
        createMenu();
    }

    public void render()
    {
        renderBackground();
        renderTiles();
        renderCharacter();
        renderImage();
        renderHealthBar();
        renderMenu();
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

    public void createImage()
    {
        Shader.IMAGE.enable();
        Image.create();

        float xIncrement = 0.0f;

        for (int i = 0; i < image.length; i++)
        {
            image[i] = new Image(xIncrement + 0.0f, 0.0f, 1.0f);
            xIncrement += 0.45;
        }

        Shader.IMAGE.disable();
    }

    public void createHealthbar()
    {
        Shader.HEALTHBAR.enable();
        Healthbar.create();

        float xIncrement = 0.0f;

        for (int i = 0; i < healthbar.length; i++)
        {
            healthbar[i] = new Healthbar(xIncrement + 0.0f, 0.0f, 1.0f);
            xIncrement += 0.45;
        }

        Shader.HEALTHBAR.disable();
    }

    public void createMenu()
    {
        Shader.MENU.enable();
        Menu.create();
        menu = new Menu(0.0f, 0.0f, 0.0f);
        Shader.MENU.disable();
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

    public void renderImage()
    {
        Shader.IMAGE.enable();

        for (int i = 0; i < image.length; i++)
        {
            image[i].getEntity().render("transformationMatrix");
        }
        Shader.IMAGE.disable();
    }

    public void renderHealthBar()
    {
        Shader.HEALTHBAR.enable();
        for (int i = 0; i < healthbar.length; i++)
        {
            healthbar[i].getEntity().render("transformationMatrix");
        }
        Shader.HEALTHBAR.disable();
    }

    public void renderMenu()
    {
        Shader.MENU.enable();
        menu.getEntity().render("transformationMatrix");
        Shader.MENU.disable();
    }
}
