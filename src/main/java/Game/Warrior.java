package Game;

/**
 * Created by teenik on 23.11.2017.
 */
public class Warrior {
    int type;
    int hp;
    int reload;
    float x;
    float y;
    boolean lookingLeft;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public float moveX(float a){this.x += a;}

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isLookingLeft() {
        return lookingLeft;
    }

    public void setLookingLeft(boolean lookingLeft) {
        this.lookingLeft = lookingLeft;
    }
}
