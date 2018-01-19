package Battle;

import Game.Warrior;

import java.util.ArrayList;
import java.util.List;
import Game.Warrior.*;

public class Line {
    private List<Warrior> army_left = new ArrayList<>();
    private List<Warrior> army_right = new ArrayList<>();

    void Move(){
        for(int i = 0; i < army_left.size(); i++){
            Warrior w = army_left.get(i);
            w.MoveX(1);

            if(i == 0){
                if(army_right.size() != 0){
                    if(w.X + 2 == army_right.get(i).X){
                        w.Status = Status.Stay;
                    }
                }
            } else {
                if(army_left.get(i-1).Status == Status.Stay){
                    w.Status = Status.Stay;
                } else {
                    w.Status = Status.Walk;
                    w.MoveX(1);
                }
            }

        }
        DrawLine();
    }

    public void Add(Warrior w){
        if(w.FacingRight){
            army_left.add(w);
        } else {
            army_right.add(w);
        }
    }

    private void DrawLine(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 25; i++)
            stringBuilder.append("_");
        for(Warrior w : army_left){
            stringBuilder.setCharAt((int)w.X+12, 'X');
        }
        for(Warrior w : army_right){
            stringBuilder.setCharAt((int)w.X+12, 'X');
        }
        System.out.println(stringBuilder.toString());
    }

}
