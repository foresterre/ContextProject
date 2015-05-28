package cg.group4.container.music;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Class for the background music specification.
 *
 * @author Martijn Gribnau
 */
public class BackgroundMusic implements IMusic {

    /**
     * Tag for the music.
     */
    protected static final String TAG = BackgroundMusic.class.getSimpleName();


    /**
     * Filepath for the music.
     */
    protected static final String PATH = "music/Summer Day.mp3";

    /**
     * The music file to be loaded.
     */
    protected Music cMusic;

    /**
     * Constructs a new music file.
     */
    public BackgroundMusic() {
        cMusic = Gdx.audio.newMusic(Gdx.files.internal(PATH));
    }

    /**
     * Returns the music contained by the BackgroundMusic.
     *
     * @return Music
     */
    @Override
    public final Music get() {
        return cMusic;
    }

    /**
     * Returns the tag for the background music.
     *
     * @return String tag
     */
    @Override
    public final String tag() {
        return TAG;
    }

    /**
     * Disposes the music file.
     * Use when it is no longer needed.
     */
    @Override
    public final void dispose() {
        cMusic.dispose();
    }

}
