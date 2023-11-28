import React, { useState } from "react";
import TextField from "@mui/material/TextField";
import axios from "axios";

const CreateReserveeAccount = () => {
  const [formData, setFormData] = useState({
    schoolID: "",
    type: "",
    firstName: "",
    lastName: "",
  });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const createUser = async () => {
    try {
      setLoading(true);
      const response = await axios.post(
        "http://localhost:9997/reservee/createaccount",
        formData
      );
      console.log("User created successfully:", response.data);
    } catch (error) {
      console.error("Error creating user:", error);
      setError("An error occurred while creating the user.");
    } finally {
      setLoading(false);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    createUser();
  };

  return (
    <form onSubmit={handleSubmit}>
      <TextField
        label="School ID"
        name="schoolID"
        value={formData.schoolID}
        onChange={handleChange}
      />
      <TextField
        label="Type"
        name="type"
        value={formData.type}
        onChange={handleChange}
      />
      <TextField
        label="First Name"
        name="firstName"
        value={formData.firstName}
        onChange={handleChange}
      />
      <TextField
        label="Last Name"
        name="lastName"
        value={formData.lastName}
        onChange={handleChange}
      />
      <button type="submit">Submit</button>
      {error && <p style={{ color: "red" }}>{error}</p>}
    </form>
  );
};

export default CreateReserveeAccount;
