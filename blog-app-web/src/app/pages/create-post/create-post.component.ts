import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';
import {PostService} from "../../service/post.service";


@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.scss'] // Correct plural property name
})
export class CreatePostComponent implements OnInit {
  postForm!: FormGroup;
  tags: string[] = [];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private snackBar: MatSnackBar,
    private postService: PostService
  ) {
  }

  ngOnInit() {
    this.postForm = this.fb.group({
      name: [null, Validators.required],
      img: [null, Validators.required],
      content: [null, [Validators.required, Validators.maxLength(500)]],
      postedBy: [null, Validators.required]
    });
  }

  add(event: any) {
    const value = (event.value || '').trim();
    if (value) {
      this.tags.push(value);
    }
    event.input.clear();
  }

  remove(tag: string) {
    const index = this.tags.indexOf(tag);
    if (index >= 0) {
      this.tags.splice(index, 1);
    }
  }

  createPost() {
    const data = this.postForm.value;
    data.tags = this.tags;
    this.postService.createNewPost(data).subscribe(res => {
      this.snackBar.open("Post created successfully", "ok", {
        duration: 3000
      });
      this.router.navigateByUrl("/");
    }, error => {
      this.snackBar.open("Something went wrong", "ok", {
        duration: 3000
      });
    })
  }
}
