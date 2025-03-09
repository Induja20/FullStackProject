package com.Springboot.Foodorder.repository;



import com.Springboot.Foodorder.model.OrderModel;

import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<OrderModel, Long> {

}

