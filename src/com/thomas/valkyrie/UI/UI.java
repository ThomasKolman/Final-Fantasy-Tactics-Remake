package com.thomas.valkyrie.UI;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.graphics.Healthbar;
import com.thomas.valkyrie.graphics.Image;
import com.thomas.valkyrie.graphics.Menu;

/**
 * Created by Thomas on 2016-01-24.
 */
public class UI
{
    private Image[] image  = new Image[4];
    private Healthbar[] healthbar = new Healthbar[4];
    private Menu menu;

    public UI()
    {
        createImage();
        createHealthbar();
        createMenu();
    }

    public void render()
    {
        renderImage();
        renderHealthBar();
        renderMenu();
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
