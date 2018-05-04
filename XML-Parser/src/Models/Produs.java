/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 *
 * @author razvan.costianu
 */
@XmlType( propOrder = { "name","cantitate", "lot", "dataExpirare"} )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="produs")
public class Produs {
    @XmlElement
    String name;
    @XmlElement
    Cantitate cantitate;
    @XmlElement
    int lot;
    @XmlElement(name="data_expirare")
    String dataExpirare;
     @XmlAttribute(name="unitate_de_masura")
    String unitateMasura;

    public String getUnitateMasura() {
        return unitateMasura;
    }

    public void setUnitateMasura(String unitateMasura) {
        this.unitateMasura = unitateMasura;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cantitate getCantitate() {
        return cantitate;
    }

    public void setCantitate(Cantitate cantitate) {
        this.cantitate = cantitate;
    }


    public int getLot() {
        return lot;
    }

    public void setLot(int lot) {
        this.lot = lot;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = dataExpirare;
    }
    
    @Override
    public String toString(){
        return "\t[name:"+this.getName()+", lot:"+this.getLot() + this.getCantitate().toString()+ " , data expirare:"+this.getDataExpirare()+"]";
    }
    
    
}
