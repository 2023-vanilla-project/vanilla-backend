package com.vanilla.vanillasns.repository;

import com.vanilla.vanillasns.embeddable.FollowerId;
import com.vanilla.vanillasns.entity.Follower;
import com.vanilla.vanillasns.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowerRepository extends JpaRepository<Follower, FollowerId> {
    List<Follower> findByUser(User user);
    void deleteByUser_IdAndFollower_Id(String userId, String followerId);
    Optional<Follower> findByUserAndFollower(User user, User follower);

}


