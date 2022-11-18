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
    int n, s, k,t,rY,rX;
    
    
    public Palabra(){
        palabra = new ArrayList();
    }

    public void addChar(Caracter a) {
        palabra.add(a);
    }

    public ArrayList<Caracter> getPalabra() {
        return palabra;
    }

    public void setPalabra(ArrayList<Caracter> palabra) {
        this.palabra = palabra;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
    
    public int getT(){
        return t;
    }
    
    public void setT(int t){
        this.t = t;
    }
    
    public int getRY(){
        return rY;
    }
    
    public void setRY(int rY){
        this.rY = rY;
    }
    
    public int getRX(){
        return rX;
    }
    
    public void setRX(int rY){
        this.rX = rY;
    }
}
