package Battle;

import Callback.CallbackManager;
import Game.Warrior;
import User.*;

import java.util.*;

import static System.GameInfo.END_POS;
import static System.GameInfo.START_POS;

public class Battle{

    private final int numOfLines = 5;

    public int battleID;
    public User user_1;
    public User user_2;
    private ArrayList<TreeMap<Integer, Warrior>> army_1 = new ArrayList<TreeMap<Integer, Warrior>>();
    private ArrayList<TreeMap<Integer, Warrior>> army_2 = new ArrayList<TreeMap<Integer, Warrior>>();
    private int num = 0;
    private int status;

    Timer timer;


    public Battle(final User user_1, User user_2) {
        this.user_1 = user_1;
        this.user_2 = user_2;
        battleID = BattleManager.getInstance().GetNextBattleID();

        for(int i = 0; i < numOfLines; i++ ){
            army_1.add(new TreeMap<Integer, Warrior>());
            army_2.add(new TreeMap<Integer, Warrior>());
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++){
                    for(Map.Entry<Integer, Warrior> w : army_1.get(i).entrySet()){
                        Warrior warrior = w.getValue();
                        warrior.MoveX(1);
                        System.out.println(warrior.Type + ":  " + warrior.X);
                        CallbackManager.getInstance().AddMsg(user_1.client, "move", warrior);
                        w.getValue().MoveX(1);
                    }
                }
            }
        }, 0, 500);
    }

    public Warrior spawn(Warrior w){
        army_1.get(w.Line).put(w);
        w.MaxHp = 100;
        w.Hp = 100;
        w.Id = Warrior.idGenerator.incrementAndGet();
        w.X = w.FacingRight ? START_POS : END_POS;
        return w;
    }

    public void End(){
        timer.cancel();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
