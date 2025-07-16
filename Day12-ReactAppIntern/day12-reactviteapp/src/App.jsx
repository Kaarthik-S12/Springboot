import { BrowserRouter, Routes, Route } from "react-router-dom";
import SignUp from "./components/SignUp";
import Login from "./components/Login";
import EmployeeList from "./components/EmployeeList";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<SignUp />} />
        <Route path="/login" element={<Login />} />
        <Route path="/employees" element={<EmployeeList />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;