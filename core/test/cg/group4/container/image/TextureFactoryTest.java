package cg.group4.container.image;

import cg.group4.GdxTestRunner;
import com.badlogic.gdx.graphics.Texture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;


/**
 * Tests for the texture factory.
 * @see <a href=https://github.com/foresterre/ContextProject/issues/37>issue 37</a>
 */
@RunWith(GdxTestRunner.class)
public class TextureFactoryTest {

    /**
     * TextureFactory mock.
     */
    protected TextureFactory textureFactoryMock;

    /**
     * Texture mock.
     */
    protected Texture textureMock;

    /**
     * Setup mocks.
     */
    @Before
    public final void setUp() {
        textureFactoryMock = mock(TextureFactory.class);
        textureMock = mock(Texture.class);
    }

    /**
     * Tear down mocks.
     */
    @After
    public final void tearDown() {
        textureFactoryMock = null;
        textureMock = null;
    }

    /**
     * Get wood menu texture test.
     */
    @Test
    public final void testGetWoodMenuTexture() {
        when(textureFactoryMock.getWoodMenuTexture()).thenReturn(textureMock);

        textureFactoryMock.getWoodMenuTexture();
        verify(textureFactoryMock, times(1)).getWoodMenuTexture();
    }
}