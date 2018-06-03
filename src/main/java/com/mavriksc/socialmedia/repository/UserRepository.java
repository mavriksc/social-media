package com.mavriksc.socialmedia.repository;

import com.mavriksc.socialmedia.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User getUserByUsername(String username);

}
