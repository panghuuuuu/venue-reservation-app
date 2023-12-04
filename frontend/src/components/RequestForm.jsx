import React, { useState, useEffect } from "react";
import "../components/RequestForm.css";
import { useNavigate, useParams } from 'react-router-dom';
import axios from "axios";
import { red } from "@mui/material/colors";
import Success from "./Success";

const RequestForm = () => {
  const navigate = useNavigate();
  const [isDisabled, setIsDisabled] = useState(false);

  const venueID = useParams();
  const [venue, setVenue] = useState({
    venueName: "",
    building: "",
    timeStart: "",
    timeEnd: "",
    type: ""
  });
  const [reservationRequest, setReservationRequest] = useState({
    venueID: venueID.id,
    schoolID: 0,
    firstName: "",
    lastName: "",
    type: "",
    email: "",
    purpose: "",
    date: "",
    timeStart: "",
    timeEnd: "",
  });
  const [venueDateTime, setVenueDateTime] = useState({
    venueID: venueID.id,
    date: "",
    timeStart: "",
    timeEnd: ""
  });
  const [reservationConflicts, setReservationConflicts] = useState([]);
  const [reservation, setReservation] = useState(null);
  const [message, setMessage] = useState(""); 

  useEffect(() => {
    fetch(`http://localhost:9998/venue/view?venueID=${venueID.id}`)
      .then(response => response.json())
      .then(data => setVenue(data))
      .catch(error => console.error('Error fetching venue: ', error))

    if(reservation) {
      navigate('/success', {state: {reservation}});
    }

  }, [reservation]);

  function handleUserInput(e) {
    const name = e.target.name;
    const value = e.target.value;
    setReservationRequest((prevData) => ({
      ...prevData,
      [name]: value,
    }));
    if (name === "date" || name === "timeStart" || name === "timeEnd") {
      setVenueDateTime((prevData) => ({
        ...prevData,
        [name]: value,
      }));
    };
  }

  const checkScheduleConflicts = async (e) => {
    e.preventDefault();

    document.getElementById('conflicts-table').style.display='block';
    document.getElementById('conflicts-message').style.display='block';
    
    await fetch(`http://localhost:9997/reservation/conflict`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(venueDateTime),
    })
      .then(response => response.json())
      .then(data => setReservationConflicts(data))
      .catch(error => console.error('Error fetching conflicts: ', error))
  };

  const submitRequest = async (e) => {
    setIsDisabled(true);
    
    const response = await fetch(`http://localhost:9999/request/reservation`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(reservationRequest),
      })
      .then(response => response.json())
      .then(data => setReservation(data))
      .catch(error => {
        console.error('Error requesting a reservation: ', error)
        setMessage("Please answer all required fields or verify the venue schedule.");
      });
  
    // Prevent spamming of request button
    setTimeout(() => {
      setIsDisabled(false);}, 250);
  }

  const cancelRequest = () => {
    navigate('/venues');
  }

  return (
    <section className="reserve-venue">
      <h1 className="title">Reservation Request Form</h1>
      <p className="body">Fill out the form with the reservation details.
        <br/>You are currently reserving the venue {venue.venueName}.</p>
      <table className="venue-table">
        <tbody>
          <tr key={venue.venueID}>
            <td className="venue-name">{venue.venueName}</td>
            <td className="venue-schedule">{venue.timeStart} - {venue.timeEnd}</td>
            <td className="venue-building">{venue.building}</td>
            <td className="venue-type"><span className="tag">{venue.type}</span></td>
          </tr>
        </tbody>        
      </table>
      <form className="reservation-request-form" id="reservation-request-form">
        <label>Venue ID 
          <input type="number" name="venueID" value={venueID.id} onChange={handleUserInput} readOnly/>
          </label>
        <label>ID Number 
          <input type="number" name="schoolID" onChange={handleUserInput} required/>
        </label>
        <label>Given Name 
          <input type="text" name="firstName" onChange={handleUserInput} required/>
          </label>
        <label>Last Name 
          <input type="text" name="lastName" onChange={handleUserInput} required/>
          </label>
        <label className="reservee-type"> Are you a Student or Faculty Member?
          <div>
            <input type="radio" id="student" name="type" value="student" onChange={handleUserInput} required/>
            <label htmlFor="student">Student</label>  
          </div>
          <div>
            <input type="radio" id="faculty" name="type" value="faculty" onChange={handleUserInput} required/>
            <label htmlFor="faculty">Faculty</label>
          </div>
        </label>        
        <label>OBF Email 
          <input type="email" name="email" onChange={handleUserInput} required/>
          </label>
        <label>Purpose of reservation 
          <input type="text" name="purpose" onChange={handleUserInput} required/>
          </label>
        <div className="reservation-conflicts">
          <p className="body">
            <em>Check for any conflicting reservations first before proceeding.</em>
          </p>
          <div className="date-time">
            <div className="date">
              <label>Date (mm/dd/yyyy)
                <input type="date" name="date" style={{width: '300px'}} onChange={handleUserInput} required/>
              </label>
            </div>
            <div className="time">
            <label>Start (hh:mm)
              <input type="time" name="timeStart" style={{width: '150px'}} onChange={handleUserInput} required/>
            </label> 
            <label>End (hh:mm)
            <input type="time" name="timeEnd" style={{width: '150px'}} onChange={handleUserInput} required/>
            </label>
            </div>
          </div>
          <input type="button" className="form-button" value="Check Schedule" onClick={checkScheduleConflicts} />
          <p className="body" id="conflicts-message" style={{display: 'none'}}>There are {`${reservationConflicts.length}`} conflicting reservations with this schedule.</p>
          <table className="conflicts-table" id="conflicts-table" style={{display: 'none'}}>
            <tbody>
              {reservationConflicts?.map(reservation => (
                <tr key={reservation.reservationID}>
                  <td>
                    <span className="reservation-purpose">{reservation.purpose}</span>
                    <div className="reservation-details">
                      <p className="body reservation-id">Reservation ID: {reservation.reservationID}</p>
                    </div>
                  </td>
                  <td> {reservation.date} </td>
                  <td> {reservation.timeStart} - {reservation.timeEnd} </td>
                  <td className="reservation-status"><p className={`tag ${reservation.status}`}></p></td>
                </tr>
              ))}
            </tbody>        
          </table>
        </div>
        <div className="form-button-container">
          <input type="button" className="form-button" value="Cancel" onClick={cancelRequest} />
          <input type="submit" className="form-button" value="Request Reservation" disabled={isDisabled} onClick={submitRequest} />
        </div>
        <p className="body" style={{color: 'red'}}>{message}</p>
      </form>
    </section>
  );
}

export default RequestForm;