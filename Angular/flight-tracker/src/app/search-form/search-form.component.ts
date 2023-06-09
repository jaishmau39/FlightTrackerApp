import { Component } from '@angular/core';
import { FormControl,FormGroup,Validators,FormBuilder } from '@angular/forms';
import { BackendService } from '../service/backend-service';
import { Flight } from '../interfaces/flight.model';
import { FlightDetailService } from '../service/flight-detail.service';
import { Router } from '@angular/router';
import { User } from '../interfaces/user.model';
import { CurrentUserService } from '../service/current-user.service';

import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent {

//Form variables
registerForm:any = FormGroup;
submitted = false;
flights: Flight[] = [];
successMessage: string="";

ffromSuggestions: string[] = [];
ftoSuggestions: string[] = [];

public isLoggedIn!: boolean;
public currentUser!: User;


constructor( 
  private formBuilder: FormBuilder,
  private route: ActivatedRoute,
  private flightDetailService: FlightDetailService,
  private backendService: BackendService,
  private router: Router,
  private currentUserService: CurrentUserService){}
//Add user form actions
get f() { return this.registerForm.controls; }

onFFromInput(event: any) {
  const value = event.target.value;

  this.ffromSuggestions = this.generateSuggestions(value);
}

onFToInput(event: any) {
  const value = event.target.value;

  this.ftoSuggestions = this.generateSuggestions(value);
}

selectFFromSuggestion(suggestion: string) {
  const abbreviatedValue = suggestion.substring(0, 3).toUpperCase();
  this.registerForm.controls['ffrom'].setValue(abbreviatedValue);
  this.ffromSuggestions = [];
}

selectFToSuggestion(suggestion: string) {
  const abbreviatedValue = suggestion.substring(0, 3).toUpperCase();
  this.registerForm.controls['fto'].setValue(abbreviatedValue);
  this.ftoSuggestions = [];
}

private generateSuggestions(value: string): string[] {

  const predefinedSuggestions = ['YYZ - Toronto Pearson International Airport', 'YVR - Vancouver International Airport', "ORD - O'Hare International Airport",'YUL - Montréal-Pierre Elliott Trudeau International Airport'];
  return predefinedSuggestions.filter(suggestion => suggestion.toLowerCase().includes(value.toLowerCase()));
}




onSubmit() {
  
  this.submitted = true;
  // stop here if form is invalid
  if (this.registerForm.invalid) {
      return;
  }

    const departure = this.registerForm.value.ffrom;
    const arrival = this.registerForm.value.fto;

    this.backendService.getFlights(departure, arrival).subscribe(
      (response) => {
        this.flights = response;
      });
 
}


addToFavorites(flight: Flight) {
  const userId = this.getUserIdFromUserObject();
  flight.flight.userId = userId;
  if (userId !== 0) {
    this.backendService.addFavoriteFlight(flight).subscribe(
      () => {
        console.log('Flight added to favorites successfully');
        console.log(userId);
        // Assigning user ID to flight's user ID property
        //flight.flight.userId = userId;
        console.log(flight.flight.userId);

        alert('Flight added to favorites successfully.');

      },
      (error: any) => {
        console.error('Error:', error);
        
      }

    );
  } else {
    alert('Please log in to add the flight to your favorites.');
    console.log('Unable to add flight to favorites. User hasnot logged In.');
  }
    
}

private getUserIdFromUserObject(): number {
  // Retrieve the user object from the route query params

  return this.currentUser.userId;
}

  ngOnInit() {
    //Add form validations
     this.registerForm = this.formBuilder.group({
      ffrom: ['', [Validators.required]],
      fto: ['', [Validators.required]],
      
      });

      

      // this.route.queryParams.subscribe(params => {
      //   this.successMessage = params['success'];
      //   //const user = JSON.parse(params['user']);
      //   const user = params['user'] ? JSON.parse(params['user']) : null;
    
        
      //   console.log(this.successMessage); // Print the success message in the console
      //   console.log(user); // Print the user data in the console
    
        if (this.successMessage) {
          // Clear success message after 3 seconds
          setTimeout(() => {
            this.successMessage = '';
          }, 3000);
        }

        
      // });

      this.currentUserService
      .getIsLoggedIn()
      .subscribe((resp) => {
        this.isLoggedIn = resp;
      });
    this.currentUserService
      .getCurrentUser()
      .subscribe((resp) => {
        this.currentUser = resp;
      });


  }
  showFlightDetail(flight: Flight){
    this.flightDetailService.setFlight(flight);
    this.router.navigate([`/flight-details/${flight.flight.flightNumber}`])
  }

}