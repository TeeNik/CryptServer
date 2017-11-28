package Game;

import java.util.ArrayList;

/**
 * Created by teenik on 23.11.2017.
 */
public class Player {
    int hp;
    int gold;
    int mp;
    ArrayList<Warrior> army;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public ArrayList<Warrior> getArmy() {
        return army;
    }

    public void setArmy(ArrayList<Warrior> army) {
        this.army = army;
    }
}
