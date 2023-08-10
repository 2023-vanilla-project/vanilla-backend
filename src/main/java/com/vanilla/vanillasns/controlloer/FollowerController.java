package com.vanilla.vanillasns.controlloer;

import com.vanilla.vanillasns.entity.User;
import com.vanilla.vanillasns.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/followers")
public class FollowerController {

    private final FollowerService followerService;

    @Autowired
    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<User>> getFollowers(@PathVariable String userId) {
        List<User> followers = followerService.getFollowers(userId);
        return new ResponseEntity<>(followers, HttpStatus.OK);
    }
}


