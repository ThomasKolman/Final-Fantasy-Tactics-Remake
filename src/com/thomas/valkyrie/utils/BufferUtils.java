package com.thomas.valkyrie.utils;

import java.nio.*;

/**
 *
 */
public class BufferUtils {

    private BufferUtils()
    {
        //TODO
    }

    public static ByteBuffer createByteBuffer(byte[] array)
    {
        ByteBuffer result = ByteBuffer.allocateDirect(array.length).order(ByteOrder.nativeOrder());
        result.put(array).flip();
        return result;
    }

    public static FloatBuffer createFloatBuffer(float[] array)
    {
        FloatBuffer result = ByteBuffer.allocateDirect(array.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        result.put(array).flip();
        return result;
    }

    public static IntBuffer createIntBuffer(int[] array)
    {
        IntBuffer result = ByteBuffer.allocateDirect(array.length << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
        result.put(array).flip();
        return result;
    }

    public static ShortBuffer createShortBuffer(short[] array)
    {
        ShortBuffer result = org.lwjgl.BufferUtils.createShortBuffer(array.length);
        result.put(array).flip();
        return result;
    }
}

