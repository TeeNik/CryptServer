package Battle;

import Warrior.Warrior;

import java.util.ArrayList;
import java.util.List;
import Warrior.Warrior.*;

public class Line {
    private List<Warrior> army_left = new ArrayList<>();
    private List<Warrior> army_right = new ArrayList<>();

    void Move(){

        MoveLine(army_left, army_right);
        MoveLine(army_right, army_left);

        //DrawLine();
    }

    private void MoveLine(List<Warrior> army_1, List<Warrior> army_2){
        Warrior w;
        for(int i = 0; i < army_1.size(); i++){
            w = army_1.get(i);
            if(i == 0) {
                if (army_2.size() != 0) {
                    if (w.X - army_2.get(i).X <= 2){
                        w.Status = Status.Stay;
                        w.Target = army_2.get(i);
                    }
                    else{
                        w.Status = Status.Walk;
                        w.Target = null;
                    }
                } else {
                    w.Status = Status.Walk;
                }
            }
            else {
                if(army_1.get(i-1).Status == Status.Stay)
                    w.Status = Status.Stay;
                else
                    w.Status = Status.Walk;
            }

            if(w.Target != null){
                w.Execute();
            }

            w.MoveX(1);
        }
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
            stringBuilder.setCharAt((int)w.X+12, 'O');
        }
        System.out.println(stringBuilder.toString());
    }

}
