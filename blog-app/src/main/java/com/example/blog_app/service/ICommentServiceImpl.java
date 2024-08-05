package com.example.blog_app.service;

import com.example.blog_app.entity.Comment;
import com.example.blog_app.entity.Post;
import com.example.blog_app.repository.CommentRepo;
import com.example.blog_app.repository.PostRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ICommentServiceImpl implements ICommentService{
    @Autowired
    private CommentRepo commentRepo;

  @Autowired
  private PostRepo postRepo;

    @Override
    public Comment saveComment(Long postId, String postedBy, String content) {
        Optional<Post>optionalPost=postRepo.findById(postId);
        if(optionalPost.isPresent()){
            Comment comment=new Comment();
            comment.setPost(optionalPost.get());
            comment.setContent(content);
            comment.setPostedBy(postedBy);
            comment.setCreatedAt(new Date());

            return commentRepo.save(comment);
        }throw new EntityNotFoundException("Entity not found");

     }
}
