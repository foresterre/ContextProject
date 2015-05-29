package cg.group4.container.music;

import cg.group4.GdxTestRunner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the music handle.
 * @see <a href=https://github.com/foresterre/ContextProject/issues/37>issue 37</a>
 */
@RunWith(GdxTestRunner.class)
public class MusicHandleTest {

    /**
     * Handle expected by the tests.
     */
    private FileHandle expectedHandle;

    /**
     * Gets the handle for a sample music file used for testing.
     */
    @Before
    public final void setUp()  {
        expectedHandle = Gdx.files.internal("music/Summer Day.mp3");
    }

    /**
     * Destroys the  handle used for testing after a test is finished.
     */
    @After
    public final void tearDown()  {
        expectedHandle = null;
    }

    /**
     * Tests whether the file handle getter works correctly.
     */
    @Test
    public final void testGet()  {
        FileHandle providedHandle = MusicHandle.bgMusic.get();
        assertEquals(expectedHandle, providedHandle);
    }

    /**
     * Tests whether the key used for the music object storage is provided correctly.
     */
    @Test
    public final void testKey()  {
        String expectedKey = Integer.toString(expectedHandle.hashCode());
        String providedKey = MusicHandle.bgMusic.key();
        assertEquals(expectedKey, providedKey);
    }
}