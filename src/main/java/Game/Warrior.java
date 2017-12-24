package Game;

import java.util.UUID;

/**
 * Created by teenik on 23.11.2017.
 */
public class Warrior {

    public enum CharacterType {
        Goblin,
        Ranger,
        Cleric,
        Skeleton,
        Golem,
        Wizard
    }

    UUID playerID;
    UUID id;
    int line;
    int type;
    int maxHp;
    int hp;
    int reload;
    float x;
    float y;
    boolean facingRight;

    public UUID getPlayerID() {
        return playerID;
    }

    public void setPlayerID(UUID playerID) {
        this.playerID = playerID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getReload() {
        return reload;
    }

    public void setReload(int reload) {
        this.reload = reload;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isFacingRight() {
        return facingRight;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public Warrior(){

    }

    public Warrior(UUID playerID, UUID id, int line, int type, int maxHp, int hp, int reload, float x, float y, boolean facingRight) {
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
