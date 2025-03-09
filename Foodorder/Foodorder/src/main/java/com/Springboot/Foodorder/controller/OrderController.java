package com.Springboot.Foodorder.controller;
import com.Springboot.Foodorder.model.OrderModel;
import com.Springboot.Foodorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/foodorderapplication")

public class OrderController {


    @Autowired

    private OrderRepository orderRepository;



    // ➤ Place an Order

    @PostMapping("/payment-ordering-details")

    public OrderModel placeOrder(@RequestBody OrderModel order) {

        return orderRepository.save(order);

    }



    // ➤ Update an Order

    @PutMapping("/payment-ordering-details/{id}")

    public OrderModel updateOrder(@PathVariable Long id, @RequestBody OrderModel updatedOrder) {

        OrderModel order = orderRepository.findById(id)

                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setUsername(updatedOrder.getUsername());

        order.setAddressLocation(updatedOrder.getAddressLocation());

        order.setContactNumber(updatedOrder.getContactNumber());

        order.setOrderedPrice(updatedOrder.getOrderedPrice());

        order.setOrderedItem(updatedOrder.getOrderedItem()); // ✅ Updates ordered item

        return orderRepository.save(order);

    }


    // ➤ Delete an Order

    @DeleteMapping("/payment-ordering-details/{id}")

    public String deleteOrder(@PathVariable Long id) {

        orderRepository.deleteById(id);

        return "Order deleted successfully";

    }



    // ➤ Get All Orders

    @GetMapping("/payment-ordering-details")

    public List<OrderModel> getAllOrders() {

        return orderRepository.findAll();

    }

}