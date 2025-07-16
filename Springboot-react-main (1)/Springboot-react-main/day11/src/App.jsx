import { useState } from "react";
import Login from "./components/Login";
import Register from "./components/Signup";
import Navbar from "./components/Navbar";

function App() {
  const [activeTab, setActiveTab] = useState("login");

  return (
    <div>
      <Navbar
        onLoginClick={() => setActiveTab("login")}
        onRegisterClick={() => setActiveTab("register")}
        activeTab={activeTab}
      />
      <div className="p-4">
        {activeTab === "login" ? <Login /> : <Register />}    //23EC054
      </div>
    </div>
  );
}

export default App;
