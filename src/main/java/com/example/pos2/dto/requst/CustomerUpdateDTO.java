package com.example.pos2.dto.requst;

public class CustomerUpdateDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private int contactNumber;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(int customerId, String customerName, String customerAddress, int contactNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.contactNumber = contactNumber;
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

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
