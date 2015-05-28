package cg.group4.container.sound;

import com.badlogic.gdx.audio.Music;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Tests for the MusicFactory.
 */
public class MusicFactoryTest {

    /**
     * Factory for the music.
     */
    MusicFactory mf;

    /**
     * Spy object for a Music object.
     */
    Music mMock;

    /**
     * Sets up the test objects.
     * @throws Exception exception catch if any
     */
    @Before
    public void setUp() throws Exception {
        mf = spy(MusicFactory.class);
        mMock = mock(Music.class);
    }

    /**
     * Tears down the test objects.
     * @throws Exception exception catch if any
     */
    @After
    public void tearDown() throws Exception {
        mf = null;
    }

    /**
     * Tests whether the background music is gettable.
     * @throws Exception exception catch if any
     */
    @Test
    public void testGetBackgroundMusic() throws Exception {
        when(mf.getBackgroundMusic()).thenReturn(mMock);

        mf.getBackgroundMusic();
        verify(mf, times(1)).getBackgroundMusic();
    }

    /**
     * Tests whether the completed music is gettable.
     * @throws Exception exception catch if any
     */
    @Test
    public void testGetCompletedTaskMusic() throws Exception {
        when(mf.getBackgroundMusic()).thenReturn(mMock);

        mf.getCompletedTaskMusic();
        verify(mf, times(1)).getCompletedTaskMusic();
    }
}