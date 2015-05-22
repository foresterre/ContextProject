package cg.group4.container.image;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by Martijn on 2015-05-22.
 */
public class WoodMenuTextureTest extends TestCase {

    WoodMenuTexture wmt;
    WoodMenuTexture wmtMock;

    @Before
    public void setUp() throws Exception {
        wmt = new WoodMenuTexture();
        wmtMock = spy(WoodMenuTexture.class);
    }

    @After
    public void tearDown() throws Exception {
        wmt = null;
    }

    @Test
    public void testGet() throws Exception {
        wmtMock.get();
        verify(wmtMock, times(1)).get();
    }

    @Test
    public void testTag() throws Exception {
        final String EXPECTED = WoodMenuTexture.class.getSimpleName();
        assertEquals(EXPECTED, wmt.tag());
    }

    @Test
    public void testDispose() throws Exception {
        wmtMock.dispose();
        verify(wmtMock, times(1)).dispose();
    }
}