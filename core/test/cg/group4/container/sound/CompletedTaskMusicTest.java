package cg.group4.container.sound;

import junit.framework.TestCase;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Tests for the completed task music.
 */
public class CompletedTaskMusicTest extends TestCase {

    /**
     * Test object.
     */
    CompletedTaskMusic ctm;

    /**
     * Mocked test object.
     */
    CompletedTaskMusic ctmm;

    /**
     * Setup CompletedTaskMusic objects.
     * @throws Exception exception if any
     */
    @Override
    public void setUp() throws Exception {
        ctm = new CompletedTaskMusic();
        ctmm = spy(CompletedTaskMusic.class);
    }

    /**
     * Tear down CompletedTaskMusic objects.
     * @throws Exception exception if any
     */
    @Override
    public void tearDown() throws Exception {
        ctm = null;
        ctmm = null;
    }

    /**
     * Setup CompletedTaskMusic objects.
     * @throws Exception exception if any
     */
    @Test
    public void testPathConst() {
        assertEquals("music/completedTask.wav", ctm.PATH);
    }

    /**
     * Tests TAG.
     */
    @Test
    public void testTagConst() {
        assertEquals("CompletedTaskMusic", ctm.TAG);
    }

    /**
     * Tests get().
     * @throws Exception exception catch if any
     */
    @Test
    public void testGet() throws Exception {
        ctmm.get();
        verify(ctmm, times(1)).get();
    }

    /**
     * Tests tag().
     * @throws Exception exception catch if any
     */
    @Test
    public void testTag() throws Exception {
        final String expected = CompletedTaskMusic.class.getSimpleName();
        assertEquals(expected, ctm.tag());
    }

    /**
     * Tests dispose().
     * @throws Exception exception catch if any
     */
    @Test
    public void testDispose() throws Exception {
        ctmm.dispose();
        verify(ctmm, times(1)).dispose();
    }
}