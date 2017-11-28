package Callback;

import User.UserService;
import com.corundumstudio.socketio.SocketIOClient;

/**
 * Created by Yan on 28.11.2017.
 */
public class CallbackManager {
    static  CallbackManager instance;

    public static CallbackManager getInstance(){
        if(instance == null){
            synchronized (CallbackManager.class){
                if(instance == null) instance = new CallbackManager();
            }
        }
        return instance;
    }

    synchronized void sendMsg(SocketIOClient client, String event, Object data){
        client.sendEvent(event, data);
    }
}
