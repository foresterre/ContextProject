package cg.group4.container.sound;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * @author Martijn Gribnau
 */
public class CompletedTaskMusicTest extends TestCase {

    CompletedTaskMusic ctm;
    CompletedTaskMusic ctmm;

    @Override
    public void setUp() throws Exception {
        ctm = new CompletedTaskMusic();
        ctmm = spy(CompletedTaskMusic.class);
    }

    @Override
    public void tearDown() throws Exception {
        ctm = null;
        ctmm = null;
    }

    @Test
    public void testPathConst() {
        assertEquals("music/completedTask.wav", ctm.PATH);
    }

    @Test
    public void testTagConst() {
        assertEquals("CompletedTaskMusic", ctm.TAG);
    }


    @Test
    public void testGet() throws Exception {
        ctmm.get();
        verify(ctmm, times(1)).get();
    }

    @Test
    public void testTag() throws Exception {
        final String expected = CompletedTaskMusic.class.getSimpleName();
        assertEquals(expected, ctm.tag());
    }

    @Test
    public void testDispose() throws Exception {
        ctmm.dispose();
        verify(ctmm, times(1)).dispose();
    }
}