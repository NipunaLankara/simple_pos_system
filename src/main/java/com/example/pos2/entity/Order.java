package com.example.pos2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table (name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name ="order_date",columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total_amount",length = 100,nullable = false)
    private double totalAmount;

    @Column(name = "order_status",length = 10,nullable = false,columnDefinition = "TINYINT default 0")
    private boolean orderStatus;

    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetails;

    public Order(Customer customer, Date date, double totalAmount) {
        this.customer = customer;
        this.date = date;
        this.totalAmount = totalAmount;
    }
}
