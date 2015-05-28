package cg.group4.container.image;

import com.badlogic.gdx.graphics.Texture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


/**
 * Tests for the texture factory.
 */
public class TextureFactoryTest {

    /**
     * TextureFactory mock.
     */
    protected TextureFactory tf;

    /**
     * Texture mock.
     */
    protected Texture tex;

    /**
     * Setup mocks.
     */
    @Before
    public final void setUp() {
        tf = mock(TextureFactory.class);
        tex = mock(Texture.class);
    }

    /**
     * Tear down mocks.
     */
    @After
    public final void tearDown() {
        tf = null;
        tex = null;
    }

    /**
     * Get wood menu texture test.
     */
    @Test
    public final void testGetWoodMenuTexture() {
        when(tf.getWoodMenuTexture()).thenReturn(tex);

        tf.getWoodMenuTexture();
        verify(tf, times(1)).getWoodMenuTexture();
    }
}