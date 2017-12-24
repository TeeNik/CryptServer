package Battle;

import Game.Warrior;
import SocketObject.SpawnObject;
import User.*;

import java.util.*;

public class Battle{

    private final int numOfLines = 5;

    public int battleID;
    public User user_1;
    public User user_2;
    private ArrayList<ArrayList<Warrior>> battleground = new ArrayList<ArrayList<Warrior>>();
    private int num = 0;
    private int status;

    Timer timer;

    public Battle(User user_1, User user_2) {
        this.user_1 = user_1;
        this.user_2 = user_2;
        battleID = BattleManager.getInstance().GetNextBattleID();

        for(int i = 0; i < numOfLines; i++ ){
            battleground.add(new ArrayList<Warrior>());
        }

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

    public Warrior spawn(Warrior w){
        battleground.get(w.line).add(w);
        w.maxHp = 100;
        w.hp = 100;
        w.id = Warrior.idGenerator.incrementAndGet();

        return w;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
