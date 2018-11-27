/*
 * Window event listener
 */
window.addEventListener('load', function(e) {
  console.log('WINDOW LOADED')
  getAllFlights();
  wifiPlanes();
  init();
});

/*
 * Init function which holds event listeners
 */
function init() {
  /*
   * Display all flights event listener
   */
  let displayAllFlightsButton = document.getElementById('displayAllFlights');
  displayAllFlightsButton.addEventListener('click', function(event) {
    event.preventDefault();
    getAllFlights();
  });

  /*
   * Display single flight event listener
   */
  document.displaySingleFlight.displaySingleFlight.addEventListener('click',
    function(event) {
      event.preventDefault();
      let getSingleFlightForm = event.target.parentElement;
      getSingleFlight(getSingleFlightForm.number.value);
    });

  /*
   * Create new flight event listener
   */
  document.createNewFlight.submitNewFlight
    .addEventListener(
      'click',
      function(event) {
        event.preventDefault();
        let newFlightForm = document.getElementById('editForm');
        let newFlight = {
          seatsOccupied: newFlightForm.seatsOccupied.value,
          scheduledDeparture: newFlightForm.scheduledDeparture.value,
          actualDeparture: newFlightForm.actualDeparture.value,
          scheduledArrival: newFlightForm.scheduledArrival.value,
          actualArrival: newFlightForm.actualArrival.value,
          flightNumber: newFlightForm.flightNumber.value,
          numberOfStops: newFlightForm.numberOfStops.value,
          available: newFlightForm.available.value
        };
        submitNewFlight(newFlight,
          newFlightForm.arrivalAirport.value,
          newFlightForm.departureAirport.value,
          newFlightForm.airplane.value);
      });
}

/*
 * Get all flights XMLHttpRequest. Returns array of flights.
 */
function getAllFlights() {
  let xhr = new XMLHttpRequest();
  xhr.open('GET', 'api/flights');
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        let allFlightsResponse = xhr.responseText;
        let allFlights = JSON.parse(allFlightsResponse);
        displayFlights(allFlights);
      } else if (xhr.status >= 400) {
        allFlights = 'No Flights Found';
        displayFlights(allFlights);
      }
    }
  };
  xhr.send();
}

/*
 * Get single flight XMLHttpRequest. Take two parameters. First is required with
 * the flight id number. If only this field is passed through the screen will
 * only display a single flight. Second is optional which if filled with the
 * string 'edit' it will put the airplane id in the form. The second is required
 * for when updating a flgiht.
 */
function getSingleFlight(flightId, edit) {
  let xhr = new XMLHttpRequest();
  xhr.open('GET', 'api/flights/' + flightId);
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        let singleFlightResponse = xhr.responseText;
        let singleFlight = JSON.parse(singleFlightResponse);
        if (edit === 'edit') {
          document.createNewFlight.airplane.value = singleFlight.id;
        } else {
          displayFlights(singleFlight);
        }
      } else if (xhr.status >= 400) {
        singleFlight = 'No Flights Found';
        displayFlights(singleFlight);
      }
    }
  };
  xhr.send();
}

/*
 * Submit new flight XMLHttpRequest. Takes four parameters, all are required.
 * newFlight = flight object from submitted form arrival = arrival airport id
 * number departure = departure airport id number airplane = airplane id number
 */
function submitNewFlight(newFlight, arrival, departure, airplane) {
  let xhr = new XMLHttpRequest();
  let newFlightJson = JSON.stringify(newFlight);
  xhr
    .open('POST',
      `api/flights/arrivals/${arrival}/departures/${departure}/airplanes/${airplane}`);
  xhr.setRequestHeader('Content-type', 'application/json');
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 201) {
        let newFlightResponse = xhr.responseText;
        let newFlightCreated = JSON.parse(newFlightResponse);
        getAllFlights();
      } else if (xhr.status >= 400) {
        newFlightCreated = 'No Flight Created';
        displayFlights(newFlightCreated);
      }
    }
  };
  xhr.send(newFlightJson);
}

/*
 * Submit updated flight XMLHttpRequest. Takes five parameters, all are
 * required. updatedFlight = flight object from submitted form arrival = arrival
 * airport id number departure = departure airport id number airplane = airplane
 * id number flightNumber = flight id number
 */
function submitUpdatedFlight(updatedFlight, arrivalAirport, departureAirport,
  airplane, flightNumber) {
  let xhr = new XMLHttpRequest();
  let updatedFlightJson = JSON.stringify(updatedFlight);
  xhr
    .open(
      'PUT',
      `api/flights/${flightNumber}/arrivals/${arrivalAirport}/departures/${departureAirport}/airplanes/${airplane}`);
  xhr.setRequestHeader('Content-type', 'application/json');
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 202) {
        let updatedFlightResponse = xhr.responseText;
        let flightUpdated = JSON.parse(updatedFlightResponse);
        displayFlights(flightUpdated);
      } else if (xhr.status >= 400) {
        flightUpdated = 'No Flight Updated';
        displayFlights(flightUpdated);
      }
    }
  };
  xhr.send(updatedFlightJson);
}

/*
 * Delete flight XMLHttpRequest. Takes one parameter which is the flight id
 * number that will be deleted and is required.
 */
function deleteFlight(flightId) {
  let xhr = new XMLHttpRequest();
  xhr.open('DELETE', `api/flights/${flightId}`);
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 202) {
        let deleteFlightResponse = xhr.responseText;
        let flightDeleted = JSON.parse(deleteFlightResponse);
        getAllFlights();
      } else if (xhr.status >= 400) {
        flightDeleted = 'Error deleteing flight';
        displayFlights(flightDeleted);
      }
    }
  };
  xhr.send();
}

/*
 * Get count of wifi planes from XMLHttpRequest. Returns integer.
 */
function wifiPlanes() {
  let xhr = new XMLHttpRequest();
  xhr.open('GET', `api/airplaneTypes/wifi`);
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        let wifiResponse = xhr.responseText;
        let wifiNumber = JSON.parse(wifiResponse);
        document.getElementById('wifi').textContent = wifiNumber;
      } else if (xhr.status >= 400) {
        flightDeleted = 'Error deleteing flight';
        displayFlights(flightDeleted);
      }
    }
  };
  xhr.send();
}

/*
 * Get single airport XMLHttpRequest. Takes two parameters, both are required.
 * airportCode = three letter airport code location = string 'arrival' or string
 * 'departure' depending on location it will add the location id to the form for
 * updating
 */
function getSingleAirport(airportCode, location) {
  let xhr = new XMLHttpRequest();
  xhr.open('GET', `api/airports/code/${airportCode}`);
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        let singleAirportResponse = xhr.responseText;
        let singleAirport = JSON.parse(singleAirportResponse);
        if (location === 'departure') {
          document.createNewFlight.departureAirport.value = singleAirport.id;
        } else if (location === 'arrival') {
          document.createNewFlight.arrivalAirport.value = singleAirport.id;
        }
      } else if (xhr.status >= 400) {
        singleFlight = 'No Flights Found';
        return 'Airport Not Found';
      }
    }
  };
  xhr.send();
}

/*
 * Display flights function This function dynamically updates the table The div
 * in the html is set to an empty string and the rebuilds the table The table
 * head is created and then the body is created by calling another function
 */
function displayFlights(flights) {

  // gets div from document and resets it back to an empty string
  let displayFlightsDiv = document.getElementById('displayFlights');
  displayFlightsDiv.textContent = '';

  // creates table
  let createdTable = document.createElement('table');
  displayFlightsDiv.appendChild(createdTable);

  // creates table head
  let createdTableHead = document.createElement('thead');
  createdTable.appendChild(createdTableHead);

  // creates table head row
  let createdTableHeadRow = document.createElement('tr');
  createdTableHead.appendChild(createdTableHeadRow);

  // creates head cell Flight Id
  let createdHeadCellFlightId = document.createElement('th');
  createdHeadCellFlightId.textContent = 'Flight Id';
  createdTableHeadRow.appendChild(createdHeadCellFlightId);

  // creates head cell Flight Number
  let createdHeadCellFlightNumber = document.createElement('th');
  createdHeadCellFlightNumber.textContent = 'Flight Number';
  createdTableHeadRow.appendChild(createdHeadCellFlightNumber);

  // creates head cell Departure Airport
  let createdHeadCellDepartureAirport = document.createElement('th');
  createdHeadCellDepartureAirport.textContent = 'Departure Airport';
  createdTableHeadRow.appendChild(createdHeadCellDepartureAirport);

  // creates head cell Arrival Airport
  let createdHeadCellArrivalAirport = document.createElement('th');
  createdHeadCellArrivalAirport.textContent = 'Arrival Airport';
  createdTableHeadRow.appendChild(createdHeadCellArrivalAirport);

  // creates head cell Scheduled Departure
  let createdHeadCellScheduledDeparture = document.createElement('th');
  createdHeadCellScheduledDeparture.textContent = 'Scheduled Departure';
  createdTableHeadRow.appendChild(createdHeadCellScheduledDeparture);

  // creates head cell Actual Departure
  let createdHeadCellActualDeparture = document.createElement('th');
  createdHeadCellActualDeparture.textContent = 'Actual Departure';
  createdTableHeadRow.appendChild(createdHeadCellActualDeparture);

  // creates head cell Scheduled Arrival
  let createdHeadCellScheduledArrival = document.createElement('th');
  createdHeadCellScheduledArrival.textContent = 'Scheduled Arrival';
  createdTableHeadRow.appendChild(createdHeadCellScheduledArrival);

  // creates head cell Actual Arrival
  let createdHeadCellActualArrival = document.createElement('th');
  createdHeadCellActualArrival.textContent = 'Actual Arrival';
  createdTableHeadRow.appendChild(createdHeadCellActualArrival);

  // creates head cell Number Of Stops
  let createdHeadCellNumberOfStops = document.createElement('th');
  createdHeadCellNumberOfStops.textContent = 'Number Of Stops';
  createdTableHeadRow.appendChild(createdHeadCellNumberOfStops);

  // creates head cell Airline
  let createdHeadCellAirline = document.createElement('th');
  createdHeadCellAirline.textContent = 'Airline';
  createdTableHeadRow.appendChild(createdHeadCellAirline);

  // creates head cell Airplane Maker
  let createdHeadCellAirplaneMaker = document.createElement('th');
  createdHeadCellAirplaneMaker.textContent = 'Airplane Maker';
  createdTableHeadRow.appendChild(createdHeadCellAirplaneMaker);

  // creates head cell Airplane Type
  let createdHeadCellAirplaneType = document.createElement('th');
  createdHeadCellAirplaneType.textContent = 'Airplane Type';
  createdTableHeadRow.appendChild(createdHeadCellAirplaneType);

  // creates head cell Seats Occupied
  let createdHeadCellSeatsOccupied = document.createElement('th');
  createdHeadCellSeatsOccupied.textContent = 'Seats Occupied';
  createdTableHeadRow.appendChild(createdHeadCellSeatsOccupied);

  // creates head cell Available
  let createdHeadCellAvailable = document.createElement('th');
  createdHeadCellAvailable.textContent = 'Available';
  createdTableHeadRow.appendChild(createdHeadCellAvailable);

  // creates table body
  let createdTableBody = document.createElement('tbody');
  createdTableBody.setAttribute('id', 'tableBody');
  createdTable.appendChild(createdTableBody);

  /*
   * Checks to see what type of object was passed into the displayFlights
   * function If an array was passed in it will iterate throught it in a for
   * loop and call the printFlights function which dynamically builds each row
   * If a single flight object is passed it will call the printFlights
   * function once to dynamically build the row Or it will display whatever
   * string that was passed to it
   */
  if (Array.isArray(flights)) {
    for (var i = 0; i < flights.length; i++) {
      printFlights(flights[i]);
    }
  } else if (typeof(flights) === 'object') {
    printFlights(flights);
  } else {
    displayFlightsDiv.textContent = flights;
  }
}

/*
 * Display flights function This function dynamically updates the table body
 */
function printFlights(printFlights) {
  // grabs the created table body from tbe previous function
  let createdTableBody = document.getElementById('tableBody');

  // creates table body
  let createdTableBodyRow = document.createElement('tr');
  /*
   * Adds an event listener to each row If a row is clicked on it will put the
   * table information into the form already on the page
   */
  createdTableBodyRow.addEventListener('click',
      function(event) {
        // grabs the row information to be able to pull
        // information from it
        let row = event.target.parentElement;
        // grabs the form location to be able to put the row
        // information into the row
        let form = document.createNewFlight;

        // unless specified the following will grab the
        // information from the row and put it into the form
        // adds flight number to form
        form.flightNumber.value = row.children[1].innerHTML;

        // calls getSingleAirport function to put the correct
        // departure airport id in the form
        getSingleAirport(row.children[2].innerHTML, 'departure');

        // calls getSingleAirport function to put the correct
        // departure airport id in the form
        getSingleAirport(row.children[3].innerHTML, 'arrival');

        // adds scheduled departure time to form
        // also sliced off the last five characters because the
        // database add '+0000' to the end of the the time
        // entered from the form
        let scheduledDeparture = row.children[4].innerHTML;
        scheduledDeparture = scheduledDeparture.slice(0, -5);
        form.scheduledDeparture.value = scheduledDeparture;

        // adds actual departure time to form
        // also sliced off the last five characters because the
        // database add '+0000' to the end of the the time
        // entered from the form
        let actualDeparture = row.children[5].innerHTML;
        actualDeparture = actualDeparture.slice(0, -5);
        form.actualDeparture.value = actualDeparture;

        // adds scheduled arrival time to form
        // also sliced off the last five characters because the
        // database add '+0000' to the end of the the time
        // entered from the form
        let scheduledArrival = row.children[6].innerHTML;
        scheduledArrival = scheduledArrival.slice(0, -5);
        form.scheduledArrival.value = scheduledArrival

        // adds actual arrival time to form
        // also sliced off the last five characters because the
        // database add '+0000' to the end of the the time
        // entered from the form
        let actualArrival = row.children[7].innerHTML;
        actualArrival = actualArrival.slice(0, -5);
        form.actualArrival.value = actualArrival

        // adds number of stops to form
        form.numberOfStops.value = row.children[8].innerHTML;

        // calls getSingleFlight function to put the correct
        // airplane id into the form
        getSingleFlight(row.children[0].innerHTML, 'edit');

        // add seats occupied to form
        form.seatsOccupied.value = row.children[12].innerHTML;

        // add available to form
        form.available.value = row.children[13].innerHTML;

        // dynamically creates hidden input to add the flight id
        // to the object
        let createdHiddenValue = document
          .createElement('input');
        createdHiddenValue.setAttribute('type', 'hidden');
        createdHiddenValue.setAttribute('name',
          'hiddenFlightNumber');
        createdHiddenValue.setAttribute('value',
          row.children[0].innerHTML);
        form.appendChild(createdHiddenValue);

        // dynamically removes the submit button
        let submitButton = document.getElementById('submitNewFlight');
        if (submitButton != null) {
          submitButton.parentNode.removeChild(submitButton);
        }

        // dynamically adds new update button
        let updateButton = document.createElement('input');
        updateButton.setAttribute('type', 'submit');
        updateButton.setAttribute('name', 'submitUpdatedFlight');
        updateButton.setAttribute('id', 'submitUpdatedFlight');
        updateButton.setAttribute('value', 'Update Flight');
        let buttonPosition = document.getElementById('buttonPosition')
        buttonPosition.appendChild(updateButton);

        // dynamically add new clear button
        let clearButton = document.createElement('input');
        clearButton.setAttribute('type', 'submit');
        clearButton.setAttribute('name', 'clearForm');
        clearButton.setAttribute('id', 'clearForm');
        clearButton.setAttribute('value', 'Clear Form');
        buttonPosition.appendChild(clearButton);

        // dynamically add new delete button
        let deleteButton = document.createElement('input');
        deleteButton.setAttribute('type', 'submit');
        deleteButton.setAttribute('name', 'deleteForm');
        deleteButton.setAttribute('id', 'deleteForm');
        deleteButton.setAttribute('value', 'Delete Flight');
        buttonPosition.appendChild(deleteButton);

        /*
         * Update button flight event listener
         */
        updateButton.addEventListener('click',
            function(event) {
              event.preventDefault();
              let updatedFlightForm = document.getElementById('editForm');
              let updatedFlight = {
                seatsOccupied: updatedFlightForm.seatsOccupied.value,
                scheduledDeparture: updatedFlightForm.scheduledDeparture.value,
                actualDeparture: updatedFlightForm.actualDeparture.value,
                scheduledArrival: updatedFlightForm.scheduledArrival.value,
                actualArrival: updatedFlightForm.actualArrival.value,
                flightNumber: updatedFlightForm.flightNumber.value,
                numberOfStops: updatedFlightForm.numberOfStops.value,
                available: updatedFlightForm.available.value
              };
              submitUpdatedFlight(
                updatedFlight,
                updatedFlightForm.arrivalAirport.value,
                updatedFlightForm.departureAirport.value,
                updatedFlightForm.airplane.value,
                updatedFlightForm.hiddenFlightNumber.value);
            }); // end of update button event
        // listener

        /*
         * Clear button event listener
         */
        clearButton.addEventListener('click', function(event) {
          clearForm();
          switchButtons();

        }); // end of clear button event listener

        /*
         * Delete button event listener
         */
        deleteButton.addEventListener('click', function(event) {
          deleteFlight(row.children[0].innerHTML);
          clearForm();
          switchButtons();
        }); // end of clear button event listener
      } // end of table row event listener function
    ); // end of table row event listener
  createdTableBody.appendChild(createdTableBodyRow); // a part of creating
  // table body row from
  // above

  // creates body cell flight id
  let createdBodyCellFlightId = document.createElement('td');
  createdBodyCellFlightId.textContent = printFlights.id;
  createdTableBodyRow.appendChild(createdBodyCellFlightId);

  // creates body cell flight number
  // if the flight number is undefined it adds it as an empty string otherwise
  // it adds the flight number
  let createdBodyCellFlightNumber = document.createElement('td');
  if (typeof(createdBodyCellFlightNumber) === 'undefined') {
    createdBodyCellFlightNumber.textContent = '';
  } else {
    createdBodyCellFlightNumber.textContent = printFlights.flightNumber;
  }
  createdTableBodyRow.appendChild(createdBodyCellFlightNumber);

  // creates body cell departure airport
  let createdBodyCellDepartureAirport = document.createElement('td');
  createdBodyCellDepartureAirport.textContent = printFlights.departureAirport.code;
  createdTableBodyRow.appendChild(createdBodyCellDepartureAirport);

  // creates body cell arrival airport
  let createdBodyCellArrivalAirport = document.createElement('td');
  createdBodyCellArrivalAirport.textContent = printFlights.arrivalAirport.code;
  createdTableBodyRow.appendChild(createdBodyCellArrivalAirport);

  // creates body cell scheduled departure
  let createdBodyCellScheduledDeparture = document.createElement('td');
  createdBodyCellScheduledDeparture.textContent = printFlights.scheduledDeparture;
  createdTableBodyRow.appendChild(createdBodyCellScheduledDeparture);

  // creates body cell actual departure
  // if the actual departure is null it as an empty string otherwise it adds
  // the actual departure
  let createdBodyCellActualDeparture = document.createElement('td');
  if (typeof(createdBodyCellActualDeparture) === 'null') {
    createdBodyCellActualDeparture.textContent = '';
  } else {
    createdBodyCellActualDeparture.textContent = printFlights.actualDeparture;
  }
  createdTableBodyRow.appendChild(createdBodyCellActualDeparture);

  // creates body cell scheduled arrival
  let createdBodyCellScheduledArrival = document.createElement('td');
  createdBodyCellScheduledArrival.textContent = printFlights.scheduledArrival;
  createdTableBodyRow.appendChild(createdBodyCellScheduledArrival);

  // creates body cell actual arrival
  // if the actual arrival is null it as an empty string otherwise it adds the
  // actual departure
  let createdBodyCellActualArrival = document.createElement('td');
  if (typeof(createdBodyCellActualArrival) === 'null') {
    createdBodyCellActualArrival.textContent = '';
  } else {
    createdBodyCellActualArrival.textContent = printFlights.actualArrival;
  }
  createdTableBodyRow.appendChild(createdBodyCellActualArrival);

  // creates body cell number of stops
  let createdBodyCellNumberOfStops = document.createElement('td');
  createdBodyCellNumberOfStops.textContent = printFlights.numberOfStops;
  createdTableBodyRow.appendChild(createdBodyCellNumberOfStops);

  // creates body cell airline
  let createdBodyCellAirline = document.createElement('td');
  createdBodyCellAirline.textContent = printFlights.airplane.airline.name;
  createdTableBodyRow.appendChild(createdBodyCellAirline);

  // creates body cell airplane maker
  let createdBodyCellAirplaneMaker = document.createElement('td');
  createdBodyCellAirplaneMaker.textContent = printFlights.airplane.airplaneType.maker;
  createdTableBodyRow.appendChild(createdBodyCellAirplaneMaker);

  // creates body cell airplane type
  let createdBodyCellAirplaneType = document.createElement('td');
  createdBodyCellAirplaneType.textContent = printFlights.airplane.airplaneType.type;
  createdTableBodyRow.appendChild(createdBodyCellAirplaneType);

  // creates body cell seats occupied
  let createdBodyCellSeatsOccupied = document.createElement('td');
  createdBodyCellSeatsOccupied.textContent = printFlights.seatsOccupied;
  createdTableBodyRow.appendChild(createdBodyCellSeatsOccupied);

  // creates body cell available
  let createdBodyCellAvailable = document.createElement('td');
  createdBodyCellAvailable.textContent = printFlights.available;
  createdTableBodyRow.appendChild(createdBodyCellAvailable);

}; // end of print flight function

// clears values in the form
function clearForm() {
  let clearFlightForm = document.getElementById('editForm');
  clearFlightForm.flightNumber.value = '';
  clearFlightForm.departureAirport.value = '';
  clearFlightForm.arrivalAirport.value = '';
  clearFlightForm.scheduledDeparture.value = '';
  clearFlightForm.actualDeparture.value = '';
  clearFlightForm.scheduledArrival.value = '';
  clearFlightForm.actualArrival.value = '';
  clearFlightForm.numberOfStops.value = '';
  clearFlightForm.airplane.value = '';
  clearFlightForm.seatsOccupied.value = '';
  clearFlightForm.available.value = '';
}

// dynamically removes update, clear, and delete buttons
function switchButtons() {
  // dynamically removes the update button
  let updateButton = document.getElementById('submitUpdatedFlight');
  if (updateButton != null) {
    updateButton.parentNode.removeChild(updateButton);
  }

  // dynamically removes the update button
  let clearButton = document.getElementById('clearForm');
  if (clearButton != null) {
    clearButton.parentNode.removeChild(clearButton);
  }

  // dynamically removes the update button
  let deleteButton = document.getElementById('deleteForm');
  if (deleteButton != null) {
    deleteButton.parentNode.removeChild(deleteButton);
  }

  // dynamically add submit button
  let submitButton = document.createElement('input');
  submitButton.setAttribute('type', 'submit');
  submitButton.setAttribute('name', 'submitNewFlight');
  submitButton.setAttribute('id', 'submitNewFlight');
  submitButton.setAttribute('value', 'Create New FLight');
  let buttonPosition = document.getElementById('buttonPosition')
  buttonPosition.appendChild(submitButton);

  submitButton.addEventListener('click', function(event) {
    event.preventDefault();
    let newFlightForm = document.getElementById('editForm');
    let newFlight = {
      seatsOccupied: newFlightForm.seatsOccupied.value,
      scheduledDeparture: newFlightForm.scheduledDeparture.value,
      actualDeparture: newFlightForm.actualDeparture.value,
      scheduledArrival: newFlightForm.scheduledArrival.value,
      actualArrival: newFlightForm.actualArrival.value,
      flightNumber: newFlightForm.flightNumber.value,
      numberOfStops: newFlightForm.numberOfStops.value,
      available: newFlightForm.available.value
    };
    submitNewFlight(newFlight, newFlightForm.arrivalAirport.value,
      newFlightForm.departureAirport.value,
      newFlightForm.airplane.value);
  });
}
