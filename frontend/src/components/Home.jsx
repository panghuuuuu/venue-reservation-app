import React from "react";
import "../components/Home.css";

function Home() {
  return (
    <section className="hero">
      <h1 className="title">
        Welcome to the
        <br />
        <span>CFMO Reservation Portal!</span>
      </h1>
      <div className="hero-buttons">
        <a href="/venues">View Venues</a>
        <a href="/equipments">Reserve Equipments</a>
        <a href="/reservations">View Reservations</a>
      </div>
      <div className="admin">
        <p>
          Are you an Admin? Click <a href="/status">here</a> to set reservation
          status.
        </p>
      </div>
    </section>
  );
}

export default Home;
