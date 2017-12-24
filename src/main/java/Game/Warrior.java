package Game;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by teenik on 23.11.2017.
 */
public class Warrior {

    public static final AtomicInteger idGenerator = new AtomicInteger(0);

    public enum CharacterType {
        Goblin,
        Ranger,
        Cleric,
        Skeleton,
        Golem,
        Wizard
    }

    public int playerID;
    public int id;
    public int line;
    public int type;
    public int maxHp;
    public int hp;
    public int reload;
    public float x;
    public float y;
    public boolean facingRight;

    public Warrior(){

    }

    public Warrior(int playerID, int id, int line, int type, int maxHp, int hp, int reload, float x, float y, boolean facingRight) {
        this.playerID = playerID;
        this.id = id;
        this.line = line;
        this.type = type;
        this.maxHp = maxHp;
        this.hp = hp;
        this.reload = reload;
        this.x = x;
        this.y = y;
        this.facingRight = facingRight;
    }

    public void MoveX(float a){
        if(facingRight) {
            this.x -= a;
        } else {
            this.x += a;
        }
    }
}
