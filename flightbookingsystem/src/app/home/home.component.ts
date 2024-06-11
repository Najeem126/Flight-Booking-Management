import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  currentUser=localStorage.getItem("userName");
  constructor(private router: Router, private fs:FlightService) {
  }
  // id:any=localStorage.getItem("id");
  // data:any[]=[]
  // userInfo:any;

  allFlights() {
    this.router.navigate(['/allflights']);
}

  yourBooking() {
    this.router.navigate(['/yourbooking']);
}

newBooking(){
  this.router.navigate(['/newbooking']);
}

cancelBooking(){
  this.router.navigate(['/cancelbooking']);
}

// userDetails(){
//   const userId = localStorage.getItem('id');
//   if (userId) {
//     // Make an HTTP request to fetch the user information based on the user ID
//     this.fs.fetchUserById(userId).subscribe(
//       (response) => {
//         // Store the user information in the userInfo object
//         this.userInfo = response;
//       },
//       (error) => {
//         console.error('Error fetching user information:', error);
//       }
//     );
//   }
// }



  ngOnInit(): void {
    // console.log(this.userInfo.id)
    // console.groupCollapsed(this.userInfo.passenger.userName)
  }

}
