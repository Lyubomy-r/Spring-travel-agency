package SpringTravelAgency.service;

import SpringTravelAgency.dao.UserService;
import SpringTravelAgency.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserService userService;

    @Autowired
    public UserServiceImp (UserService userService){
        this.userService = userService;
    }
    @Override
    public User getUserAllConnectionsById(Long theId){
        return userService.getUserAllConnectionsById(theId);
    }
    @Override
    public User getUserAllConnectionsByName(String nameUred){
        return userService.getUserAllConnectionsByName(nameUred);
    }
    @Override
    public User findUserById(Long theId){
        return userService.findUserById(theId);
    }
    @Override
    public List<User> getUserList(){
        return userService.getUserList();
    }
    @Override
    public void addUser(User theUser){
        userService.addUser(theUser);
    }
    @Override
    public void updateUser(User theUser){
        userService.updateUser(theUser);
    }
    @Override
    public void deleteUserById(Long theUser){
        userService.deleteUserById(theUser);
    }



}
