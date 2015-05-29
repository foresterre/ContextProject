package cg.group4.container.music;

import cg.group4.GdxTestRunner;
import com.badlogic.gdx.audio.Music;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

/**
 * Tests for the MusicFactory.
 */
@RunWith(GdxTestRunner.class)
public class MusicFactoryTest {

    /**
     * Factory for the music.
     */
    protected MusicFactory cMusicFactoryMock;

    /**
     * Mock object for a Music object.
     */
    protected Music cMusicMock;

    /**
     * Sets up the test objects.
     *
     * @throws Exception exception catch if any
     */
    @Before
    public final void setUp() throws Exception {
        cMusicFactoryMock = mock(MusicFactory.class);
        cMusicMock = mock(Music.class);
    }

    /**
     * Tears down the test objects.
     *
     * @throws Exception exception catch if any
     */
    @After
    public final void tearDown() throws Exception {
        cMusicFactoryMock = null;
        cMusicMock = null;
    }

    /**
     * Tests whether the background music is gettable.
     *
     * @throws Exception exception catch if any
     */
    @Test
    public final void testGetBackgroundMusic() throws Exception {
        when(cMusicFactoryMock.getBackgroundMusic()).thenReturn(cMusicMock);
        cMusicFactoryMock.getBackgroundMusic();
        verify(cMusicFactoryMock).getBackgroundMusic();
    }

    /**
     * Tests whether the completed music is gettable.
     *
     * @throws Exception exception catch if any
     */
    @Test
    public final void testGetCompletedTaskMusic() throws Exception {
        when(cMusicFactoryMock.getCompletedTaskMusic()).thenReturn(cMusicMock);
        cMusicFactoryMock.getCompletedTaskMusic();
        verify(cMusicFactoryMock).getCompletedTaskMusic();
    }
}