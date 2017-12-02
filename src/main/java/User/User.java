package User;

import Game.Player;
import com.corundumstudio.socketio.SocketIOClient;

import java.util.UUID;

/**
 * Created by teenik on 17.10.2017.
 */
public class User {
    UUID currentSessionId;
    long id;
    Player player;
    boolean inSearchBattle;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SocketIOClient client;

    public User(){

    }

    public User(long id, Player player, String name) {
        this.id = id;
        this.player = player;
        this.name = name;
        inSearchBattle = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public UUID getCurrentSessionId(){return currentSessionId;}

    public void setCurrentSessionId(UUID id){ currentSessionId = id;}

}

