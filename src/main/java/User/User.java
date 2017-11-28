package User;

import Game.Player;

/**
 * Created by teenik on 17.10.2017.
 */
public class User {
    int id;
    Player player;
    boolean inSearchBattle;

    public User(int id, Player player) {
        this.id = id;
        this.player = player;
        inSearchBattle = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isInSearchBattle() {
        return inSearchBattle;
    }

    public void setInSearchBattle(boolean g) {
        this.inSearchBattle = g;
    }

}

