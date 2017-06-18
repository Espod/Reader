package com.espod.repository;

import com.espod.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User save(User user);

    User findByUserID(String userID);
}
