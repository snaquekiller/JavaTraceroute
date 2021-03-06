/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NicolasG
 */
@XmlRootElement(name = "Node_Model")
@XmlAccessorType (XmlAccessType.FIELD)
public class Node_Model {

    //private Node_List pere = null;
   //private List<Node_Model> Fils = new ArrayList<Node_Model>();
    
    @XmlElement(name = "Ip")
    private Ip ip;

    public String getName() {
        return name;
    }

    public Node_Model() {
    }

    public Ip getIp() {
        return ip;
    }

    public void setIp(Ip ip) {
        this.ip = ip;
    }
    
    @XmlElement(name = "Name")
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
