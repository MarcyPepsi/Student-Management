/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Student;
import tools.Tools;
import views.Main;
import Database.FileManagement;

/**
 * FXML Controller class
 *
 * @author Marcy GADEU
 */
public class StudentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
 
    @FXML
    private JFXTextField search;
    @FXML
    private TableView<Student> tableStudent;
    @FXML
    private TableColumn<Student, String> refCol;

    @FXML
    private TableColumn<Student, String> nameCol;

    @FXML
    private TableColumn<Student, String> levelCol;

    @FXML
    private TableColumn<Student, String> programCol;

    @FXML
    private JFXTextField refNumber;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField program;

    @FXML
    private JFXTextField level;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXTextField department;
    @FXML
    private JFXButton editBut;
     @FXML
    private JFXButton addBut;
    
    

    @FXML
    void OnDelete(ActionEvent event) {
        Student s = tableStudent.getSelectionModel().getSelectedItem();
        if(s == null)
           {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setHeaderText("No student Selected");
               alert.setContentText("Please select a student before clicking on Edit");
               alert.showAndWait();
               return;
           }
        else{
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
               a.setHeaderText("Sure to delete?");
               a.setContentText("Are you sure you wish to delete the selected student?");
                a.resultProperty().addListener(new ChangeListener<ButtonType>(){
                @Override
                public void changed(ObservableValue<? extends ButtonType> observable, ButtonType oldValue, ButtonType newValue) {
                    if(newValue == ButtonType.OK)
                    {
                        tableStudent.getItems().remove(s);
                        Tools.database.remove(s);
                        FileManagement.saveData();
             refNumber.setText("");
        name.setText("");
        phone.setText("");
        program.setText("");
        level.setText("");
        address.setText("");
        department.setText("");
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText("Student Successfully delected");
               alert.setContentText("the student has been successfully deleted");
               alert.showAndWait();

                        
                    }
                }
                    
                });
                a.showAndWait();
                       
                        
        }

    }

    @FXML
    void OnSearch(ActionEvent event) {
         performSearch(search.getText());
        
    }
    private void performSearch(String searchKey)
    {
       
        ObservableList<Student> current = FXCollections.observableArrayList();
        Tools.database.forEach(student ->{
            if(student.getName().toLowerCase().contains(searchKey.toLowerCase()))
                {
                    current.add(student);
                }
        });
        tableStudent.setItems(current);
        tableStudent.refresh();
                
    }
    @FXML
    private void keySearch(KeyEvent event) {
        performSearch(search.getText());
    }

    @FXML
    void displayStudentDetails(MouseEvent event) {
        Student student = tableStudent.getSelectionModel().getSelectedItem();
        refNumber.setText(student.getRefNumber());
        name.setText(student.getName());
        phone.setText(String.valueOf(student.getPhoneNumber()));
        program.setText(student.getProgram());
        level.setText(student.getLevel());
        address.setText(student.getAddress());
        department.setText(student.getDepartment());

    }

    @FXML
    void onAddorEdit(ActionEvent event) throws IOException{

     
    Locale.setDefault(Locale.ENGLISH);
        Parent root = FXMLLoader.load(getClass().getResource("/views/newstudent.fxml"));

          FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/newstudent.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setScene(new Scene((Pane)loader.load()));
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/Resources/images/logopkf.jpg")));
        NewStudentController controller = loader.getController();
        controller.setStudentsTable(tableStudent);
        if(event.getSource() == editBut)
        {
           if(tableStudent.getSelectionModel().getSelectedItem() == null)
           {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setHeaderText("No student Selected");
               alert.setContentText("Please select a student before clicking on Edit");
               alert.showAndWait();
               return;
           }
            controller.setToBeUpdated(tableStudent.getSelectionModel().getSelectedItem());
            controller.initWindow();
        }
        stage.setResizable(false);
        stage.show();
     

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refCol.setCellValueFactory(new PropertyValueFactory<>("refNumber"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        levelCol.setCellValueFactory(new PropertyValueFactory<>("level"));
        programCol.setCellValueFactory(new PropertyValueFactory<>("program"));
       // Tools.database = Tools.defaultData();
        tableStudent.setItems(FXCollections.observableArrayList(Tools.database));
        tableStudent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                refNumber.setText(newValue.getRefNumber());
                name.setText(newValue.getName());
                phone.setText(String.valueOf(newValue.getPhoneNumber()));
                program.setText(newValue.getProgram());
                level.setText(newValue.getLevel());
                address.setText(newValue.getAddress());
                department.setText(newValue.getDepartment());
            }
             

        });
       FileManagement.saveData();
    }

    

}
