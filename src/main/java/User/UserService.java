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
        if(!users.contains(user)){

        }
    }
}
