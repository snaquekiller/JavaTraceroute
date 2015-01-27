/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author NicolasG
 */
public class Ip {

    private String ip;

    public Ip(String tabb) {
        this.ip = tabb;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object e) {
        if (e instanceof Ip == true) {
            Ip a = (Ip) e;
            if (a.getIp().equalsIgnoreCase(this.ip)) {
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
        hash = 19 * hash + Objects.hashCode(this.ip);
        return hash;
    }

}
