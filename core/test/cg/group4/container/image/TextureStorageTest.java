package cg.group4.container.image;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for the texture storage.
 */
public class TextureStorageTest {

    /**
     * TextureStorage (object).
     */
    protected TextureStorage ts;

    /**
     * TextureStorage (mock object).
     */
    protected TextureStorage tsMock;

    /**
     * Setup TextureStorage's.
     */
    @Before
    public final void setUp() {
        ts = new TextureStorage();
        tsMock = mock(TextureStorage.class);
    }

    /**
     * Tear down TextureStorage.
     */
    @After
    public final void tearDown() {
        ts = null;
        tsMock = null;
    }

    /**
     * Tests whether all the initial textures are added to the map.
     * Tests by side effects.
     */
    @Test
    public final void testInitStore() {
        tsMock.initStore();
        verify(tsMock, times(1)).initStore();
    }

    /**
     * Tests whether the menu texture can be found.
     */
    @Test
    public final void testGet() {
        tsMock.get("WoodMenuTexture");
        verify(tsMock, times(1)).get("WoodMenuTexture");

    }
}