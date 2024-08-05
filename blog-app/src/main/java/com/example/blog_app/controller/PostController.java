package com.example.blog_app.controller;

import com.example.blog_app.entity.Post;
import com.example.blog_app.service.IPostService;
import com.example.blog_app.service.PostServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {
    @Autowired
    private IPostService postServiceImpl;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        try {
            Post createdPost = postServiceImpl.postSave(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        try {
            return ResponseEntity.ok(postServiceImpl.getAllPosts());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable Long postId) {
        try {
            Post post = postServiceImpl.updateViewCount(postId);
            return ResponseEntity.ok(post);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

        }
    }

    @PutMapping("/{postId}/like")
    public ResponseEntity<?> updateLikeCount(@PathVariable Long postId) {
        try {
            Post post = postServiceImpl.likePost(postId);
            return ResponseEntity.ok(new String[]{"Post liked successfully"});
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchByName(@PathVariable String name) {
        try {
            List<Post> dataList = postServiceImpl.searchPostByName(name);
            return ResponseEntity.status(HttpStatus.OK).body(dataList);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
