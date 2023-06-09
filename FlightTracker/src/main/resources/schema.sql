DROP DATABASE IF EXISTS FlightTracker;

CREATE DATABASE FlightTracker;
USE FlightTracker;

-- Table structure for users
CREATE TABLE users (
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    username varchar(100) NOT NULL,
    email varchar(100) NOT NULL
);


-- Table structure for flights (user favourites)

CREATE TABLE flights (
  flight_id INT PRIMARY KEY AUTO_INCREMENT,
  flight_number varchar(25) NOT NULL,
  airline varchar(25) NOT NULL, -- ex AC for Air Canada
  departure varchar(25) NOT NULL, -- ex YYZ for Toronto
  arrival varchar(25) NOT NULL, -- ex YVR for Vancouver
  flight_status varchar(100),
  dep_time varchar(250),
  arr_time varchar(250),
  arr_time_est varchar(250),
  user_id INT NOT NULL,
  foreign key (user_id) references users (user_id)


);

-- Table structure for Airports

CREATE TABLE airports (
	airport_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    airport_code varchar(25) NOT NULL,
    city varchar(250) NOT NULL,
    country varchar(250) NOT NULL,
    timezone varchar(25)

);

-- Table structure for Airlines

CREATE TABLE airlines (
    airline_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    airline_code VARCHAR(25) NOT NULL,
    airline_name VARCHAR(100) NOT NULL
);




-- INSERT STATIC AIRLINE AND AIRPORT
INSERT INTO airports VALUES (1,'YYZ', 'Toronto', 'Canada', 'ET'),
(2,'YVR','Vancouver','Canada', 'PT'),
(3,'YUL','Montreal','Canada', 'ET'),
(4,'ORD','Chicago','United States of America', 'CT');

INSERT INTO airlines VALUES (1,'AC', 'Air Canada'),
 (2,'AA', 'American Airlines'),
(3,'DL', 'Delta'),
(4, 'UA', 'United'),
(5, 'WS', 'Westjet'),
(6, 'F8', 'Flair'),
(7, 'PD', 'Porter');

INSERT INTO users VALUES(1, 'FreqFlyer', 'freq@flyer.com');