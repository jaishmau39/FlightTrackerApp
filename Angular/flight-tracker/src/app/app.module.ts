import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { SearchFormComponent } from './search-form/search-form.component';
import { UserFavoritesComponent } from './user-favorites/user-favorites.component';

import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { BackendService } from './service/backend-service';
import { FlightDetailService } from './service/flight-detail.service';
import { LoginPageComponent } from './login-page/login-page.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';

@NgModule({
  declarations: [
    AppComponent,
    SearchFormComponent,
    UserFavoritesComponent,
    FlightDetailsComponent,
    LoginPageComponent,
    SignUpComponent,
    
  ],
  imports: [
    LeafletModule,
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [BackendService, FlightDetailService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
