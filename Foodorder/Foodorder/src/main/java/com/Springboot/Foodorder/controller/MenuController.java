package com.Springboot.Foodorder.controller;

import com.Springboot.Foodorder.model.MenuModel;
import com.Springboot.Foodorder.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/foodorderapplication")
@CrossOrigin(origins = "http://localhost:5173") // ✅ Allows requests from React
public class MenuController {

    @Autowired
    private MenuService menuService;

    // ➤ Create a New Menu Item
    @PostMapping("/menus")
    public MenuModel addMenu(@RequestBody MenuModel menu) {
        return menuService.addMenuItem(menu);
    }

    // ➤ Update a Menu Item
    @PutMapping("/menus/{id}")
    public MenuModel updateMenu(@PathVariable Long id, @RequestBody MenuModel updatedMenu) {
        return menuService.updateMenuItem(id, updatedMenu);
    }

    // ➤ Delete a Menu Item
    @DeleteMapping("/menus/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuService.deleteMenuItem(id);
        return "Menu item deleted successfully";
    }

    // ➤ Get All Menu Items
    @GetMapping("/menus")
    public List<MenuModel> getAllMenus() {
        return menuService.getAllMenus();
    }
}
