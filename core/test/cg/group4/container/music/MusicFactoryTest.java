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
 * @see <a href=https://github.com/foresterre/ContextProject/issues/37>issue 37</a>
 */
@RunWith(GdxTestRunner.class)
public class MusicFactoryTest {

    /**
     * Factory for the music.
     */
    protected MusicFactory musicFactoryMock;

    /**
     * Mock object for a Music object.
     */
    protected Music musicMock;

    /**
     * Sets up the test objects.
     *
     * @throws Exception exception catch if any
     */
    @Before
    public final void setUp() throws Exception {
        musicFactoryMock = mock(MusicFactory.class);
        musicMock = mock(Music.class);
    }

    /**
     * Tears down the test objects.
     *
     * @throws Exception exception catch if any
     */
    @After
    public final void tearDown() throws Exception {
        musicFactoryMock = null;
        musicMock = null;
    }

    /**
     * Tests whether the background music is gettable.
     *
     * @throws Exception exception catch if any
     */
    @Test
    public void testGetBackgroundMusic() throws Exception {
        when(musicFactoryMock.getBackgroundMusic()).thenReturn(musicMock);
        musicFactoryMock.getBackgroundMusic();
        verify(musicFactoryMock).getBackgroundMusic();
    }

    /**
     * Tests whether the completed music is gettable.
     *
     * @throws Exception exception catch if any
     */
    @Test
    public final void testGetCompletedTaskMusic() throws Exception {
        when(musicFactoryMock.getCompletedTaskMusic()).thenReturn(musicMock);
        musicFactoryMock.getCompletedTaskMusic();
        verify(musicFactoryMock).getCompletedTaskMusic();
    }
}