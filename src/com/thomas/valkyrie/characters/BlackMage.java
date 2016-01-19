package com.thomas.valkyrie.characters;

import com.thomas.valkyrie.logic.Movement;

/**
 * Created by Thomas on 2016-01-18.
 */
public class BlackMage extends BaseCharacter
{
    public BlackMage()
    {
        health = 100;
        meleeAttack = 10;
        mobility = 4;
    }

    @Override
    public void move()
    {
        Movement.checkMovementSpace(mobility);

    }
}
