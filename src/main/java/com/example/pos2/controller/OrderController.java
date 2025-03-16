package com.example.pos2.controller;

import com.example.pos2.dto.requst.OrderSaveDTO;
import com.example.pos2.service.OrderService;
import com.example.pos2.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("api/v1/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save-1")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody OrderSaveDTO orderSaveDTO){
        String message = orderService.saveOrder(orderSaveDTO);

        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED);
        return response;
    }
}
