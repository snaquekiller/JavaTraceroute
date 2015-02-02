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
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
    public static void main(String[] args) throws IOException, JAXBException {
        launch(args);

        //Graph test = new Graph();
        Graph test;
          
            test = unMarshalingExample();

        test.add_fils_with_arc();
        System.out.println("*********  NOEUDS 1 ********\n");
        for (int i = 0; i < test.Graph.size(); i++) {
            System.out.println(test.Graph.get(i).getIp().getIp());

        }

        System.out.println("************  Arcs 2 ********\n");

        Iterator<Arc> list = test.Arcs.iterator();
        int i = 0;
        while (list.hasNext()) {
            Arc a = list.next();
            System.out.println("ARC N°" + i + " :\n  From :" + a.getFrom().getIp().getIp() + "\n  To :" + a.getTo().getIp().getIp() + "\n");
            i++;
        }
        
        try {
            marshalingExample(test);
        } catch (JAXBException ex) {
            Logger.getLogger(Trace_route_FXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("ARC N°" + i + " :\n  From :" + test.Arcs. get(i).get_from().get_ip().getIp() + "\n  To :" + test.Arcs.get(i).get_to().get_ip().getIp() + "\n");
    }

    private static void marshalingExample(Graph graphh) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Graph.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(graphh, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(graphh, new File("C:/Windows/Temp/graph.xml"));
    }

    private static Graph unMarshalingExample() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Graph.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //We had written this file in marshalling example
        Graph grap = (Graph) jaxbUnmarshaller.unmarshal(new File("C:/Windows/Temp/graph.xml"));
        return grap;
    }
    
}
