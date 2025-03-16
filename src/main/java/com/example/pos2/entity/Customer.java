package com.example.pos2.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name = "customer")



public class Customer {

    @Id
    @Column (name = "customer_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column (name = "customer_name",length = 100)
    private String customerName;

    @Column (name = "customer_address",length = 200)
    private String customerAddress;

    @Column (name = "contact_number",length = 15)
    private int contactNumber;

    @Column (name ="nic")
    private String nic;

    @Column (name = "status",columnDefinition = "TINYINT default 0")
    private boolean status;

    @OneToMany(mappedBy="customer")
    private Set<Order> orders;

    public Customer() {
    }



    public Customer(int customerId, String customerName, String customerAddress, int contactNumber, String nic, boolean status) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                ", status=" + status +
                '}';
    }
}
