package com.thomas.valkyrie.animation;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.graphics.Sprite;

/**
 * Created by Thomas on 2016-01-25.
 */
public class Animation
{
    private Sprite sprite;

    public Animation()
    {
        createSprite();
    }

    public void render()
    {
        renderSprite();
    }

    private void createSprite()
    {
        Shader.SPRITE.enable();
        Sprite.create();
        sprite = new Sprite(0.0f, 0.0f, 1.0f);
        Shader.SPRITE.disable();
    }

    private void renderSprite()
    {
        Shader.SPRITE.enable();
        sprite.getEntity().render("transformationMatrix");
        Shader.SPRITE.disable();
    }

    public void moveSprite(float xTarget, float yTarget, float xPos, float yPos)
    {
        float xDistance = xTarget - xPos;
        float yDistance = yTarget - yPos;

        System.out.println(xDistance);
        System.out.println(yDistance);

        Shader.SPRITE.enable();
        sprite.getEntity().increasePosition(xDistance, yDistance, 0.0f);
        Shader.SPRITE.disable();
    }
}
