import { Component } from '@angular/core';
import { FormControl, FormGroup, NgForm , Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { FlightService } from '../flight.service';
 
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  userName: any;
  email: any;
  address: any;
  password: any;
  gender:any;
  birthDate:any;
  mobileNo:any;
  age:any;
  errorMessage: any;
  phnoPattern: RegExp = /^[789]\d{9}$/;
 
  constructor(private fs: FlightService, private router: Router) {}
 
 
  registerUser(){
    if(this.email.endsWith("@gmail.com") && this.password.length >= 6 && this.phnoPattern.test(this.mobileNo)){
      let body={
        userName: this.userName,
        email: this.email,
        address: this.address,
        password: this.password,
        gender:this.gender,
        birthDate:this.birthDate,
        mobileNo:this.mobileNo,
        age:this.age
      }
      this.fs.postUser(body).subscribe((res)=>{
        console.log(res);
          this.router.navigate(["/login"]);
          alert("Registration successful please login");
        },
        (err) => {
          alert("Mail already exists");
        }
      )
    }else {
      alert("Invalid email or password or phone number format");
    }
   }
 
   submitForm(form: NgForm){
    if(form.valid){
      this.registerUser();
    }
   }
 }