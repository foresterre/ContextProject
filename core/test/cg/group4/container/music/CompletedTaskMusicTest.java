package cg.group4.container.music;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Tests for the completed task music.
 */
public class CompletedTaskMusicTest {

    /**
     * Test object.
     */
    protected CompletedTaskMusic ctm;

    /**
     * Mocked test object.
     */
    protected CompletedTaskMusic ctmm;

    /**
     * Setup CompletedTaskMusic objects.
     */
    @Before
    public final void setUp() {
        ctm = new CompletedTaskMusic();
        ctmm = spy(CompletedTaskMusic.class);
    }

    /**
     * Tear down CompletedTaskMusic objects.
     */
    @After
    public final void tearDown() {
        ctm = null;
        ctmm = null;
    }

    /**
     * Setup CompletedTaskMusic objects.
     */
    @Test
    public final void testPathConst() {
        assertEquals("music/completedTask.wav", CompletedTaskMusic.PATH);
    }

    /**
     * Tests TAG.
     */
    @Test
    public final void testTagConst() {
        assertEquals("CompletedTaskMusic", ctm.tag());
    }

    /**
     * Tests get().
     */
    @Test
    public final void testGet() {
        ctmm.get();
        verify(ctmm, times(1)).get();
    }

    /**
     * Tests tag().
     */
    @Test
    public final void testTag() {
        final String expected = CompletedTaskMusic.class.getSimpleName();
        assertEquals(expected, ctm.tag());
    }

    /**
     * Tests dispose().
     *
     * @throws Exception exception catch if any
     */
    @Test
    public final void testDispose() throws Exception {
        ctmm.dispose();
        verify(ctmm, times(1)).dispose();
    }
}