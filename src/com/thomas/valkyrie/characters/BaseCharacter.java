package com.thomas.valkyrie.characters;

import com.thomas.valkyrie.engine.Texture;

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

    protected BaseCharacter(int ID, int health, int meleeAttack, int mobility, int range, int healPower, Texture texture)
    {
        this.ID = ID;
        this.health = health;
        this.meleeAttack = meleeAttack;
        this.mobility = mobility;
        this.range = range;
        this.healPower = healPower;
        this.texture = texture;
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
