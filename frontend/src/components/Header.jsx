import React, { useState } from "react";
import "../components/Header.css";

function Header() {
  return (
    <header>
      <a href="/">
        <div className="site-header-title">
          <img
            src={require("../assets/ateneo-logo.png")}
            alt="Ateneo Logo"
            width="75"
            height="75"
          ></img>
          <div className="text">
            <h3 className="title">Ateneo de Manila University</h3>
            <h2 className="title">CFMO Venue Reservation Portal</h2>
          </div>
        </div>
      </a>
      <nav>
        <a href="/venues">
          <p className="body">Venues</p>
        </a>
        <a href="equipments">
          <p className="body">Equipments</p>
        </a>
        <a href="reservations">
          <p className="body">Reservations</p>
        </a>
      </nav>
    </header>
  );
}

export default Header;
