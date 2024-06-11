import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { NewBookingComponent } from './new-booking/new-booking.component';
import { CancelBookingComponent } from './cancel-booking/cancel-booking.component';
import { YourBookingComponent } from './your-booking/your-booking.component';
import { AllFlightsComponent } from './all-flights/all-flights.component';
import { RegisterComponent } from './register/register.component';
import { LogoutComponent } from './logout/logout.component';
import { HeaderComponent } from './header/header.component';
import { ContactComponent } from './contact/contact.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminComponent } from './admin/admin.component';
import { ManageFlightsComponent } from './manage-flights/manage-flights.component';
import { ManageRoutesComponent } from './manage-routes/manage-routes.component';
import { ManageUsersComponent } from './manage-users/manage-users.component';
import { ManageBookingsComponent } from './manage-bookings/manage-bookings.component';
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import { FlightService } from './flight.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AboutComponent,
    HomeComponent,
    NewBookingComponent,
    CancelBookingComponent,
    YourBookingComponent,
    AllFlightsComponent,
    RegisterComponent,
    LogoutComponent,
    HeaderComponent,
    ContactComponent,
    NotfoundComponent,
    AdminComponent,
    ManageFlightsComponent,
    ManageRoutesComponent,
    ManageUsersComponent,
    ManageBookingsComponent,
    AdminHeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [FlightService],
  bootstrap: [AppComponent]
})
export class AppModule { }
