import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

     c:string="";
     userId:any;
     email:any;
     password:any;
     user:any;
     id: any;
     showAlert: boolean = false; // Add this line
   
    constructor(private ms: FlightService, private router: Router){}
    ngOnInit(): void {
     localStorage.clear();
    }
    
  login(){
    if(this.email==="admin@gmail.com" && this.password==="admin@123"){
      localStorage.setItem("role","admin");
      this.router.navigate(["/admin"]);
    }
    else{
      this.ms.UserExists({"email":this.email,"password":this.password}).subscribe(
        (data:any)=>{
          if(data.message==='User login was successful'){
            this.userId=data.passenger.id;
            this.id=data.passenger.id;
            this.user=data.passenger.userName;
            localStorage.setItem('token',data.token);
            localStorage.setItem("userName",this.user);
            localStorage.setItem("id",data.passenger.id);
            localStorage.setItem("role",data.passenger.role);
            this.router.navigate(["/home"]);
            this.showAlert = false; // Add this line
          }
          else{
            this.showAlert = true; // Add this line
          }
        }
      )
    }
  }
}