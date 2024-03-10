package com.project.se2project.repository.order;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.se2project.model.order.Order;
import com.project.se2project.model.order.OrderPayment;
import com.project.se2project.model.order.OrderProduct;
import com.project.se2project.model.order.OrderStatus;
import com.project.se2project.repository.order.model.OrderRepositoryModel;
import com.project.se2project.utils.DateFormatter;

@Component("orderRepository")
public class OrderRepository {
  @Autowired
  private OrderRepositoryJPA orderRepositoryJPA;

  public void saveOrder(Order order) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      orderRepositoryJPA.save(new OrderRepositoryModel(
          order.getId(),
          order.getCustomerId().toString(),
          order.getOrderStatus().toString(),
          DateFormatter.formatDate(order.getOrderDate()),
          order.getOrderPayment().toString(),
          order.getOrderAddress(),
          mapper.writeValueAsString(order.getListOrderProduct())));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Order getOrderById(String id) {
    return orderRepositoryJPA.findById(id).map(this::mapOrder).orElse(null);
  }

  public List<Order> getOrders(UUID customerId) {
    List<OrderRepositoryModel> orders = orderRepositoryJPA.findByCustomerId(customerId.toString());
    return orders.stream().map(this::mapOrder).toList();
  }

  public List<Order> getAllOrders() {
    List<OrderRepositoryModel> orders = orderRepositoryJPA.findAll();
    return orders.stream().map(this::mapOrder).toList();
  }

  private Order mapOrder(OrderRepositoryModel orderFromDatabase) {
    try {
      List<OrderProduct> orderProduct = new ObjectMapper().readValue(orderFromDatabase.products, new TypeReference<>() {
      });
      return new Order(
          orderFromDatabase.id,
          UUID.fromString(orderFromDatabase.customerId),
          OrderStatus.valueOf(orderFromDatabase.status),
          DateFormatter.parseDate(orderFromDatabase.date),
          OrderPayment.valueOf(orderFromDatabase.payment),
          orderFromDatabase.address,
          orderProduct);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
