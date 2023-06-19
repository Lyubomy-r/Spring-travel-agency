package SpringTravelAgency.service;

import SpringTravelAgency.dao.UserDAO;
import SpringTravelAgency.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserAllConnectionsById(Long theId) {
        return userDAO.getUserAllConnectionsById(theId);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return userDAO.getUserByEmail(userEmail);
    }

    @Override
    public User getUserAllConnectionsByName(String nameUser) {
        return userDAO.getUserAllConnectionsByName(nameUser);
    }

    @Override
    public User findUserById(Long theId) {
        return userDAO.findUserById(theId);
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }

    @Override
    public Boolean emailExist(List<User> userList, User theUser){

        return  userList.stream()
                .anyMatch(user -> user.getEmail().equals(theUser.getEmail()));
    }

    @Override
    public void addUser(User theUser) {
        userDAO.addUser(theUser);
    }

    @Override
    public void updateUser(User theUser) {
        userDAO.updateUser(theUser);
    }

    @Override
    public void bannedUser(Long userId) {
        userDAO.bannedUser(userId);
    }

    @Override
    public void deleteUserById(Long theUser) {
        userDAO.deleteUserById(theUser);
    }
}
