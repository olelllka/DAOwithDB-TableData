module com.example.demodao {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens com.example.demodao to javafx.fxml;
    exports com.example.demodao;
    exports com.example.demodao.Controller;
    opens com.example.demodao.Controller to javafx.fxml;
    exports com.example.demodao.DAO;
    opens com.example.demodao.DAO to javafx.fxml;
}