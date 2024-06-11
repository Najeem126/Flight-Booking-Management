import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FlightService {

  

  constructor(private http:HttpClient) { }

  // fetchFlights():Observable<any[]>{

  //   return this.http.get<any[]>("http://localhost:8081/Flight/all")
  // }

  fetchFlights(){
    return this.http.get("http://localhost:8081/Flight/all");
  }
  // postUser(body:any) {
  //   return this.http.post("http://localhost:8081/passenger/add",body);
  // }
  postUser(body:any) {
    return this.http.post("http://localhost:8081/register",body);
  }
  // UserExists(Credentials:any){
  //   return this.http.post("http://localhost:8081/passenger/login",Credentials);
  // }
  UserExists(Credentials:any){
    return this.http.post("http://localhost:8081/login",Credentials);
  }
  deleteFlight(id:any){
    return this.http.delete("http://localhost:8081/Flight/delete/"+id)
  }
  postFlight(body:any){
    return this.http.post("http://localhost:8081/Flight/add",body)
  }
  putFlight(body:any){
    return this.http.put("http://localhost:8081/Flight/update",body)
  }
  fetchRoutes(){
    return this.http.get("http://localhost:8081/route/all");
  }
  deleteRoute(id:any){
    return this.http.delete("http://localhost:8081/route/delete/"+id)
  }
  putRoute(body:any){
    return this.http.put("http://localhost:8081/route/update",body)
  }
  postRoute(body:any){
    return this.http.post("http://localhost:8081/route/add",body)
  }
  fetchUsers(){
    return this.http.get("http://localhost:8081/passenger/all");
  }
  deleteUser(id:any){
    return this.http.delete("http://localhost:8081/passenger/delete/"+id)
  }
  putUser(body:any){
    return this.http.put("http://localhost:8081/passenger/update/"+body['id'],body)
  }

  fetchBookingsId(){
    return this.http.get("http://localhost:8081/booking/pass/"+localStorage.getItem("id"))
  }

  fetchallBookings(){
    return this.http.get("http://localhost:8081/booking/all");
  }

  makeBooking(body:any){
    return this.http.post("http://localhost:8081/booking/add",body);
  }
  cancelBooking(PNR:any){
    return this.http.delete("http://localhost:8081/booking/cancel/"+PNR);
  }

  deleteBookingId(id:any){
    return this.http.delete("http://localhost:8081/booking/delete/"+id)
  }
  fetchUserById(id:any){
    return this.http.get("http://localhost:8081/passenger/"+id)
  }
}
