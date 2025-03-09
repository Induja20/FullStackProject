package com.Springboot.Foodorder.service;

import com.Springboot.Foodorder.model.MenuModel;
import com.Springboot.Foodorder.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    // ✅ Create a New Menu Item
    public MenuModel addMenuItem(MenuModel menu) {
        return menuRepository.save(menu);
    }

    // ✅ Update a Menu Item
    public MenuModel updateMenuItem(Long id, MenuModel updatedMenu) {
        Optional<MenuModel> existingMenuOptional = menuRepository.findById(id);
        if (existingMenuOptional.isPresent()) {
            MenuModel existingMenu = existingMenuOptional.get();
            existingMenu.setMenuDishes(updatedMenu.getMenuDishes());
            existingMenu.setPrice(updatedMenu.getPrice());
            existingMenu.setRatings(updatedMenu.getRatings());
            return menuRepository.save(existingMenu);
        }
        return null;
    }

    // ✅ Delete a Menu Item
    public void deleteMenuItem(Long id) {
        menuRepository.deleteById(id);
    }

    // ✅ Get All Menu Items
    public List<MenuModel> getAllMenus() {
        return menuRepository.findAll();
    }
}
