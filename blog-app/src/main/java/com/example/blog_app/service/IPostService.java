package com.example.blog_app.service;

import com.example.blog_app.entity.Post;

import java.util.List;

public interface IPostService {
    Post postSave(Post post);
List<Post>getAllPosts();
Post updateViewCount(Long postId);
    Post likePost(Long postId);
}
