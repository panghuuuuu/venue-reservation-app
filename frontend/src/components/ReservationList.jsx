import React, { useState, useEffect } from "react";
import "../components/ReservationList.css"

function ReservationList() {
  const [reservations, setReservations] = useState([]);
  const [reservationByID, setReservationByID] = useState({});
  const requestForm = document.getElementById("find-reservation-by-id");

  useEffect(() => {
    fetch('http://localhost:9997/reservation/fetch')
      .then(response => response.json())
      .then(data => setReservations(data))
      .catch(error => console.error('Error fetching reservations: ', error))
  }, [])

  const findReservation = async (e) => {
    e.preventDefault();
    let formData = new FormData(requestForm);
    let formDataObject = Object.fromEntries(formData.entries());

    await fetch(`http://localhost:9997/reservation/view?reservationID=${formDataObject.reservationID}`)
      .then(response => response.json())
      .then(data => setReservationByID(data))
      .catch(error => console.error('Error fetching reservation: ', error))

      document.getElementById('reservation-by-id-table').style.display='block';
  };

  return (
    <section className="reservation-list">
      <h1 className="title">Reservations</h1>
      <div className="reservation-by-id">
        <form className="find-reservation-by-id" id="find-reservation-by-id">
          <h2 className="title">Find a Reservation by ID</h2>
          <label>Reservation ID <input type="number" name="reservationID" /></label>
          <input type="button" className="form-button" value="Find Reservation" onClick={findReservation} />
          <table className="reservation-table" id="reservation-by-id-table" style={{display: 'none'}}>
            <tr>
              <td>
                <span className="reservation-purpose">{reservationByID.purpose}</span>
                <div className="reservation-details">
                  <p className="body reservation-id">Reservation ID: {reservationByID.reservationID}</p>
                  <p className="body reservee-id">Reservee ID: {reservationByID.reserveeID}</p>
                  <p className="body venue-id">Venue ID: {reservationByID.venueID}</p>
                </div>
              </td>
              <td> {reservationByID.venueName} </td>
              <td> {reservationByID.date} </td>
              <td> {reservationByID.timeStart} - {reservationByID.timeEnd} </td>
              <td className="reservation-status"><p className={`tag ${reservationByID.status}`}></p></td>
            </tr>
          </table>
        </form>
      </div>
      <p className="body">Recent reservation requests are displayed here.</p>
      <table className="reservation-table">
        <tbody>
          {reservations?.map(reservation => (
            <tr key={reservation.reservationID}>
              <td>
                <span className="reservation-purpose">{reservation.purpose}</span>
                <div className="reservation-details">
                  <p className="body reservation-id">Reservation ID: {reservation.reservationID}</p>
                  <p className="body reservee-id">Reservee ID: {reservation.reserveeID}</p>
                  <p className="body venue-id">Venue ID: {reservation.venueID}</p>
                </div>
              </td>
              <td> {reservation.venueName} </td>
              <td> {reservation.date} </td>
              <td> {reservation.timeStart} - {reservation.timeEnd} </td>
              <td className="reservation-status"><p className={`tag ${reservation.status}`}></p></td>
            </tr>
          ))}
        </tbody>
      </table>
    </section>
  );
}

export default ReservationList;
