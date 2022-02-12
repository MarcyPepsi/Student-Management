/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author Marcy GADEU
 */
public class Tools {
    public static  ArrayList<Student> database = new ArrayList<>();
    public static ArrayList<Student> defaultData()
    {
        ArrayList<Student>  list = new ArrayList<>();
        list.add(new Student("SC021", "Happi Monthe", 698528962,"BS Computer Science", "Junior 2", "LOgbaba", "Computing"));
        list.add(new Student("MS020", "GADEU MONTHE", 698827962,"BS Economics", "Junior 1", "Grand moulin", "Econs and management"));
        list.add(new Student("SC022","NGANGOUM MARIANE",699081290,"BS Telecommunications","Sophomore 2","Logbaba","Econs"));
        list.add(new Student("SC023","nya happi",699091290,"BS Telecommunications","Sophomore 2","Logbaba","Econs"));
        return list;
        
        
    }

//   
//
//    public  ArrayList<Student> getData(String filepath) throws ClassNotFoundException 
//    {
//        File fileName = new File("C:\\Users\\Marcy GADEU\\Documents\\NetBeansProjects\\SimpleStudentManagement\\src\\Database\\Student.dat");
//        ArrayList<Student> students = new ArrayList<>();
//        try {
//            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
//            
//             students = (ArrayList<Student>) is.readObject();
//                        
//            
//        } catch (IOException ex) {
//            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return students;
//                
//    }
//    public void saveData(String filepath, ArrayList<Student> students) throws IOException 
//    { 
//        try {
//            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filepath));
//            for( Student s: students)
//            {
//                os.writeObject(s);
//                os.writeObject("\n");
//                os.close();
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//        }
   
  }
    

