package Battle;

import Game.Warrior;
import SocketObject.TestObject;
import User.User;
import com.corundumstudio.socketio.SocketIOClient;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Thread.sleep;

public class Battle implements Runnable{
    public SocketIOClient client;

    private User user_1;
    private User user_2;

    private ArrayList<ArrayList<Warrior>> battleground = new ArrayList<ArrayList<Warrior>>(5);

    private int num = 0;

    public Battle(){
        client = null;
    }

    public Battle(SocketIOClient s){
        client = s;
    }

    public void run() {
        try {

            while (true){

                for(int i = 0; i < 5; i++){
                    Iterator it = battleground.get(i).iterator();
                    while(it.hasNext()){
                        Warrior w = (Warrior)it.next();
                        w.moveX(1);
                    }
                }


                num++;

                client.sendEvent("test", new TestObject(num));
                System.out.println("Send: " + num);

                sleep(2500);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
