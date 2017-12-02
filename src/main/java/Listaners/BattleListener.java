package Listaners;

import SocketObject.SpawnObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

/**
 * Created by Yan on 28.11.2017.
 */
public class BattleListener {

    static void Init(SocketIOServer s){

        s.addEventListener("spawnWarrior", SpawnObject.class, new DataListener<SpawnObject>() {
                    @Override
                    public void onData(SocketIOClient client, SpawnObject data, AckRequest ackSender) throws Exception {

                    }
                }
        );
    }



}
