# Flight Tracker App - Java Spring Boot & Angular

This app uses the Airlabs API to display info about flights schedules on a route, and display live flight details such as location, speed, alititude. Clients can make an account on the website and save their favorite flights to a local MySQL database.

---

## Search Form
### Search for all scheduled flights on a given route for that day. Ex Toronto to Vancouver
<img src='/READMEGifs/searchNotLoggedIn.gif' style='width:100%' />

This page displays all scheduled flights. If a client is not logged in they will be unable to favorite a flight.

---

## Flight Details
### For active flights clients can view the live flight info and the planes current location in a Leaflet map
<img src='/READMEGifs/Flightdetail.gif' style='width:100%' />

Geography information is being pulled through the backend from Airlabs API.

---

## Login Flow
### A User service provides the current user information to all Angular components
<img src='/READMEGifs/LogInFavorite.gif' style='width:100%' />

Upon logging in, the nav bar updates to hide the login button. The current user is provided to all components in the site, to allow features such as adding a flight to favorites.

---

## User Favorites
### A logged in user can fetch their favorite flights stored in MySQL through the backend controller
<img src='/READMEGifs/UserFav.gif' style='width:100%' />

View all flights in the MySQL db for a given user. Users may send a DELETE request to the controller to remove a flight from their list of favorites.

---