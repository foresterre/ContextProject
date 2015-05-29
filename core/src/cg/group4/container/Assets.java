package cg.group4.container;

import cg.group4.container.image.TextureStorage;
import cg.group4.container.music.MusicStorage;

/**
 * Container class for all assets.
 */
public class Assets {

    /**
     * Container for the music files.
     */
    protected MusicStorage cMusicStorage;

    /**
     * Container for texture files.
     */
    protected TextureStorage cTextureStorage;

    /**
     * Initializes the assets.
     */
    public Assets() {
        cMusicStorage = new MusicStorage();
        cMusicStorage.initStore();

        cTextureStorage = new TextureStorage();
        cTextureStorage.initStore();
    }

    /**
     * MusicStorage getter.
     *
     * @return music storage.
     */
    public final MusicStorage getMusicStorage() {
        return cMusicStorage;
    }

    /**
     * TextureStorage getter.
     *
     * @return texture storage.
     */
    public final TextureStorage getTextureStorage() {
        return cTextureStorage;
    }
}
