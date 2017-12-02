package Listaners;

import SocketObject.AccountObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

/**
 * Created by teenik on 02.12.2017.
 */
public class UserListener {

    static void Init(SocketIOServer server){
        server.addEventListener("auth", AccountObject.class, new DataListener<AccountObject>() {
            @Override
            public void onData(SocketIOClient client, AccountObject data, AckRequest ackSender) throws Exception {
                if(client != null && client.isChannelOpen()){

                }
            }
        });
    }
}
