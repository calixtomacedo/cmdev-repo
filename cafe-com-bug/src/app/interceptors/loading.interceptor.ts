import { HttpEvent, HttpHandler, HttpInterceptor, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OcupadoService } from '../services/ocupado.service';
import { Observable, delay, finalize } from 'rxjs';

@Injectable()
export class LoadingInterceptor implements HttpInterceptor {
  
  constructor(private ocupadoService: OcupadoService) {}

  intercept(req: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const start = Date.now();
    this.ocupadoService.ocupado();
    return next.handle(req).pipe(
      delay(500),
      finalize(() => {
        this.ocupadoService.desocupado();
      })
    );
  }

}
