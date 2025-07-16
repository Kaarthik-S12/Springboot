import React, { useState } from "react";

const Login = () => {
  const [formData, setFormData] = useState({
    email: "",
    password: "",
    roles: [],
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    if (type === "checkbox") {
      setFormData((prev) => {
        const roles = checked
          ? [...prev.roles, value]
          : prev.roles.filter((role) => role !== value);
        return { ...prev, roles };
      });
    } else {
      setFormData((prev) => ({ ...prev, [name]: value }));                                          //23EC054
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Login Data:", formData);
    alert("Logged In Successfully!");
    setFormData({ email: "", password: "", roles: [] });
  };

  return (
    <>
      <h2 className="text-2xl font-bold mb-4 text-center">Login</h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleChange}
          placeholder="Email"
          required
          className="w-full p-2 border rounded"
        />
        <input
          type="password"
          name="password"
          value={formData.password}
          onChange={handleChange}
          placeholder="Password"
          required
          className="w-full p-2 border rounded"
        />
        <div className="flex space-x-4">
          <label className="flex items-center space-x-1">
            <input
              type="checkbox"
              value="ROLE_ADMIN"
              checked={formData.roles.includes("ROLE_ADMIN")}
              onChange={handleChange}
            />
            <span>Admin</span>
          </label>
          <label className="flex items-center space-x-1">
            <input
              type="checkbox"
              value="ROLE_USER"
              checked={formData.roles.includes("ROLE_USER")}
              onChange={handleChange}
            />
            <span>User</span>
          </label>
        </div>
        <button
          type="submit"
          className="w-full bg-blue-500 text-white py-2 rounded hover:bg-blue-600 transition"
        >
          Login
        </button>
      </form>
    </>
  );
};

export default Login;
