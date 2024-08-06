import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePostComponent } from './pages/create-post/create-post.component';
import { ViewAllComponent } from './pages/view-all/view-all.component';
import { ViewPostComponent } from './pages/view-post/view-post.component';
import { SearchByNameComponent } from './pages/search-by-name/search-by-name.component';

const routes: Routes = [
  {
    path: 'create-post',
    component: CreatePostComponent,
    pathMatch: 'full',
  },
  {
    path: 'view-all',
    component: ViewAllComponent,
    pathMatch: 'full',
  },
  {
    path: 'view-post/:id',
    component: ViewPostComponent,
    pathMatch: 'full',
  },
  {
    path: 'search-by-name',
    component: SearchByNameComponent,
    pathMatch: 'full',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
