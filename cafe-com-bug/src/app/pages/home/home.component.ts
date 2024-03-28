import { Component, DoCheck } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})

export class HomeComponent {

  user: User | undefined;

  constructor(private userService: UserService){
    this.user = userService.getUser();
  }

}
