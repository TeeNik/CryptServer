package SocketObject;

import Warrior.Warrior;

/**
 * Created by Yan on 28.11.2017.
 */
public class SpawnObject {
    public int userId;
    public int line;
    public Warrior warrior;

    public SpawnObject(int line, Warrior warrior) {
        this.line = line;
        this.warrior = warrior;
    }

    public SpawnObject() {
    }

}
