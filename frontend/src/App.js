
import React, { useState } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./components/Header";
import Home from "./components/Home";
import VenueList from "./components/VenuesList";
import RequestForm from "./components/RequestForm";
import ReservationList from "./components/ReservationList";
import Success from "./components/Success";

function App() {
  return (
    <div className="app-class">
      <Header />
      <BrowserRouter>
        <Routes>
          <Route path="/">
            <Route index element={<Home />} />
            <Route path="venues" element={<VenueList />} /> 
            <Route path="venues/:id/reserve" element={<RequestForm />} />
            <Route path="success" element={<Success />} />
            <Route path="reservations" element={<ReservationList />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
