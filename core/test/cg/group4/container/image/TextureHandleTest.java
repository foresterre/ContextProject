package cg.group4.container.image;

import cg.group4.GdxTestRunner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the texture handle.
 */
@RunWith(GdxTestRunner.class)
public class TextureHandleTest {

    /**
     * Handle expected by the tests.
     */
    private FileHandle cExpectedHandle;

    /**
     * Gets the handle for a sample texture file used for testing.
     */
    @Before
    public void setUp() {
        cExpectedHandle = Gdx.files.internal("images/wooden_sign.png");
    }

    /**
     * Destroys the handle used for testing after a test is finished.
     */
    @After
    public void tearDown() {
        cExpectedHandle = null;
    }

    /**
     * Tests whether the file handle getter works correctly.
     */
    @Test
    public void testGet() {
        FileHandle providedHandle = TextureHandle.woodenSign.get();
        assertEquals(cExpectedHandle, providedHandle);
    }

    /**
     * Tests whether the key used for the texture object storage is provided correctly.
     */
    @Test
    public void testKey() {
        String expectedKey = Integer.toString(cExpectedHandle.hashCode());
        String providedKey = TextureHandle.woodenSign.key();
        assertEquals(expectedKey, providedKey);
    }
}
