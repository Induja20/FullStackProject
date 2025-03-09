package com.Springboot.Foodorder.service;



import com.Springboot.Foodorder.model.OrderModel;

import com.Springboot.Foodorder.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import java.util.List;

import java.util.Optional;



@Service

public class OrderService {



    @Autowired

    private OrderRepository orderRepository;



    // ➤ Place an Order

    public OrderModel placeOrder(OrderModel order) {

        return orderRepository.save(order);

    }



    // ➤ Update an Order

    public OrderModel updateOrder(Long id, OrderModel updatedOrder) {

        Optional<OrderModel> order = orderRepository.findById(id);

        if (order.isPresent()) {

            OrderModel existingOrder = order.get();

            existingOrder.setUsername(updatedOrder.getUsername());

            existingOrder.setAddressLocation(updatedOrder.getAddressLocation());

            existingOrder.setContactNumber(updatedOrder.getContactNumber());

            existingOrder.setOrderedPrice(updatedOrder.getOrderedPrice());

            existingOrder.setOrderedItem(updatedOrder.getOrderedItem());

            return orderRepository.save(existingOrder);

        } else {

            throw new RuntimeException("Order not found");

        }

    }



    // ➤ Delete an Order

    public void deleteOrder(Long id) {

        orderRepository.deleteById(id);

    }



	public List<OrderModel> getAllOrders() {

		// TODO Auto-generated method stub

		return null;

	}

}