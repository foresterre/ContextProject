package cg.group4.container.sound;

import cg.group4.GdxTestRunner;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Tests for the BackgroundMusic class.
 */
@RunWith(GdxTestRunner.class)
public class BackgroundMusicTest extends TestCase {

    /**
     * BackgroundMusic test object.
     */
    BackgroundMusic bg;

    /**
     * BackgroundMusic spy object.
     */
    BackgroundMusic bgm;

    /**
     * Setup background music tests.
     * @throws Exception exception catch if any
     */
    @Before
    public void setUp() throws Exception {
        bg = new BackgroundMusic();
        bgm = spy(BackgroundMusic.class);
    }

    /**
     * Tear down background music tests.
     * @throws Exception exception catch if any
     */
    @After
    public void tearDown() throws Exception {
        bg = null;
        bgm = null;
    }

    /**
     * Test path.
     */
    @Test
    public void testPathConst() {
        final String REQUIRE = "music/Summer Day.mp3";
        assertEquals(REQUIRE, bg.PATH);
    }

    /**
     * Test tag.
     */
    @Test
    public void testTagConst() {
        final String REQUIRE = "BackgroundMusic";
        assertEquals(REQUIRE, bg.TAG);
    }

    /**
     * Test get().
     * @throws Exception exception catch if any
     */
    @Test
    public void testGet() throws Exception {
        bgm.get();
        verify(bgm, times(1)).get();
    }

    /**
     * Test tag().
     * @throws Exception exception catch if any
     */
    @Test
    public void testTag() throws Exception {
        final String REQUIRE = BackgroundMusic.class.getSimpleName();
        assertEquals(REQUIRE, bg.tag());
    }

    /**
     * Test dispose().
     * @throws Exception exception catch if any
     */
    @Test
    public void testDispose() throws Exception {
        bgm.dispose();
        verify(bgm, times(1)).dispose();
    }
}