import React, { useState } from "react";
import "../components/Success.css";
import { useLocation } from "react-router-dom";

function Success() {
  const { state } = useLocation();
  const reservation = state.reservation;

  return (
    <section className="success">
      <h1 className="title">
        Thank you for using the
        <br /> CFMO Venue Reservation Portal!
      </h1>
      <p className="body">
        Your reservation has been requested with the following details:
      </p>
      <table className="reservation-table">
        <tbody>
          <tr>
            <td>
              <span className="reservation-purpose">{reservation.purpose}</span>
              <div className="reservation-details">
                <p className="body reservation-id">
                  Reservation ID: {reservation.reservationID}
                </p>
                <p className="body reservee-id">
                  Reservee ID: {reservation.reserveeID}
                </p>
                <p className="body venue-id">Venue ID: {reservation.venueID}</p>
              </div>
            </td>
            <td> {reservation.venueName} </td>
            <td> {reservation.date} </td>
            <td>
              {" "}
              {reservation.timeStart} - {reservation.timeEnd}{" "}
            </td>
            <td className="reservation-status">
              <p className={`tag ${reservation.status}`}></p>
            </td>
          </tr>
        </tbody>
      </table>
      <a href="/reservations">Back</a>
    </section>
  );
}

export default Success;
