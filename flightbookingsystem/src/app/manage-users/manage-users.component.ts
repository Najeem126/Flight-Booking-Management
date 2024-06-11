import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-manage-users',
  templateUrl: './manage-users.component.html',
  styleUrls: ['./manage-users.component.css']
})
export class ManageUsersComponent implements OnInit {

  constructor(private fs:FlightService) { }

  users:any[]=[];
  formHeader:any;
  showForm:boolean=false;

  id:any
  email:any
  userName:any
  password:any
  address:any
  birthDate:any
  age:any
  gender:any
  mobileNo:any

  details(){
    this.fs.fetchUsers().subscribe(
      (data:any)=>{
        this.users=data;
      },
      (err)=>{
        console.log("error");
      }
    )
  }

  deleteUser(id:any){
    this.fs.deleteUser(id).subscribe(
      (res)=>{
        this.details();
      }
    )
  }

  openForm(data:any=null){
    this.showForm=true;
    this.clearForm();
    if(data){
      this.id=data.id;
      this.email=data.email;
      this.userName=data.userName;
      this.password=data.password;
      this.address= data.address;
      this.birthDate=data.birthDate;
      this.age=data.age;
      this.gender=data.gender;
      this.mobileNo=data.mobileNo;
      this.formHeader="Edit User Details";
    }
    else{
      this.id=null;
      this.formHeader="Add User";
    }
  }

  closeForm(){
    this.showForm=false;
    this.clearForm();
  }

  clearForm(){
    this.id=null;
    this.email=null;
    this.userName=null;
    this.password=null;
    this.address= null;
    this.birthDate=null;
    this.age=null;
    this.gender=null;
    this.mobileNo=null;
  }

  saveUser(){
    this.showForm=false;
    let body:any = {
      id:this.id,
      email:this.email,
      userName:this.userName,
      password:this.password,
      address:this.address,
      birthDate:this.birthDate,
      age:this.age,
      gender:this.gender,
      mobileNo:this.mobileNo
    };

    if(this.id){
      body['id'] = this.id;
      this.fs.putUser(body).subscribe(
        (res)=>{
          this.details();
        }
      )
    }
    else{
      this.fs.postUser(body).subscribe(
        (res)=>{
          this.details();
        }
      )
    }
  }

  ngOnInit(): void {
    this.details();
  }

}
