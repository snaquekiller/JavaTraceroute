/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trace_route_fxml;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hassane
 */
public class Trace_route_FXML extends Application {

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/View/MainView.fxml"));
            Parent root = (Parent) Loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Trace Route Project");

            stage.setScene(scene);
            //stage.setScene(scene);
            stage.show();
        } catch (Exception a) {

            System.out.println(a.fillInStackTrace());
        }
    }
    
    public static List<String>  Get_Adresses() throws IOException
    {
    String line = "";
String line2 = null;
String[] tab = new String[20];
List<String> tab2=new ArrayList<String>();            
      

            Process run = Runtime.getRuntime().exec("java -jar ./lib/fakeroute.jar www.google.com");
            BufferedReader reader = new BufferedReader(new InputStreamReader(run.getInputStream()));
            while ((line = reader.readLine()) != null) {
      
                line = line.replaceAll(" ", "/");
                
                
                tab = line.split("/");
                for (int i = 0; i < tab.length; i++) {

                    int temp = tab[i].split("\\.").length;
                    if (temp == 4) {
                        if(tab[i].contains("(")==false)
                        {
                        tab2.add(tab[i]);
                        }
                    }
                }
             
            } 
      
     return tab2; 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        launch(args);
         List<String> a =Get_Adresses();
for( int i=0;i<a.size();i++)
{
System.out.println(a.get(i));

}

    }

}
