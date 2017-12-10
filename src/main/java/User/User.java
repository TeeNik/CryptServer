package User;

import Game.Player;
import com.corundumstudio.socketio.SocketIOClient;

import java.util.UUID;

/**
 * Created by teenik on 17.10.2017.
 */
public class User {
    private UUID currentSessionId;
    private int id;
    private Player player;
    private boolean inSearchBattle;
    private String name;
    private int battleID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SocketIOClient client;

    public User(){

    }

    public User(int id, Player player, String name, SocketIOClient c) {
        this.id = id;
        this.player = player;
        this.name = name;
        inSearchBattle = false;
        client = c;
    }

    public int getBattleID() {
        return battleID;
    }

    public void setBattleID(int battleID) {
        this.battleID = battleID;
    }

    public SocketIOClient getClient() {
        return client;
    }

    public void setClient(SocketIOClient client) {
        this.client = client;
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

    public UUID getCurrentSessionId(){return currentSessionId;}

    public void setCurrentSessionId(UUID id){ currentSessionId = id;}

}

