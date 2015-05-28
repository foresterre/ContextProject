package cg.group4.container.image;

import com.badlogic.gdx.graphics.Texture;

/**
 * Interface for a texture which has to be created with the TextureFactory..
 *
 * @author Martijn Gribnau
 */
public interface ITexture {

    /**
     * Returns the texture object.
     *
     * @return Texture
     */
    Texture get();

    /**
     * Returns a String which represents the tag of the texture object.
     *
     * @return String
     */
    String tag();

    /**
     * Disposes the music.
     */
    void dispose();
}
