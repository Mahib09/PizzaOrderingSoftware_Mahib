module com.example.pizzaorderingsoftware_mahib {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.pizzaorderingsoftware_mahib to javafx.fxml;
    exports com.example.pizzaorderingsoftware_mahib;
}