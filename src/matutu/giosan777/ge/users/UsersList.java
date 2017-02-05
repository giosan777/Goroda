package matutu.giosan777.ge.users;// giosan777 ...

import java.util.ArrayList;
import java.util.List;

public class UsersList {
    private static UsersList usersList = new UsersList();
    List<Long> usersArray = new ArrayList<>();

    private UsersList() {
    }

    public static UsersList getInstance() {
        if (usersList == null) {
            usersList = new UsersList();
        }
        return usersList;
    }

    public synchronized void addUserId(Long id) {
        usersArray.add(id);
    }

    public synchronized Long getId() {
        if (!usersArray.isEmpty()) {
            long id=usersArray.get(0);
            return id;
        }
        return Long.valueOf(0);
    }


}
