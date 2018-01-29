package Battle;

import Warrior.Warrior;
import User.*;

import java.util.*;

import static System.GameInfo.END_POS;
import static System.GameInfo.START_POS;

public class Battle{

    public enum BattleStatus{
        Started,
        Finished
    }

    private final int numOfLines = 5;

    public int battleID;
    public User user_1;
    public User user_2;
    private ArrayList<Line> battleground = new ArrayList<>();
    private BattleStatus status;

    Timer timer;


    public Battle(final User user_1, User user_2) {
        this.user_1 = user_1;
        this.user_2 = user_2;
        battleID = BattleManager.getInstance().GetNextBattleID();

        for(int i = 0; i < numOfLines; i++ ){
            battleground.add(new Line());
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(Line line : battleground){
                    line.Move();
                    /*for(Map.Entry<Integer, Warrior> w : army_left.get(i).entrySet()){
                        Warrior warrior = w.getValue();
                        warrior.MoveX(1);
                        System.out.println(warrior.Type + ":  " + warrior.X);
                        CallbackManager.getInstance().AddMsg(user_1.client, "move", warrior);
                        w.getValue().MoveX(1);
                    }*/
                }
            }
        }, 0, 500);
    }

    public Warrior spawn(Warrior w){
        w.MaxHp = 100;
        w.Hp = 100;
        w.Id = Warrior.idGenerator.incrementAndGet();
        w.X = w.FacingRight ? START_POS : END_POS;
        System.out.println("spawn fr: " + w.FacingRight);
        battleground.get(w.Line).Add(w);
        return w;
    }

    public void End(){
        timer.cancel();
    }

    public BattleStatus getStatus() {
        return status;
    }

    public void setStatus(BattleStatus status) {
        this.status = status;
    }
}
