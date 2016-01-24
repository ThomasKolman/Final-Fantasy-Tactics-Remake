package com.thomas.valkyrie.level;

import com.thomas.valkyrie.logic.Map;

/**
 * Created by Thomas on 2016-01-24.
 */
public class BaseLevel
{
    final public Map map;

    final protected int row;
    final protected int column;

    protected BaseLevel(int row, int column)
    {
        this.row = row;
        this.column = column;

        map = new Map(row, column);
    }
}
