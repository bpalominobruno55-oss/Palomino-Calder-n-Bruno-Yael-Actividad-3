module com.mycompany.ejercicio3punto1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.ejercicio3punto1 to javafx.fxml;
    exports com.mycompany.ejercicio3punto1;
}
