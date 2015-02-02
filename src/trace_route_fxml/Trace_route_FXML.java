/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trace_route_fxml;

import Model.Arc;
import Model.Graph_model;
import java.io.IOException;


import java.util.Iterator;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Hassane
 */
public class Trace_route_FXML extends Application {

    @Override
    public void start(Stage stage) {
        try {
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        }); 
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    
        
       /* Iterator<Arc> list = test.Arcs.iterator();
        int i =0;
        while(list.hasNext()){
            Arc a = list.next();
            System.out.println("ARC N°" + i + " :\n  From :" + a.get_from().get_ip().getIp() + "\n  To :" + a.get_to().get_ip().getIp() + "\n");
            i++;
        }*/ {
       /* Graph_model test = new Graph_model("google.com"); System.out.println("************  Arcs 2 ********\n");
        Iterator<Arc> list = test.Arcs.iterator();
        int i =0;
        while(list.hasNext()){
            Arc a = list.next();
            System.out.println("ARC N°" + i + " :\n  From :" + a.get_from().get_ip().getIp() + "\n  To :" + a.get_to().get_ip().getIp() + "\n");
            i++;
        }*/
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        launch(args);
 
        

       /* System.out.println("*********  NOEUDS 1 ********\n");
        for (int i = 0; i < test.Graph.size(); i++) {
            System.out.println(test.Graph.get(i).get_ip().getIp());

        }*/

      
        
    

            
        //System.out.println("ARC N°" + i + " :\n  From :" + test.Arcs. get(i).get_from().get_ip().getIp() + "\n  To :" + test.Arcs.get(i).get_to().get_ip().getIp() + "\n");

        

    }

}
