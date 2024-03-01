import { Component, DoCheck } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
//export class HomeComponent implements OnDestroy, DoCheck {
  export class HomeComponent implements DoCheck {
  num: number = 1

  ngDoCheck(): void {
    console.log('Uma mudança foi feita');
  }

  /*
  ngOnDestroy(): void {
    console.log('Componente Home destruído');
  }
  */

  public adicionaUm(){
    this.num++;
  }

}
