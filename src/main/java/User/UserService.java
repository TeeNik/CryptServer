package User;

import Callback.CallbackManager;
import SocketObject.CallbackObject;

import java.util.*;

public class UserService {
    public static volatile UserService instance;
    volatile List<User> users = new ArrayList();

    public Timer serviceTask;

    public UserService(){
        serviceTask = new Timer();
        serviceTask.schedule(new TimerTask() {
            @Override
            public void run() {
                CallbackObject co = new CallbackObject();
                co.setOk(true);
                for (User u : users){
                    co.setId(u.getId());

                    CallbackManager.getInstance().AddMsg(u.client, "connect",co);
                    System.out.println("send connect to " + u.getName() + " " + u.getId());
                }
            }
        }, 0, 1000);
    }

    public static UserService getInstance(){
        if(instance == null){
            synchronized (UserService.class){
                if(instance == null) instance = new UserService();
            }
        }
        return instance;
    }

    public synchronized void auth(User user, UUID id){
        if(findUserBySessionId(id) == null){
            user.setCurrentSessionId(id);
            users.add(user);
            System.out.println("add user: " + user.getName());
        }
    }

    public synchronized void refuse(UUID id){
        Iterator it = users.iterator();
        while(it.hasNext()){
            User user = (User)it.next();
            if(user != null && user.getCurrentSessionId().equals(id)){
                it.remove();
            }
        }
    }

    public synchronized User findUserBySessionId(UUID id) {
        Iterator it = users.iterator();
        while (it.hasNext()) {
            User user = (User)it.next();
            if (user != null && user.getCurrentSessionId().equals(id)) {
                return  user;
            }
        }
        return null;
    }
}
