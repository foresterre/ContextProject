package cg.group4.container.image;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

/**
 * Data object for the reuse of texture objects.
 * Stores textures in a map.
 * If you are not re-using textures, you can also directly use a TextureFactory.
 *
 * @author Martijn Gribnau
 */
public class TextureStorage {

    /**
     * Factory used to get the texture files.
     */
    protected TextureFactory cTextureFactory;

    /**
     * Factory for the tags of the used texture files.
     */

    protected TextureTagFactory cTextureTagFactory;
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
        cTextureTagFactory = new TextureTagFactory();
    }

    /**
     * Stores each texture in the map, for reuse.
     */
    public final void initStore() {
        // wood menu image
        cTextureMap.put(cTextureTagFactory.getWoodMenuTextureTag(), cTextureFactory.getWoodMenuTexture());
    }

    /**
     * Returns the texture with the given tag.
     *
     * @param tag The given tag.
     * @return The texture.
     */
    public final Texture get(final String tag) {
        return cTextureMap.get(tag);
    }
}
