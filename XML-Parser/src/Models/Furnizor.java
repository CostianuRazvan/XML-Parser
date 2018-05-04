/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author razvan.costianu
 */
@XmlRootElement(name="furnizor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Furnizor {
    @XmlElement ( name = "produs")
    ArrayList<Produs> listaProduse = new ArrayList<>();
    @XmlAttribute
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Produs> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(ArrayList<Produs> listaProduse) {
        this.listaProduse = listaProduse;
    }
    
    @Override
    public String toString(){
        String furnizori = "";
        for (Produs p : listaProduse){
            if (p.equals(listaProduse.get(0))){
                furnizori = "Furnizor: " +this.getName()+ "\n\n" +furnizori + p.toString() + "\n";
            }else{
               furnizori =furnizori + p.toString() + "\n"; 
            }
        }
        return furnizori;
    }
    
}
