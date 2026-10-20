module com.mycompany.ejercicio3punto2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.ejercicio3punto2 to javafx.fxml;
    exports com.mycompany.ejercicio3punto2;
}
