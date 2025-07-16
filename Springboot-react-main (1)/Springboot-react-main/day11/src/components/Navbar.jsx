import React from "react";

const Navbar = ({ onLoginClick, onRegisterClick, activeTab }) => {
  return (
    <nav className="bg-blue-600 text-white p-4 flex justify-between items-center shadow-md">
      <div className="text-2xl font-bold">Auth App</div>
      <div className="space-x-4">
        <button
          onClick={onLoginClick}
          className={`px-4 py-2 rounded ${
            activeTab === "login" ? "bg-white text-blue-600" : "hover:bg-blue-500"
          }`}
        >
          Login
        </button>
        <button
          onClick={onRegisterClick}
          className={`px-4 py-2 rounded ${
            activeTab === "register" ? "bg-white text-blue-600" : "hover:bg-blue-500"
          }`}
        >
          Register                                                            //23EC054
        </button>
      </div>
    </nav>
  );
};

export default Navbar;
