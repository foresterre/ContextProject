package cg.group4.container.music;

import com.badlogic.gdx.audio.Music;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Martijn Gribnau
 */
public class MusicStorage {

    /**
     * Factory used to get the audio files.
     */
    protected MusicFactory cMusicFactory;

    /**
     * Factory for the tags of the used audo files.
     */

    protected MusicTagFactory cMusicTagFactory;
    /**
     * Stores a Music object in the following map.
     * The reason for this is, that this way, not every Music object has to be recreated
     * each time the music is requested.
     */
    protected Map<String, Music> cSoundMap;

    /**
     *
     */
    public MusicStorage() {
        cSoundMap = new HashMap<String, Music>();
        cMusicFactory = new MusicFactory();
        cMusicTagFactory = new MusicTagFactory();
    }

    /**
     * Stores each music type in the map, for reuse.
     */
    public final void initStore() {
        // background music
        cSoundMap.put(cMusicTagFactory.getBackgroundMusicTag(), cMusicFactory.getBackgroundMusic());
        // completed task music
        cSoundMap.put(cMusicTagFactory.getCompletedTaskMusicTag(), cMusicFactory.getCompletedTaskMusic());
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
