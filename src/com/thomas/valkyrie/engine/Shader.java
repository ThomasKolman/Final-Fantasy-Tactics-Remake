package com.thomas.valkyrie.engine;

import com.thomas.valkyrie.utils.ShaderUtils;

/**
 * Created by Thomas on 2016-01-10.
 */
public class Shader
{
    private int ID;

    public Shader(String vertex, String fragment)
    {
        ID = ShaderUtils.loadAll();
    }
}
