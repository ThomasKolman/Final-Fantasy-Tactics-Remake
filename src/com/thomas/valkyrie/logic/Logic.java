package com.thomas.valkyrie.logic;

import com.thomas.valkyrie.characters.BaseCharacter;
import com.thomas.valkyrie.characters.BlackMage;
import com.thomas.valkyrie.level.BaseLevel;
import com.thomas.valkyrie.utils.FileUtils;

/**
 * Created by Thomas on 2016-01-24.
 */
public class Logic
{
    final private BaseCharacter[] baseCharacter = new BaseCharacter[4];
    final private BaseLevel baseLevel;

    public Logic(BaseLevel baseLevel)
    {
        this.baseLevel = baseLevel;

        int[] chosenCharacters = FileUtils.getStartupData();

        for (int i = 0; i < chosenCharacters.length; i++)
        {
            switch (chosenCharacters[i])
            {
                case 0 :
                    baseCharacter[i] = new BlackMage();
                    break;

                case 1 :
                    baseCharacter[i] = new BlackMage();
                    break;

                case 2 :
                    baseCharacter[i] = new BlackMage();
                    break;

                case 3 :
                    baseCharacter[i] = new BlackMage();
                    break;

            }
        }
    }

    public void update()
    {

    }
}
