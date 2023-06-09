import { Component, OnInit, AfterContentInit } from '@angular/core';
import { Flight } from '../interfaces/flight.model';
import { User } from '../interfaces/user.model';
import { Geography } from '../interfaces/geography.model';
import { BackendService } from '../service/backend-service';
import { ActivatedRoute } from '@angular/router';
import { FlightDetailService } from '../service/flight-detail.service';
import { latLng, tileLayer, marker, icon } from 'leaflet';
import { CurrentUserService } from '../service/current-user.service';


@Component({
  selector: 'app-flight-details',
  templateUrl: './flight-details.component.html',
  styleUrls: ['./flight-details.component.css'],
})
export class FlightDetailsComponent {
  flight: Flight;
  user!: User;
  geography!: Geography;

  direction: string = '';
  delay: string = '';

  options = {};
  baseMap = {};
  flightMarker = {};
  layersControl = {};

  constructor(
    private route: ActivatedRoute,
    private backendService: BackendService,
    private flightDetailService: FlightDetailService,
    private currentUserService: CurrentUserService
  ) {
    this.flight = flightDetailService.getFlight();
    this.setDelay(this.flight.flight.arrivalTime, this.flight.flight.arrivalTimeEst);
  }

  ngOnInit(): void {

    this.getGeography();

  }

  loadMap(): void {
    this.baseMap = tileLayer(
      'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
      {
        detectRetina: true,
        attribution:
          '&amp;copy; &lt;a href="https://www.openstreetmap.org/copyright"&gt;OpenStreetMap&lt;/a&gt; contributors',
      }
    );

    this.flightMarker = marker([this.geography.lat, this.geography.lng], {
      icon: icon({
        iconSize: [25, 41],
        iconAnchor: [13, 41],
        iconUrl: 'leaflet/marker-icon.png',
        shadowUrl: 'leaflet/marker-shadow.png',
      }),
    });

    this.layersControl = {
      baseLayers: { 'Street Maps': this.baseMap },
      overlays: { 'Current Location': this.flightMarker },
    };

    this.options = {
      layers: [this.baseMap, this.flightMarker],
      zoom: 7,
      center: latLng([this.geography.lat, this.geography.lng]),
    };
  }

  getGeography(): void {
    this.backendService
      .getGeography(this.route.snapshot.paramMap.get('flightNum')!)
      .subscribe((geography) => {
        this.geography = geography;
        this.loadMap();
        this.setDirection(geography.dir);

      });
  }

  setDelay(actual: string, estimated: string) {

    var difference = Date.parse(actual) - Date.parse(estimated);
    //if greater that 600,000 (10mins in unix)

    if(difference > 600000){
      this.delay = `Late by ${Math.floor(Math.abs(difference)/60000)}mins`
    }else if (difference < -600000){
      this.delay = `Early by ${Math.floor(Math.abs(difference)/60000)}mins`
    }else{
      this.delay = 'On time'
    }



  }

  setDirection(compass: number) {
    switch (true) {
      case compass < 22:
        this.direction = 'N';
        break;
      case compass < 67:
        this.direction = 'NE';
        break;
      case compass < 112:
        this.direction = 'E';
        break;
      case compass < 157:
        this.direction = 'SE';
        break;
      case compass < 202:
        this.direction = 'S';
        break;
      case compass < 247:
        this.direction = 'SW';
        break;
      case compass < 292:
        this.direction = 'W';
        break;
      case compass < 337:
        this.direction = 'NW';
        break;
      case compass < 360:
        this.direction = 'N';
        break;
    }
  }
  getDetailFlight(): void {
    this.flight = this.flightDetailService.getFlight();
  }
}
