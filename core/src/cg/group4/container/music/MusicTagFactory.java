package cg.group4.container.music;


/**
 * Factory for tags of different songs.
 */
public class MusicTagFactory {

    /**
     * Empty constructor for the music tag factory.
     * Get each music sound by calling the getters below.
     */
    public MusicTagFactory() {
    }

    /**
     * Tag for the background music.
     *
     * @return String tag
     */
    public final String getBackgroundMusicTag() {
        return new BackgroundMusic().tag();
    }

    /**
     * Tag for the completed task music.
     *
     * @return String tag
     */
    public final String getCompletedTaskMusicTag() {
        return new CompletedTaskMusic().tag();
    }

}