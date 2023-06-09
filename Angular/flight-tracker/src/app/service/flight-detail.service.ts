import { Injectable } from '@angular/core';
import { Flight } from '../interfaces/flight.model';

@Injectable({
  providedIn: 'root'
})
export class FlightDetailService {

  public flight!: Flight;

  setFlight(flight: Flight){
    this.flight = flight;
  }

  getFlight() : Flight {
      return this.flight;
  }

  constructor() {
  }
}
