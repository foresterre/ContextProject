package cg.group4.container.image;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Tests for the texture tag factory.
 */
public class TextureTagFactoryTest {

    /**
     * TextureTagFactory (object).
     */
    protected TextureTagFactory ttf;

    /**
     * TextureTagFactory (mock object).
     */
    protected TextureTagFactory ttfMock;

    /**
     * Setup TextureTagFactory.
     */
    @Before
    public final void setUp() {
        ttf = new TextureTagFactory();
        ttfMock = mock(TextureTagFactory.class);
    }

    /**
     * Tear down TextureTagFactory.
     */
    @After
    public final void tearDown() {
        ttf = null;
        ttfMock = null;
    }

    /**
     * Test TextureTagFactory (getWoodMenuTextureTag).
     */
    @Test
    public final void testGetWoodMenuTextureTag() {
        ttfMock.getWoodMenuTextureTag();
        verify(ttfMock, times(1)).getWoodMenuTextureTag();
    }

}