import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Blog} from "../entity/blogs/Blog";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class BlogService
{
  blogs: Blog[];

  constructor(private httpClient: HttpClient)
  {
  }

  getBlogs()
  {
    return this.httpClient.get<Blog[]>("api/blogs")
      .subscribe(value => this.blogs = value);
  }
}
