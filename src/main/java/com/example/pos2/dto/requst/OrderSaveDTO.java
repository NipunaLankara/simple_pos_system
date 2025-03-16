package com.example.pos2.dto.requst;

import com.example.pos2.entity.Customer;
import com.example.pos2.entity.OrderDetails;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderSaveDTO {
    private int customer;
    private Date date;
    private double totalAmount;
    private boolean orderStatus;
    private List<OrderDetailsSaveDTO> orderDetails;


}


