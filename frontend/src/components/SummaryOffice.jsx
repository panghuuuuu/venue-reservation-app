import React, { useState } from "react";
import "../components/SummaryOffice.css";
import { useLocation } from "react-router-dom";

function SummaryOffice() {
  const { state } = useLocation();
  const admin = state.admin;

  return (
    <section className="success">
        <h1 className="title">
        Thank you for using the
        <br /> CFMO Venue Reservation Portal!
      </h1>
        <p className="body">
        Your office has been successfully saved with the following details:
        </p>
        <p className="body">
            Office ID: {admin.officeID}
        </p>
        <p className="body">
            Office Name: {admin.officeName}
        </p>
        <a href="/office">Back</a>
      </section>
  );

}

export default SummaryOffice;