import { Injectable } from '@angular/core';
import { User } from '../interfaces/user.model';
import { BehaviorSubject, Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  private isLoggedIn = new BehaviorSubject<boolean>(false);
  private currentUser = new BehaviorSubject<User>({userId: 0, userName: "", userEmail: ""});


  constructor(){
  }

  getIsLoggedIn() {
    return this.isLoggedIn;
  }

  setIsLoggedIn(status : boolean) {
    this.isLoggedIn.next(status);    
  }

  getCurrentUser() {
    return this.currentUser;
  }

  setCurrentUser(user: User){
    this.currentUser.next(user);
  }
}
