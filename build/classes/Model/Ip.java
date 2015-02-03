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
@XmlRootElement (name = "IP_p")
@XmlAccessorType (XmlAccessType.FIELD)
public class Ip {

    @XmlElement (name = "IP")
    private String ip;

    public Ip(String tabb) {
        this.ip = tabb;
    }

    public String getIp() {
        return ip;
    }

    public Ip() {
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
