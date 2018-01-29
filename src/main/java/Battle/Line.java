package Battle;

import Warrior.AttackState;
import Warrior.SupportState;
import Warrior.WalkState;
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
                        w.ChangeState(new AttackState());
                        w.Target = army_2.get(i);
                    }
                    else{
                        w.ChangeState(new WalkState());
                        w.Target = null;
                    }
                } else {
                    w.ChangeState(new AttackState());
                }
            }
            else {
                if(army_1.get(i-1).State.getClass() == AttackState.class)
                    w.ChangeState(new SupportState());
                else
                    w.ChangeState(new WalkState());
            }

            w.State.Execute();
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
