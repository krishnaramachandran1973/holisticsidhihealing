import {Component, OnInit} from '@angular/core';
import {NgwWowService} from "ngx-wow";
import {Router} from "@angular/router";

@Component({
  selector: 'app-consult',
  templateUrl: './consult.component.html',
  styleUrls: ['./consult.component.css']
})
export class ConsultComponent implements OnInit
{

  constructor(private wowService: NgwWowService, private router: Router)
  {
  }

  ngOnInit(): void
  {
    this.wowService.init();
  }

  gotoBooking(id: number)
  {
    this.router.navigate(['/booking', id]);
  }

}
