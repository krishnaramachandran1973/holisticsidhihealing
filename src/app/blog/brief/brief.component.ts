import { Component, OnInit } from '@angular/core';
import {Blog} from "../../entity/blogs/Blog";
import {BlogService} from "../../services/blog.service";
import {NgwWowService} from "ngx-wow";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-brief',
  templateUrl: './brief.component.html',
  styleUrls: ['./brief.component.css']
})
export class BriefComponent implements OnInit {

  constructor(public blogService: BlogService, private wowService: NgwWowService, private router: Router, private route: ActivatedRoute)
  {
    this.blogService.getBlogs();
  }

  ngOnInit(): void
  {
    this.wowService.init();
  }

  gotToDetails(id: number)
  {
    this.router.navigate(['./', id], {relativeTo: this.route});
  }
}
