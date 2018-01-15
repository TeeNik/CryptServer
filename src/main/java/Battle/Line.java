package Battle;

import Game.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import Game.Warrior.*;

public class Line {
    Map<Integer, Warrior> army = new TreeMap<>();
    List<Warrior> army_1 = new ArrayList<>();
    List<Warrior> army_2 = new ArrayList<>();

    void Move(){
        for(int i = 0; i < army_1.size(); i++){
            Warrior w = army_1.get(i);
            w.MoveX(1);

            if(i == 0){
                if(army_2.size() != 0){
                    if(w.X + 2 == army_2.get(i).X){
                        w.Status = Status.Stay;
                    }
                }
            } else {
                w.MoveX(1);
                if(army_1.get(i-1).Status == Status.Stay){
                    w.Status = Status.Stay;
                }
            }

        }
    }
}
