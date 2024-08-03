package com.example.blog_app.service;

import com.example.blog_app.entity.Post;
import com.example.blog_app.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostService implements IPostService {
    @Autowired
    private PostRepo postRepo;


    @Override
    public Post postSave(Post post) {
post.setLikeCount(0);
post.setViewCount(0);
post.setDate(new Date());



        return postRepo.save(post);

    }
}
