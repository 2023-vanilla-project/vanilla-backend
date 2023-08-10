package com.vanilla.vanillasns.service;

import com.vanilla.vanillasns.dto.FollowingDTO;
import com.vanilla.vanillasns.entity.Following;
import com.vanilla.vanillasns.entity.User;
import com.vanilla.vanillasns.exception.ResourceNotFoundException;
import com.vanilla.vanillasns.repository.FollowingRepository;
import com.vanilla.vanillasns.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FollowingService {

    public Following addFollowing(String userId, String followingId, FollowingDTO followingDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        User following = userRepository.findById(followingDTO.getFollowingId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + followingDTO.getFollowingId()));

        Following newFollowing = new Following(user, following);
        return followingRepository.save(newFollowing);
    }
    public List<User> getFollowing(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        List<Following> followingRelations = followingRepository.findByUser(user);
        List<User> followingUsers = new ArrayList<>();

        for (Following following : followingRelations) {
            followingUsers.add(following.getFollowing());
        }

        return followingUsers;
    }
    private final FollowingRepository followingRepository;
    private final UserRepository userRepository;

    @Autowired
    public FollowingService(FollowingRepository followingRepository, UserRepository userRepository) {
        this.followingRepository = followingRepository;
        this.userRepository = userRepository;
    }

    public List<User> getFollowers(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        List<Following> followerRelations = followingRepository.findByFollowing(user);

        List<User> followers = new ArrayList<>();
        for (Following relation : followerRelations) {
            followers.add(relation.getUser());
        }

        return followers;
    }

    public Following followUser(String userId, String followingId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + followingId));

        Following newFollowing = new Following(user, following);
        return followingRepository.save(newFollowing);
    }

    public void unfollowUser(String userId, String followingId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + followingId));

        Following followingRelation = followingRepository.findByUserAndFollowing(user, following)
                .orElseThrow(() -> new ResourceNotFoundException("Following relation not found"));

        followingRepository.delete(followingRelation);
    }
}

