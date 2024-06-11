import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-manage-routes',
  templateUrl: './manage-routes.component.html',
  styleUrls: ['./manage-routes.component.css']
})
export class ManageRoutesComponent implements OnInit {

  constructor(private fs:FlightService) { }
  routes:any[]=[];
  formHeader:any;
  showForm:boolean=false;

  routeId:any;
  source:any;
  destination:any;
  // flight:any ={
  //   "flightId":""
  // };

  details(){
    this.fs.fetchRoutes().subscribe(
      (data:any)=>{
        this.routes=data;
      },
      (err)=>{
        console.log("error");
      }
    )
  }

  deleteRoute(id:any){
    this.fs.deleteRoute(id).subscribe(
      (res)=>{
        this.details();
      }
    )
  }

  openForm(data:any=null){
    this.showForm=true;
    this.clearForm();
    if(data){
      this.routeId = data.routeId;
      this.source = data.source;
      this.destination = data.destination;
      // this.flight.flightId=data.flight.flightId;
      this.formHeader="Edit Route Details";
    }
    else{
      this.routeId=null;
      this.formHeader="Add Route";
    }
  }

  closeForm(){
    this.showForm=false;
    this.clearForm();
  }

  clearForm(){
    this.routeId = null;
    this.source = null;
    this.destination = null;
    // this.flight.flightId=null;
  }

  saveRoute(){
    this.showForm=false;
    let body:any = {
      // routeId:this.routeId,
      source:this.source,
      destination:this.destination,
      // flight:{
      //   flightId:this.flight.flightId
      // }
    };
    if(this.routeId){
      body['routeId'] = this.routeId;
      this.fs.putRoute(body).subscribe(
        (res)=>{
          this.details();
        }
      )
    }
    else{
      this.fs.postRoute(body).subscribe(
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
