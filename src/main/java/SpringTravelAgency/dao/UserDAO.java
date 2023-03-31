package SpringTravelAgency.dao;

import SpringTravelAgency.entity.User;

import java.util.List;

public interface UserDAO {

    public User getUserAllConnections(Long theId);
    public User findUserById(Long theId);
    public List<User> getUserList();
    public void addUser(User theUser);
    public void updateUser(User theUser);
    public void deleteUserById(Long theUser);


}
