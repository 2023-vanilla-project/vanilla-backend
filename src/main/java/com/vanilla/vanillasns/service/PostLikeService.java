package com.vanilla.vanillasns.service;

import com.vanilla.vanillasns.entity.Post;
import com.vanilla.vanillasns.entity.PostLike;
import com.vanilla.vanillasns.entity.User;
import com.vanilla.vanillasns.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostLikeService {
    private final PostLikeRepository postLikeRepository;

    public void likePost(User user, Post post) {
        Optional<PostLike> existingLike = postLikeRepository.findByUserAndPost(user, post);
        if (!existingLike.isPresent()) {
            PostLike postLike = new PostLike();
            postLike.setUser(user);
            postLike.setPost(post);
            postLikeRepository.save(postLike);
        }
    }
}
