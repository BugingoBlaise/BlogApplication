package com.example.blog_app.controller;

import com.example.blog_app.entity.Comment;
import com.example.blog_app.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    private ICommentService iCommentService;

    @PostMapping("/comments/create")
    public ResponseEntity<?> createComment(@RequestParam Long postId,
                                           @RequestParam String postedBy,
                                           @RequestBody String content
    ) {
        try {
            Comment createdComment = iCommentService.saveComment(postId, postedBy, content);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
        }
    }



}
