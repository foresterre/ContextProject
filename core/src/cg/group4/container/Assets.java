package cg.group4.container;

import cg.group4.container.sound.MusicStorage;

/**
 * Container class for all assets.
 */
public class Assets {

    /**
     * Container for the music files.
     */
    MusicStorage cMusicStorage;

    /**
     * Initializes the assets.
     */
    public Assets() {
        cMusicStorage = new MusicStorage();
        cMusicStorage.initStore();
    }

    public MusicStorage getMusicStorage() {
        return cMusicStorage;
    }

}
