import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "../components/VenueList.css";

const VenueList = () => {
  const [venues, setVenues] = useState([]);

  useEffect(() => {
    fetch("http://localhost:9998/venue/fetch")
      .then((response) => response.json())
      .then((data) => setVenues(data))
      .catch((error) => console.error("Error fetching venues: ", error));
  }, []);

  return (
    <section className="venue-list">
      <h1 className="title">Available Venues</h1>
      <p className="body">Pick a venue you would like to reserve.</p>
      <table className="venue-table">
        <thead>
          <tr>
            <td>Venue Name</td>
            <td>Schedule</td>
            <td>Building</td>
            <td>Type</td>
          </tr>
        </thead>
        <tbody>
          {venues.map((venue) => (
            <tr key={venue.venueID}>
              <td>
                <Link to={`/venues/${venue.venueID}/reserve`}>
                  <span className="venue-name">{venue.venueName}</span>
                </Link>
              </td>
              <td className="venue-schedule">
                {venue.timeStart} - {venue.timeEnd}
              </td>
              <td className="venue-building">{venue.building}</td>
              <td className="venue-type">
                <span className="tag">{venue.type}</span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </section>
  );
};

export default VenueList;
