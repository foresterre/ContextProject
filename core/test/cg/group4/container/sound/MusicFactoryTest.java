package cg.group4.container.sound;

import com.badlogic.gdx.audio.Music;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * @author Martijn Gribnau
 */
public class MusicFactoryTest {

    MusicFactory mf;
    Music mMock;

    @Before
    public void setUp() throws Exception {
        mf = spy(MusicFactory.class);
        mMock = mock(Music.class);
    }

    @After
    public void tearDown() throws Exception {
        mf = null;
    }


    @Test
    public void testGetBackgroundMusic() throws Exception {
        when(mf.getBackgroundMusic()).thenReturn(mMock);

        mf.getBackgroundMusic();
        verify(mf, times(1)).getBackgroundMusic();
    }

    @Test
    public void testGetCompletedTaskMusic() throws Exception {
        when(mf.getBackgroundMusic()).thenReturn(mMock);

        mf.getCompletedTaskMusic();
        verify(mf, times(1)).getCompletedTaskMusic();
    }
}