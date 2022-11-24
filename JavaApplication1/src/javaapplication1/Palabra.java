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
    int n, s, k, t, rY, rX,ang;

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

    public void reorganiza() {
        int i, j = palabra.size() - 1;
        //revisa estilos
        if (palabra.get(0).chr == '^') {
            i = 0;
            //i aumenta hasta que ya no es estilo
            while (i + 1 < palabra.size()) {
                if (palabra.get(i + 1).chr == '+') {
                    i++;
                } else if (palabra.get(i).chr == '^' || palabra.get(i).chr == '+') {
                    switch (palabra.get(i + 1).chr) {
                        case 'K' -> {
                            i++;
                        }
                        case 'S' -> {
                            i++;
                        }
                        case 'N' -> {
                            i++;
                        }
                        case 'T' -> {
                            i++;
                        }
                        case 'R' -> {
                            i++;
                        }
                        case 'X' -> {
                            i++;
                        }
                        case 'Y' -> {
                            i++;
                        }
                        case 'M' -> {
                            i++;
                        }
                        case 'P' -> {
                            i++;
                        }
                        default -> {
                        }
                    }
                } else if ((int) palabra.get(i).chr >= 48 && (int) palabra.get(i).chr <= 57) {
                    i++;
                } else {
                    break;
                }
            }
            i++;
            //revisa si hay estilos del final
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
