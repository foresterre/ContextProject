package cg.group4.container.image;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

/**
 * Data object for the reuse of texture objects.
 * Stores textures in a map.
 * If you are not re-using textures, you can also directly use a TextureFactory.
 */
public class TextureStorage {

    /**
     * Factory used to get the texture files.
     */
    protected TextureFactory cTextureFactory;

    /**
     * Stores a Texture object in the following map.
     * The reason for this is, that this way, not every Music object has to be recreated
     * each time the texture is requested.
     */
    protected Map<String, Texture> cTextureMap;

    /**
     * Creates a new Texture storage.
     */
    public TextureStorage() {
        cTextureMap = new HashMap<String, Texture>();
        cTextureFactory = new TextureFactory();
    }

    /**
     * Stores each texture in the map, for reuse.
     */
    public void initStore() {
        // wood menu image
        cTextureMap.put(TextureHandle.woodenSign.key(), cTextureFactory.getWoodMenuTexture());
    }

    /**
     * Returns the texture with the given tag.
     *
     * @param key The key of the texture which is defined as the String of the hashCode of the fileHandle
     *            in the TextureHandle enum.
     * @return The texture.
     */
    public Texture get(final String key) {
        return cTextureMap.get(key);
    }
}
