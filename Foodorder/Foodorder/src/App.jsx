import React from "react";
import { Routes, Route, NavLink } from "react-router-dom";
import Menu from "./components/Menu";
import Order from "./components/Order";
import Login from "./components/Login";
import "./styles/App.css";  // Import styles

const App = () => {
  return (
    <div className="app-container"> 
      <nav className="nav">
        <NavLink to="/" className="link">Menu</NavLink> | 
        <NavLink to="/order" className="link">Place Order</NavLink> | 
        <NavLink to="/login" className="link">Login</NavLink>
      </nav>

      <Routes>
        <Route path="/" element={<Menu />} />
        <Route path="/order" element={<Order />} />
        <Route path="/login" element={<Login />} />
        <Route path="*" element={<h2>Page Not Found</h2>} />
      </Routes>
    </div>
  );
};

export default App;
