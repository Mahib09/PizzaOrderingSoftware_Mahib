package com.example.pizzaorderingsoftware_mahib;

public class OrderDAO {
    private int orderId;
    private String customerNumber;
    private int mobileNumber;
    private String size;
    private int numberofToppings;
    private double totalBill;

   public OrderDAO(int orderId, String customerNumber, int mobileNumber, String size, int numberofToppings, double totalBill) {
       this.orderId=orderId;
       this.customerNumber=customerNumber;
       this.mobileNumber=mobileNumber;
       this.size=size;
       this.numberofToppings=numberofToppings;
       this.totalBill=totalBill;
   }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNumberofToppings() {
        return numberofToppings;
    }

    public void setNumberofToppings(int numberofToppings) {
        this.numberofToppings = numberofToppings;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}
