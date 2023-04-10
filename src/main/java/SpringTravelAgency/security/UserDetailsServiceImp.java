package SpringTravelAgency.security;

import SpringTravelAgency.entity.User;
import SpringTravelAgency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsServiceImp")
public class UserDetailsServiceImp implements UserDetailsService {

    private UserService userService;

    @Autowired
    public UserDetailsServiceImp(UserService userService){
        this.userService=userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

            Optional<User> user = Optional.ofNullable(userService.getUserByEmail(email));
            if(user.isEmpty()){
            throw new UsernameNotFoundException("User doesn't exists ");
        }else {
                return SecurityUser.fromUser(user.get());
            }
    }
}
