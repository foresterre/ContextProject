package cg.group4.container.image;

//public class WoodMenuTextureTest extends TestCase {
//
//    WoodMenuTexture wmt;
//    WoodMenuTexture wmtMock;
//
//    @Before
//    public final void setUp() throws Exception {
//        wmt = new WoodMenuTexture();
//        wmtMock = mock(WoodMenuTexture.class);
//    }
//
//    @After
//    public final void tearDown() throws Exception {
//        wmt = null;
//        wmtMock = null;
//    }
//
//    /**
//     * Anti-warning test.
//     * See below for the reason for no activated tests in the class.
//     */
//    @Test
//    public final void trueTest() {
//
//    }
//
//    // Reason of failing tests & Why they are commented:
//    // The current setup requires the working directory in the IDE to be set on the module Android and the folder
//    // assets ([project root]/android/assets/).
//    // This is so we only have to concern ourselves with one directory with assets.
//    // However the test runner does not recognize this working directory.
//    // Currently (this week's sprint) we have no solution for this problem.
//    // This is the reason the tests below are commented out.
//    // If your IDE is configured though, you can uncomment this class.
////
////    @Test
////    public void testGet() throws Exception {
////        wmtMock.get();
////        verify(wmtMock, times(1)).get();
////    }
////
////    @Test
////    public void testTag() throws Exception {
////        final String EXPECTED = WoodMenuTexture.class.getSimpleName();
////        assertEquals(EXPECTED, wmt.tag());
////    }
////
////    @Test
////    public void testDispose() throws Exception {
////        wmtMock.dispose();
////        verify(wmtMock, times(1)).dispose();
////    }
//}