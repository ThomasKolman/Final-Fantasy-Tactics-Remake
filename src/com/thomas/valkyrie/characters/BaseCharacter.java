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

    private int xPosition;
    private int yPosition;

    final public Texture texture;

    protected BaseCharacter(int ID, int health, int meleeAttack, int mobility, int range, Texture texture)
    {
        this.ID = ID;
        this.health = health;
        this.meleeAttack = meleeAttack;
        this.mobility = mobility;
        this.range = range;
        this.texture = texture;
    }

    protected void move()
    {

    }

    public int getxPosition()
    {
        return xPosition;
    }

    public int getyPosition()
    {
        return yPosition;
    }

    public void setxPosition(int xPosition)
    {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition)
    {
        this.yPosition = yPosition;
    }
}
