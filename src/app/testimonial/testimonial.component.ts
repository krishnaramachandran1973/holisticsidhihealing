import {Component, HostListener, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {Audio} from "../entity/Audio.model";
import {TestimonialService} from "../services/testimonial.service";
import {NgwWowService} from "ngx-wow";

@Component({
  selector: 'app-testimonial',
  templateUrl: './testimonial.component.html',
  styleUrls: ['./testimonial.component.css']
})
export class TestimonialComponent implements OnInit
{
  fileNames: Array<Audio> = [];

  constructor(private testimonialService: TestimonialService, private wowService: NgwWowService)
  {
  }


  ngOnInit(): void
  {
    this.wowService.init();
    this.testimonialService.getAudioFiles()
      .subscribe(data => this.fileNames = data);
  }

   @HostListener('contextmenu', ['$event'])
   onRightClick(event)
   {
     event.preventDefault();
   }

}
