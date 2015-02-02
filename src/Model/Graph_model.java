/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hassane
 */
@XmlRootElement(name = "Graph_Model")
@XmlAccessorType(XmlAccessType.FIELD)
public class Graph_model {

    @XmlElement(name = "Graph")
    public List<Node_Model> Graph = new LinkedList<Node_Model>();
    @XmlElement(name = "Arcs")
    public HashSet<Arc> Arcs = new HashSet();
    @XmlElement(name = "Address_route")
    public String address_route;
    @XmlElement(name = "Counter")
    public int counter = 0;

    public Graph_model(String ip_to_route) throws IOException {
        address_route = ip_to_route;
        Get_Adresses(ip_to_route);
    }

    void add_node(String ip_node, String name) {
        Graph.add(new Node_Model(ip_node, name));

    }

    public Graph_model() {
    }  

    public List<Node_Model> getGraph() {
        return Graph;
    }

    public void setGraph(List<Node_Model> Graph) {
        this.Graph = Graph;
    }

    public HashSet<Arc> getArcs() {
        return Arcs;
    }

    public void setArcs(HashSet<Arc> Arcs) {
        this.Arcs = Arcs;
    }

    public String getAddress_route() {
        return address_route;
    }

    public void setAddress_route(String address_route) {
        this.address_route = address_route;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void Get_Adresses(String ip_to_route) throws IOException {

        String line = "";
        String line2 = null;
        String[] tab = new String[20];
        LinkedList<Node_Model> tab2 = new LinkedList<Node_Model>();
        System.out.println("wesh");
        Process run = Runtime.getRuntime().exec("java -jar ./lib/fakeroute.jar" + " " + ip_to_route);

        BufferedReader reader = new BufferedReader(new InputStreamReader(run.getInputStream()));

        Pattern p = Pattern.compile("\\d{1,3}\\.\\d{1,3}.\\d{1,3}\\.\\d{1,3}");

        Matcher m;
        LinkedList<LinkedList<Node_Model>> array = new LinkedList<>();
        System.out.println(array.size());
        while ((line = reader.readLine()) != null) {
            LinkedList< Node_Model> tmps = new LinkedList<>();
            line = line.replace("\\s+", " ");
            String[] tabb = line.split(" ");
            line2 = line2 + line + "\n";
            for (int i = 0; i < tabb.length; i++) {

                m = p.matcher(tabb[i]);
                if (m.matches() == true || tabb[i].equals("*")) {
                    counter++;
                    tmps.add(new Node_Model(tabb[i], "Node" + String.valueOf(counter)));
                }
            }
            array.add(tmps);
            counter++;
        }

        System.out.println(line2);

        Initilize_Graph(array);

    }

    void Initilize_Graph(LinkedList<LinkedList<Node_Model>> table) {
        ListIterator<LinkedList<Node_Model>> l = table.listIterator();
        LinkedList<Node_Model> l2;
        int counter = 0;
        while (l.hasNext()) {

            l2 = l.next();
            int index = table.indexOf(l2);
            ListIterator<Node_Model> list_node = l2.listIterator();

            System.out.println(table.get(counter).size());

            while (list_node.hasNext()) {
                Node_Model node = list_node.next();
                System.out.println("INDEX while " + index);
                check_node(node);
                check_arc(node, table, index);

            }
            counter++;
        }

    }

    void check_node(Node_Model node) {
        boolean found = false;
        ListIterator<Node_Model> l = Graph.listIterator();

        while (l.hasNext() && found == false) {

            if (l.next().equals(node)) {
                found = true;
            }
        }
        if (found == false) {

            Graph.add(node);

        }
    }

    void check_arc(Node_Model node, LinkedList<LinkedList<Node_Model>> list, int index) {
        // list which store very parent node
        LinkedList<Node_Model> nodes_from = new LinkedList<>();
        ListIterator<Node_Model> l2 = nodes_from.listIterator();

        if (index != 1) {
            for (int i = 0; i < list.get(index - 1).size(); i++) {
                nodes_from.add(list.get(index - 1).get(i));
            }

        } else {
            System.out.println("Ajout Index 0");
            check_node(new Node_Model("Node_Start", "Host"));
            nodes_from.add(new Node_Model("Node_Start", "Host"));

        }

        for (int i = 0; i < nodes_from.size(); i++) {
            Arcs.add(new Arc(nodes_from.get(i), node));

        }

    }

}
