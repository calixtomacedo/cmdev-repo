import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent implements OnInit {

  user: User | undefined;
  userForm: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.iniciarForm();
  }

  iniciarForm() {
    this.userForm = this.formBuilder.group({
      nome: ['', [Validators.required, Validators.maxLength(250)]],
      idade: ['', [Validators.required, Validators.min(1), Validators.max(110)]],
    });
  }

  submitForm() {
    if(this.userForm.valid){
      this.users.push(this.userForm.value);
      this.userForm.reset();
    }
  }

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
    }
  ];

  userSelecionado(user: User) {
    this.user = user;
  }


}
