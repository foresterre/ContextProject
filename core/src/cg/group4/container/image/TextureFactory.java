package cg.group4.container.image;

import com.badlogic.gdx.graphics.Texture;

/**
 * Texture factory.
 *
 * @author Martijn Gribnau
 */
public class TextureFactory {

    /**
     * Factory for textures.
     */
    public TextureFactory() {
    }

    /**
     * Returns a new wood texture used or the buttons in the menu.
     *
     * @return Texture
     */
    public final Texture getWoodMenuTexture() {
        return new WoodMenuTexture().get();
    }
}
