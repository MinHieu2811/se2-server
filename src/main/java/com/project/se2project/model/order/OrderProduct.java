package com.project.se2project.model.order;

import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderProduct {
  public UUID id;
    public int amount;

    public OrderProduct() {
    }

    public OrderProduct(UUID id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
