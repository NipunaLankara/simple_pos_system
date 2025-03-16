package com.example.pos2.entity;

import com.example.pos2.dto.requst.ItemSaveDTO;
import com.example.pos2.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table (name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Item {

    @Id
    @Column(name = "item_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 100,nullable = false)
    private String itemName;

    @Column(name = "measure_type",length = 255,nullable = false)
    private MeasuringUnitType measuirngUnitType;

    @Column(name = "quantity",length = 150,nullable = false)
    private int quantity;

    @Column(name = "supplier_price",length = 150,nullable = false)
    private int supplierPrice;

    @Column(name = "selling_price",length = 150,nullable = false)
    private int sellingPrice;

    @Column(name = "status",length = 10,nullable = false,columnDefinition = "TINYINT default 0")
    private boolean status;

    @OneToMany(mappedBy="items")
    private Set<OrderDetails> orderDetails;

    public Item(String itemName, MeasuringUnitType measuirngUnitType, int quantity, int supplierPrice, int sellingPrice, boolean status) {
        this.itemName = itemName;
        this.measuirngUnitType = measuirngUnitType;
        this.quantity = quantity;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
        this.status = status;
    }

}
