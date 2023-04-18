package SpringTravelAgency.dao;

import SpringTravelAgency.entity.User;

import java.util.List;

public interface UserDAO {

    public User getUserAllConnectionsById(Long theId);

    public User getUserAllConnectionsByName(String nameUser);
    public User findUserById(Long theId);
    public User getUserByEmail(String userEmail);
    public List<User> getUserList();
    public void addUser(User theUser);
    public void updateUser(User theUser);
    public void bannedUser(Long userId);
    public void deleteUserById(Long theUser);


}
