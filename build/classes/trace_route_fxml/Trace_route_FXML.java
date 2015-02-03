/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trace_route_fxml;


import java.io.IOException;



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
           
            stage.show();
        } catch (Exception a) {

            System.out.println(a.fillInStackTrace());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
      // import nedeed for the graph 
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        launch(args);

    }
}
