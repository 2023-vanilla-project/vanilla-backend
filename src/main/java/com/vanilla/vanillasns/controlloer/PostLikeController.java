package com.vanilla.vanillasns.controlloer;

import com.vanilla.vanillasns.entity.Post;
import com.vanilla.vanillasns.entity.User;
import com.vanilla.vanillasns.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts/{postId}/likes")
public class PostLikeController {
    private final PostLikeService postLikeService;

    @PostMapping
    public void likePost(@PathVariable long postId, @RequestParam String userId) {
        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setId(postId);

        postLikeService.likePost(user, post);
    }
}
