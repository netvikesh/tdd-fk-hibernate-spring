package net.vikesh.fk.repository;

import net.vikesh.fk.entity.User;
import net.vikesh.fk.repository.generic.GenericCrudRepository;

/**
 * Created by vikes on 11-06-2017.
 */
public interface UserRepository extends GenericCrudRepository<User, String> {

    /**
     * @param userName
     * @return User by the given userName
     */
    User findByUserName(String userName);

    /**
     * @param email
     * @return User by the given email
     */
    User findByEmail(String email);
}