package Warrior;

public class WalkState extends WarriorState{
    @Override
    public void Enter(Warrior w) {
        warrior = w;
    }

    @Override
    public void Execute() {
        warrior.MoveX(1);
    }

    @Override
    public void Exit() {

    }
}
