package cg.group4.container.music;

import cg.group4.GdxTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Tests for the BackgroundMusic class.
 */
@RunWith(GdxTestRunner.class)
public class BackgroundMusicTest {

    /**
     * BackgroundMusic test object.
     */
    protected BackgroundMusic bg;

    /**
     * BackgroundMusic spy object.
     */
    protected BackgroundMusic bgm;

    /**
     * Setup background music tests.
     */
    @Before
    public final void setUp() {
        bg = new BackgroundMusic();
        bgm = spy(BackgroundMusic.class);
    }

    /**
     * Tear down background music tests.
     */
    @After
    public final void tearDown() {
        bg = null;
        bgm = null;
    }

    /**
     * Test path.
     */
    @Test
    public final void testPathConst() {
        final String path = "music/Summer Day.mp3";
        assertEquals(path, BackgroundMusic.PATH);
    }

    /**
     * Test tag.
     */
    @Test
    public final void testTagConst() {
        final String path = "BackgroundMusic";
        assertEquals(path, bg.tag());
    }

    /**
     * Test get().
     */
    @Test
    public final void testGet() {
        bgm.get();
        verify(bgm, times(1)).get();
    }

    /**
     * Test tag().
     */
    @Test
    public final void testTag() {
        final String tag = BackgroundMusic.class.getSimpleName();
        assertEquals(tag, bg.tag());
    }

    /**
     * Test dispose().
     */
    @Test
    public final void testDispose() {
        bgm.dispose();
        verify(bgm, times(1)).dispose();
    }
}