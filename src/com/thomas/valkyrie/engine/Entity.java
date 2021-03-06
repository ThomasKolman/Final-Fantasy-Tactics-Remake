package com.thomas.valkyrie.engine;

import com.thomas.valkyrie.maths.Matrix4f;
import com.thomas.valkyrie.maths.Vector3f;


/**
 * Creates a model entity that stores positional data. The
 * vertex array bindings, texture bindings, transformation
 * data, rotation data and scale of an entity are all stored
 * here.
 *
 * <p> Any constant uniform variables are declared here;
 * all single instance uniform variable transformations are
 * done in the @Level class </p>
 *
 * <p> Provides getter methods to distribute entity data
 * across the program</p>
 *
 * @author Thomas Kolman
 */
public class Entity
{
    private VertexArray vertexArray;
    private Texture texture;
    private Vector3f position;
    private float rotX, rotY, rotZ;
    private float scale;
    private Vector3f rotational_position;

    /**
     * Sets all entity data to class-level variables before rendering
     *
     * <p> Vertices data may be shared across entity objects,
     * but positional vector data is guaranteed to be different </p>
     *
     * @param vertexArray takes in graphical vertices data
     * @param texture takes in loaded texture
     * @param position takes in a positional vector
     * @param rotX takes in rotational data across the x axis
     * @param rotY takes in rotational data across the y axis
     * @param rotZ takes in rotational data across the z axis
     * @param scale takes in scale data (how small the image renders)
     */
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

    /**
     * Renders entity
     *
     * <p> Takes in no constant uniform variables (eg. rendering for
     * background texture)</p>
     *
     * @see VertexArray
     * @see Texture
     */
    public void render()
    {
        texture.bind();
        vertexArray.render();
        texture.unbind();
    }

    /**
     * Renders entity
     *
     * <p> Takes in a single constant transformation uniform variable </p>
     *
     * @see VertexArray
     * @see Texture
     */
    public void render(String uniformVariableName)
    {
        Shader.TILE.setUniformMat4(uniformVariableName, Matrix4f.translate(position));
        texture.bind();
        vertexArray.render();
        texture.unbind();
    }

    /**
     * Increses
     *
     * @param dx
     * @param dy
     * @param dz
     */
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