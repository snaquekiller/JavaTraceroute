/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Hassane
 */
public class Graph {
    
    public List<Node> Graph=new LinkedList<Node>();
    public List<Arc> Arcs= new LinkedList<Arc>();
     public Graph(List<Node> tab)
    {
        
        Graph=tab;
    }
      public Graph() throws IOException
    {
        
        Get_Adresses();
    }
    
    void add_node(String ip_node)
    {
    Graph.add(new Node(ip_node));
    
    }
    public void Get_Adresses() throws IOException
    {
    String line = "";
    String line2 = null;
    String[] tab = new String[20];
    LinkedList<Node> tab2=new LinkedList<Node>();            
      

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
                        tab2.add(new Node(tab[i]));
                        }
                    }
                }
             
            } 
      Initilize_Graph(tab2);
     
    }
    
    void Initilize_Graph(LinkedList<Node> table)
    {
        ListIterator<Node> l= table.listIterator();
        int index ;
        while (l.hasNext())
            
        {   
            
            Node node=l.next();
           
            check_node(node);
            check_arc(node,table);
        
        }
       
        
    
    }
    void check_node(Node node)
            
    {
    boolean found=false;
    ListIterator<Node> l= Graph.listIterator();
    
    while (l.hasNext() && found==false)
        
    {
    
        if(l.next().get_ip()==node.get_ip())
        {
        found=true;
        }
    }
    if(found==false)
    {
    Graph.add(node);
    
    }
    }
    
    void check_arc(Node node,List<Node> list){
    int pos_node =list.indexOf(node);
    Node node_from;
    Node node_to= list.get(pos_node);
    ListIterator<Arc> l= Arcs.listIterator();
    boolean arc_found=false;
    if(pos_node!=0)
    {
    node_from=list.get(pos_node-1); 
            
    }
    else {
        
    node_from= new Node("start");
    }
    
    while(l.hasNext() && arc_found==false)
    {
        Arc arc=l.next();
        
        if(arc.get_from().get_ip()==node_from.get_ip() && arc.get_to().get_ip()==node_to.get_ip())
        {
        arc_found=true;
        
        }
    
    }
    if(arc_found==false)
    {
    Arcs.add(new Arc(node_from,node_to));
    
    }
    
    
    
    
    }
    
}
