package com.thomas.valkyrie.utils;

import org.lwjgl.system.libffi.Closure;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniform1f;
import static org.lwjgl.opengl.GL20.glUniform3f;

/**
 * Created by Thomas on 2016-01-06.
 */
public class UniformUtils
{
    ShaderUtils shaderUtils = new ShaderUtils();

    private int location_transformationMatrix;

    private int getUniformLocation(String uniformName)
    {
        return glGetUniformLocation(shaderUtils.getProgramID(), uniformName);
    }

    private void getAllUniformLocations()
    {
        location_transformationMatrix = getUniformLocation("transformationMatrix");
    }

    private void loadFloat(int location, float value)
    {
        glUniform1f(location, value);
    }

    private void loadVector(int location, Vector3f vector)
    {
        glUniform3f(location, vector.x, vector.y, vector.z);
    }

    private void loadBoolean(int location, boolean value)
    {
        float toLoad = 0;
        if (value)
        {
            toLoad = 1;
        }
        glUniform1f(location, toLoad);
    }

    private void loadMatrix(int location, Matrix4f matrix)
    {

    }
}
