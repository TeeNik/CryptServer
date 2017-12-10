package Listaners;

import Callback.CallbackManager;
import Game.Player;
import SocketObject.AccountObject;
import SocketObject.CallbackObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import User.*;
/**
 * Created by teenik on 02.12.2017.
 */
public class UserListener {

    public static void Init(SocketIOServer server){
        server.addEventListener("auth", AccountObject.class, new DataListener<AccountObject>() {
            @Override
            public void onData(SocketIOClient client, AccountObject data, AckRequest ackSender) throws Exception {
                if(client != null && client.isChannelOpen()){
                    System.out.println("Auth: " + data.getName());
                    User user = new User(data.getId(), new Player(), data.getName());
                    user.client = client;
                    UserService.getInstance().auth(user, client.getSessionId());
                    CallbackObject co = new CallbackObject();
                    co.setOk(true);
                    co.setId(user.getId());
                    CallbackManager.getInstance().AddMsg(client, "auth", co);
                }
            }
        });
    }
}
