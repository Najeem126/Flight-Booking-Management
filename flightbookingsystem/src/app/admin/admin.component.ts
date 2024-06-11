import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private router: Router) { }
  manageFlights() {
    this.router.navigate(['/manage-flights']);
}

  manageBookings() {
    this.router.navigate(['/manage-bookings']);
}

manageUsers(){
  this.router.navigate(['/manage-users']);
}

manageRoutes(){
  this.router.navigate(['/manage-routes']);
}
  ngOnInit(): void {
  }

}
