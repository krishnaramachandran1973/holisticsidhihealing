import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {BlogService} from "../../services/blog.service";
import {Blog} from "../../entity/blogs/Blog";

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit
{
  id: number
  blog: Blog;

  constructor(private route: ActivatedRoute, private blogService: BlogService)
  {
    route.params.subscribe(params =>
    {
      this.id = params['id'];
      this.blog = this.blogService.blogs.find(blog => blog.id == this.id)
    });
  }

  ngOnInit(): void
  {

  }

}
