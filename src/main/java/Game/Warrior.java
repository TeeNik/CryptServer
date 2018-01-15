package Game;

import System.GameInfo.CharacterType;

import java.util.concurrent.atomic.AtomicInteger;

import static System.GameInfo.END_POS;
import static System.GameInfo.START_POS;

/**
 * Created by teenik on 23.11.2017.
 */
public class Warrior {

    public static final AtomicInteger idGenerator = new AtomicInteger(0);



    public int PlayerId;
    public int Id;
    public int Line;
    public CharacterType Type;
    public int MaxHp;
    public int Hp;
    public int Reload;
    public float X;
    public float Y;
    public boolean FacingRight;

    public Warrior(){

    }

    public Warrior(int playerID, int id, int line, CharacterType type, int maxHp, int hp, int reload, float x, float y, boolean facingRight) {
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
        if(FacingRight && this.X < END_POS)
        {
            this.X += a;
        }
        else if (!FacingRight && this.X > START_POS)
        {
            this.X -= a;
        }
    }
}
