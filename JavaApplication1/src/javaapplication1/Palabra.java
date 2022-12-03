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
    int n, s, k, t, rY, rX, ang;

    public Palabra() {
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

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getRY() {
        return rY;
    }

    public void setRY(int rY) {
        this.rY = rY;
    }

    public int getRX() {
        return rX;
    }

    public void setRX(int rY) {
        this.rX = rY;
    }

    public int getrY() {
        return rY;
    }

    public void setrY(int rY) {
        this.rY = rY;
    }

    public int getrX() {
        return rX;
    }

    public void setrX(int rX) {
        this.rX = rX;
    }

    public int getAng() {
        return ang;
    }

    public void setAng(int ang) {
        this.ang = ang;
    }

    public void reorganiza() {
        int i, j = palabra.size() - 1;
        //revisa estilos si es que hay estilos hacia adelante
        if (palabra.get(0).chr == '^') {
            i = 0;
            //i aumenta hasta que ya no es estilo
            while (i + 1 < palabra.size()) {
                //si es signo + avanza i
                if (palabra.get(i + 1).chr == '+') {
                    i++;
                } //revisa estilos hacia adelante (avanza i en 2)
                else if (palabra.get(i).chr == '^' || palabra.get(i).chr == '+') {
                    switch (palabra.get(i + 1).chr) {
                        case 'K' -> {
                            i += 2;
                        }
                        case 'S' -> {
                            i += 2;
                        }
                        case 'N' -> {
                            i += 2;
                        }
                        case 'T' -> {
                            i += 2;
                        }
                        case 'R' -> {
                            i += 2;
                        }
                        case 'X' -> {
                            i += 2;
                        }
                        case 'Y' -> {
                            i += 2;
                        }
                        case 'M' -> {
                            i += 2;
                        }
                        case 'P' -> {
                            i += 2;
                        }
                        case 'a' -> {
                            i += 2;
                        }
                        case 'A' -> {
                            i += 2;
                        }
                        default -> {
                            i++;
                        }
                    }
                } //revisa si son numeros y avanza i
                else if ((int) palabra.get(i).chr >= 48 && (int) palabra.get(i).chr <= 57) {
                    i++;
                } //revisa si es signo negativo y avanza i
                else if ((int) palabra.get(i).chr == 45) {
                    i++;
                } //si no es estilo sale del while
                else {
                    break;
                }
            }//revisa si hay estilos del final
            for (int l = i; l <= j; l++) {
                if (palabra.get(l).chr == '^') {
                    j = l - 1;
                }
            }
            //da vuelta palabra(solo lo escrito)
            for (int l = i; l < j; l++) {
                Caracter aux = palabra.get(l);
                palabra.set(l, palabra.get(j));
                palabra.set(j, aux);
                j--;
            }
        } else {
            //revisa si hay estilos del final
            for (int l = 1; l <= j; l++) {
                if (palabra.get(l).chr == '^') {
                    j = l - 1;
                }
            }
            //da vuelta palabra(solo lo escrito)
            for (int l = 0; l < j; l++) {
                Caracter aux = palabra.get(l);
                palabra.set(l, palabra.get(j));
                palabra.set(j, aux);
                j--;
            }
        }
    }
}
