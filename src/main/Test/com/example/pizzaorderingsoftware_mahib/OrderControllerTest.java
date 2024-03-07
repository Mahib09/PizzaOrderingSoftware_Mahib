package com.example.pizzaorderingsoftware_mahib;

import javafx.fxml.Initializable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest{
    @Test
    void billCalculation() {
        OrderController x=new OrderController();
    assertEquals(x.billCalculation("L",3),18.975);
    }
}