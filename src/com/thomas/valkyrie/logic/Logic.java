package com.thomas.valkyrie.logic;

import com.thomas.valkyrie.UI.DynamicGraphics;
import com.thomas.valkyrie.animation.Animation;
import com.thomas.valkyrie.characters.BaseCharacter;
import com.thomas.valkyrie.characters.BlackMage;
import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.graphics.Indicators;
import com.thomas.valkyrie.input.MousePosition;
import com.thomas.valkyrie.level.BaseLevel;
import com.thomas.valkyrie.maths.CoordMath;
import com.thomas.valkyrie.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 2016-01-24.
 */
public class Logic
{
    final public BaseCharacter[] baseCharacter = new BaseCharacter[4];
    final public BaseLevel baseLevel;

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

    public void preActionUpdate()
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
        int xPosition = CoordMath.floatToInt(baseCharacter[characterTurn].getxPosition());
        int yPosition = CoordMath.floatToInt(baseCharacter[characterTurn].getyPosition());
        baseLevel.map.updateNodeData(xPosition, yPosition);

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

    private void setNewPosition(float newXPos, float newYPos)
    {
        baseCharacter[characterTurn].setxPosition(newXPos);
        baseCharacter[characterTurn].setyPosition(newYPos);
    }

    public void move(Animation animation)
    {
        float xTarget;
        float yTarget;

        List<Integer> xCoord = new ArrayList<>(DynamicGraphics.getxPositions());
        List<Integer> yCoord = new ArrayList<>(DynamicGraphics.getyPositions());

        for (int i = 0; i < xCoord.size(); i++)
        {
            xTarget = baseLevel.map.nodeMap[xCoord.get(i)][yCoord.get(i)].getxCoord();
            yTarget = baseLevel.map.nodeMap[xCoord.get(i)][yCoord.get(i)].getyCoord();

            if (MousePosition.getxCartesian() > xTarget && MousePosition.getxCartesian() < xTarget + 0.1f)
            {
                if (MousePosition.getyCartesian() < yTarget && MousePosition.getyCartesian() > yTarget - 0.1f)
                {
                    baseCharacter[characterTurn].move(xTarget, yTarget, baseCharacter[characterTurn].getxPosition(),
                            baseCharacter[characterTurn].getyPosition());
                    setNewPosition(xTarget, yTarget);
                }
            }
        }
    }

    public Logic(BaseLevel baseLevel)
    {
        this.baseLevel = baseLevel;
        int[] chosenCharacters = FileUtils.getStartupData();

        Shader[] listOfShaders = new Shader[]
                {
                    Shader.SPRITE_ONE,
                    Shader.SPRITE_TWO,
                    Shader.SPRITE_THREE,
                    Shader.SPRITE_FOUR
                };

        float[] listOfStartingXPositions = new float[]
                {
                        -0.9f,
                        -0.9f,
                        0.2f,
                        0.2f
                };

        float[] listOfStartingYPositions = new float[]
                {
                        0.9f,
                        0.8f,
                        -0.2f,
                        -0.3f
                };

        for (int i = 0; i < chosenCharacters.length; i++)
        {
            switch (chosenCharacters[i])
            {
                case 0 :
                    baseCharacter[i] = new BlackMage(listOfShaders[i], listOfStartingXPositions[i],
                            listOfStartingYPositions[i]);
                    break;

                case 1 :
                    baseCharacter[i] = new BlackMage(listOfShaders[i], listOfStartingXPositions[i],
                            listOfStartingYPositions[i]);
                    break;

                case 2 :
                    baseCharacter[i] = new BlackMage(listOfShaders[i], listOfStartingXPositions[i],
                            listOfStartingYPositions[i]);
                    break;

                case 3 :
                    baseCharacter[i] = new BlackMage(listOfShaders[i], listOfStartingXPositions[i],
                            listOfStartingYPositions[i]);
                    break;

            }
        }
    }

    public int getCharacterTurn()
    {
        return characterTurn;
    }

    public int getCharacterState()
    {
        return characterState;
    }
}
