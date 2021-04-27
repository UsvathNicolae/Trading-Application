package org.fis.ta.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.ta.MainApp;
import org.fis.ta.services.UserService;

import java.io.IOException;

public class LoginController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Text loginMessage;
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    void handleRegisterAction() throws IOException {
        MainApp m = new MainApp();
        Stage stage = (Stage) passwordField.getScene().getWindow();
        Parent viewRegisterPage = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Scene scene = new Scene(viewRegisterPage,380,275);
        stage.setScene(scene);
    }
    @FXML
    public void handleLoginAction() throws IOException {
        if(UserService.checkLoginCredentials(usernameField.getText(),passwordField.getText())){
            String username = usernameField.getText();
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("homepage.fxml"));
            root=loader.load();
            HomepageController hc = loader.getController();
            hc.loadMessage(username);
            stage = (Stage) passwordField.getScene().getWindow();
            scene = new Scene(root,600,600);
            stage.setScene(scene);
        }
        else
            loginMessage.setText("Account does not exist!");
    }

}
