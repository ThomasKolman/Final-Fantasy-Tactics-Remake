package com.thomas.valkyrie.engine;

import com.thomas.valkyrie.maths.Vector3f;
import com.thomas.valkyrie.maths.Matrix4f;
import com.thomas.valkyrie.utils.ShaderUtils;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL20.*;

/**
 * Created by Thomas on 2016-01-10.
 */
public class Shader
{
    private int ID;
    public static Shader BG, TILE;
    private int location_transformationMatrix;

    private Shader(String vertex, String fragment)
    {
        ID = ShaderUtils.load(vertex, fragment);
    }

    public static void loadAll()
    {
        BG = new Shader("com/thomas/valkyrie/shaders/background.vert", "com/thomas/valkyrie/shaders/background.frag");
        TILE = new Shader("com/thomas/valkyrie/shaders/triangle.vert", "com/thomas/valkyrie/shaders/triangle.frag");
    }

    public int getUniformLocation(String name)
    {
        return glGetUniformLocation(ID, name);
    }

    public void getAllUniformLocations()
    {
        location_transformationMatrix = getUniformLocation("transformationMatrix");
    }

    public void setUniform3f(String name, Vector3f vector)
    {
        glUniform3f(getUniformLocation(name), vector.x, vector.y, vector.z);
    }

    public void setUniformMat4(String name, Matrix4f matrix4f)
    {
        glUniformMatrix4fv(getUniformLocation(name), false, matrix4f.toFloatBuffer());
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
