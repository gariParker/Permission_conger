module com.example.myfirstinterface {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires org.apache.poi.ooxml;

    opens com.example.myfirstinterface to javafx.fxml;
    exports com.example.myfirstinterface;
}