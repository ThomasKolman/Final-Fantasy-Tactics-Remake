package com.thomas.valkyrie.graphics;

import com.thomas.valkyrie.engine.Shader;
import com.thomas.valkyrie.engine.Texture;
import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.maths.Matrix4f;
import com.thomas.valkyrie.maths.Vector3f;

/**
 * Created by Thomas on 2016-01-16.
 */
public class Level
{
    private Tile[] tile = new Tile[5 * 2];

    public Level()
    {
        createTiles();
    }

    private void createTiles()
    {
        Tile.create();
        int increment = 0;

        for (int i = 0; i < 5 * 2; i += 2)
        {
            increment += 0.001f;
            tile[i] = new Tile(0.0f, 0.0f, 0.0f);
            tile[i].uploadAsEntity();
        }
    }

    public void renderTiles()
    {
        Shader.BG.enable();
        Shader.BG.setUniformMat4("transformationMatrix", Matrix4f.translate(new Vector3f(0.0f, 0.0f, 0.0f)));
        Tile.getTexture().bind();
        Tile.getVertexArray().draw();

        for (int i = 0; i < 5 * 2; i++)
        {
            Shader.BG.setUniformMat4("ml_matrix", tile[i].getTile_matrix());
        }
    }

}
