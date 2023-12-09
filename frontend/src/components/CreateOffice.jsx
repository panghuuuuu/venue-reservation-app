import React, { useState, useEffect } from "react";
import "../components/CreateOffice.css"
import { useNavigate } from "react-router-dom";


const CreateOffice = () => {
    const [admin, setOffice] = useState({
        officeName: "",
        
    });

    const navigate = useNavigate();

  const handleInputChange = (e) => {
    setOffice({
      ...admin,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
        const response = await fetch("http://localhost:9998/office/create", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(admin),
        });
  
        if (response.ok) {
          const data = await response.json();
          navigate("/summaryOffice", { state: { admin: data } });
        } else {
          console.error("Error creating office");
        }
      } catch (error) {
        console.error("Error creating office: ", error);
      }

  };
    return (
        <section className="reservee-signup">
            <h1 className="title">Create Office</h1>
            <p className="body">
                Fill out the fields with the necessary information.
                <br />
            </p>
            <form
                className="signup-form"
                id="signup-form"
                onSubmit={handleSubmit}
            >
            <label>
                Office Name
                <input
                    type="text"
                    name="officeName"
                    value={admin.officeName}
                    onChange={handleInputChange}
                />
            </label>
           
                <button type="submit" className="form-button">Create Office</button>         
            </form>
            
            
        </section>
    )


}
export default CreateOffice;