
import {Injectable, NgZone} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Audio} from "../entity/Audio.model";

@Injectable({
  providedIn: 'root'
})
export class TestimonialService
{

  constructor(private http: HttpClient)
  {
  }

  getAudioFiles(): Observable<Audio[]>
  {
    return this.http.get<Audio[]>("api/audios")
  }
}
