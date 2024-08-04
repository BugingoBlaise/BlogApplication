package com.example.blog_app.service;

import com.example.blog_app.entity.Post;
import com.example.blog_app.repository.PostRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post updateViewCount(Long postId) {

        Optional<Post> optionalPost = postRepo.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setViewCount(post.getViewCount() + 1);
            return postRepo.save(post);
        } else {
            throw new EntityNotFoundException("Post Not Found");
        }


    }
    @Override
    public Post likePost(Long postId) {

        Optional<Post> postOptional = postRepo.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            post.setLikeCount(post.getLikeCount() + 1);
            return postRepo.save(post);
        } else {
            throw new EntityNotFoundException("Post Not Found with Id: "+postId);
        }


    }
}
