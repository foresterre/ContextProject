package cg.group4.container.image;

/**
 * Tag factory for textures.
 */
public class TextureTagFactory {

    public TextureTagFactory(){}

    /**
     * Returns the tag of the texure.
     * @return String
     */
    public String getWoodMenuTextureTag() {
        return new WoodMenuTexture().tag();
    }
}
