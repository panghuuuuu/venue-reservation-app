import React, { useState } from "react";
import "../components/EquipmentsList.css";
import { useNavigate } from "react-router-dom";

function EquipmentsList() {
  const [equipment, setEquipment] = useState({
    reservationID: 0,
    tables: 0,
    chairs: 0,
    extensions: 0,
    projectors: 0,
    projectorScreens: 0,
    microphones: 0,
    speakers: 0,
  });

  const navigate = useNavigate();

  const handleInputChange = (e) => {
    setEquipment({
      ...equipment,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch("http://localhost:9998/equipment/create", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(equipment),
      });

      if (response.ok) {
        const data = await response.json();
        navigate("/summary", { state: { reservation: data } });
      } else {
        console.error("Error creating equipment");
      }
    } catch (error) {
      console.error("Error creating equipment: ", error);
    }
  };

  return (
    <section className="reserve-equipment">
      <h1 className="title">Equipments Request Form</h1>
      <p className="body">
        Fill out the fields with the necessary information.
        <br />
      </p>
      <form
        className="reservation-request-form"
        id="reservation-request-form"
        onSubmit={handleSubmit}
      >
        <label>
          Reservation ID
          <input
            type="number"
            name="reservationID"
            value={equipment.reservationID}
            onChange={handleInputChange}
          />
        </label>
        <label>
          Tables{" "}
          <input
            type="number"
            name="tables"
            value={equipment.tables}
            onChange={handleInputChange}
          />
        </label>
        <label>
          Chairs{" "}
          <input
            type="text"
            name="chairs"
            value={equipment.chairs}
            onChange={handleInputChange}
          />
        </label>
        <label>
          Extension Cords{" "}
          <input
            type="text"
            name="extensions"
            value={equipment.extensions}
            onChange={handleInputChange}
          />
        </label>
        <label>
          Projectors{" "}
          <input
            type="text"
            name="projectors"
            value={equipment.projectors}
            onChange={handleInputChange}
          />
        </label>
        <label>
          Projector Screens{" "}
          <input
            type="text"
            name="projectorScreens"
            value={equipment.projectorScreens}
            onChange={handleInputChange}
          />
        </label>
        <label>
          Microphones{" "}
          <input
            type="text"
            name="microphones"
            value={equipment.microphones}
            onChange={handleInputChange}
          />
        </label>
        <label>
          Speakers{" "}
          <input
            type="text"
            name="speakers"
            value={equipment.speakers}
            onChange={handleInputChange}
          />
        </label>
        <button type="submit" className="form-button">
          Submit
        </button>
      </form>
    </section>
  );
}

export default EquipmentsList;
