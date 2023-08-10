package com.vanilla.vanillasns.service;

import com.vanilla.vanillasns.dto.PostLikeDTO;
import com.vanilla.vanillasns.entity.Post;
import com.vanilla.vanillasns.entity.PostLike;
import com.vanilla.vanillasns.entity.User;
import com.vanilla.vanillasns.repository.PostLikeRepository;
import com.vanilla.vanillasns.repository.PostRepository;
import com.vanilla.vanillasns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostLike addLike(long postId, String userId, PostLikeDTO postLikeDTO) {
        PostLike postLike = new PostLike();
        postLike.setId(postLikeDTO.getId());

        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post no found with ID: " + postId));
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));

        postLike.setPost(post);
        postLike.setUser(user);

        return postLikeRepository.save(postLike);
    }

    public boolean deleteLike(long id) {
        Optional<PostLike> optionalLike = postLikeRepository.findById(id);
        if (optionalLike.isPresent()) {
            postLikeRepository.delete(optionalLike.get());
            return true;
        } else {
            return false;
        }
    }
}
