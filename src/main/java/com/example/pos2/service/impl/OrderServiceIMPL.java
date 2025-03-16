package com.example.pos2.service.impl;

import com.example.pos2.dto.requst.OrderSaveDTO;
import com.example.pos2.entity.Order;
import com.example.pos2.entity.OrderDetails;
import com.example.pos2.repo.CustomerRepo;
import com.example.pos2.repo.ItemRepo;
import com.example.pos2.repo.OrderDetailsRepo;
import com.example.pos2.repo.OrderRepo;
import com.example.pos2.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public String saveOrder(OrderSaveDTO orderSaveDTO) {
        Order order = new Order(
                customerRepo.getReferenceById(orderSaveDTO.getCustomer()),
                orderSaveDTO.getDate(),
                orderSaveDTO.getTotalAmount()
        );
        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())) {
            List<OrderDetails> orderDetails = modelMapper.map(orderSaveDTO.getOrderDetails(),
                    new TypeToken<List<OrderDetails>>(){}.getType()
            );

            for (int i=0;i<orderDetails.size();i++){
                orderDetails.get(i).setOrders(order); // set order object using loop
                int itemId = orderSaveDTO.getOrderDetails().get(i).getItems(); // Catch item id for get item object
                orderDetails.get(i).setItems(itemRepo.getReferenceById(itemId)); // set item object using loop
            }

            if (orderDetails.size()>0) {
                orderDetailsRepo.saveAll(orderDetails);
                return "Order Saved";

            } else {
                throw new RuntimeException("Save Failed");
            }

        } else {
            throw new RuntimeException("Save Failed");
        }
    }


}
