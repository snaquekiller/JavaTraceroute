/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Hassane
 */
public class ViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
   

   
    private Scene scene;
    @FXML
    private Label label;
    @FXML
    private Button start;
    @FXML
    private Button Back;
    @FXML
    private Button Again;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    System.out.println("You clicked me!"); 
    FXMLLoader Loader= new FXMLLoader();
    if(event.getSource()==start)
    {
        try {
            System.out.println("You clicked me1!");
            Loader.setLocation(getClass().getResource("/View/GraphView.fxml"));   
            scene=new Scene ((Parent)Loader.load());
            Stage stage =  (Stage) start.getScene().getWindow(); 
            stage.setScene(scene);
            
        } catch (IOException ex) {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
  
    } @FXML
    private void handleButtonAction2(ActionEvent event) {if(event.getSource()==Back)
    {FXMLLoader Loader= new FXMLLoader();
        try {
            System.out.println("You clicked me2!");
            Loader.setLocation(getClass().getResource("/View/MainView.fxml"));
            
            scene=new Scene ((Parent)Loader.load()); 
          Stage stage = (Stage) Back.getScene().getWindow(); 
          stage.setScene(scene);
       } catch (IOException ex) {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // label.setText("Welcome");
    }    
  
   
}
