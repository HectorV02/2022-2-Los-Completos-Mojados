/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author janit
 */
public class PrimaryController {
    
    @FXML
    public TextField cuadroTexto;
    @FXML
    public Label canvas;
    
    @FXML
    public ArrayList<Caracter> Empezar(){
        ArrayList<ArrayList> puntos = new ArrayList();
        for (int i = 0; i < 6; i++) { 
            for (int j = 0; j < 6; j++) {
                ArrayList<Integer> xy = new ArrayList();
                xy.add(20 * j);
                xy.add(20 * i);
                puntos.add(xy);
            }   
        }
        //digamos que recibe los puntos 24,29,8,10 y los puntos 14,10,4,32
        ArrayList<Integer> ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(14).get(0)));  
        ArrayList<Integer> iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(14).get(1)));
        ArrayList<Integer> fx = new ArrayList(Arrays.asList(puntos.get(29).get(0),puntos.get(10).get(0)));
        ArrayList<Integer> fy = new ArrayList(Arrays.asList(puntos.get(29).get(1),puntos.get(10).get(1)));
        ArrayList<Integer> ch1x = new ArrayList(Arrays.asList(puntos.get(8).get(0),puntos.get(30).get(0)));
        ArrayList<Integer> ch1y = new ArrayList(Arrays.asList(puntos.get(8).get(1),puntos.get(30).get(1)));
        ArrayList<Integer> ch2x = new ArrayList(Arrays.asList(puntos.get(10).get(0),puntos.get(33).get(0)));
        ArrayList<Integer> ch2y = new ArrayList(Arrays.asList(puntos.get(10).get(1),puntos.get(33).get(1)));
        Caracter a = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,canvas,2);
        ArrayList<Caracter> letras = new ArrayList();
        letras.add(a);
        return letras;
    }
    @FXML
    public void dibuja() throws IOException {
        String frase=(this.cuadroTexto.getText());
        ArrayList<Caracter> letras=Empezar();
        letras.get(0).dibujar();
        //System.out.println("llega2");
        System.out.println(frase);
    }
}
