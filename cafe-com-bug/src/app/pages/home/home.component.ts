import { Component, DoCheck, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';
import { UserGit } from '../../models/userGit';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent {

  user: UserGit | undefined;
  usermane: string = '';

  /*
  user: User | undefined;
  constructor(private userService: UserService){
    this.user = userService.getUser();
  }
  */

  constructor( private service: UserService, private toastr: ToastrService) {

  }

  getGitHubUser() {
    if (this.usermane.length == 0) {
      this.toastr.error('O campo username é obrigatório');
      return;
    }

    this.service.getGitHubUser(this.usermane).subscribe((response: UserGit) => {
      this.user = response;
    }, (resp) => {
      if(resp.error.message == 'Not Found') {
        this.toastr.error('Usuário não encontrado');
      }
      //this.toastr.error(resp.error.message);
    });
  }

}
