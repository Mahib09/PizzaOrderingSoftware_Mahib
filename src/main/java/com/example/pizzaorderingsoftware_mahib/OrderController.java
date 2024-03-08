package com.example.pizzaorderingsoftware_mahib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class OrderController implements Initializable {
    @FXML
    private Label lblMessage;
    @FXML
    private TextField inputOrderId;
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputNumber;
    @FXML
    private RadioButton sizeXL;
    @FXML
    private RadioButton sizeL;
    @FXML
    private RadioButton sizeM;
    @FXML
    private RadioButton sizeS;
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
    String size;
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

    @FXML
    protected void onReadButtonClicked() {populateTable();}
    @FXML
    protected void onInsertButtonClicked() {insertData();}
    @FXML
    protected void onUpdateButtonClicked() {updateData();}
    @FXML
    protected void onDeleteButtonClicked() {deleteData();}
    @FXML
    protected void onLoadButtonClicked() {loadData();}

    public void populateTable(){
        tbl_view.getItems().clear();
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "SELECT * FROM `orderinformation`";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int tbl_orderId = resultSet.getInt("orderId");
                String tbl_name = resultSet.getString("customerName");
                int tbl_number = resultSet.getInt("mobileNumber");
                String tbl_size=resultSet.getString("size");
                int tbl_numberOfToppings=resultSet.getInt("numberofToppings");
                double tbl_totalBill=resultSet.getDouble("totalBill");
                tbl_view.getItems().add(new OrderDAO(tbl_orderId,tbl_name,tbl_number,tbl_size,tbl_numberOfToppings,tbl_totalBill));
            }     } catch (SQLException e) {
            e.printStackTrace();     }
    }
    public void insertData() {
        getSelectedSizeRadioButton();
    if(size=="none"){
        lblMessage.setText("Please Select The size");
    }else{
        if (Integer.parseInt(inputNoOfToppings.getText())!=0) {
            double totalBill = billCalculation(size, Integer.parseInt(inputNoOfToppings.getText()));

            if (inputName.getText().isEmpty()) {
                lblMessage.setText("Name Required to Insert");
            } else {
                try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                    String query = "INSERT INTO `orderinformation` (`orderId`, `customerName`, `mobileNumber`, `size`, `numberofToppings`, `totalBill`) VALUES (NULL, '" + inputName.getText() + "', '" + inputNumber.getText() + "', '" + size + "', '" + inputNoOfToppings.getText() + "', '" + totalBill + "')";
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);
                    populateTable();
                    clearForm();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            lblMessage.setText("Number of Toppings Should be one or more!");
        }
    }


    }


    public void updateData() {
        getSelectedSizeRadioButton();
        if (size == "none") {
            lblMessage.setText("Please Select The size");
        } else {
            if (Integer.parseInt(inputNoOfToppings.getText()) != 0) {
                double totalBill = billCalculation(size, Integer.parseInt(inputNoOfToppings.getText()));
                if (inputOrderId.getText().isEmpty()) {
                    lblMessage.setText("Please Enter Id to Update");
                } else {
                    try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                        String query = ("UPDATE orderinformation SET customerName ='" + inputName.getText() + "' , mobileNumber='" + inputNumber.getText() + "',size='" + size + "',numberofToppings='" + inputNoOfToppings.getText() + "',totalBill='" + totalBill + "'  WHERE orderId='" + inputOrderId.getText() + "';");

                        Statement statement = connection.createStatement();
                        statement.executeUpdate(query);
                        populateTable();
                        clearForm();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public void deleteData(){
        if(inputOrderId.getText().isEmpty()){
            lblMessage.setText("Please Enter Id to Delete");
        }else{
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                String query = ("DELETE FROM orderinformation WHERE orderId='"+inputOrderId.getText()+"'");
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
                populateTable();
                clearForm();
            } catch (SQLException e) {
                e.printStackTrace();     }
        }
    }
    public void loadData(){
        if(inputOrderId.getText().isEmpty()){
            lblMessage.setText("Please Enter Id to Load");
        }else{try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = ("SELECT * FROM orderinformation WHERE orderId='"+inputOrderId.getText()+"'");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            if (resultSet.getString("orderId").isEmpty()){
                lblMessage.setText("No Orders Found");
            }else {
                inputName.setText(resultSet.getString("customerName"));
                inputNumber.setText(resultSet.getString("mobileNumber"));
                if (resultSet.getString("size").equals("XL")) {
                    sizeXL.setSelected(true);
                } else if (resultSet.getString("size").equals("L")) {
                    sizeL.setSelected(true);
                } else if (resultSet.getString("size").equals("M")) {
                    sizeM.setSelected(true);
                } else if (resultSet.getString("size").equals("S")) {
                    sizeS.setSelected(true);
                }
                inputNoOfToppings.setText(resultSet.getString("numberofToppings"));
                lblMessage.setText("");
            }
        } catch (SQLException e) {
            e.printStackTrace();     }}
    }
    public void clearForm(){
    inputName.setText("");
    inputNumber.setText("");
    inputNoOfToppings.setText("");

    }
    private void getSelectedSizeRadioButton() {
        if (sizeXL.isSelected()) {
            size = "XL";
        } else if (sizeL.isSelected()) {
            size = "L";
        } else if (sizeM.isSelected()) {
            size = "M";
        } else if (sizeS.isSelected()) {
            size = "S";
        } else {
            size = "none";
        }
    }
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
             }}
}