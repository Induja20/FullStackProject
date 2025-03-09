import { useEffect, useState } from "react";
import axios from "axios";

const Menu = () => {
  const [menu, setMenu] = useState([]);
  const [newDish, setNewDish] = useState({ menuDishes: "", price: "", ratings: "" });
  const [editingItem, setEditingItem] = useState(null);

  useEffect(() => {
    axios.get("http://localhost:8080/foodorderapplication/menus")
      .then(response => setMenu(response.data))
      .catch(error => console.error("Error fetching menu:", error));
  }, []);

  const handleChange = (e) => {
    setNewDish({ ...newDish, [e.target.name]: e.target.value });
  };

  const addMenuItem = () => {
    axios.post("http://localhost:8080/foodorderapplication/menus", newDish)
      .then(response => {
        setMenu([...menu, response.data]);
        setNewDish({ menuDishes: "", price: "", ratings: "" });
      })
      .catch(error => console.error("Error adding menu item:", error));
  };

  const deleteMenuItem = (id) => {
    axios.delete(`http://localhost:8080/foodorderapplication/menus/${id}`)
      .then(() => setMenu(menu.filter(item => item.id !== id)))
      .catch(error => console.error("Error deleting menu item:", error));
  };

  const startEditing = (item) => {
    setEditingItem(item);
  };

  const handleEditChange = (e) => {
    setEditingItem({ ...editingItem, [e.target.name]: e.target.value });
  };

  const updateMenuItem = () => {
    axios.put(`http://localhost:8080/foodorderapplication/menus/${editingItem.id}`, editingItem)
      .then(response => {
        setMenu(menu.map(item => (item.id === editingItem.id ? response.data : item)));
        setEditingItem(null);
      })
      .catch(error => console.error("Error updating menu item:", error));
  };

  return (
    <div className="menu-container">
      <h2>🍽️ Our Menu</h2>
      <div className="menu-form">
        <input type="text" name="menuDishes" placeholder="Dish Name" value={newDish.menuDishes} onChange={handleChange} />
        <input type="number" name="price" placeholder="Price (₹)" value={newDish.price} onChange={handleChange} />
        <input type="number" name="ratings" placeholder="Ratings (1-5)" value={newDish.ratings} onChange={handleChange} />
        <button className="add-btn" onClick={addMenuItem}>➕ Add Dish</button>
      </div>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Dish Name</th>
            <th>Price (₹)</th>
            <th>Ratings ⭐</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {menu.map(item => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{editingItem?.id === item.id ? <input name="menuDishes" value={editingItem.menuDishes} onChange={handleEditChange} /> : item.menuDishes}</td>
              <td>{editingItem?.id === item.id ? <input name="price" type="number" value={editingItem.price} onChange={handleEditChange} /> : `₹${item.price}`}</td>
              <td>{editingItem?.id === item.id ? <input name="ratings" type="number" value={editingItem.ratings} onChange={handleEditChange} /> : `${item.ratings} ⭐`}</td>
              <td>
                {editingItem?.id === item.id ? (
                  <button onClick={updateMenuItem}>💾 Save</button>
                ) : (
                  <button onClick={() => startEditing(item)}>✏️ Edit</button>
                )}
                <button onClick={() => deleteMenuItem(item.id)}>🗑️ Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Menu;
