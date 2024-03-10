package com.project.se2project.model.order;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
  private String id;
  private UUID customerId;
  private OrderStatus orderStatus;
  private Date date;
  private OrderPayment orderPayment;
  private String address;
  private List<OrderProduct> orderProducts;

  public Order(String id, UUID cusUuid, OrderStatus orderStatus, Date date, OrderPayment orderPayment, String address, List<OrderProduct> orderProducts ) {
    this.id = id;
    this.address = address;
    this.date = date;
    this.customerId = cusUuid;
    this.orderPayment = orderPayment;
    this.orderProducts = orderProducts;
    this.orderStatus = orderStatus;
  }

  public String getId() {
    return id;
  }

  public UUID getCustomerId() {
    return customerId;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public OrderPayment getOrderPayment() {
    return orderPayment;
  }

  public Date getOrerDate() {
    return date;
  }

  public String getOrderAddress() {
    return address;
  }

  public List<OrderProduct> getListOrderProduct() {
    return orderProducts;
  }

  // SET
  public void setCustomerId(UUID cusId) {
    this.customerId = cusId;
  }

  public void setOrderStatus(OrderStatus status) {
    this.orderStatus = status;
  }

  public void setOrderPayment(OrderPayment payment) {
    this.orderPayment = payment;
  }

  public void setOrerDate(Date orderDate) {
    this.date = orderDate;
  }

  public void setOrderAddress(String orderAddress) {
    this.address = orderAddress;
  }

  public void setListOrderProduct(List<OrderProduct> products) {
    this.orderProducts = products;
  }
}
