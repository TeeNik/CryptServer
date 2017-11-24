import User.User;

import java.util.ArrayList;

/**
 * Created by teenik on 23.11.2017.
 */
public class Lobby {
    ArrayList<User> userQueue;

    public Lobby() {
        userQueue = new ArrayList<User>();

    }

    void Add(User u){
        userQueue.add(u);
    }
}
