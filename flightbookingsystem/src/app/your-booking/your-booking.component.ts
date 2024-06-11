import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-your-booking',
  templateUrl: './your-booking.component.html',
  styleUrls: ['./your-booking.component.css']
})
export class YourBookingComponent implements OnInit {

  constructor(private fs:FlightService) { }

  bookings:any[]=[];
 books:any[]=[];
  // bookingId:any;
  // pnr:any;
  // seatsRequired:any;
  // seatNumbers:any;
  // passenger:any={
  //   "id":""
  // };
  // flight:any ={
  //   "flightId":""
  // };

  currId=localStorage.getItem("id");

  fetchBookings(){
    this.fs.fetchallBookings().subscribe(
  
      (data:any)=>{
        this.bookings=data;
        console.log(data);

        //iterating for getting user specific data
        for(const b of this.bookings){
          if(b.passenger.id==this.currId){
            this.books.push(b);
          }
        }
      },
      (err)=>{
        console.log("error");
      }
    )
  }

  ngOnInit(): void {
    this.fetchBookings();
  }

}
