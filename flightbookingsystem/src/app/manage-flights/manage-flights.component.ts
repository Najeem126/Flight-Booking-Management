import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-manage-flights',
  templateUrl: './manage-flights.component.html',
  styleUrls: ['./manage-flights.component.css']
})
export class ManageFlightsComponent implements OnInit {

  constructor(private fs:FlightService) { }
  
  fli=true;
  flights:any[]=[];
  formHeader:any;
  showForm:boolean=false;

  flightId:any;
  flightName:any;
  flightClass:any;
  capacity:any;
  date:any;
  timing:any;
  route:any ={
    "routeId":""
  };

  details(){
    this.fs.fetchFlights().subscribe(
      (data:any)=>{
        this.flights=data;
      },
      (err)=>{
        console.log("error");
      }
    )

  }

  deleteFlight(id:any){
    this.fs.deleteFlight(id).subscribe(
      (res)=>{
        this.details();
      }
    )
  }

  openForm(data:any=null){
    this.showForm=true;
    this.clearForm();
    if(data){
      this.flightName = data.flightName;
      this.flightClass = data.flightClass;
      this.capacity = data.capacity;
      this.route.routeId=data.route.routeId;
      this.date = data.date;
      this.timing = data.timing;
      this.flightId = data.flightId;
      this.formHeader="Edit Flight Details";
    }
    else{
      this.flightId=null;
      this.formHeader="Add Flight";
    }
  }
  closeForm(){
    this.showForm=false;
    this.clearForm();
  }

  clearForm(){
    this.flightName = null;
    this.flightClass = null;
    this.capacity = null;
    this.route.routeId=null;
    this.route.source=null;
    this.route.destination=null;
    this.date = null;
    this.timing = null;
  }

  saveFlight(){
    this.showForm=false;
    let body:any = {
      flightId:this.flightId,
      flightName:this.flightName,
      flightClass: this.flightClass,
      capacity:this.capacity,
      date:this.date,
      timing:this.timing,
      route:{
        routeId:this.route.routeId
      }
    }

    if(this.flightId){
      body['flightId'] = this.flightId;
      this.fs.putFlight(body).subscribe(
        (res)=>{
          this.details();
        }
      )
    }
    else{
      this.fs.postFlight(body).subscribe(
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