package Warrior;

public abstract class WarriorState {

    public Warrior warrior;

    abstract public void Enter(Warrior w);
    abstract public void Execute();
    abstract public void Exit();
}
