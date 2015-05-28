package cg.group4.container.image;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for the texture tag factory.
 */
public class TextureTagFactoryTest extends TestCase {

    /**
     * TextureTagFactory (object).
     */
    TextureTagFactory ttf;

    /**
     * TextureTagFactory (mock object).
     */
    TextureTagFactory ttfMock;

    /**
     * Setup TextureTagFactory.
     */
    @Before
    public void setUp() throws Exception {
        ttf = new TextureTagFactory();
        ttfMock = mock(TextureTagFactory.class);
    }

    /**
     * Tear down TextureTagFactory.
     */
    @After
    public void tearDown() throws Exception {
        ttf = null;
        ttfMock = null;
    }

    /**
     * Test TextureTagFactory (getWoodMenuTextureTag).
     */
    @Test
    public void testGetWoodMenuTextureTag() throws Exception {
        ttfMock.getWoodMenuTextureTag();
        verify(ttfMock, times(1)).getWoodMenuTextureTag();
    }

}