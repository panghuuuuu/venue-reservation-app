import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:9997/",
  headers: {
    "Content-Type": "application/json",
  },
  withCredentials: true,
});
