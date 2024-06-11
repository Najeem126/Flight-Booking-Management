import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.css']
})
export class CancelBookingComponent implements OnInit {

  constructor(private fs:FlightService) { }
  PNR:any;
  msg:any="";

  clearform(){
    this.PNR=null;
  }

  cancellation(PNR:any){
     this.fs.cancelBooking(this.PNR).subscribe(
      (res) => {
        alert("Cancellation successful");
      },
      (error) => {
        alert("Cancellation Success");
      }
    );
    this.clearform();
  }


  ngOnInit(): void {
  }

}
