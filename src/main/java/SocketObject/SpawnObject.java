package SocketObject;

import Game.Warrior;

/**
 * Created by Yan on 28.11.2017.
 */
public class SpawnObject {
    int userId;
    int line;
    Warrior warrior;

    public SpawnObject(int line, Warrior warrior) {
        this.line = line;
        this.warrior = warrior;
    }

    public SpawnObject() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLine() {

        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }
}
