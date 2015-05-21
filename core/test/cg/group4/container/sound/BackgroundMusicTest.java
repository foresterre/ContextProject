package cg.group4.container.sound;

import cg.group4.GdxTestRunner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Tests for the BackgroundMusic class.
 * @author Martijn Gribnau
 */
@RunWith(GdxTestRunner.class)
public class BackgroundMusicTest extends TestCase {

    BackgroundMusic bg;
    BackgroundMusic bgm;

    @Before
    public void setUp() throws Exception {
        bg = new BackgroundMusic();
        bgm = spy(BackgroundMusic.class);
    }

    @After
    public void tearDown() throws Exception {
        bg = null;
        bgm = null;
    }

    @Test
    public void testPathConst() {
        assertEquals("music/Summer Day.mp3", bg.PATH);
    }

    @Test
    public void testTagConst() {
        assertEquals("BackgroundMusic", bg.TAG);
    }

    @Test
    public void testGet() throws Exception {
        bgm.get();
        verify(bgm, times(1)).get();
    }

    @Test
    public void testTag() throws Exception {
        final String expected = BackgroundMusic.class.getSimpleName();
        assertEquals(expected, bg.tag());
    }

    @Test
    public void testDispose() throws Exception {
        bgm.dispose();
        verify(bgm, times(1)).dispose();
    }
}