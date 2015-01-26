/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trace_route_fxml;

import Model.Arc;
import Model.Graph;
import Model.Ip;
import Model.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        launch(args);

        Graph test = new Graph();

        System.out.println("*********  NOEUDS 1 ********\n");
        for (int i = 0; i < test.Graph.size(); i++) {
            System.out.println(test.Graph.get(i).get_ip().getIp());

        }

        System.out.println("************  Arcs 2 ********\n");
        Iterator<Arc> list = test.Arcs.iterator();
        int i =0;
        while(list.hasNext()){
            Arc a = list.next();
            System.out.println("ARC N°" + i + " :\n  From :" + a.get_from().get_ip().getIp() + "\n  To :" + a.get_to().get_ip().getIp() + "\n");
            i++;
        }
    

            
        //System.out.println("ARC N°" + i + " :\n  From :" + test.Arcs. get(i).get_from().get_ip().getIp() + "\n  To :" + test.Arcs.get(i).get_to().get_ip().getIp() + "\n");

        

    }

}
