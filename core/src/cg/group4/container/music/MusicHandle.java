package cg.group4.container.music;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Stores handles for the different music files.
 * Based on these handles, the MusicFactory creates new Music objects.
 */
public enum MusicHandle {

    /**
     * File handle for the background music.
     */
    bgMusic(Gdx.files.internal("music/Summer Day.mp3")),

    /**
     * File handle for the music played after completing a task.
     */
    completedTaskMusic(Gdx.files.internal("music/completedTask.wav"));

    /**
     * The music handle to be stored by each enum value.
     */
    private final FileHandle cMusicHandle;

    /**
     * Stores a FileHandle for each enum value.
     * @param music The location of the music as a FileHandle object.
     */
    MusicHandle(final FileHandle music) {
        cMusicHandle = music;
    }

    /**
     * Returns the file handle for the stored file url.
     * @return file handle for the texture.
     */
    public FileHandle get() {
        return cMusicHandle;
    }

    /**
     * Returns the key used by the MusicStorage.
     * The key has to be unique for each music file.
     * Hence the hashCode has been used.
     * @return hashCode as string of the FileHandle
     */
    public String key() {
        return Integer.toString(cMusicHandle.hashCode());
    }

}
