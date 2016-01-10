package com.thomas.valkyrie.engine;

import com.thomas.valkyrie.maths.Vector3f;
import com.thomas.valkyrie.utils.ShaderUtils;

import static org.lwjgl.opengl.GL20.*;

/**
 * Created by Thomas on 2016-01-10.
 */
public class Shader
{
    private int ID;
    public static Shader BG;

    public Shader(String vertex, String fragment)
    {
        ID = ShaderUtils.load(vertex, fragment);
    }

    public static void loadAll()
    {
        BG = new Shader("com/thomas/valkyrie/shaders/triangle.vert", "com/thomas/valkyrie/shaders/triangle.frag");
    }

    public int getUniform(String name)
    {
        return glGetUniformLocation(ID, name);
    }

    public void setUniform3f(String name, Vector3f vector)
    {
        glUniform3f(getUniform(name), vector.x, vector.y, vector.z);
    }

    public void enable()
    {
        glUseProgram(ID);
    }

    public void disable()
    {
        glUseProgram(0);
    }
}
