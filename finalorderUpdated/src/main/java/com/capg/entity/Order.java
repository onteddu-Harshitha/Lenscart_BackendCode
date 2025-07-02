package com.capg.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long orderId;

   private Long customerId;
   private String address;
   private String pincode;
   private LocalDateTime orderDateTime;
   private double totalAmount; // This is now discounted total
   @Enumerated(EnumType.STRING) // Use EnumType.STRING to store enum as a string in the DB
   private PaymentStatus paymentStatus; // PENDING, COMPLETED, FAILED

   @Enumerated(EnumType.STRING) // Use EnumType.STRING to store enum as a string in the DB
   private OrderStatus orderStatus; // PROCESSING, SHIPPED, DELIVERED
}