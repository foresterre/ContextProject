package cg.group4.container.image;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Enum which stores the handles to the texture files used by this application.
 * Specifically if stored in TextureStorage.
 */
public enum TextureHandle {

    /**
     * The wooden button image displayed through the menu's.
     */
    woodenSign(Gdx.files.internal("images/wooden_sign.png"));

    /**
     * File handle for the values in this enum.
     */
    private final FileHandle textureHandle;

    /**
     * Stores a FileHandle for each enum value.
     * @param fileHandle The location of the texture image as a FileHandle object.
     */
    TextureHandle(final FileHandle fileHandle) {
        textureHandle = fileHandle;
    }

    /**
     * Returns the file handle for the pre defined file.
     * @return file handle for the texture.
     */
    public FileHandle get() {
        return textureHandle;
    }

    /**
     * Returns the key used by the TextureStorage.
     * The key has to be unique for each texture file.
     * Hence the hashCode has been used.
     * @return hashCode as string of the FileHandle
     */
    public String key() {
        return Integer.toString(textureHandle.hashCode());
    }

}
