package cg.group4.container.image;

import cg.group4.container.sound.WoodMenuTexture;

/**
 * Tag factory for textures.
 */
public class TextureTagFactory {

    /**
     * Returns the tag of the texure.
     * @return String
     */
    public String getWoodMenuTextureTag() {
        return new WoodMenuTexture().tag();
    }
}
