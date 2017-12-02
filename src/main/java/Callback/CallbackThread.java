package Callback;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by teenik on 02.12.2017.
 */
public class CallbackThread {
    private final int messageTimeWait = 100; //.1 sec
    //End Config

    private volatile BlockingQueue<CallbackMessage> messagePull = new LinkedBlockingDeque<>();
    public Timer SenderThread;

    public synchronized void AddMsg(CallbackMessage msg){
        messagePull.add(msg);
    }

    public void Init(){
        SenderThread = new Timer();
        SenderThread.schedule(new ServiceTask(), 0, messageTimeWait);
    }

    public class ServiceTask extends TimerTask {
        public void run(){
            List<CallbackMessage> data = new ArrayList<>();

            if (messagePull.size() < 70000) {
                messagePull.drainTo(data);
            } else {
                messagePull.drainTo(data, 70000);
            }
            if (!data.isEmpty()) {
                Iterator it = data.iterator();
                while (it.hasNext()) {
                    CallbackMessage msg = (CallbackMessage)it.next();
                    if (msg != null && msg.client != null && msg.client.isChannelOpen()){
                        msg.client.sendEvent(msg.eventName,msg.data);
                    }
                }
                data.clear();
            }


        }
    }
}
