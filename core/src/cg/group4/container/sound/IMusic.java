package cg.group4.container.sound;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;

/**
 * Interface for a music object.
 * @author Martijn Gribnau
 */
public interface IMusic {

    /**
     * Returns the music object.
     * @return Music
     */
    Music get();

    /**
     * Returns a String which represents the tag of the music object.
     * @return String
     */
    String tag();

    /**
     * Disposes the music.
     */
    void dispose();
}
