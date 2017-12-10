package Battle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by teenik on 10.12.2017.
 */
public class BattleManager {

    private static volatile int BattleID = 1;
    private Timer timer;
    private static volatile BattleManager instance;
    private volatile ArrayList<Battle> battleList;

    public static BattleManager getInstance() {
        if (instance == null) {
            synchronized (BattleManager.class) {
                if (instance == null) instance = new BattleManager();
            }
        }
        return instance;
    }

    public void Init(){
        battleList = new ArrayList<>();
        timer = new Timer();

    }

    public synchronized int GetNextBattleID(){
        return ++BattleID;
    }

    public synchronized void AddBattle(Battle battle){
        battleList.add(battle);
    }

    public synchronized Battle GetBattle(int id){
        return battleList.get(id);
    }

    public class ServiceTask extends TimerTask{
        @Override
        public void run() {

        }
    }


}
