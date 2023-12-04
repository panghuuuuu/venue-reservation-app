import React, { useState } from "react";
import "../components/Home.css"
import axios from "axios";

function Home() {
  return (
    <section className="hero">
      <h1 className="title">
        Welcome to the<br/><span>CFMO Reservation Portal!</span> 
      </h1>
      <div className="hero-buttons">
        <a href="/venues">View Venues</a>
        <a href="reservations">View Reservations</a>
      </div>
    </section>
  );
}

export default Home;