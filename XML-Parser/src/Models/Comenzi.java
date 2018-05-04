/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author razvan.costianu
 */
@XmlRootElement(name="comenzi")
@XmlAccessorType(XmlAccessType.FIELD)
public class Comenzi {
    @XmlElement ( name = "furnizor")
    ArrayList<Furnizor> listaFurnizori = new ArrayList<>();

    public ArrayList<Furnizor> getListaFurnizori() {
        return listaFurnizori;
    }

    public void setListaFurnizori(ArrayList<Furnizor> listaFurnizori) {
        this.listaFurnizori = listaFurnizori;
    }
    
    @Override
    public String toString(){
        String comenzi = "";
        for (Furnizor f : listaFurnizori){
            comenzi = comenzi + f.toString() + "\n";
        }
        return comenzi;
    }
    
    
}
