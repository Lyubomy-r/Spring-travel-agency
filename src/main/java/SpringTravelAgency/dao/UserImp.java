package SpringTravelAgency.dao;

import SpringTravelAgency.entity.User;
import org.hibernate.jpa.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository

public class UserImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserById(Long theId){
        User user=entityManager.find(User.class, theId);

        return user;
    }

    @Override
    public List<User> getUserList(){

        Query queryGetUsers=entityManager.createQuery("SELECT r FROM User r");
        List<User> allUsers= queryGetUsers.getResultList();

        return allUsers;
    }

    @Override
    public User getUserAllConnectionsById(Long theId) {
        Query query = entityManager.createQuery("SELECT DISTINCT u FROM User u LEFT join fetch u.orderList  WHERE u.userId=:theId")
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false );
        query.setParameter("theId", theId);
        User finUser= (User) query.getSingleResult();

        return finUser;
    }

    @Override
    public User getUserAllConnectionsByName(String nameUser) {
        Query query = entityManager.createQuery("SELECT DISTINCT u FROM User u LEFT join fetch u.orderList  WHERE u.firstName=:nameUser")
                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false );
        query.setParameter("nameUser", nameUser);
        User finUser= (User) query.getSingleResult();

        return finUser;
    }

    @Override
    public void addUser(User theUser){
        entityManager.persist(theUser);
    }

    @Override
    public void updateUser(User theUser){
        entityManager.merge(theUser);
    }
    @Override
    public void deleteUserById(Long theUser){
        User user=findUserById(theUser);
        entityManager.remove(user);
    }

}
