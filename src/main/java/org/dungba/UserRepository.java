package org.dungba;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class UserRepository implements IUserRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
}
