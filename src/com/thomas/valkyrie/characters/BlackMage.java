package com.thomas.valkyrie.characters;

import com.thomas.valkyrie.engine.Texture;

/**
 * Created by Thomas on 2016-01-18.
 */
public class BlackMage extends BaseCharacter
{
    public BlackMage()
    {
        super(0, 100, 10, 4, 0, new Texture("black_mage.png"));
    }

    @Override
    public void move()
    {

    }

    public int getID()
    {
        return ID;
    }

    public int getHealth()
    {
        return health;
    }

    public int getMeleeAttack()
    {
        return meleeAttack;
    }

    public int getMobility()
    {
        return mobility;
    }

    public int getRange()
    {
        return range;
    }

    public Texture getTexture()
    {
        return texture;
    }
}
