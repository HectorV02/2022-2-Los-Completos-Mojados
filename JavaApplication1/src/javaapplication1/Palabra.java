/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author PC GAMER
 */
public class Palabra {
    ArrayList<Caracter> palabra;
    String stl;
    public Palabra(String stl){
        palabra = new ArrayList();
        this.stl = stl;
    }
    public void addChar(Caracter a){
        palabra.add(a);        
    }
    
    public ArrayList<Caracter> getPalabra(){
        return palabra;
    }
}
