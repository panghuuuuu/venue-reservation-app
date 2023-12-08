import React from "react";
import { useLocation } from "react-router-dom";
import "../components/Summary.css";

function Summary() {
  const { state } = useLocation();
  const reservation = state.reservation;

  if (!state || !state.reservation) {
    return (
      <div>
        <h1>Success Page</h1>
        <p>No reservation data available</p>
      </div>
    );
  }

  return (
    <section className="summary">
      <div>
        <h1 className="title">Reservation Summary</h1>
        <table className="reservation-table">
          <tbody>
            <tr>
              <div className="reservation-details">
                <p className="body reservation-id">
                  Reservation ID: {reservation.reservationID}
                </p>
                <p className="body tables">Tables: {reservation.tables}</p>
                <p className="body chairs">Chairs: {reservation.chairs}</p>
                <p className="body extensions">
                  Extension Cords: {reservation.extensions}
                </p>
                <p className="body projectors">
                  Projectors: {reservation.projectors}
                </p>
                <p className="body projectorScreens">
                  Projector Screens: {reservation.projectorScreens}
                </p>
                <p className="body microphones">
                  Microphones: {reservation.microphones}
                </p>
                <p className="body speakers">
                  Speakers: {reservation.speakers}
                </p>
              </div>
            </tr>
          </tbody>
        </table>
      </div>
    </section>
  );
}

export default Summary;
