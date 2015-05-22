package cg.group4.container;

import cg.group4.container.image.TextureStorage;
import cg.group4.container.sound.MusicStorage;

/**
 * Container class for all assets.
 * @author Martijn Gribnau
 */
public class Assets {

    /**
     * Container for the music files.
     */
    MusicStorage cMusicStorage;

    /**
     * Container for texture files.
     */
    TextureStorage cTextureStorage;

    /**
     * Initializes the assets.
     */
    public Assets() {
        cMusicStorage = new MusicStorage();
        cMusicStorage.initStore();

        cTextureStorage = new TextureStorage();
        cTextureStorage.initStore();
    }

    public MusicStorage getMusicStorage() {
        return cMusicStorage;
    }
    public TextureStorage getcTextureStorage() { return cTextureStorage; }
}
