import React, { useState } from "react";
import axios from "axios";
import "../styles/Order.css";

const Order = () => {
  const [order, setOrder] = useState({
    username: "",
    addressLocation: "",
    contactNumber: "",
    orderedItem: "",
    orderedPrice: 0,
  });

  const placeOrder = () => {
    axios.post("http://localhost:8080/foodorderapplication/payment-ordering-details", order)
      .then(() => alert("Order placed successfully!"))
      .catch(error => console.error("Error placing order:", error));
  };

  return (
    <div className="order-container">
      <h2>Place Your Order</h2>
      <input type="text" placeholder="Username" onChange={(e) => setOrder({ ...order, username: e.target.value })} />
      <input type="text" placeholder="Address" onChange={(e) => setOrder({ ...order, addressLocation: e.target.value })} />
      <input type="text" placeholder="Contact Number" onChange={(e) => setOrder({ ...order, contactNumber: e.target.value })} />
      <input type="text" placeholder="Ordered Item" onChange={(e) => setOrder({ ...order, orderedItem: e.target.value })} />
      <input type="number" placeholder="Price" onChange={(e) => setOrder({ ...order, orderedPrice: parseFloat(e.target.value) })} />
      <button onClick={placeOrder}>Place Order</button>
    </div>
  );
};

export default Order;
