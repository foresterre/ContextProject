package cg.group4.container.image;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for the texture storage.
 */
public class TextureStorageTest extends TestCase {

    /**
     * TextureStorage (object).
     */
    TextureStorage ts;

    /**
     * TextureStorage (mock object).
     */
    TextureStorage tsMock;

    /**
     * Setup TextureStorage's.
     */
    @Before
    public void setUp() throws Exception {
        ts = new TextureStorage();
        tsMock = mock(TextureStorage.class);
    }

    /**
     * Tear down TextureStorages.
     */
    @After
    public void tearDown() throws Exception {
        ts = null;
        tsMock = null;
    }

    /**
     * Tests whether all the initial textures are added to the map.
     * Tests by side effects.
     * @throws Exception
     */
    @Test
    public void testInitStore() throws Exception {
        tsMock.initStore();
        verify(tsMock, times(1)).initStore();
    }

    /**
     * Tests whether the menu texture can be found.
     */
    @Test
    public void testGet() throws Exception {
        tsMock.get("WoodMenuTexture");
        verify(tsMock, times(1)).get("WoodMenuTexture");

    }
}