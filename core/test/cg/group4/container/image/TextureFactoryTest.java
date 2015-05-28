package cg.group4.container.image;

import com.badlogic.gdx.graphics.Texture;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for the texture factory.
 */
public class TextureFactoryTest extends TestCase {

    /**
     * TextureFactory mock.
     */
    TextureFactory tf;

    /**
     * Texture mock.
     */
    Texture tex;

    /**
     * Setup mocks.
     */
    @Before
    public void setUp() throws Exception {
        tf = mock(TextureFactory.class);
        tex = mock(Texture.class);
    }

    /**
     * Tear down mocks.
     */
    @After
    public void tearDown() throws Exception {
        tf = null;
        tex = null;
    }

    /**
     * Get wood menu texture test.
     */
    @Test
    public void testGetWoodMenuTexture() throws Exception {
        when(tf.getWoodMenuTexture()).thenReturn(tex);

        tf.getWoodMenuTexture();
        verify(tf, times(1)).getWoodMenuTexture();
    }
}