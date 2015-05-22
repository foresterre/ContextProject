package cg.group4.container.image;

import cg.group4.container.image.TextureFactory;
import cg.group4.container.image.TextureTagFactory;
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
     * Factory used to get the exture files.
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
     *
     */
    public TextureStorage() {
        cTextureMap = new HashMap<String, Texture>();
        cTextureFactory = new TextureFactory();
        cTextureTagFactory = new TextureTagFactory();
    }

    /**
     * Stores each texture in the map, for reuse.
     */
    public void initStore() {
        // wood menu image
        cTextureMap.put(cTextureTagFactory.getWoodMenuTextureTag(), cTextureFactory.getWoodMenuTexture());
    }

    public Texture get(String tag) {
        return cTextureMap.get(tag);
    }


}
