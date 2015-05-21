package cg.group4.container.sound;

import com.badlogic.gdx.audio.Music;

/**
 * Factory for music.
 * Not linearly the factory method.
 */
public class MusicFactory {

    /**
     * Empty constructor for the music factory.
     * Get each music sound by calling the getters below.
     */
    public MusicFactory() {
    }

    /**
     * Returns the background music as Music object.
     * @return Music
     */
    public Music getBackgroundMusic() {
        return new BackgroundMusic().get();
    }

    /**
     * Returns the completed task music as Music object.
     * @return Music
     */
    public Music getCompletedTaskMusic() {
        return new CompletedTaskMusic().get();
    }

}
