package com.vanilla.vanillasns.controlloer;

import com.vanilla.vanillasns.dto.PostLikeDTO;
import com.vanilla.vanillasns.entity.PostLike;
import com.vanilla.vanillasns.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts/{postId}/likes")
public class PostLikeController {
    private final PostLikeService postLikeService;

    //게시글 좋아요
    @PostMapping
    public ResponseEntity<PostLike> addLike(@PathVariable long postId, @RequestParam String userId, @RequestBody PostLikeDTO postLikeDTO) {
        PostLike postLike = postLikeService.addLike(postId, userId, postLikeDTO);

        return new ResponseEntity<>(postLike, HttpStatus.CREATED);
    }

    //게시글 좋아요 취소
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLike(@PathVariable long id) {
        boolean isDeleted = postLikeService.deleteLike(id);
        if (isDeleted) {
            return new ResponseEntity<>("좋아요가 취소되었습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("좋아요를 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
        }
    }
}
