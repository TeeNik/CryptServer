import SocketObject.TestObject;
import User.User;
import com.corundumstudio.socketio.SocketIOClient;

import static java.lang.Thread.sleep;

public class Battle implements Runnable{
    public SocketIOClient client;

    private User user_1;
    private User user_2;

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
