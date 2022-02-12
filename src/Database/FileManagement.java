/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import tools.Tools;

/**
 *
 * @author Marcy GADEU
 */
public class FileManagement {
     public static void saveData(){
        
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream("src\\Database\\Student.dat"));
            output.writeObject(Tools.database);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void getData(){
        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(new FileInputStream("src\\Database\\Student.dat"));
            Tools.database = (ArrayList<Student>) (input.readObject());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
