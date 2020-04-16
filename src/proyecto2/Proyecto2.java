/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import Windows.window;
import Windows.windowCategory;
import Windows.windowProvider;

import entities.Category;
import entities.Costomer;


import java.awt.ComponentOrientation;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import persistence.CategoryRepositoryImp;
import persistence.CostumerRepositoryImp;
import persistence.EntityManageRepository;

/**
 *
 * @author copad
 */
public class Proyecto2 {
    
    

    
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
            window ventana=new window();
            
            ventana.setVisible(true);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setLocationRelativeTo(null);
        


        
    }
    
    
    
    
    

    
    
    
}
