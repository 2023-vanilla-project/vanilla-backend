package com.vanilla.vanillasns.repository;

import com.vanilla.vanillasns.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
