import Callback.CallbackManager;
import Listaners.BattleListener;
import Listaners.UserListener;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

/**
 * Created by teenik on 17.10.2017.
 */
public class MainLauncher {
    public static void main(String[] args) throws InterruptedException {

        Configuration config = new Configuration();
        config.setPort(3735);
        config.setOrigin("*");
        config.setHostname("localhost");

        int current_processors_amount = Runtime.getRuntime().availableProcessors();
        config.setBossThreads(current_processors_amount * 4);
        config.setWorkerThreads(current_processors_amount * 4);


        SocketIOServer server = new SocketIOServer(config);

        UserListener.Init(server);
        BattleListener.Init(server);
        CallbackManager.getInstance().Init();
        LobbyThread lobbyThread = new LobbyThread();
        lobbyThread.Init();

        server.addConnectListener(new ConnectListener() {
            public void onConnect(SocketIOClient client) {
                System.out.println("Connect: " + client);
            }
        });

        server.addDisconnectListener(new DisconnectListener() {
            public void onDisconnect(SocketIOClient client) {
                System.out.println("Disconnect: " + client);
            }
        });

        server.startAsync();

        Thread.sleep(Integer.MAX_VALUE);
        /*Thread.sleep(Integer.MAX_VALUE);
        server.stop();*/

    }
}
