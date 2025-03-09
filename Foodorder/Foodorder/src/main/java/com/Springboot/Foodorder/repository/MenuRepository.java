package com.Springboot.Foodorder.repository;

import com.Springboot.Foodorder.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel, Long> {
}
