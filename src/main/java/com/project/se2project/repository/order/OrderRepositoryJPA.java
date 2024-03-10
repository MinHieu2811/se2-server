package com.project.se2project.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.se2project.repository.order.model.OrderRepositoryModel;

public interface OrderRepositoryJPA extends JpaRepository<OrderRepositoryModel, String> {
  List<OrderRepositoryModel> findByCustomerId(String cusId);
}
