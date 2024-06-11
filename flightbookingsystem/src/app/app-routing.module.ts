import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { AdminComponent } from './admin/admin.component';
import { AdminauthService } from './adminauth.service';
import { AllFlightsComponent } from './all-flights/all-flights.component';
import { AuthService2 } from './auth.service';
import { UserAuthService } from './user-auth.service';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { ContactComponent } from './contact/contact.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ManageBookingsComponent } from './manage-bookings/manage-bookings.component';
import { ManageFlightsComponent } from './manage-flights/manage-flights.component';
import { ManageRoutesComponent } from './manage-routes/manage-routes.component';
import { ManageUsersComponent } from './manage-users/manage-users.component';
import { NewBookingComponent } from './new-booking/new-booking.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { RegisterComponent } from './register/register.component';
import { YourBookingComponent } from './your-booking/your-booking.component';

const routes: Routes = [
  {path:'', component:LoginComponent},
  {path:'home', component:HomeComponent,canActivate:[UserAuthService,UserAuthService]},
  {path:'register', component:RegisterComponent ,},
  {path:'login', component:LoginComponent},
  {path:'home', component:HomeComponent,canActivate:[UserAuthService,UserAuthService]},
  {path:'allflights',component:AllFlightsComponent,canActivate:[UserAuthService,UserAuthService]},
  {path:'yourbooking',component:YourBookingComponent,canActivate:[UserAuthService,UserAuthService]},
  {path:'cancelbooking',component:CancelBookingComponent,canActivate:[UserAuthService,UserAuthService]},
  {path:'newbooking', component:NewBookingComponent,canActivate:[UserAuthService,UserAuthService]},
  {path:'contact',component:ContactComponent,canActivate:[UserAuthService,UserAuthService]},
  {path:'home',component:HomeComponent,canActivate:[UserAuthService,UserAuthService]},
  {path:'about',component:AboutComponent},
  {path:'admin',component:AdminComponent,canActivate:[AuthService2,AdminauthService]},
  {path:'manage-flights',component:ManageFlightsComponent,canActivate:[AuthService2,AdminauthService]},
  {path:'manage-bookings', component:ManageBookingsComponent,canActivate:[AuthService2,AdminauthService]},
  {path:'manage-users', component:ManageUsersComponent,canActivate:[AuthService2,AdminauthService]},
  {path:'manage-routes', component:ManageRoutesComponent,canActivate:[AuthService2,AdminauthService]},



  
  {path:'**', component:NotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
