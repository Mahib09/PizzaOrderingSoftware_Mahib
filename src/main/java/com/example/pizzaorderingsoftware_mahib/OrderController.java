package com.example.pizzaorderingsoftware_mahib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

   
    public static double billCalculation(String size , int numtopping){
         double XL=15;
         double L=12;
         double M=10;
         double S=8;
         double topping=1.5;
         double hst=0.15;
         double totalbill;
         if(size=="XL") {
             double bill = (XL + (topping * numtopping));
             totalbill=bill*hst+bill;
             return totalbill;
         } else if (size=="L") {
             double bill = (L + (topping * numtopping));
             totalbill=bill*hst+bill;
             return totalbill;
         } else if (size=="M") {
             double bill = (M + (topping * numtopping));
             totalbill=bill*hst+bill;
             return totalbill;
         }else{
             double bill = (S + (topping * numtopping));
             totalbill=bill*hst+bill;
             return totalbill;
         }
    }

    }