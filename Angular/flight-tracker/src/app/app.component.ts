import { Component, OnInit } from '@angular/core';
import { CurrentUserService } from './service/current-user.service';
import { User } from './interfaces/user.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'flight-tracker';

  public isLoggedIn!: boolean;
  public currentUser!: User;
  public currentUserSubscription!: Subscription;

  constructor(private currentUserService: CurrentUserService){ }

  ngOnInit(): void {
    this.currentUserSubscription = this.currentUserService.getIsLoggedIn().subscribe( resp => this.isLoggedIn = resp);
    this.currentUserSubscription = this.currentUserService.getCurrentUser().subscribe( resp => this.currentUser = resp);

  }




}
