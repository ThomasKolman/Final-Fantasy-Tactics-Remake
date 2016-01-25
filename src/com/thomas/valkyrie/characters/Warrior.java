package com.thomas.valkyrie.characters;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;

/**
 * Created by Thomas on 2016-01-06.
 */
public class Warrior extends BaseCharacter
{
    public Warrior(Shader SPRITE, float xPosition, float yPosition)
    {
        super(1, 100, 20, 5, 3, 2, new Texture("dirt_png"), SPRITE, xPosition, yPosition);
    }
}
