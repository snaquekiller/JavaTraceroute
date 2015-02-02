/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Arc;
import Model.Graph_model;
import Model.Node_Model;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.ProxyPipe;
import org.graphstream.ui.layout.springbox.implementations.SpringBox;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;
import org.graphstream.ui.swingViewer.Viewer.ThreadingModel;
import trace_route_fxml.Trace_route_FXML;



/**
 * FXML Controller class
 *
 * @author Hassane
 */
public class ViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private int counter=0;
   private ProxyPipe pipe;
   private Graph_model graph;
   private Graph graph_screen ;
    @FXML
    private StackPane pane=new StackPane();
    private Scene scene;
    @FXML
    private Label label;
    @FXML
    private Button start;
    @FXML
    private Button Back;
    @FXML
    private Button Go;
    @FXML
    private TextField ip_field;
    @FXML
    private CheckBox ip;
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, InterruptedException {
        
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
    else if(event.getSource()==Go)
    {
       if(counter==0)
       {
           System.out.println("First time");
        graph=new Graph_model(ip_field.getText());
    do_graph();
    counter++;
       }
       else
       {
           System.out.println("Second time");
       graph.Get_Adresses(ip_field.getText());
       graph_screen.clear();
       do_graph();
       counter++;
       }
    }
    else if(event.getSource()==ip)
    { // Show ip if box selected
        if(ip.isSelected())
        {
        System.out.println("Explorons \n");
    Iterator<Node> k =  graph_screen.getNodeIterator();

    while (k.hasNext()) {
      
     Node next=k.next();
             next.addAttribute("ui.label", next.getAttribute("Ip").toString());
      

    }
      
    }else if(!ip.isSelected())
    {
           System.out.println("Explorons \n");
    Iterator<Node> k =  graph_screen.getNodeIterator();

    while (k.hasNext()) {
      
     Node next=k.next();
             next.addAttribute("ui.label", " ");
      

    }
    
    }
    }
     
  
    } 
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        if(event.getSource()==Back)
    {
        FXMLLoader Loader= new FXMLLoader();
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
                   
                
             
 
    }    
  
    void set_graph(Graph_model graph)
    {
    this.graph=graph;
    
    }
    
    void do_graph() throws IOException
    {
        System.out.println("salut");
     
         System.out.println("salut");
        graph_screen= new SingleGraph("Graph_Ip_Route");
        graph_screen.setAttribute("layout.quality", 4);
       // graph_screen.display(false);
       //graph_screen.setStrict(false);
        //graph_screen.setAutoCreate(true);
      for (int i = 0; i < graph.Graph.size(); i++) {
           Node_Model node=graph.Graph.get(i);
            graph_screen.addNode(node.getName());
            graph_screen.getNode(node.getName()).addAttribute("Ip",node.get_ip().getIp());
          // graph_screen.getNode(node.getName()).addAttribute("layout.frozen");
           graph_screen.getNode(node.getName()).setAttribute("layout.weight",100);
            //  graph_screen.getNode(node.getName()).addAttribute("xy",1+i, 1+i);
            System.out.println(node.getName());
        }
      
   
       Iterator<Arc> list =graph.Arcs.iterator();
        int i =0;
        while(list.hasNext()){
           
            Arc a = list.next();
           System.out.println("From :"+a.get_from().getName());
           System.out.println("To :"+a.get_to().getName());
           graph_screen.addEdge(a.get_from().getName()+a.get_to().getName(),a.get_from().getName(),a.get_to().getName());
           System.out.println("Done Arc :"+a.get_from().getName()+a.get_to().getName());
            i++;
    
    }
 graph_screen.addAttribute("ui.stylesheet", "node {\n" +

"    size: 20px, 20px ;\n"+
"    fill-mode: image-scaled; \n" +
"    fill-image:url('ordi.png');    \n" +

"   text-padding: 2px ;\n"+
"   text-background-mode: none ; \n"+
"   text-alignment: under; \n"+
"    icon:url('ip.png\');\n"+
"    icon-mode:   at-left ;\n"+

"}\n" +
" node.marked {\n" +
" fill-color: red;\n" +
    "}\n"+
"edge {\n"+
"fill-color : blue ; \n"+
 "arrow-shape : circle; \n"+
"arrow-size : 50px,50px;\n"+
 "}"
   
   );
 
Viewer viewer = new Viewer(graph_screen, ThreadingModel.GRAPH_IN_SWING_THREAD);
SpringBox layout=new SpringBox(false,new Random(0));
 viewer.enableAutoLayout(layout);
 View view = viewer.addDefaultView(false);

view.addMouseWheelListener(new Mouse_Wheel(view));

 pipe=viewer.newViewerPipe();
pipe.addAttributeSink(graph_screen);
SwingNode swingNode = new SwingNode();
view.getCamera().setViewPercent(0.5);
swingNode.setContent(view); 
pane.getChildren().add(swingNode);
      
   
}
     private void save()
    {
    
   /* try {
        // 
            marshalingExample(graph);
        } catch (JAXBException ex) {
            Logger.getLogger(Trace_route_FXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("ARC N°" + i + " :\n  From :" + test.Arcs. get(i).get_from().get_ip().getIp() + "\n  To :" + test.Arcs.get(i).get_to().get_ip().getIp() + "\n");
    }

    private static void marshalingExample(Graph_model graphh) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Graph_model.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(graphh, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(graphh, new File("C:/Windows/Temp/graph.xml"));
    }

    private static Graph_model unMarshalingExample() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Graph_model.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        //We had written this file in marshalling example
        Graph_model grap = (Graph_model) jaxbUnmarshaller.unmarshal(new File("C:/Windows/Temp/graph.xml"));
        return grap;
    }*/
    }
}

   


