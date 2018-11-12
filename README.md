## Event Tracker Project

#### Created By Zachary Lamb

### Summary
This program was strictly built out a desire to challenge myself. This is a basic flight tracker that I believe an airport would use to keep track of flights coming in and going out. It was only built out to 5 database tables but when thinking of the magnitude that this project could become is astonishing to me. I find it fascinating that there are all of these underlying processes out in the world that we take for granted. This project helped give me a little look at the real world and I am excited to jump into it soon. This project was built just after week 11 of the boot camp meaning I only have 5 more weeks to go until graduation.

### Overview
The premise and goal of this project was to build out an event tracker. We had full control of the project from start to finish. I came up with the idea and coded everything to make it work. I choose a flight tracker which I thought would be fun and challenging.

#### Operation/Description of how the program works:
This program was primarily tested with Postman to ensure that all functionality worked.

#### Paths/Routes

Use these numbers to ensure you are grabbing proper ids:
- flightId: 1-2
- airlineId: 1-10
- airplaneId: 1-15
- airplaneTypeId: 1-27
- airportId: 1-4
- arrivalId: 1-4
- departureId: 1-4

#####GetMethod
Obtains information from the database, no special information needed
- api/ping
- Flights
	- api/flights
	- api/flights/{flightId}
- Airlines
	- api/airlines
	- api/airlines/{airlineId}
- Airplanes
	- api/airplanes
	- api/airplanes/{airplaneId}
- AirplaneTypes
	- api/airplaneTypes
	- api/airplaneTypes/{airplaneTypeId}
- Airports
	- api/airports
	- api/airports/{airportId}

#####PostMethod
Creates an entity. For Flights and Airplanes you must have required ids in the path. The entities required for Flights and Airplanes must be created before you create a new flight.
- Flights
	- api/flights/arrival/{arrivalId}/departure/{departureId}/airplane/{airplaneId}
- Airlines
	- api/airlines
- Airplanes
	- api/airplanes/airline/{airlineId}/airplaneType/{airplaneTypeId}
- AirplaneTypes
	- api/airplaneTypes
- Airports
	- api/airports

#####DeleteMethod
Deletes entity
- Flights
	- api/flights/{flightId}
- Airlines
	- api/airlines/{airlineId}
- Airplanes
	- api/airplanes/{airplaneId}
- AirplaneTypes
	- api/airplaneTypes/{airplaneTypeId}
- Airports
	- api/airports/{airportId}

#####PutMethod
Updates an entity. For Flights you must have required ids in the path. The entities required for Flights and Airplanes must be created before you update a new flight. If you would like to update the arrival, departure, or airplane of a flight all you need to do is change the id number to update what you would like. For the put method you must include all non null items in your JSon Body Request.
- Flights
	- api/flights/{flightId}/arrival/{arrivalId}/departure/{departureId}/airplane/{airplaneId}
- Airlines
	- api/airlines/{airlineId}
- AirplaneTypes
	- api/airplaneTypes/{airplaneTypeId}
- Airports
	- api/airports/{airportId}


#####PatchMethod
Patches an entity. Not all values are required to update these entities. If you would like to update an airplane, all that is needed is to change the value in the URL. No RequestBody required. The same goes for flights, you can update the arrival, departure, and airplane by changing the number in the URL and no RequestBody required although you can also update just the items you want in the RequestBody as well.
- Flights
	- api/flights/{flightId}/arrival/{arrivalId}/departure/{departureId}/airplane/{airplaneId}
- Airplanes
	- api/airplanes/{airplaneId}/airline/{airlineId}/airplaneType/{airplaneTypeId}
- AirplaneTypes
	- api/airplaneTypes/{airplaneTypeId}
- Airports
	- api/airports/{airportId}



#### Technologies/Techniques Used

| Technologies       |
| ------------------ |
| JPA                |
| JDBC               |
| AWS                |
| Develop Database   |
| Sprint Tools Suite |
| Entities           |
| Interface          |
| MAMP               |
| MySQL Workbench    |
| JUnit Jupiter      |
| SpringBoot         |
| Service            |
| Controller         |
| Repositories       |
| RESTful Services   |

#### Lessons Learned
- The set up is always the hardest and most important part of any project. If you first don't get it set up right the first time you will have issues down the road or nothing will even work. Down the road if you try to edit and change things it will require a whole reworking of everything.
- One of the things I found interesting is that if you have an entity that only contains foreign keys I had to create and update based on the URL path. So if you need to create or update you would just add/or change the id to what you would like it to go to.
- One big thing that I learned was that I like RESTful service much more than using ModeAndView. I am excited to see how the front end connects to it.
- I made some assumptions being that someone would have pulled up the longer URLs on the front end. 

#### Problems/Issues
- I had a few issues in getting things all set up at the beginning with talking to the datbase. But once everything was good to go the rest of the program was pretty straigh forward.
- I was having an issue with how the JSon was coming back. It had to do with any of the lists being a part an entity. The solution was to remove the list from the toString of each entity that had a list. Even though I had @JsonIgnore on the lists and the toString list had .size() it was still causing issues.

#### Things we were unable to add or incorporate
- I would have liked to build out more database tables
- JUnit tests for Controllers, Services, and Repositories
- Have more ways to search the entities
- Mark flight as unavailable automatically if the seats occupied match seat capacity
- Not allow a user to enter seats occupied to be greater than seat capacity
- Have a way to add or update the URLs that don't require you to input the number in the URL to do the add or update
