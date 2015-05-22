package cg.group4.container.image;

import cg.group4.container.sound.WoodMenuTexture;
import com.badlogic.gdx.graphics.Texture;

/**
 * Texture factory.
 * @author Martijn Gribnau
 */
public class TextureFactory {
    /**
     * Returns a new wood texture used or the buttons in the menu.
     * @return Texture
     */
    public Texture getWoodMenuTexture() {
        return new WoodMenuTexture().get();
    }
}
