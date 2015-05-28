package cg.group4.container.music;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Tests for the MusicStorage.
 */
public class MusicStorageTest {

    /**
     * Spy for the music storage.
     */
    protected MusicStorage msMock;

    /**
     * Setup for test objects.
     */
    @Before
    public final void setUp() {
        msMock = spy(MusicStorage.class);
    }

    /**
     * Setup for tear down objects.
     */
    @After
    public final void tearDown() {
        msMock = null;
    }

    /**
     * Tests the initialization of the MusicStorage.
     */
    @Test
    public final void testInitStore() {

        final int before = 0;
        final int after = 2;
        assertTrue(msMock.cSoundMap.size() == before);
        msMock.initStore();
        verify(msMock, times(1)).initStore();
        assertTrue(msMock.cSoundMap.size() == after);
    }

    /**
     * Tests the getter of the MusicStorage.
     */
    @Test
    public final void testGet() {
        msMock.get("BackgroundMusic");
        verify(msMock, times(1)).get("BackgroundMusic");
    }

}