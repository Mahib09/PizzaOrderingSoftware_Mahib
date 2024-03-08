package com.example.pizzaorderingsoftware_mahib;

public class OrderDAO {
    private int orderId;
    private String customerName;
    private int mobileNumber;
    private String size;
    private int numberofToppings;
    private double totalBill;

   public OrderDAO(int orderId, String customerName, int mobileNumber, String size, int numberofToppings, double totalBill) {
       this.orderId=orderId;
       this.customerName=customerName;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerNumber(String customerName) {
        this.customerName = customerName;
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
