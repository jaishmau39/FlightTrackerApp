export interface Flight {
    flight: {
      flightId: number;
      flightNumber: string;
      userId: number;
      airline: string;
      departure: string;
      arrival: string;
      flightStatus: string;
      departureTime: string;
      arrivalTime: string;
      arrivalTimeEst: string;
    };
    arrival: {
      airportId: number;
      airportCode: string;
      city: string;
      country: string;
      timezone: string;
    };
    departure: {
      airportId: number;
      airportCode: string;
      city: string;
      country: string;
      timezone: string;
    };
    airline: {
      airlineId: number;
      airlineName: string;
      airlineCode: string;
    };
  }