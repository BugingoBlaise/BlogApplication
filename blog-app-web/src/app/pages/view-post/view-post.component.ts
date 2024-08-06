import { Component, OnInit } from '@angular/core';
import { PostService } from '../../service/post.service';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommentService } from '../../service/comment.service';

@Component({
  selector: 'app-view-post',
  templateUrl: './view-post.component.html',
  styleUrl: './view-post.component.scss',
})
export class ViewPostComponent {
  postId = this.activatedRoute.snapshot.params['id'];
  postData: any;
  commentForm!: FormGroup;
  constructor(
    private postService: PostService,
    private activatedRoute: ActivatedRoute,
    private matSnackBar: MatSnackBar,
    private fb: FormBuilder,
    private commentService: CommentService
  ) {}
  ngOnInit(): void {
    console.log(this.postId);
    console.log(this.getPostById());
    this.commentForm = this.fb.group({
      postedBy: [null, Validators.required],
      content: [null, Validators.required],
    });
  }

  publishComment() {
    const postedBy = this.commentForm.get('postedBy')?.value;
    const content = this.commentForm.get('content')?.value;

    this.commentService.createComment(this.postId, postedBy, content).subscribe(
      (res) => {
        this.matSnackBar.open('Comment Added successfully', 'Ok');
      },
      (error) => {
        this.matSnackBar.open('Something went wrong', 'Ok');
      }
    );
  }

  getPostById() {
    this.postService.getAllPostById(this.postId).subscribe(
      (res) => {
        this.postData = res;
        console.log(res);
      },
      (err) => {
        this.matSnackBar.open('Something went wrong', 'Ok');
      }
    );
  }
  likePost() {
    this.postService.likePost(this.postId).subscribe(
      (res) => {
        this.matSnackBar.open('Post liked successfully', 'Ok');
        this.getPostById();
      },
      (error) => {
        this.matSnackBar.open('Something went wrong', 'Ok');
      }
    );
  }
}
