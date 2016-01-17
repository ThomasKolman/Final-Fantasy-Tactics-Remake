package com.thomas.valkyrie.engine;

import com.thomas.valkyrie.maths.Matrix4f;
import com.thomas.valkyrie.maths.Vector3f;


/**
 * Created by Thomas on 2015-12-20.
 */
public class Entity
{
    private VertexArray vertexArray;
    private Texture texture;
    private Vector3f position;
    private float rotX, rotY, rotZ;
    private float scale;

    public Entity(VertexArray vertexArray, Texture texture, Vector3f position, float rotX, float rotY, float rotZ, float scale)
    {
        this.vertexArray = vertexArray;
        this.texture = texture;
        this.position = position;
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
        this.scale = scale;
    }

    public void render()
    {
        texture.bind();
        vertexArray.render();
        texture.unbind();
    }

    public void render(String uniformVariableName)
    {
        Shader.TILE.setUniformMat4(uniformVariableName, Matrix4f.translate(position));
        texture.bind();
        vertexArray.render();
        texture.unbind();
    }

    public void increasePosition(float dx, float dy, float dz)
    {
        this.position.x += dx;
        this.position.y += dy;
        this.position.z += dz;
    }

    public void increaseRotation(float dx, float dy, float dz)
    {
        this.rotX += dx;
        this.rotY += dy;
        this.rotZ += dz;
    }

    public void setPosition(Vector3f position)
    {
        this.position = position;
    }

    public void setRotX(float rotX)
    {
        this.rotX = rotX;
    }

    public void setRotY(float rotY)
    {
        this.rotY = rotY;
    }

    public void setRotZ(float rotZ)
    {
        this.rotZ = rotZ;
    }

    public void setScale(float scale)
    {
        this.scale = scale;
    }

    public Vector3f getPosition()
    {
        return position;
    }

    public float getRotX()
    {
        return rotX;
    }

    public float getRotY()
    {
        return rotY;
    }

    public float getRotZ()
    {
        return rotZ;
    }

    public float getScale()
    {
        return scale;
    }

}