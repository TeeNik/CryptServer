package Listaners;

import Battle.BattleManager;
import Game.Warrior;
import SocketObject.SpawnObject;
import User.UserService;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

/**
 * Created by Yan on 28.11.2017.
 */
public class BattleListener {

    public static void Init(SocketIOServer s){

        s.addEventListener("spawnWarrior", Warrior.class, new DataListener<Warrior>() {
                    @Override
                    public void onData(SocketIOClient client, Warrior data, AckRequest ackSender) throws Exception {
                        int battleID = UserService.getInstance().findUserById(data.getPlayerID()).getBattleID();
                        BattleManager.getInstance().GetBattle(battleID).spawn(data);
                    }
                }
        );
    }



}
