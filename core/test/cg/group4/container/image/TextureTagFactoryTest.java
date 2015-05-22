package cg.group4.container.image;

import cg.group4.container.sound.WoodMenuTexture;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Tests for the texture tag factory.
 */
public class TextureTagFactoryTest extends TestCase {

    TextureTagFactory ttf;
    TextureTagFactory ttfMock;

    @Before
    public void setUp() throws Exception {
        ttf = new TextureTagFactory();
        ttfMock = spy(TextureTagFactory.class);
    }

    @After
    public void tearDown() throws Exception {
        ttf = null;
        ttfMock = null;
    }

    @Test
    public void testGetWoodMenuTextureTag() throws Exception {
        final String EXPECTED = WoodMenuTexture.class.getSimpleName();
        assertEquals(EXPECTED, ttf.getWoodMenuTextureTag());

        ttfMock.getWoodMenuTextureTag();
        verify(ttfMock, times(1)).getWoodMenuTextureTag();
    }

}