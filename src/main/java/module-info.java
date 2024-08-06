module com.itgroup.www {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; //for JDBC



    opens com.itgroup.www to javafx.fxml;
    exports com.itgroup.www;
}