import React, { useState } from "react";
import "./App.css";
import axios from "axios";

function App() {
  const [reserveeID, setReserveeID] = useState("");
  const [userData, setUserData] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);

  const fetchUserData = async () => {
    try {
      setLoading(true);
      const response = await axios.get(
        `http://localhost:9997/reservee/view?reserveeID=${reserveeID}`
      );
      setUserData(response.data);
    } catch (error) {
      console.error("Error fetching user data:", error);
      setError("An error occurred while fetching data.");
    } finally {
      setLoading(false);
    }
  };

  const handleButtonClick = () => {
    fetchUserData();
  };

  return (
    <div className="App">
      <header className="App-header">
        <label>
          Enter Reservee ID:
          <input
            type="text"
            value={reserveeID}
            onChange={(e) => setReserveeID(e.target.value)}
          />
        </label>
        <button onClick={handleButtonClick} disabled={loading}>
          {loading ? "Fetching..." : "Fetch User Data"}
        </button>
        {error ? (
          <div>
            <p>{error}</p>
          </div>
        ) : (
          userData && (
            <div>
              <h2>User Information</h2>
              <p>{JSON.stringify(userData, null, 2)}</p>
            </div>
          )
        )}
      </header>
    </div>
  );
}

export default App;
