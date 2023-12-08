import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./components/Header";
import Home from "./components/Home";
import VenueList from "./components/VenuesList";
import RequestForm from "./components/RequestForm";
import ReservationList from "./components/ReservationList";
import Success from "./components/Success";
import EquipmentsList from "./components/EquipmentsList";
import Summary from "./components/Summary";

function App() {
  return (
    <div className="app-class">
      <Header />
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="venues" element={<VenueList />} />
          <Route path="venues/:id/reserve" element={<RequestForm />} />
          <Route path="success" element={<Success />} />
          <Route path="reservations" element={<ReservationList />} />
          <Route path="equipments" element={<EquipmentsList />} />
          <Route path="summary" element={<Summary />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
