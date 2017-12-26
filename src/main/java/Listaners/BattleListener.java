package Listaners;

import Battle.Battle;
import Battle.BattleManager;
import Callback.CallbackManager;
import Game.Warrior;
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

        s.addEventListener("SpawnWarrior", Warrior.class, new DataListener<Warrior>() {
                    @Override
                    public void onData(SocketIOClient client, Warrior data, AckRequest ackSender) throws Exception {
                        int battleID = UserService.getInstance().findUserById(data.PlayerId).getBattleID();
                        Battle battle = BattleManager.getInstance().GetBattle(battleID);
                        Warrior w = battle.spawn(data);
                        System.out.println("Spawn: " + w.Type + "  " + w.Id);
                        CallbackManager.getInstance().AddMsg(battle.user_1.client, "spawnWarrior", w);
                        //CallbackManager.getInstance().AddMsg(battle.user_2.client, "spawnWarrior", w);
                    }
                }
        );
    }



}
