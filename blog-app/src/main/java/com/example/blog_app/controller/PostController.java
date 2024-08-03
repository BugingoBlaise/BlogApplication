package com.example.blog_app.controller;

import com.example.blog_app.entity.Post;
import com.example.blog_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts")
public class PostController {
    @Autowired
    private PostService postService;
@PostMapping
    public ResponseEntity<?>createPost(@RequestBody Post post){
        try{
            Post createdPost=postService.postSave(post);
            return  ResponseEntity.status(HttpStatus.CREATED).body(post);
        }catch (Exception exception){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }


}
