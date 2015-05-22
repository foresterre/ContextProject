package cg.group4.container.sound;

import com.badlogic.gdx.audio.Music;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.spy;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Martijn Gribnau
 */
public class MusicStorageTest extends TestCase {

    MusicStorage msMock;

    @Before
    public void setUp() throws Exception {
        msMock = spy(MusicStorage.class);
    }

    @After
    public void tearDown() throws Exception {
        msMock = null;

    }

    @Test
    public void testInitStore() throws Exception {
        assertTrue(msMock.cSoundMap.size() == 0);
        msMock.initStore();
        verify(msMock, times(1)).initStore();
        assertTrue(msMock.cSoundMap.size() == 2);
    }

    @Test
    public void testGet() throws Exception {
        msMock.get("BackgroundMusic");
        verify(msMock, times(1)).get("BackgroundMusic");
    }

}