package com.ed.manufacture.dao;

import com.ed.manufacture.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "FROM User WHERE password IS NOT NULL AND dismissed = false ORDER BY surname")
    Iterable<User> getAuthUsers();

    @Query(value = "FROM User WHERE surname = :username")
    User findUser(@Param("username") String username);
}
