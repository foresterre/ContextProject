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
 * @see <a href=https://github.com/foresterre/ContextProject/issues/37>issue 37</a>
 */
@RunWith(GdxTestRunner.class)
public class TextureStorageTest {

    /**
     * TextureStorage (object).
     */
    protected TextureStorage textureStorageMock;

    /**
     * Mock for a texture.
     */
    protected Texture textureMock;


    /**
     * Setup TextureStorage's.
     */
    @Before
    public final void setUp() {
        textureStorageMock = mock(TextureStorage.class);
        textureMock = mock(Texture.class);
    }

    /**
     * Tear down TextureStorage.
     */
    @After
    public final void tearDown() {
        textureStorageMock = null;
    }

    /**
     * Tests whether all the initial textures are added to the map.
     * Tests by side effects.
     */
    @Test
    public final void testInitStore() {
        textureStorageMock.initStore();
        verify(textureStorageMock, times(1)).initStore();
    }

    /**
     * Tests whether the menu texture can be found.
     */
    @Test
    public final void testGet() {
        textureStorageMock.initStore();
        when(textureStorageMock.get(TextureHandle.woodenSign.key())).thenReturn(textureMock);
        textureStorageMock.get(TextureHandle.woodenSign.key());
        verify(textureStorageMock, times(1)).get(TextureHandle.woodenSign.key());

    }
}