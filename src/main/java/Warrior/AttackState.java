package Warrior;

public class AttackState extends WarriorState{

    @Override
    public void Enter(Warrior w) {
        warrior = w;
    }

    @Override
    public void Execute() {
        warrior.Target.TakeDamage(warrior.Damage);
    }

    @Override
    public void Exit() {

    }
}
