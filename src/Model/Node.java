/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author NicolasG
 */
public class Node {

    //private Node_List pere = null;
    private List<Node> Fils = new ArrayList<Node>();
    private Ip ip;

    public Node(String ip) {
        this.ip = new Ip(ip);

    }

    public void add_fils(String ip_fils) {
        Fils.add(new Node(ip_fils));

    }

    public List<Node> get_fils() {
        List<Node> list = new ArrayList<Node>();
        for (int i = 0; i < Fils.size(); i++) {

            list.add(Fils.get(i));
        }
        return list;
    }

    public Ip get_ip() {
        return ip;

    }
    
    @Override
    public boolean equals(Object e)
    {  if (e instanceof Node == true) {
            Node a = (Node) e;
            if (a.get_ip().getIp().equalsIgnoreCase(this.ip.getIp())) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    
    
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.ip);
        return hash;
    }

    

}
