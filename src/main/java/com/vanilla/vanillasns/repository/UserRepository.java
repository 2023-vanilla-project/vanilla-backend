package com.vanilla.vanillasns.repository;

import com.vanilla.vanillasns.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}