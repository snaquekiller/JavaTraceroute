/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
            if (a.from == this.from && a.to == this.to) {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
