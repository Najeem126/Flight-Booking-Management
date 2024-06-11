import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot,CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService2 implements CanActivate {

  constructor(private router:Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    let loggedIn;
    let role = localStorage.getItem('role');
    if(role=="admin"){
       return true;
    }
    // else if(role==='user'){
    //   loggedIn = localStorage.getItem('id');
    //   return true;
    // }
    else{
      alert("Unauthorized access")
      this.router.navigate(['/login']);
      return false;
    }
  }
 
}
