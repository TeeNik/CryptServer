package Game;

import java.util.ArrayList;

/**
 * Created by teenik on 23.11.2017.
 */
public class Player {
    public boolean facingRight;
    public int hp;
    public int maxHp;
    public int gold;
    public int mana;
    public int maxMana;
    public int moneySpeed;
    public int manaSpeed;
    public ArrayList<Warrior> army;


    public void Init(boolean facingRight){
        this.facingRight = facingRight;
        maxHp = 100;
        hp = maxHp;
        moneySpeed = 5;
        gold = 200;
        manaSpeed = 2;
        army = new ArrayList<>();
        maxMana = 50;
        mana = 10;
    }
}


