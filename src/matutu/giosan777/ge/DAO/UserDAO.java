package matutu.giosan777.ge.DAO;


import matutu.giosan777.ge.entity.UsersEntity;

import java.util.List;

public interface UserDAO {
    public List getAllUser();
    public void addUser(UsersEntity usersEntity);

}
