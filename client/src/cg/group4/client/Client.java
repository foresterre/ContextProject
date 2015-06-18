package cg.group4.client;

import cg.group4.client.connection.Connection;
import cg.group4.client.connection.UnConnected;
import cg.group4.data_structures.PlayerData;
import cg.group4.data_structures.collection.Collection;
import cg.group4.data_structures.collection.collectibles.Collectible;
import cg.group4.data_structures.subscribe.Subject;
import cg.group4.server.database.ResponseHandler;
import cg.group4.server.database.query.*;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Jurgen van Schagen
 */
public final class Client {
    /**
     * Default Logger in Java used for the purpose of logging changes in the Server.
     */
    private static final Logger LOGGER = Logger.getLogger(Client.class.getName());
    /**
     * The Client connection with the internal storage server.
     * FindBugs: cg.group4.client.Client.cLocalInstance should be package protected
     */
    protected static Client cLocalInstance;
    /**
     * The Client connection with the remote server.
     * FindBugs: cg.group4.client.Client.cRemoteInstance should be package protected
     */
    protected static Client cRemoteInstance;
    /**
     * The default IP to connect to.
     */
    protected final String cDefaultIp = "82.169.19.191";
    /**
     * The default port to connect to.
     */
    protected final int cDefaultPort = 56789;
    /**
     * The connection state with the server.
     */
    protected Connection cConnection;
    /**
     * The user id. Android Phone ID or Desktop name.
     */
    protected UserIDResolver cUserIDResolver;
    /**
     * Notifies all listeners that the server has either connected or disconnected.
     */
    protected Subject cChangeSubject;

    /**
     * A list of Runnable that have to be run at the end of a render cycle.
     * These are added to the Gdx.app.postRunnable().
     */
    protected ArrayList<Runnable> cPostRunnables;


    /**
     * Constructs a new Client and sets the state to unconnected.
     */
    public Client() {
        cConnection = new UnConnected();
        cUserIDResolver = new DummyUserIdResolver();
        cChangeSubject = new Subject();
        cPostRunnables = new ArrayList<Runnable>();
    }

    /**
     * Gets the Singleton instance.
     *
     * @return The Client.
     */
    public static Client getLocalInstance() {
        if (cLocalInstance == null) {
            cLocalInstance = new Client();
        }
        return cLocalInstance;
    }

    /**
     * Gets the Singleton instance.
     *
     * @return The Client.
     */
    public static Client getRemoteInstance() {
        if (cRemoteInstance == null) {
            cRemoteInstance = new Client();
        }
        return cRemoteInstance;
    }

    /**
     * Returns the ChangeSubject that notifies whenever a change in the connection status occurs.
     * @return Subject that can be subscribed on.
     */
    public Subject getChangeSubject() {
        return cChangeSubject;
    }

    /**
     * Returns the list of Runnable that need to be processed in the Gdx.app.postRunnable().
     * @return ArrayList with the Runnables.
     */
    public ArrayList<Runnable> getPostRunnables() {
        return cPostRunnables;
    }

    /**
     * Adds another Runnable to the PostRunnable list.
     * @param runnable The task to run.
     */
    public void addPostRunnables(final Runnable runnable) {
        cPostRunnables.add(runnable);
    }

    /**
     * Clears the PostRunnable ArrayList.
     */
    public void resetPostRunnables() {
        cPostRunnables.clear();
    }

    /**
     * Connects to the default server. Behaviour depends on the state.
     */
    public void connectToServer() {
        cConnection.connect(cDefaultIp, cDefaultPort);
    }

    /**
     * Connects to a server given an IP and port. If the server is null, it will connect to localhost.
     * @param ip Ip to connect to. If null localhost.
     * @param port Port to connect to.
     */
    public void connectToServer(final String ip, final int port) {
        cConnection.connect(ip, port);
    }

    /**
     * Sets the connection to the new connection.
     * @param connection The connection that needs to be set.
     */
    public void setConnection(final Connection connection) {
        cConnection = connection;
        cChangeSubject.update(connection.isConnected());
        LOGGER.info("Managed to connect: " + connection.isConnected());
    }

    /**
     * Updates the stroll timers in the database.
     * @param timeStamp The timestamp when the timer should end.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void updateStrollTimer(final Long timeStamp, final ResponseHandler responseHandler) {
        PlayerData playerData = new PlayerData(cUserIDResolver.getID());
        playerData.setStrollTimeStamp(timeStamp);
        tryToSend(new UpdatePlayerData(playerData), responseHandler);
    }

    /**
     * Sends the given query to the server, if there has not already been made a previous request.
     * @param query The query to the server.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    protected void tryToSend(final Query query, final ResponseHandler responseHandler) {
        cConnection.send(query, responseHandler);
    }

    /**
     * Creates a CreateGroup Query that will be send to the server.
     * @param groupId The group if to create.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void createGroup(final String groupId, final ResponseHandler responseHandler) {
        tryToSend(new CreateGroup(groupId, cUserIDResolver.getID()), responseHandler);
    }

    /**
     * Updates the interval timers in the database.
     * @param timeStamp The timestamp when the timer should end.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void updateIntervalTimer(final Long timeStamp, final ResponseHandler responseHandler) {
        PlayerData playerData = new PlayerData(cUserIDResolver.getID());
        playerData.setIntervalTimeStamp(timeStamp);
        tryToSend(new UpdatePlayerData(playerData), responseHandler);
    }

    /**
     * Updates the username in the server. Behaviour depends on the state.
     * @param username The new username.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void updatePlayer(final String username, final ResponseHandler responseHandler) {
        PlayerData playerData = new PlayerData(cUserIDResolver.getID());
        playerData.setUsername(username);
        tryToSend(new UpdatePlayerData(playerData), responseHandler);
    }

    /**
     * Gets the collection belonging to the specified group.
     * @param groupId The group to get the collection from.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void getCollection(final String groupId, final ResponseHandler responseHandler) {
        tryToSend(new RequestCollection(groupId), responseHandler);
    }

    /**
     * Adds the player to the specified group.
     * @param groupId The group to join.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void joinGroup(final String groupId, final ResponseHandler responseHandler) {
        PlayerData playerData = new PlayerData(cUserIDResolver.getID());
        playerData.setGroupId(groupId);
        tryToSend(new UpdatePlayerData(playerData), responseHandler);
    }

    /**
     * Gets the userdata from the server. Uses UserIDResolver to get the data. Behaviour depends on the state.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void getPlayerData(final ResponseHandler responseHandler) {
        tryToSend(new RequestPlayerData(cUserIDResolver.getID()), responseHandler);
    }

    /**
     * Adds the collection to the server. Behaviour depends on the state.
     * @param collection The collection to add to the server.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void addCollection(final Collection collection, final ResponseHandler responseHandler) {
        tryToSend(new AddCollection(collection), responseHandler);
    }

    /**
     * Removes the given collection from the database.
     * @param collection Collection to delete.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void removeCollection(final Collection collection, final ResponseHandler responseHandler) {
        tryToSend(new RemoveCollection(collection), responseHandler);
    }

    /**
     * Gets the group data from the server. Behaviour depends on the state.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void getGroupData(final ResponseHandler responseHandler) {
    	tryToSend(new GetGroupData(), responseHandler);
    }

    /**
     * Stores the host ip on the server with a generated code that it will return to let the client connect.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void hostEvent(final ResponseHandler responseHandler) {
        tryToSend(new RequestHostCode(getIPAddress(true)), responseHandler);
//        try {
//            String ip = Inet4Address.getLocalHost().getHostName();
//            tryToSend(new RequestHostCode(ip), responseHandler);
//        }
//        catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Android returns 127.0.0.1 for Inet4Address.getLocalHost().getHostName(), so using a method found at:
     * http://stackoverflow.com/questions/6064510/how-to-get-ip-address-of-the-device
     *
     * @param useIPv4
     * @return
     */
    public static String getIPAddress(boolean useIPv4) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress().toUpperCase();
                        boolean isIPv4 = validIP(sAddr);
                        if (useIPv4) {
                            if (isIPv4)
                                return sAddr;
                        } else {
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 port suffix
                                return delim<0 ? sAddr : sAddr.substring(0, delim);
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) { } // for now eat exceptions
        return "";
    }

    /**
     * http://stackoverflow.com/questions/4581877/validating-ipv4-string-in-java
     * @param ip
     * @return
     */
    public static boolean validIP (String ip) {
        try {
            if (ip == null || ip.isEmpty()) {
                return false;
            }

            String[] parts = ip.split( "\\." );
            if ( parts.length != 4 ) {
                return false;
            }

            for ( String s : parts ) {
                int i = Integer.parseInt( s );
                if ( (i < 0) || (i > 255) ) {
                    return false;
                }
            }
            if(ip.endsWith(".")) {
                return false;
            }

            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /**
     * Retrieves the ip of the host.
     * @param code code of the connection.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void getHost(final Integer code, final ResponseHandler responseHandler) {
        tryToSend(new RequestHostIp(code), responseHandler);
    }

    /**
     * Resets the player data.
     * @param responseHandler The task to execute once a reply is received completed.
     */
    public void resetPlayerData(final ResponseHandler responseHandler) {
        tryToSend(new ResetPlayerData(cUserIDResolver.getID()), responseHandler);
    }

    /**
     * Sets the userid using the device ID.
     * @param idResolver Tool used for getting the proper device ID.
     */
    public void setUserIDResolver(final UserIDResolver idResolver) {
        cUserIDResolver = idResolver;
    }

    /**
     * Returns the user ID from the supplied UserIDResolver.
     * @return The ID belonging to the current player.
     */
    public String getUserID() {
        return cUserIDResolver.getID();
    }

    /**
     * Adds a collectible to the server.
     */
    public void addCollectible(final Collectible collectible, final String groupId,
                               final ResponseHandler responseHandler) {
        tryToSend(new AddCollectible(collectible, groupId), responseHandler);
    }

    /**
     * Removes a collectible from the server.
     */
    public void removeCollectible(final Collectible collectible, final String groupId,
                                  final ResponseHandler responseHandler) {
        tryToSend(new RemoveCollectible(collectible, groupId), responseHandler);
    }

    /**
     * Returns if connected to the server or not.
     * @return Is connected or not.
     */
    public boolean isConnected() {
        return cConnection.isConnected();
    }
}
