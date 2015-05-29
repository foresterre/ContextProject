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
 */
@RunWith(GdxTestRunner.class)
public class TextureFactoryTest {

    /**
     * TextureFactory mock.
     */
    protected TextureFactory cTextureFactoryMock;

    /**
     * Texture mock.
     */
    protected Texture cTextureMock;

    /**
     * Setup mocks.
     */
    @Before
    public final void setUp() {
        cTextureFactoryMock = mock(TextureFactory.class);
        cTextureMock = mock(Texture.class);
    }

    /**
     * Tear down mocks.
     */
    @After
    public final void tearDown() {
        cTextureFactoryMock = null;
        cTextureMock = null;
    }

    /**
     * Get wood menu texture test.
     */
    @Test
    public final void testGetWoodMenuTexture() {
        when(cTextureFactoryMock.getWoodMenuTexture()).thenReturn(cTextureMock);
        cTextureFactoryMock.getWoodMenuTexture();
        verify(cTextureFactoryMock, times(1)).getWoodMenuTexture();
    }
}