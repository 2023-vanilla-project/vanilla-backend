package com.vanilla.vanillasns.repository;

import com.vanilla.vanillasns.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByName(String name);
}
