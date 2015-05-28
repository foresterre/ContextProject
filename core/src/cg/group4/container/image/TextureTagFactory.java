package cg.group4.container.image;

/**
 * Tag factory for textures.
 */
public class TextureTagFactory {

    /**
     * Creates a new TextureTagFactory.
     */
    public TextureTagFactory() {
    }

    /**
     * Returns the tag of the texture.
     *
     * @return String
     */
    public final String getWoodMenuTextureTag() {
        return new WoodMenuTexture().tag();
    }
}
