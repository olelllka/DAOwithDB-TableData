package com.example.demodao.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField login;
    @FXML
    TextField password;
    String log;
    String pas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    public void OpenForm(ActionEvent event) throws IOException {


       int log = Integer.parseInt(login.getText());
       int pas = Integer.parseInt(password.getText());

       if (log == 0 && pas == 0) {

           root = FXMLLoader.load(getClass().getResource("Sys.fxml"));
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
       }
        if (log == 1 && pas == 1) {

            root = FXMLLoader.load(getClass().getResource("Teacher.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }
}
