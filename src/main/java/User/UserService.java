package User;

import java.util.*;

public class UserService {
    public static volatile UserService instance;
    volatile List<User> users = new ArrayList();

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
