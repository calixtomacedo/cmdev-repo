import { Component } from '@angular/core';
import { User } from '../../models/user';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent {

  /*
  users: String[] = [
    'Calixto Macedo',
    'Rosimeire Santos',
    'Adrielly Thamyres',
    'Davi Lucca Macedo',
    'Izabel Macedo'
  ]
  */

  users: User[] = [
    {
    nome: 'Calixto Macedo',
    idade: 52
    },
    {
    nome: 'Rosimeire Santos',
    idade: 38
    },
    {
    nome: 'Adrielly Thamyres',
    idade: 22
    },
    {
    nome: 'Davi Lucca Macedo',
    idade: 1
    },
    {
    nome: 'Izabel Macedo',
    idade: 79
    },
  ];

}
