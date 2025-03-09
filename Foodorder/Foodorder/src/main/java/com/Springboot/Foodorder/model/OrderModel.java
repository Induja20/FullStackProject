package com.Springboot.Foodorder.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class OrderModel {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "address_location", nullable = false)
    private String addressLocation;
    @Column(name = "contact_number", nullable = false)
    private String contactNumber;
    @Column(name = "ordered_price", nullable = false)
    private double orderedPrice;
    @Column(name = "ordered_item", nullable = false)
    private String orderedItem; // ✅ Stores ordered menu dishes

}

