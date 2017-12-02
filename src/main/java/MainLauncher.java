import Battle.Battle;
import SocketObject.TestObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import System.Debug;
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

        server.addConnectListener(new ConnectListener() {
            public void onConnect(SocketIOClient client) {
                System.out.println("Connect: " + client);
                new Thread(new Battle(client)).start();
            }
        });

        server.addDisconnectListener(new DisconnectListener() {
            public void onDisconnect(SocketIOClient client) {
                System.out.println("Disconnect: " + client);
            }
        });

        server.addEventListener("test", TestObject.class, new DataListener<TestObject>() {
            public void onData(SocketIOClient client, TestObject data, AckRequest ackRequest){
                Debug.Log("we got test object");
            }
        });

        server.startAsync();

        System.out.println("HERE");


        Thread.sleep(Integer.MAX_VALUE);
        /*Thread.sleep(Integer.MAX_VALUE);
        server.stop();*/

    }
}
