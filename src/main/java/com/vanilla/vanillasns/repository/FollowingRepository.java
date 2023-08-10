package com.vanilla.vanillasns.repository;

import com.vanilla.vanillasns.embeddable.FollowingId;
import com.vanilla.vanillasns.entity.Following;
import com.vanilla.vanillasns.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowingRepository extends JpaRepository<Following, FollowingId> {
    List<Following> findByUser(User user);

    Optional<Following> findByUserAndFollowing(User user, User following);

    List<Following> findByFollowing(User user);
}
