package com.thomas.valkyrie.logic;

import com.thomas.valkyrie.UI.DynamicGraphics;
import com.thomas.valkyrie.characters.BaseCharacter;
import com.thomas.valkyrie.characters.BlackMage;
import com.thomas.valkyrie.graphics.Indicators;
import com.thomas.valkyrie.level.BaseLevel;
import com.thomas.valkyrie.utils.FileUtils;

import java.util.*;
import java.util.Map;

/**
 * Created by Thomas on 2016-01-24.
 */
public class Logic
{
    final private BaseCharacter[] baseCharacter = new BaseCharacter[4];
    final private BaseLevel baseLevel;

    private int characterTurn = 0;
    private int characterState = 0;

    public void updateTurn()
    {
        characterTurn += 1;
        if (characterTurn == 4)
            characterTurn = 0;
    }

    public void updateState()
    {
        characterState += 1;
        if (characterState == 3)
            characterState = 0;
    }

    public void update()
    {
        if (characterState == 0)
        {
            checkActionRange(baseCharacter[characterTurn].mobility);
        }
        else if (characterState == 1)
        {
            checkActionRange(baseCharacter[characterTurn].range);
        }
        else
        {
            checkActionRange(baseCharacter[characterTurn].range);
        }
    }

    public void checkActionRange(int range)
    {
        baseLevel.map.updateNodeData(0, 0);
        Indicators.create();
        DynamicGraphics.clearAll();
        int indexer = 0;

        for (int i = 0; i < baseLevel.map.getRows(); i++)
        {
            for (int j = 0; j < baseLevel.map.getColumns(); j++)
            {
                if (baseLevel.map.getNodeData(i, j) < range)
                {
                    DynamicGraphics.createNewIndicators(i, j, indexer, baseCharacter[characterTurn].getxPosition(),
                            baseCharacter[characterTurn].getyPosition(), characterState);
                    indexer += 1;
                }
            }
        }
    }

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
}
