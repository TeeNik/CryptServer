package Battle;

import java.util.*;

/**
 * Created by teenik on 10.12.2017.
 */
public class BattleManager {

    private static volatile int BattleID = 1;
    private static volatile BattleManager instance;
    private volatile Map<Integer, Battle> battleList;

    public BattleManager(){
        battleList = new TreeMap<>();
    }

    public static BattleManager getInstance() {
        if (instance == null) {
            synchronized (BattleManager.class) {
                if (instance == null) instance = new BattleManager();
            }
        }
        return instance;
    }

    public synchronized int GetNextBattleID(){
        return ++BattleID;
    }

    public synchronized void AddBattle(Battle battle){
        battleList.put(battle.battleID, battle);
    }

    public synchronized Battle GetBattle(int id){
        return battleList.get(id);
    }

    public synchronized void EndBattle(int id){
        System.out.println("end battle");
        battleList.get(id).End();
        battleList.remove(id);
    }
}
