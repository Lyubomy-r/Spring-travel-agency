package SpringTravelAgency.service;

import SpringTravelAgency.entity.User;

import java.util.List;

public interface UserService {

    public User getUserAllConnectionsById(Long theId);

    public User getUserAllConnectionsByName(String nameUred);
    public User findUserById(Long theId);
    public User getUserByEmail(String userEmail);
    public List<User> getUserList();
    public void addUser(User theUser);
    public void updateUser(User theUser);

    public void bannedUser(Long userId);
    public void deleteUserById(Long theUser);
}
