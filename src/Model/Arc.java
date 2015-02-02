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
 * @author Hassane
 */
@XmlRootElement(name = "Arc")
@XmlAccessorType (XmlAccessType.FIELD)
public class Arc {

    @XmlElement(name = "From")
    public Node from;
    @XmlElement(name = "To")
    public Node to;

    public Arc(Node from, Node to) {
        this.from = from;
        this.to = to;

    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public Node getFrom() {

        return from;
    }

    public Node getTo() {
        return to;

    }

    public Arc() {
    }

    @Override
    public boolean equals(Object e) {
        if (e instanceof Arc == true) {
            Arc a = (Arc) e;
            if (a.from.equals(this.from) && a.to.equals(this.to)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.from);
        hash = 97 * hash + Objects.hashCode(this.to);
        return hash;
    }

}
