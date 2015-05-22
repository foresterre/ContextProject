package cg.group4.container.image;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

/**
 * Class for the wooden sign specification.
 * Used to display menu buttons.
 * @author Martijn Gribnau
 */
public class WoodMenuTexture implements ITexture {

    /**
     * Tag for the texture.
     */
    protected final String TAG = this.getClass().getSimpleName();


    /**
     * Filepath for the texture.
     */
    protected final String PATH = "images/wooden_sign.png";

    /**
     * The texture file to be loaded.
     */
    protected Texture cTexture;

    /**
     * Constructs a new texture file.
     */
    public WoodMenuTexture() {
        FileHandle handle = Gdx.files.internal(PATH);
        cTexture = new Texture(handle);
    }

    /**
     * Returns the music contained by the BackgroundMusic.
     * @return Music
     */
    @Override
    public Texture get() {
        return cTexture;
    }

    /**
     * Returns the tag for the texture.
     * @return String tag
     */
    @Override
    public String tag() {
        return TAG;
    }

    /**
     * Disposes the texture file.
     * Use when it is no longer needed.
     */
    @Override
    public void dispose() {
        cTexture.dispose();
    }

}
