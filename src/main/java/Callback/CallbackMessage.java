package Callback;

import com.corundumstudio.socketio.SocketIOClient;

/**
 * Created by teenik on 02.12.2017.
 */
public class CallbackMessage {
    public SocketIOClient client;
    public String eventName;
    public Object data;

    public CallbackMessage(SocketIOClient cl, String ev, Object dt){
        client = cl;
        eventName = ev;
        data = dt;
    }
}
