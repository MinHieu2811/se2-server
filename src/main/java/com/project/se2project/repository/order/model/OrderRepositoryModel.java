package com.project.se2project.repository.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class OrderRepositoryModel {
  @Column(nullable = false, length = 100)
  @Id
  public String id;
  public String customerId;
  public String status;
  public String date;
  public String payment;
  public String address;
  public String products;

  public OrderRepositoryModel(
      String id,
      String customerId,
      String status,
      String date,
      String payment,
      String address,
      String products) {
    this.id = id;
    this.customerId = customerId;
    this.status = status;
    this.date = date;
    this.payment = payment;
    this.address = address;
    this.products = products;
  }

  public OrderRepositoryModel() {

  }
}
