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

    TextureStorage ts;
    TextureStorage tsMock;

    @Before
    public void setUp() throws Exception {
        ts = new TextureStorage();
        tsMock = mock(TextureStorage.class);
    }

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
        assertTrue(ts.cTextureMap.size() == 0);
        ts.initStore();
        assertTrue(ts.cTextureMap.size() == 1);

        tsMock.initStore();
        verify(tsMock, times(1)).initStore();
    }

    @Test
    public void testGet() throws Exception {
        tsMock.get("WoodMenuTexture");
        verify(tsMock, times(1)).get("WoodMenuTexture");

    }
}