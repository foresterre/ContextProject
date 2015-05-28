package cg.group4.container.music;

import com.badlogic.gdx.audio.Music;

import java.util.HashMap;
import java.util.Map;

/**
 * Storage for the different music objects used by the game.
 * @author Martijn Gribnau
 */
public class MusicStorage {

    /**
     * Factory used to get the audio files.
     */
    protected MusicFactory cMusicFactory;

    /**
     * Stores a Music object in the following map.
     * The reason for this is, that this way, not every Music object has to be recreated
     * each time the music is requested.
     */
    protected Map<String, Music> cSoundMap;

    /**
     * Creates a new map for storage of the loaded music files.
     * Also creates a factory for the creation of the Music objects.
     */
    public MusicStorage() {
        cSoundMap = new HashMap<String, Music>();
        cMusicFactory = new MusicFactory();
    }

    /**
     * Stores each music type in the map, for reuse.
     */
    public final void initStore() {
        // background music
        cSoundMap.put(MusicHandle.bgMusic.key(), cMusicFactory.getBackgroundMusic());
        // completed task music
        cSoundMap.put(MusicHandle.completedTaskMusic.key(), cMusicFactory.getCompletedTaskMusic());
    }

    /**
     * Getter for a music object with the given tag.
     *
     * @param tag The given tag.
     * @return The music object.
     */
    public final Music get(final String tag) {
        return cSoundMap.get(tag);
    }


}
