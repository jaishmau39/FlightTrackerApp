import { Component, SimpleChanges } from '@angular/core';
import { Flight } from '../interfaces/flight.model';
import { User } from '../interfaces/user.model';
import { BackendService } from '../service/backend-service';
import { OnInit, OnChanges } from '@angular/core';
import { Input } from '@angular/core';
import { Subscription } from 'rxjs';
import { CurrentUserService } from '../service/current-user.service';

@Component({
  selector: 'app-user-favorites',
  templateUrl: './user-favorites.component.html',
  styleUrls: ['./user-favorites.component.css'],
})
export class UserFavoritesComponent {
  flights: Flight[] = [];
  public isLoggedIn!: boolean;
  public currentUser!: User;

  constructor(
    private service: BackendService,
    private currentUserService: CurrentUserService
  ) {}

  getFavoriteFlights(): void {
    this.service
      .getFavoriteFlights(this.currentUser.userId)
      .subscribe((response) => (this.flights = response));
  }

  removeFlight(flightId: number ){
    this.service.removeFlight(flightId).subscribe( () => {
      alert("Flight removed");
      this.getFavoriteFlights();
    });
    
    
  }

  ngOnInit(): void {
    this.currentUserService
      .getIsLoggedIn()
      .subscribe((resp) => {
        this.isLoggedIn = resp;
      });
    this.currentUserService
      .getCurrentUser()
      .subscribe((resp) => {
        this.currentUser = resp;
        if (this.currentUser.userId != 0) {
          this.getFavoriteFlights();
        }
      });
  }
}
