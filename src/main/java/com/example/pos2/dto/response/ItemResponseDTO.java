package com.example.pos2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemResponseDTO {
    private int itemId;
    private String itemName;
    private int quantity;
    private int supplierPrice;
    private int sellingPrice;
    private boolean status;
}
