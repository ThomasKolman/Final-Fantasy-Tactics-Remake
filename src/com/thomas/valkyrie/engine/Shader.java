package com.thomas.valkyrie.engine;

import com.thomas.valkyrie.maths.Vector3f;
import com.thomas.valkyrie.utils.BufferUtils;
import com.thomas.valkyrie.utils.ShaderUtils;
import org.lwjgl.util.vector.Matrix4f;

import java.nio.FloatBuffer;
import sun.audio.*;

import static org.lwjgl.opengl.GL20.*;

/**
 * Created by Thomas on 2016-01-10.
 */
public class Shader
{
    private int ID;
    public static Shader BG;

    // USES CUSTOM BUFFERUTILS CLASS ;; SWITCH TO LWJGL'S DEFAULT IMPLEMENT IF NOT WORKING
    private static FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(16);

    private int location_transformationMatrix;

    public Shader(String vertex, String fragment)
    {
        ID = ShaderUtils.load(vertex, fragment);
    }

    public static void loadAll()
    {
        BG = new Shader("com/thomas/valkyrie/shaders/triangle.vert", "com/thomas/valkyrie/shaders/triangle.frag");
    }

    public int getUniformLocation(String name)
    {
        return glGetUniformLocation(ID, name);
    }

    public void getAllUniformLocation()
    {
        location_transformationMatrix = getUniformLocation("transformationMatrix");
    }

    public void loadTransformationMatrix(Matrix4f matrix)
    {
        loadMatrix(location_transformationMatrix, matrix);
    }

    public void setUniform3f(String name, Vector3f vector)
    {
        glUniform3f(getUniformLocation(name), vector.x, vector.y, vector.z);
    }

    public void loadFloat(int location, float value)
    {
        glUniform1f(location, value);
    }

    public void loadVector(int location, Vector3f vector)
    {
        glUniform3f(location, vector.x, vector.y, vector.z);
    }

    public void loadBoolean(int location, boolean value)
    {
        float toLoad = 0;
        if( value )
        {
            toLoad = 1;
        }
        glUniform1f(location, toLoad);
    }

    public void loadMatrix(int location, Matrix4f matrix)
    {
        matrix.store(matrixBuffer);
        matrixBuffer.flip();
        glUniformMatrix4fv(location, false, matrixBuffer);
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
