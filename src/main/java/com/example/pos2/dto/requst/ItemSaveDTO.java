package com.example.pos2.dto.requst;

import com.example.pos2.entity.enums.MeasuringUnitType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemSaveDTO {
    private int itemId;
    private String itemName;
    private MeasuringUnitType measuirngUnitType;
    private int quantity;
    private int supplierPrice;
    private int sellingPrice;
}
