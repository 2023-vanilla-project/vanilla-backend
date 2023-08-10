package com.vanilla.vanillasns.service;

import com.vanilla.vanillasns.entity.Follower;
import com.vanilla.vanillasns.entity.User;
import com.vanilla.vanillasns.exception.ResourceNotFoundException;
import com.vanilla.vanillasns.repository.FollowerRepository;
import com.vanilla.vanillasns.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FollowerService {

    private final FollowerRepository followerRepository;
    private final UserRepository userRepository;

    @Autowired
    public FollowerService(FollowerRepository followerRepository, UserRepository userRepository) {
        this.followerRepository = followerRepository;
        this.userRepository = userRepository;
    }

    public List<User> getFollowers(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

        List<Follower> followerRelations = followerRepository.findByUser(user);

        List<User> followers = new ArrayList<>();
        for (Follower relation : followerRelations) {
            followers.add(relation.getFollower());
        }

        return followers;
    }
}


