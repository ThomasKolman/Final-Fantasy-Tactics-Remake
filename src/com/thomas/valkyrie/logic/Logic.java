package com.thomas.valkyrie.logic;

import com.thomas.valkyrie.UI.DynamicGraphics;
import com.thomas.valkyrie.characters.BaseCharacter;
import com.thomas.valkyrie.characters.BlackMage;
import com.thomas.valkyrie.engine.Shader;
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

    final private DynamicGraphics dynamicGraphics = new DynamicGraphics();

    private int characterTurn = 0;

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
        baseLevel.map.updateNodeData(0, 0);
        Indicators.create();
        int incrementList = 0;

        for (int i = 0; i < baseLevel.map.getRows(); i++)
        {
            for (int j = 0; j < baseLevel.map.getColumns(); j++)
            {
                if (baseLevel.map.getNodeData(i, j) < baseCharacter[0].mobility)
                {
                    DynamicGraphics.createNewIndicators(i, j, incrementList, baseCharacter[0].getxPosition(), baseCharacter[0].getyPosition());
                    incrementList += 1;
                }
            }
        }
    }
}
