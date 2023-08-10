package com.vanilla.vanillasns.repository;

import com.vanilla.vanillasns.entity.Post;
import com.vanilla.vanillasns.entity.PostLike;
import com.vanilla.vanillasns.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByUserAndPost(User user, Post post);
}
