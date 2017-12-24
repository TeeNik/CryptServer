package Game;

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

    public int PlayerId;
    public int Id;
    public int Line;
    public int Type;
    public int MaxHp;
    public int Hp;
    public int Reload;
    public float X;
    public float Y;
    public boolean FacingRight;

    public Warrior(){

    }

    public Warrior(int playerID, int id, int line, int type, int maxHp, int hp, int reload, float x, float y, boolean facingRight) {
        this.PlayerId = playerID;
        this.Id = id;
        this.Line = line;
        this.Type = type;
        this.MaxHp = maxHp;
        this.Hp = hp;
        this.Reload = reload;
        this.X = x;
        this.Y = y;
        this.FacingRight = facingRight;
    }

    public void MoveX(float a){
        if(FacingRight) {
            this.X -= a;
        } else {
            this.X += a;
        }
    }
}
