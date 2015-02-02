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
import java.util.Iterator;
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
@XmlRootElement(name = "Graph_Total")
@XmlAccessorType(XmlAccessType.FIELD)
public class Graph {

    @XmlElement(name = "Graphs")
    public List<Node> Graph = new LinkedList<Node>();
    @XmlElement(name = "Arcs")
    public HashSet<Arc> Arcs = new HashSet();

    public Graph(List<Node> tab) {

        Graph = tab;
    }

    public List<Node> getGraph() {
        return Graph;
    }

    public void setGraph(List<Node> Graph) {
        this.Graph = Graph;
    }

    public HashSet<Arc> getArcs() {
        return Arcs;
    }

    public void setArcs(HashSet<Arc> Arcs) {
        this.Arcs = Arcs;
    }

    public Graph() throws IOException {

        Get_Adresses();
    }

    void add_node(String ip_node) {
        Graph.add(new Node(ip_node));

    }

    public void Get_Adresses() throws IOException {
        String line = "";
        String line2 = null;
        String[] tab = new String[20];
        LinkedList<Node> tab2 = new LinkedList<Node>();

        Process run = Runtime.getRuntime().exec("java -jar ./lib/fakeroute.jar www.google.com");
        BufferedReader reader = new BufferedReader(new InputStreamReader(run.getInputStream()));
        Pattern p = Pattern.compile("\\d{1,3}\\.\\d{1,3}.\\d{1,3}\\.\\d{1,3}");
        Matcher m;
        LinkedList<LinkedList<Node>> array = new LinkedList<>();

        while ((line = reader.readLine()) != null) {
            LinkedList< Node> tmps = new LinkedList<>();

            String[] tabb = line.split(" ");
            line2 = line2 + line + "\n";
            for (int i = 0; i < tabb.length; i++) {

                m = p.matcher(tabb[i]);
                if (m.matches() == true) {

                    tmps.add(new Node(tabb[i]));
                }
            }
            array.add(tmps);

        }
        System.out.println(line2);

        Initilize_Graph(array);

    }

    void Initilize_Graph(LinkedList<LinkedList<Node>> table) {
        ListIterator<LinkedList<Node>> l = table.listIterator();
        LinkedList<Node> l2;
        while (l.hasNext()) {
            l2 = l.next();
            ListIterator<Node> list_node = l2.listIterator();
            int index = table.indexOf(l2);
            System.out.println("INDEXXXX:" + index);
            while (list_node.hasNext()) {
                Node node = list_node.next();

                check_node(node);
                check_arc(node, table, index);
            }
        }
    }

    void check_node(Node node) {
        boolean found = false;
        ListIterator<Node> l = Graph.listIterator();

        while (l.hasNext() && found == false) {

            if (l.next().getIp() == node.getIp()) {
                found = true;
            }
        }
        if (found == false) {
            Graph.add(node);

        }
    }

    void check_arc(Node node, LinkedList<LinkedList<Node>> list, int index) {
        // list which store very parent node
        LinkedList<Node> nodes_from = new LinkedList<>();
        ListIterator<Node> l2 = nodes_from.listIterator();

        boolean arc_found = false;
        if (index != 0) {
            for (int i = 0; i < list.get(index - 1).size(); i++) {
                nodes_from.add(list.get(index - 1).get(i));
            }

        } else {
            nodes_from.add(new Node("start"));
        }

        for (int i = 0; i < nodes_from.size(); i++) {
            Arcs.add(new Arc(nodes_from.get(i), node));
        }
    }

    public void add_fils_with_arc() {
        Iterator a = Arcs.iterator();
        Arc arc;
        while (a.hasNext()) {
            arc = (Arc) a.next();

            for (int i = 0; i < Graph.size(); i++) {
                String arc_ipfrom = arc.getFrom().getIp().getIp();
                // verif if a node where the ip from exist
                if (Graph.get(i).getIp().getIp().equals(arc_ipfrom)) {
                    String arc_ipto = arc.getTo().getIp().getIp();
                    for (int j = 0; j < Graph.size(); j++) {
                        Node get = Graph.get(j);
                        //get the good node with good ip for ip to and add to the 1st(from)
                        if (get.getIp().getIp() == arc_ipto) {
                            Graph.get(i).add_fils(get);
                        }
                    }

                }
            }
        }

    }
}
