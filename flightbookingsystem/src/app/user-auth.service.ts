import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})

export class UserAuthService {
  constructor(private route:Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):boolean {
    let role = localStorage.getItem('role');
    if(localStorage.getItem('token') !== null){
      // if(role==='USER'){
        return true;
      // }else{
      //   this.route.navigate(['/login']);
      //   alert("UnAuthorized Access");
      //   return false;
      // }
    }
    else{
      this.route.navigate(['/login']);
        alert("UnAuthorized Access");
        return false;
    }
  }

}
