import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-manage-bookings',
  templateUrl: './manage-bookings.component.html',
  styleUrls: ['./manage-bookings.component.css']
})
export class ManageBookingsComponent implements OnInit {

  constructor(private fs:FlightService) { }

  bookings:any[]=[];

  bookingId:any;
  pnr:any;
  seatsRequired:any;
  flight:any ={
    "flightName":""
  };
  passenger:any ={
    "name":""
  };

  details(){
    this.fs.fetchallBookings().subscribe(
       (data:any)=>{
        this.bookings=data;
        console.log(data);
      },
      (err)=>{
        console.log("error");
      }
    )
    }

  deleteBooking(id:any){
    this.fs.deleteBookingId(id).subscribe(
      (res)=>{
        this.details();
      }
    )
  }
  ngOnInit(): void {
    this.details();
  }

}
