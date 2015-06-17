package cg.group4.server;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author Jurgen van Schagen
 */
public class ServerTest {
    /**
     * The server to be tested upon.
     */
    protected Server cServer;


    /**
     * Sets up the environment for the tests.
     */
    @Before
    public void setUp() {
        cServer = new Server(new RemoteStorageResolver());
    }

//    /**
//     * Tears down the environment after the tests.
//     */
//    @Test
//    public void testCreateLocalIP() {
//        cServer.cStaticsCaller = mock(StaticsCaller.class);
//        cServer.createLocalIP();
//        assertThat(cServer.cLocalHost, instanceOf(LocalHost.class));
//    }
//
//    /**
//     * Makes sure an exception will be thrown createLocalIp fails.
//     */
//    @Test
//    public void testCreateLocalIPWithException() {
//        cServer.cStaticsCaller = mock(StaticsCaller.class);
//        try {
//            doThrow(new UnknownHostException()).when(cServer.cStaticsCaller).getLocalHost();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        cServer.createLocalIP();
//        assertThat(cServer.cLocalHost, instanceOf(UnknownHost.class));
//    }

    /**
     * Checks port validity.
     */
    @Test
    public void testIsValidPortNegative() {
        assertFalse(cServer.isValidPort(-1));
    }

    /**
     * Checks port validity.
     */
    @Test
    public void testIsValidPort() {
        assertTrue(cServer.isValidPort(20));
    }
}
