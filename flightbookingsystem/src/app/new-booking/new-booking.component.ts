import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-new-booking',
  templateUrl: './new-booking.component.html',
  styleUrls: ['./new-booking.component.css']
})
export class NewBookingComponent implements OnInit {
  seatsRequired: any;
  currUser:any=localStorage.getItem("id");

  constructor(private fs:FlightService) { }
  
  bookings:any[]=[];
  showForm:boolean=false;
  flightId:any;
  flight:any ={
    "flightId":""
  };
    

  flights:any[]=[];
  
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

  openForm(data:any){
    this.showForm=true;
    this.clearForm();
    this.flightId=data.flightId;
  }

  closeForm(){
    this.showForm=false;
    this.clearForm();
  }

  clearForm(){
    this.seatsRequired = null;
  }

  saveBooking(){
    this.showForm=false;
    let body:any = {
      seatsRequired:this.seatsRequired,
      passenger:{
        id:this.currUser
      },
      flight:{
          flightId:this.flightId
      }
    };
    this.fs.makeBooking(body).subscribe(
      (res)=>{
        this.details();
      }
    )
    alert("Booking is successful");
  }

  ngOnInit(): void {
    this.details();
  }

}
