package SpringTravelAgency.service;

import SpringTravelAgency.entity.Room;
import SpringTravelAgency.entity.User;

import java.util.List;

public interface UserService {

    User getUserAllConnectionsById(Long theId);

    User getUserAllConnectionsByName(String nameUred);

    User findUserById(Long theId);

    User getUserByEmail(String userEmail);

    List<User> getUserList();

    Boolean emailExist(List<User> userList, User theUser);

    void addUser(User theUser);

    void updateUser(User theUser);

    void bannedUser(Long userId);

    void deleteUserById(Long theUser);
}
