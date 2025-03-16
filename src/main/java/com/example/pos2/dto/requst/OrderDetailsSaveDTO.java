package com.example.pos2.dto.requst;

import com.example.pos2.entity.Item;
import com.example.pos2.entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetailsSaveDTO {
    private String itemName;
    private double qty;
    private double amount;
    private int items;
    private int orders;

}
