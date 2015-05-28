package cg.group4.container.image;

import com.badlogic.gdx.graphics.Texture;

/**
 * Factory to create new textures.
 * Does this based on the FileHandle's defined in the TextureHandle enum.
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
     * @return Texture texture
     */
    public final Texture getWoodMenuTexture() {
        return new Texture(TextureHandle.woodenSign.get());
    }
}
