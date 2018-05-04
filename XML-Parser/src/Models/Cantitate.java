/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author razvan.costianu
 */
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType( propOrder = {"cantitate"} )
@XmlRootElement(name="cantitate")
public class Cantitate {
    
    @XmlValue
    int cantitate;
    @XmlAttribute(name="unitate_de_masura")
    String unitateMasura;

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public String getUnitateMasura() {
        return unitateMasura;
    }

    public void setUnitateMasura(String unitateMasura) {
        this.unitateMasura = unitateMasura;
    }

    @Override
    public String toString() {
        return " ,cantitate:" + this.getCantitate()+" " + this.getUnitateMasura();
    }
    
}
