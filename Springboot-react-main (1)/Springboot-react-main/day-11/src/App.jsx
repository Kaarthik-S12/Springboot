import { useState } from "react";
import Login from "./components/Login";
import Register from "./components/Signup";

function App() {
  const [showLogin, setShowLogin] = useState(true);

  return (
    <div>
      <h1>Auth App</h1>
      <button onClick={() => setShowLogin(true)}>Login</button>
      <button onClick={() => setShowLogin(false)}>Signup</button>
      <hr />
      {showLogin ? <Login /> : <Signup />}
    </div>
  );
}

export default App;
