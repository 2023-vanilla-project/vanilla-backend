package com.vanilla.vanillasns.controlloer;

import com.vanilla.vanillasns.dto.PostDTO;
import com.vanilla.vanillasns.entity.Post;
import com.vanilla.vanillasns.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    //게시글 등록
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDTO requestDto) {
        Post createdPost = postService.createPost(requestDto);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    //게시글 목록 조회
    @GetMapping("/list")
    public ResponseEntity<List<Post>> findAllPosts() {
        List<Post> posts = postService.findAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);

    }

    //게시글 조회
    @GetMapping("/{id}")
    public ResponseEntity<Post> findPost(@PathVariable long id) {
        Optional<Post> optionalPost = postService.findPost(id);
        if (optionalPost.isPresent()) {
            Post findPost = optionalPost.get();
            return new ResponseEntity<>(findPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody PostDTO requestDto) {
        Post updatedPost = postService.updatePost(id, requestDto);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    //게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id) {
        boolean isDeleted = postService.deletePost(id);
        if (isDeleted) {
            return new ResponseEntity<>("게시물이 성공적으로 삭제되었습니다.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("해당 게시물을 찾을 수 없습니다.", HttpStatus.NOT_FOUND);
        }
    }
}
