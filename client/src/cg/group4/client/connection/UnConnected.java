package cg.group4.client.connection;

import cg.group4.client.Client;
import cg.group4.server.database.Response;
import cg.group4.server.database.ResponseHandler;
import cg.group4.server.database.query.Query;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * A state where the client is not connected to a server.
 */
public class UnConnected implements Connection {
    /**
     * Default java logging functionality.
     */
    protected static final Logger LOGGER = Logger.getLogger(Connection.class.getName());
    /**
     * Localhost that can be used to connect to the local server.
     */
    protected static final String LOCALHOST = "127.0.0.1";
    /**
     * Boolean whether this connection is already trying to connect.
     */
    protected boolean cConnecting;

    /**
     * Creates a new state where the Client is Unconnected.
     */
    public UnConnected() {
        cConnecting = false;
    }

    /**
     * Connects to either a local or a remote server. Connects to localhost if ip is 'null'.
     * @param ip   The IP to connect to.
     * @param port The port to connect to.
     */
    @Override
    public void connect(final String ip, final int port) {
        if (!cConnecting) {
            if (ip == null) {
                localConnect(LOCALHOST, port);
            } else {
                remoteConnect(ip, port);
            }
        }
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public void send(final Query query, final ResponseHandler responseHandler) {
        if (responseHandler != null) {
            responseHandler.handleResponse(new Response(false, null));
        }
    }

    /**
     * Attempts to connect to the local server.
     * @param ip Localhost.
     * @param port Port provided.
     */
    protected void localConnect(final String ip, final int port) {
        cConnecting = true;
        try {
            LOGGER.info("Trying to connect to the local server");
            Connection connection = new LocalConnection(ip, port);
            Client.getInstance().setLocalConnection(connection);
        } catch (IOException e) {
            LOGGER.info("Connection failed!");
        }
        cConnecting = false;
    }

    /**
     * Connects to a remote server. Connection is done in a separate Thread as not to block the game.
     * @param ip The IP to connect to.
     * @param port The port to connect to.
     */
    protected void remoteConnect(final String ip, final int port) {
        cConnecting = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Client client = Client.getInstance();
                try {
                    LOGGER.info("Trying to connect to the remote server");
                    final Connection connection = new RemoteConnection(ip, port);
                    client.addPostRunnables(new Runnable() {
                        @Override
                        public void run() {
                            client.setRemoteConnection(connection);
                            cConnecting = false;
                        }
                    });
                } catch (IOException e) {
                    LOGGER.info("Failed to connect to remote server, retrying.");
                    cConnecting = false;
                    client.addPostRunnables(new Runnable() {
                        @Override
                        public void run() {
                            client.connectToRemoteServer();
                        }
                    });
                }
            }
        }).start();
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnect: Not even connected");
    }
}
