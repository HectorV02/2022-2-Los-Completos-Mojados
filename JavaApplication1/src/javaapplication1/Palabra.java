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
    public Palabra(){
        palabra = new ArrayList();
    }
    public void addChar(Caracter a){
        palabra.add(a);        
    }
    public void addStyle(String s){
        stl = s;
    }
    
    public ArrayList<Caracter> getPalabra(){
        return palabra;
    }
}
