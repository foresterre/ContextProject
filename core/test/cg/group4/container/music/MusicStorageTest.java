package cg.group4.container.music;

import cg.group4.GdxTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Tests for the MusicStorage.
 */
@RunWith(GdxTestRunner.class)
public class MusicStorageTest {

    /**
     * Spy for the music storage.
     */
    protected MusicStorage cMusicStorageSpy;

    /**
     * Setup for test objects.
     */
    @Before
    public final void setUp() {
        cMusicStorageSpy = spy(MusicStorage.class);
    }

    /**
     * Setup for tear down objects.
     */
    @After
    public final void tearDown() {
        cMusicStorageSpy = null;
    }

    /**
     * Tests the initialization of the MusicStorage.
     */
    @Test
    public final void testInitStore() {
        final int before = 0;
        final int after = 2;
        assertTrue(cMusicStorageSpy.cSoundMap.size() == before);
        cMusicStorageSpy.initStore();
        verify(cMusicStorageSpy, times(1)).initStore();
        assertTrue(cMusicStorageSpy.cSoundMap.size() == after);
    }

    /**
     * Tests the getter of the music storage.
     */
    @Test
    public final void testGet() {

    }


}