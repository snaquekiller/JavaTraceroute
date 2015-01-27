/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author Hassane
 */
public class Arc {

    public Node from;
    public Node to;

    public Arc(Node from, Node to) {
        this.from = from;
        this.to = to;

    }

    public Node get_from() {

        return from;
    }

    public Node get_to() {
        return to;

    }

    @Override
    public boolean equals(Object e) {
        if (e instanceof Arc == true) {
            Arc a = (Arc) e;
       if(a.from.equals(this.from)&& a.to.equals(this.to))
       {return true;}
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
