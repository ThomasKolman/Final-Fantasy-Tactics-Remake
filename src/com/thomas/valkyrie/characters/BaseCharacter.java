package com.thomas.valkyrie.characters;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.graphics.Sprite;
import com.thomas.valkyrie.maths.CoordMath;

/**
 * Created by Thomas on 2016-01-06.
 */
public class BaseCharacter
{
    final public int ID;
    final public int health;
    final public int meleeAttack;
    final public int mobility;
    final public int range;
    final public int healPower;

    private float xPosition;
    private float yPosition;

    final public Texture texture;
    final public Shader SPRITE;
    private Sprite sprite;

    protected BaseCharacter(int ID, int health, int meleeAttack, int mobility, int range, int healPower,
                            Texture texture, Shader SPRITE, float xPosition, float yPosition)
    {
        this.ID = ID;
        this.health = health;
        this.meleeAttack = meleeAttack;
        this.mobility = mobility;
        this.range = range;
        this.healPower = healPower;
        this.texture = texture;
        this.SPRITE = SPRITE;

        this.xPosition = xPosition;
        this.yPosition = yPosition;

        createCharacter();
        move(xPosition, yPosition, 0.9f, 0.9f);
    }

    private void createCharacter()
    {
        SPRITE.enable();
        Sprite.create();
        sprite = new Sprite(0.0f, 0.0f, 1.0f);
        SPRITE.disable();
    }

    public void render()
    {
        SPRITE.enable();
        sprite.getEntity().render("transformationMatrix");
        SPRITE.disable();
    }

    public void move(float xTarget, float yTarget, float xPos, float yPos)
    {
        float xDifference = CoordMath.getDifference(xPos, xTarget);
        float yDifference = CoordMath.getDifference(yPos, yTarget);

        SPRITE.enable();
        sprite.getEntity().increasePosition(xDifference + 0.0f, yDifference + 0.0f, 0.0f);
        SPRITE.disable();
    }

    public float getxPosition()
    {
        return xPosition;
    }

    public float getyPosition()
    {
        return yPosition;
    }

    public void setxPosition(float xPosition)
    {
        this.xPosition = xPosition;
    }

    public void setyPosition(float yPosition)
    {
        this.yPosition = yPosition;
    }
}
