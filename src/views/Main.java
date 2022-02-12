/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tools.Tools;
import Database.FileManagement;

/**
 *
 * @author Marcy GADEU
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Locale.setDefault(Locale.ENGLISH);
        FileManagement.getData();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/Resources/images/logopkf.jpg")));
        stage.setResizable(false);
        stage.show();
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
