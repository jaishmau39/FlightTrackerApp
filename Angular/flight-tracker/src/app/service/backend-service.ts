import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Geography } from '../interfaces/geography.model';
import { Flight } from '../interfaces/flight.model';
import { User } from '../interfaces/user.model';

@Injectable({ providedIn: 'root' })
export class BackendService {
  private exernalUrl = 'http://localhost:8080/external';
  private serverURL = 'http://localhost:8080/server';

  constructor(private http: HttpClient) {}

  getFlights(departure: string, arrival: string): Observable<Flight[]> {
    const url = `${this.exernalUrl}/schedules?dep=${departure}&arr=${arrival}`;
    return this.http.get<Flight[]>(url);
  }


  getGeography(flightNumber: string): Observable<Geography> {
    const url = `${this.exernalUrl}/geography?flight_iata=${flightNumber}`;
    return this.http.get<Geography>(url);
  }

  addFavoriteFlight(flight: Flight): Observable<Flight> {
    const favoriteFlight = {
      // flightId: flight.flight.flightId,
      flightNumber: flight.flight.flightNumber,
      userId: flight.flight.userId,
      airline: flight.flight.airline,
      departure: flight.flight.departure,
      arrival: flight.flight.arrival,
      flightStatus: flight.flight.flightStatus,
      departureTime: flight.flight.departureTime,
      arrivalTime: flight.flight.arrivalTime,
      arrivalTimeEst: flight.flight.arrivalTimeEst,
      //userId: 1
    };

    const url = `${this.serverURL}/flights`;
    return this.http.post<Flight>(url, favoriteFlight);
  }

  removeFlight(flightId: number ) {
    const url = `${this.serverURL}/flight/${flightId}`
    return this.http.delete(url);
  }

  getUserByName(name: string): Observable<User> {
    const url = `${this.serverURL}/users/${name}`;
    return this.http.get<User>(url);
  }

  getFavoriteFlights(userId: number): Observable<Flight[]> {
    const url = `${this.serverURL}/flights/${userId}`;
    return this.http.get<Flight[]>(url);
  }

  addUser(user: User): Observable<User> {
    const newUser = {
      
        userName: user.userName,
        userEmail: user.userEmail
      
    };

    //const newUser = user.user;

  const url = `${this.serverURL}/users`;
  return this.http.post<User>(url, newUser);
}



}
