import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BackendService } from '../service/backend-service';
import { Router } from '@angular/router';
import { CurrentUserService } from '../service/current-user.service';

@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})


export class LoginPageComponent {
  loginForm!: FormGroup;
  submitted = false;
  loginSuccess = false;
  errorMessage = '';

  constructor(
    private formBuilder: FormBuilder,
    private favoriteFlightService: BackendService,
    private router: Router,
    private currentUserService: CurrentUserService

  ) {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required]
    });
  }

  onSubmit() {
    this.submitted = true;

    if (this.loginForm.invalid) {
      return;
    }

    // Clear previous messages
    this.clearMessages();


    const username = this.loginForm.controls['username'].value;
    this.favoriteFlightService.getUserByName(username).subscribe(
      (user: any) => {
    
        console.log(user);
        if(user!==null){// User found, login success
          // this.loginSuccess = true;

          this.currentUserService.setIsLoggedIn(true);
          this.currentUserService.setCurrentUser(user);
          this.router.navigate(['/search-form'], {
            queryParams: { success: 'Login success!', user: JSON.stringify(user) }
          });
          
        }
          else {
            // User is null, display error message
            this.errorMessage = 'User does not exist';
          }
        
      },
      (error) => {
        // User not found, login failed
        console.error('Error:', error);
      }
    );
  }

  clearMessages() {
    this.loginSuccess = false;
    this.errorMessage = '';
  }

  goToSearchForm() {
    this.router.navigate(['/search-form']);
  }
}