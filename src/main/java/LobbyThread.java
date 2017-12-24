import Callback.CallbackManager;
import SocketObject.CallbackObject;
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
                        Battle battle = new Battle(user_1, null);
                        battle.setStatus(1);

                        user_1.setInSearchBattle(false);
                        user_1.setBattleID(battle.battleID);

                        BattleManager.getInstance().AddBattle(battle);

                        CallbackObject co = new CallbackObject(user_1.getId(), true);
                        CallbackManager.getInstance().AddMsg(user_1.client, "startBattle", co);
                    }
                }
            }
        }
    }





}
