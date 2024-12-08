package com.bd.pdv.models.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order", schema = "ventas")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "clientid")
    private int clientId;

    @NotNull
    private float quantity;

    @NotNull
    private float total;

    @NotNull
    private int paymentstatus;
    private float balance;

    @OneToMany(mappedBy = "orderId", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<OrderDetail> orderDetail = new HashSet<>();

    public Order() {
    }

    public Order(Long id, int clientId, float quantity, float total, int paymentstatus, float balance) {
        this.id = id;
        this.clientId = clientId;
        this.quantity = quantity;
        this.total = total;
        this.paymentstatus = paymentstatus;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(int paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Set<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Set<OrderDetail> details) {
        this.orderDetail = details;
    }
}
