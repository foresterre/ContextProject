package cg.group4.container.image;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        assertTrue(tsMock.cTextureMap.size() == 0);
        tsMock.initStore();
        verify(tsMock, times(1)).initStore();
        assertTrue(tsMock.cTextureMap.size() == 1);
    }

    @Test
    public void testGet() throws Exception {
        tsMock.get("WoodMenuTexture");
        verify(tsMock, times(1)).get("WoodMenuTexture");

    }
}