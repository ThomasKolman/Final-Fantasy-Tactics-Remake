package com.thomas.valkyrie.characters;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;

/**
 * Created by Thomas on 2016-01-18.
 */
public class BlackMage extends BaseCharacter
{
    public BlackMage(Shader SPRITE, float xPos, float yPos)
    {
        super(0, 100, 10, 4, 3, 2, new Texture("black_mage.png"), SPRITE, xPos, yPos);
    }

}
