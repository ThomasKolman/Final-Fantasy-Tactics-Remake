package com.thomas.valkyrie.characters;

/**
 * Created by Thomas on 2016-01-23.
 */
public class CharacterTuple<ID, TEXTURE>
{
    final public ID id;
    final public TEXTURE texture;

    public CharacterTuple(ID id, TEXTURE texture)
    {
        this.id = id;
        this.texture = texture;
    }
}
