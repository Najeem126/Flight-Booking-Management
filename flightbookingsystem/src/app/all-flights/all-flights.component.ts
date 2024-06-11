import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-all-flights',
  templateUrl: './all-flights.component.html',
  styleUrls: ['./all-flights.component.css']
})
export class AllFlightsComponent implements OnInit {

  constructor(private fs:FlightService) { }
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

  ngOnInit(): void {
    this.details();
  }

}
