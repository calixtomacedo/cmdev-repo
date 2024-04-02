import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  user: User | undefined;
  baseUrl: string = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getGitHubUser(username: string) {
    return this.http.get(this.baseUrl.concat('users/'.concat(username))).pipe(map((response: any) => {
      return response;
    }))
  }

  setUser(user: User | undefined) {
    localStorage.setItem('user', JSON.stringify(user));
    this.user = user;
  }

  getUser(){
    return this.user;
  }

}
