package com.example.blog_app.service;

import com.example.blog_app.entity.Comment;

public interface ICommentService {
    Comment saveComment(Long postId, String postedBy, String content);
}
