package cg.group4.container.image;

import cg.group4.GdxTestRunner;
import com.badlogic.gdx.graphics.Texture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

/**
 * Tests for the texture storage.
 */
@RunWith(GdxTestRunner.class)
public class TextureStorageTest {

    /**
     * TextureStorage (object).
     */
    protected TextureStorage cTextureStorageMock;

    /**
     * Mock for a texture.
     */
    protected Texture cTextureMock;


    /**
     * Setup TextureStorage's.
     */
    @Before
    public final void setUp() {
        cTextureStorageMock = mock(TextureStorage.class);
        cTextureMock = mock(Texture.class);
    }

    /**
     * Tear down TextureStorage.
     */
    @After
    public final void tearDown() {
        cTextureStorageMock = null;
    }

    /**
     * Tests whether all the initial textures are added to the map.
     * Tests by side effects.
     */
    @Test
    public final void testInitStore() {
        cTextureStorageMock.initStore();
        verify(cTextureStorageMock, times(1)).initStore();
    }

    /**
     * Tests whether the menu texture can be found.
     */
    @Test
    public final void testGet() {
        cTextureStorageMock.initStore();
        when(cTextureStorageMock.get(TextureHandle.woodenSign.key())).thenReturn(cTextureMock);
        cTextureStorageMock.get(TextureHandle.woodenSign.key());
        verify(cTextureStorageMock, times(1)).get(TextureHandle.woodenSign.key());

    }
}