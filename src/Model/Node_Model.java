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
public class Node_Model {

    //private Node_List pere = null;
   //private List<Node_Model> Fils = new ArrayList<Node_Model>();
    private Ip ip;

    public String getName() {
        return name;
    }
    private String name;
    public Node_Model(String ip,String name) {
        this.ip = new Ip(ip);
        this.name=name;

    }

    /*public void add_fils(String ip_fils) {
        Fils.add(new Node_Model(ip_fils));

    }*/

    /*public List<Node_Model> get_fils() {
        List<Node_Model> list = new ArrayList<Node_Model>();
        for (int i = 0; i < Fils.size(); i++) {

            list.add(Fils.get(i));
        }
        return list;
    }*/

    public Ip get_ip() {
        return ip;

    }
    
    @Override
    public boolean equals(Object e)
    {  if (e instanceof Node_Model == true) {
            Node_Model a = (Node_Model) e;
            if (a.get_ip().getIp().equalsIgnoreCase(this.ip.getIp()) && a.getName().equals(this.getName())) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    
    
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.ip);
        hash = 13 * hash + Objects.hashCode(this.name);
        return hash;
    }

  

    

}
