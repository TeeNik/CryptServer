import Game.Warrior;
import SocketObject.TestObject;
import User.User;
import com.corundumstudio.socketio.SocketIOClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.enumerate;
import static java.lang.Thread.sleep;

public class Battle implements Runnable{
    public SocketIOClient client;

    private User user_1;
    private User user_2;

    private int num = 0;

    private Timer timer;

    public Battle(){
        client = null;
    }

    ArrayList<ArrayList<Warrior>> battleground = new ArrayList<ArrayList<Warrior>>(5);

    public Battle(SocketIOClient s){
        client = s;
    }

    public void Init(){
        ArrayList

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(Warrior w : user_1.getPlayer().getArmy()){
                    if( w.isLookingLeft()) w.moveX(-10);
                    else w.moveX(10);
                }
            }
        }, 0, 300);
    }

    public void run() {
        try {

            while (true){
                num++;

                client.sendEvent("test", new TestObject(num));
                System.out.println("Send: " + num);

                sleep(2500);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Spawn(int type, int line){
        battleground.get(line).add(new Warrior());
    }
}
