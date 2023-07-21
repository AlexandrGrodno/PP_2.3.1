package web.DAo;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAO {
    private static int counUser;
    private List<User> user;

    {

        user = new ArrayList<>();
        user.add(new User(++counUser,"111","1122",(byte)1));
        user.add(new User(++counUser,"222","2233",(byte)1));

    }
    public List<User> GetAll(){
        return user;
    }
    public User GetUser(int id){
        return user.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    public void save(User users){
        users.setId(++counUser);
        user.add(users);
    }
}
