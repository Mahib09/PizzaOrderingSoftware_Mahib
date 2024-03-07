module com.example.pizzaorderingsoftware_mahib {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.pizzaorderingsoftware_mahib to javafx.fxml;
    exports com.example.pizzaorderingsoftware_mahib;
}