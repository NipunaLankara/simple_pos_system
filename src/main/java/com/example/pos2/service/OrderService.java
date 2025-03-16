package com.example.pos2.service;

import com.example.pos2.dto.requst.OrderSaveDTO;

public interface OrderService {
    String saveOrder(OrderSaveDTO orderSaveDTO);
}
