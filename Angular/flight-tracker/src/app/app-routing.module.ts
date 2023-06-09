import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';;
import { SearchFormComponent } from './search-form/search-form.component';
import { FlightDetailsComponent } from './flight-details/flight-details.component';
import { UserFavoritesComponent } from './user-favorites/user-favorites.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { SignUpComponent } from './sign-up/sign-up.component';

const routes: Routes = [

  {path: 'search-form', component: SearchFormComponent},
  {path: 'user-favorites', component: UserFavoritesComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'sign-up', component: SignUpComponent},
  {path: 'flight-details/:flightNum', component: FlightDetailsComponent},
  { path: '', redirectTo: '/search-form', pathMatch: 'full' },


]



@NgModule({
  imports: [RouterModule.forRoot(routes,{ useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {

  
 }
