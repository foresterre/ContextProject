package cg.group4.container.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;

/**
 * Class for the completed task music specification.
 * @author Martijn Gribnau
 */
public class CompletedTaskMusic implements IMusic {

    /**
     * Tag for the music.
     */
    protected final String TAG = this.getClass().getSimpleName();

    /**
     * Filepath for the music.
     */
    protected final String PATH = "music/completedTask.wav";


    /**
     * The music file to be loaded.
     */
    protected Music cMusic;

    /**
     * Constructs a new music file.
     */
    public CompletedTaskMusic() {
        FileHandle handle = Gdx.files.internal(PATH);
        cMusic = Gdx.audio.newMusic(handle);
    }

    /**
     * Returns the music contained by the BackgroundMusic.
     * @return Music
     */
    @Override
    public Music get() {
        return cMusic;
    }

    /**
     * Returns the tag of the completed task music.
     * @return
     */
    @Override
    public String tag() {
        return TAG;
    }

    /**
     * Disposes the music file.
     * Use when it is no longer needed.
     */
    @Override
    public void dispose() {
        cMusic.dispose();
    }
}
