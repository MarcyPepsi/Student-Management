/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import views.Main;
/**
 *
 * @author Marcy GADEU
 */
public class LoginController implements Initializable {
    
   @FXML
    private JFXTextField login;

    @FXML
   private JFXPasswordField password;

    @FXML
    void cancel(ActionEvent event) {
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();

    }

    @FXML
    void connect(ActionEvent event) throws IOException {
        // The correct credentials are login: user;password:studentMgnt2020
       // if(password.getOnKeyPressed().equals( KeyCode.ENTER)){
         if(login.getText().equals("user")&&password.getText().equals("studentMgnt2020"))
        {
           // System.out.println("The user is connected");
            
            Locale.setDefault(Locale.ENGLISH);
        Parent root = FXMLLoader.load(getClass().getResource("/views/student.fxml"));
        
        Scene scene = new Scene(root);
        
       Stage st = new Stage();
       st.setScene(scene);
        st.getIcons().add(new Image(Main.class.getResourceAsStream("/Resources/images/logopkf.jpg")));
        st.setResizable(false);
        st.show();
        Node source = (Node)event.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
            } 
        
        else
        {
          Alert ko = new Alert(Alert.AlertType.ERROR);
            ko.setHeaderText("Connection unsuccessful");
            ko.setContentText("The credentials are incorrect");  
            ko.showAndWait();
            
            
        }
        //}
//         Node source = (Node)event.getSource();
//            Stage stage = (Stage)source.getScene().getWindow();
//            stage.close();
        

    }
                                            
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
