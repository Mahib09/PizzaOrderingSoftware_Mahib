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

    @FXML
    private TextField inputName;
    @FXML
    private TextField inputNumber;
    @FXML
    private CheckBox sizeXL;
    @FXML
    private CheckBox sizeL;
    @FXML
    private CheckBox sizeM;
    @FXML
    private CheckBox sizeS;
    @FXML
    private TextField inputNoOfToppings;
    @FXML
    private TableView<OrderDAO> tbl_view;
    @FXML
    private TableColumn<OrderDAO, Integer> tbl_orderId;
    @FXML
    private TableColumn<OrderDAO, String> tbl_name;
    @FXML
    private TableColumn<OrderDAO, Integer> tbl_number;
    @FXML
    private TableColumn<OrderDAO, String> tbl_size;
    @FXML
    private TableColumn<OrderDAO, Integer> tbl_numberOfToppings;
    @FXML
    private TableColumn<OrderDAO, Double> tbl_totalBill;

    ObservableList<OrderDAO> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tbl_orderId.setCellValueFactory(new PropertyValueFactory<OrderDAO, Integer>("orderId"));
        tbl_name.setCellValueFactory(new PropertyValueFactory<OrderDAO, String>("customerName"));
        tbl_number.setCellValueFactory(new PropertyValueFactory<OrderDAO, Integer>("mobileNumber"));
        tbl_size.setCellValueFactory(new PropertyValueFactory<OrderDAO, String>("size"));
        tbl_numberOfToppings.setCellValueFactory(new PropertyValueFactory<OrderDAO, Integer>("numberofToppings"));
        tbl_totalBill.setCellValueFactory(new PropertyValueFactory<OrderDAO, Double>("totalBill"));
    }
    String jdbcUrl = "jdbc:mysql://localhost:3306/csd214_mahib_test3";
    String dbUser = "root";
    String dbPassword = "";

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