import { useState } from "react";
import axios from "axios";

const Register = () => {
  const [formData, setFormData] = useState({
    empId: "",
    name: "",
    email: "",
    password: "",
    userName: "",
    roleNames: [],
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleRolesChange = (e) => {
    const rolesArray = e.target.value
      .split(",")
      .map((role) => role.trim())
      .filter((role) => role !== "");
    setFormData((prev) => ({
      ...prev,
      roleNames: rolesArray,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();                                             //23EC054
    try {
      await axios.post("http://localhost:8080/signup", {
        ...formData,
        empId: Number(formData.empId),
      });
      alert("Registered Successfully!");
    } catch (error) {
      console.error("Registration Error:", error);
      alert("Registration Failed!");
    }
  };

  return (
    <div>
      <h2>Signup</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          name="empId"
          value={formData.empId}
          onChange={handleChange}
          placeholder="Employee ID"
          required
        />
        <br /><br />
        <input
          type="text"
          name="name"
          value={formData.name}
          onChange={handleChange}
          placeholder="Full Name"
          required
        />
        <br /><br />
        <input
          type="text"
          name="userName"
          value={formData.userName}
          onChange={handleChange}
          placeholder="Username"
          required
        />
        <br /><br />
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
          placeholder="Email"
          required
        />
        <br /><br />
        <input
          type="password"
          name="password"
          value={formData.password}
          onChange={handleChange}
          placeholder="Password"
          required
        />
        <br /><br />
        <input
          type="text"
          name="roleNames"
          onChange={handleRolesChange}
          placeholder="Roles (comma separated)"
        />
        <br /><br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default Register;
