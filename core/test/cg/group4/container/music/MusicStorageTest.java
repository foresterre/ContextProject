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
 * @see <a href=https://github.com/foresterre/ContextProject/issues/37>issue 37</a>
 */
@RunWith(GdxTestRunner.class)
public class MusicStorageTest {

    /**
     * Spy for the music storage.
     */
    protected MusicStorage musicStorageMock;

    /**
     * Setup for test objects.
     */
    @Before
    public final void setUp() {
        musicStorageMock = spy(MusicStorage.class);
    }

    /**
     * Setup for tear down objects.
     */
    @After
    public final void tearDown() {
        musicStorageMock = null;
    }

    /**
     * Tests the initialization of the MusicStorage.
     */
    @Test
    public final void testInitStore() {
        final int before = 0;
        final int after = 2;
        assertTrue(musicStorageMock.cSoundMap.size() == before);
        musicStorageMock.initStore();
        verify(musicStorageMock, times(1)).initStore();
        assertTrue(musicStorageMock.cSoundMap.size() == after);
    }


}