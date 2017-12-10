package Battle;

import Game.Warrior;
import SocketObject.SpawnObject;
import User.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class Battle{
    public int battleID;
    private User user_1;
    private User user_2;
    private ArrayList<ArrayList<Warrior>> battleground = new ArrayList<ArrayList<Warrior>>(5);
    private int num = 0;
    private int status;

    Timer timer;

    public Battle(User user_1, User user_2) {
        this.user_1 = user_1;
        this.user_2 = user_2;
        battleID = BattleManager.getInstance().GetNextBattleID();
    }

    public void Init(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    Iterator it = battleground.get(i).iterator();
                    while(it.hasNext()){
                        Warrior w = (Warrior)it.next();
                        w.MoveX(1);
                    }
                }
            }
        }, 0, 300);
    }

    public void spawn(SpawnObject s){
        battleground.get(s.getLine()).add(s.getWarrior());
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
