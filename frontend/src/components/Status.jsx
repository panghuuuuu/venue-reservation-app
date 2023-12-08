import React, { useEffect, useState } from "react";
import "../components/Status.css";

function Status() {
  const [reservations, setReservations] = useState([]);

  useEffect(() => {
    fetch("http://localhost:9997/reservation/fetch")
      .then((response) => {
        if (!response.ok) {
          throw new Error(`Error fetching reservations: ${response.status}`);
        }
        return response.json();
      })
      .then((data) => setReservations(data))
      .catch((error) => {
        console.error("Error fetching reservations:", error);
      });
  }, []);

  const handleApprove = async (reservationID) => {
    try {
      const response = await fetch(
        "http://localhost:9997/reservation/setstatus",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded",
          },
          body: new URLSearchParams({
            reservationID,
            status: "Approved",
          }).toString(),
        }
      );

      if (!response.ok) {
        throw new Error(`Error approving reservation: ${response.status}`);
      }

      console.log(`Reservation ${reservationID} has been approved.`);
      window.location.reload();
    } catch (error) {
      console.error("Error approving reservation: ", error);
    }
  };

  return (
    <section className="status-list">
      <h1 className="title">List of Reservations</h1>
      <table className="status-table">
        <thead>
          <tr>
            <th>Reservation ID</th>
            <th>Reservee ID</th>
            <th>Venue ID</th>
            <th>Venue Name</th>
            <th>Date</th>
            <th>Time Start</th>
            <th>Time End</th>
            <th>Status</th>
            <th>Purpose</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {reservations.map((reservation) => (
            <tr key={reservation.reservationID}>
              <td>{reservation.reservationID}</td>
              <td>{reservation.reserveeID}</td>
              <td>{reservation.venueID}</td>
              <td>{reservation.venueName}</td>
              <td>{reservation.date}</td>
              <td>{reservation.timeStart}</td>
              <td>{reservation.timeEnd}</td>
              <td>{reservation.status}</td>
              <td>{reservation.purpose}</td>
              <td>
                {reservation.status === "Approved" ? (
                  <p class="tag Approved"></p>
                ) : (
                  <button
                    type="submit"
                    className="form-button"
                    onClick={() => handleApprove(reservation.reservationID)}
                  >
                    Approve
                  </button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </section>
  );
}

export default Status;
