/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Student;
import Database.FileManagement;
import tools.Tools;

/**
 * FXML Controller class
 *
 * @author Marcy GADEU
 */
public class NewStudentController implements Initializable {

    /**
     * Initializes the controller class.
     */
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
    
    private TableView<Student> StudentsTable;
    
    private Student toBeUpdated ;
   
       
    public void setToBeUpdated(Student toBeUpdated) {
        this.toBeUpdated = toBeUpdated;
    }
    

    public void setStudentsTable(TableView<Student> StudentsTable) {
        this.StudentsTable = StudentsTable;
    }

    @FXML
    void OnSave(ActionEvent event) {
        Student newStudent = new Student();
        newStudent.setRefNumber(refNumber.getText());
        newStudent.setAddress(address.getText());
        newStudent.setName(name.getText());
        newStudent.setLevel(level.getText());
        newStudent.setPhoneNumber(Integer.parseInt(phone.getText()));
        newStudent.setDepartment(department.getText());
        newStudent.setProgram(program.getText());
        if(toBeUpdated != null)
        {
            StudentsTable.getItems().remove(toBeUpdated);
            Tools.database.remove(toBeUpdated);
            
        }
        StudentsTable.getItems().add(newStudent);
        Tools.database.add(newStudent);
         FileManagement.saveData();
        StudentsTable.refresh();
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
       

    }

    @FXML
    void onCancel(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }
    public void initWindow()
    {
        refNumber.setText(toBeUpdated.getRefNumber());
        address.setText(toBeUpdated.getAddress());
        name.setText(toBeUpdated.getName());
        level.setText(toBeUpdated.getLevel());
        phone.setText(Integer.toString(toBeUpdated.getPhoneNumber()));
        department.setText(toBeUpdated.getDepartment());
        program.setText(toBeUpdated.getProgram());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     

}
