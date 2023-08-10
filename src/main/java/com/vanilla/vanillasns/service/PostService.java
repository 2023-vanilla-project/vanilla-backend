package com.vanilla.vanillasns.service;

import com.vanilla.vanillasns.dto.PostDTO;
import com.vanilla.vanillasns.entity.Location;
import com.vanilla.vanillasns.entity.Post;
import com.vanilla.vanillasns.entity.PostCategory;
import com.vanilla.vanillasns.entity.User;
import com.vanilla.vanillasns.repository.LocationRepository;
import com.vanilla.vanillasns.repository.PostCategoryRepository;
import com.vanilla.vanillasns.repository.PostRepository;
import com.vanilla.vanillasns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostCategoryRepository postCategoryRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public Post createPost(PostDTO postDTO) {
        Post post = new Post();
        post.setId(postDTO.getId());

        PostCategory postCategory = postCategoryRepository.findById(postDTO.getCategoryId()).orElse(null);
        Location location = locationRepository.findById(postDTO.getLocationId()).orElse(null);
        User user = userRepository.findById(postDTO.getUserId()).orElse(null);

        post.setPostCategory(postCategory);
        post.setLocation(location);
        post.setUser(user);
        post.setContent(postDTO.getContent());
        post.setImage(postDTO.getImage());
        post.setDate(postDTO.getDate());

        return postRepository.save(post);
    }

    public Post updatePost(long id, PostDTO postDTO) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글을 찾을 수 없습니다. ID: " + id));

        PostCategory postCategory = postCategoryRepository.findById(postDTO.getCategoryId()).orElse(null);
        Location location = locationRepository.findById(postDTO.getLocationId()).orElse(null);

        existingPost.setPostCategory(postCategory);
        existingPost.setLocation(location);
        existingPost.setContent(postDTO.getContent());
        existingPost.setImage(postDTO.getImage());
        existingPost.setDate(postDTO.getDate());


        return postRepository.save(existingPost);
    }

    public boolean deletePost(long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            postRepository.delete(optionalPost.get());
            return true;
        } else {
            return false;
        }
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> findPost(long id) {
        return postRepository.findById(id);
    }
}
