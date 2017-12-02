import Battle.Battle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teenik on 27.11.2017.
 */
public class LobbyThread {
    public static volatile LobbyThread instance;
    volatile List<Battle> users = new ArrayList();

    public static LobbyThread getInstance(){
        if(instance == null){
            synchronized (LobbyThread.class){
                if(instance == null) instance = new LobbyThread();
            }
        }
        return instance;
    }






}
