import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit
{

  constructor()
  {
  }

  ngOnInit(): void
  {
  }

  onActivate(event)
  {
    const scrollToTop = window.setInterval(() =>
    {
      const pos = window.pageYOffset;
      if (pos > 0)
      {
        window.scrollTo(0, pos - 20); // how far to scroll on each step
      } else
      {
        window.clearInterval(scrollToTop);
      }
    }, 16);
  }
}
