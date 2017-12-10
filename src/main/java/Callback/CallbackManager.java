package Callback;

import com.corundumstudio.socketio.SocketIOClient;

/**
 * Created by Yan on 28.11.2017.
 */
public class CallbackManager {
    static volatile CallbackManager instance;
    static volatile CallbackThread[] threads;
    volatile int curThread = 0;

    public static CallbackManager getInstance(){
        if(instance == null){
            synchronized (CallbackManager.class){
                if(instance == null) instance = new CallbackManager();
            }
        }
        return instance;
    }

    public void Init(){
        threads = new CallbackThread[Runtime.getRuntime().availableProcessors() * 2];
        for (int i = 0; i < threads.length; i++){
            threads[i] = new CallbackThread();
            threads[i].Init();
        }
    }

    public synchronized void AddMsg(SocketIOClient cl, String ev, Object dt){
        threads[curThread].AddMsg(new CallbackMessage(cl,ev,dt));
        curThread += 1;
        if (curThread > threads.length - 1) curThread = 0;
    }

    public void Stop(){
        for (int i = 0; i < threads.length; i++){
            threads[i].SenderThread.cancel();
        }
    }
}
