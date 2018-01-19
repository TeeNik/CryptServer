import Callback.CallbackManager;
import Game.Player;
import SocketObject.CallbackObject;
import SocketObject.StartBattleObject;
import User.*;
import Battle.*;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by teenik on 27.11.2017.
 */
public class LobbyThread {

    private Timer timer;

    public void Init(){
        timer = new Timer();
        timer.schedule(new ServiceTask(), 0 , 1000);
    }

    public class ServiceTask extends TimerTask {
        @Override
        public void run() {
            if(UserService.getInstance().getUsersList().size() >= 1){
                Iterator list = UserService.getInstance().getUsersList().iterator();
                while (list.hasNext()){
                    User user_1 = (User)list.next();
                    if(user_1.isInSearchBattle()) {
                        while (list.hasNext()){
                            User user_2 = (User)list.next();
                            if(user_2.isInSearchBattle()){
                                Battle battle = new Battle(user_1, null);
                                battle.setStatus(Battle.BattleStatus.Started);

                                InitUserForBattle(user_1, battle, true);
                                InitUserForBattle(user_2, battle, false);
                                
                                BattleManager.getInstance().AddBattle(battle);

                                StartBattleObject co = new StartBattleObject();
                                CallbackManager.getInstance().AddMsg(user_1.client, "startBattle", co);
                                CallbackManager.getInstance().AddMsg(user_2.client, "startBattle", co);
                            }
                        }
                    }
                }
            }
        }
    }

    private void InitUserForBattle(User user, Battle battle, boolean fr){
        user.setBattleID(battle.battleID);
        user.setInSearchBattle(false);
        Player player = new Player();
        player.facingRight = fr;
        user.setPlayer(player);
    }





}
