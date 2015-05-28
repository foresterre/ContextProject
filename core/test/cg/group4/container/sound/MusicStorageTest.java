package cg.group4.container.sound;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for the MusicStorage.
 */
public class MusicStorageTest extends TestCase {

    /**
     * Spy for the music storage.
     */
    MusicStorage msMock;

    /**
     * Setup for test objects.
     * @throws Exception exception catch if any
     */
    @Before
    public void setUp() throws Exception {
        msMock = spy(MusicStorage.class);
    }

    /**
     * Setup for tear down objects.
     * @throws Exception exception catch if any
     */
    @After
    public void tearDown() throws Exception {
        msMock = null;
    }

    /**
     * Tests the initialization of the MusicStorage.
     * @throws Exception exception catch if any
     */
    @Test
    public void testInitStore() throws Exception {

        final int BEFORE = 0;
        final int AFTER = 2;
        assertTrue(msMock.cSoundMap.size() == BEFORE);
        msMock.initStore();
        verify(msMock, times(1)).initStore();
        assertTrue(msMock.cSoundMap.size() == AFTER);
    }

    /**
     * Tests the getter of the MusicStorage.
     * @throws Exception exception catch if any
     */
    @Test
    public void testGet() throws Exception {
        msMock.get("BackgroundMusic");
        verify(msMock, times(1)).get("BackgroundMusic");
    }

}