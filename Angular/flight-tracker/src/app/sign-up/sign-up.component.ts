import { Component } from '@angular/core';
import { BackendService } from '../service/backend-service';
import { User } from '../interfaces/user.model';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {

  
  signupForm!: FormGroup;
  submitted = false;
  signUpSuccess = false;
  errorMessage = '';

  //Create an object to store the user sign-up data
  user: User = { 
      userId: 0,
      userName: '',
      userEmail: ''
    
  }; 

  constructor(
    private formBuilder: FormBuilder,
    private userService: BackendService,
    private router: Router
  ) {
    this.signupForm = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  onSubmit() {
    this.submitted = true;

    if (this.signupForm.invalid) {
      return;
    }

    // Clear previous messages
    this.clearMessages();

    const name = this.signupForm.controls['name'].value;
    const email = this.signupForm.controls['email'].value;

    this.user.userName=name;
    this.user.userEmail=email;
    console.log(this.user);

   
    // Call the user service to handle the sign-up request
    this.userService.addUser(this.user).subscribe(
      (response: any) => {
        // Handle successful sign-up
        console.log('Sign-up successful:', response);
        this.signUpSuccess = true;
      },
      (error) => {
        // Handle sign-up error
        console.error('Sign-up failed:', error);
        this.errorMessage = 'Sign-up failed';
      }
    );
  }

  clearMessages() {
    this.signUpSuccess = false;
    this.errorMessage = '';
  }

  goToSearchForm() {
    this.router.navigate(['/search-form']);
  }

 
}