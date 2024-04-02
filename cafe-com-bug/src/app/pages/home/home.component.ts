import { Component, DoCheck, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';
import { UserGit } from '../../models/userGit';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent implements OnInit {

  user: UserGit | undefined;

  /*
  user: User | undefined;
  constructor(private userService: UserService){
    this.user = userService.getUser();
  }
  */

  constructor( private service: UserService) {

  }

  ngOnInit(): void {
    this.getGitHubUser();
  }

  getGitHubUser() {
    this.service.getGitHubUser('bancobv').subscribe((response: UserGit) => {
      this.user = response;
    })
  }


}
