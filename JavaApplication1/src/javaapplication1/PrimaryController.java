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
import javafx.scene.layout.Pane;
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
    public ArrayList<Caracter> Empezar(int x ,int y){
        Pane p = new Pane();
        //p.setPrefSize(100, 100);
        p.setMaxSize(100, 140);
        p.setMinSize(100, 140);
        p.setStyle("-fx-background-color: white;");
        //p.relocate(x, y);
        p.setTranslateX(x);
        p.setTranslateY(y);
        ArrayList<ArrayList> puntos = new ArrayList();
        for (int i = 0; i < 8; i++) { 
            for (int j = 0; j < 6; j++) {
                ArrayList<Integer> xy = new ArrayList();
                xy.add(20 * j);
                xy.add(20 * i);
                puntos.add(xy);
            }   
        }        
        return mayusculas(p, puntos);
    }
    public static ArrayList<Caracter> mayusculas(Pane p, ArrayList<ArrayList
            > puntos){
        
        ArrayList<Integer> ix = new ArrayList(Arrays.asList(puntos.get(13).get(0),puntos.get(22).get(0),puntos.get(22).get(0)));  
        ArrayList<Integer> iy = new ArrayList(Arrays.asList(puntos.get(13).get(1),puntos.get(22).get(1),puntos.get(22).get(1)));
        ArrayList<Integer> fx = new ArrayList(Arrays.asList(puntos.get(22).get(0),puntos.get(13).get(0),puntos.get(35).get(0)));
        ArrayList<Integer> fy = new ArrayList(Arrays.asList(puntos.get(22).get(1),puntos.get(13).get(1),puntos.get(35).get(1)));
        ArrayList<Integer> ch1x = new ArrayList(Arrays.asList(puntos.get(42).get(0),puntos.get(4).get(0),puntos.get(46).get(0)));
        ArrayList<Integer> ch1y = new ArrayList(Arrays.asList(puntos.get(42).get(1),puntos.get(4).get(1),puntos.get(46).get(1)));
        ArrayList<Integer> ch2x = new ArrayList(Arrays.asList(puntos.get(46).get(0),puntos.get(2).get(0),puntos.get(35).get(0)));
        ArrayList<Integer> ch2y = new ArrayList(Arrays.asList(puntos.get(46).get(1),puntos.get(2).get(1),puntos.get(35).get(1)));
        Caracter A = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        ArrayList<Caracter> letras = new ArrayList();
        letras.add(A);
        
        ix = new ArrayList(Arrays.asList(puntos.get(6).get(0),puntos.get(7).get(0),puntos.get(25).get(0),puntos.get(37).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(6).get(1),puntos.get(7).get(1),puntos.get(25).get(1),puntos.get(37).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(37).get(0),puntos.get(25).get(0),puntos.get(37).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(37).get(1),puntos.get(25).get(1),puntos.get(37).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(4).get(0),puntos.get(17).get(0),puntos.get(40).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(4).get(1),puntos.get(17).get(1),puntos.get(40).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(22).get(0),puntos.get(41).get(0),puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(22).get(1),puntos.get(41).get(1),puntos.get(35).get(1)));
        Caracter B = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,4);
        letras.add(B);
        
        ix = new ArrayList(Arrays.asList(puntos.get(4).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(0).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(42).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(42).get(1)));
        Caracter C = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,1);
        letras.add(C);
        
        ix = new ArrayList(Arrays.asList(puntos.get(0).get(0),puntos.get(36).get(0),puntos.get(33).get(0),puntos.get(33).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(36).get(1),puntos.get(33).get(1),puntos.get(33).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(36).get(0),puntos.get(33).get(0),puntos.get(0).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(36).get(1),puntos.get(33).get(1),puntos.get(0).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0),puntos.get(30).get(0),puntos.get(23).get(0),puntos.get(38).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1),puntos.get(30).get(1),puntos.get(23).get(1),puntos.get(38).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(31).get(0),puntos.get(38).get(0),puntos.get(2).get(0),puntos.get(40).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(31).get(1),puntos.get(38).get(1),puntos.get(2).get(1),puntos.get(40).get(1)));
        Caracter D = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,4);
        letras.add(D);
        
        ix = new ArrayList(Arrays.asList(puntos.get(10).get(0),puntos.get(21).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(10).get(1),puntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(21).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(21).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(30).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(31).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(44).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(44).get(1)));
        Caracter E = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,2);
        letras.add(E);
        
        ix = new ArrayList(Arrays.asList(puntos.get(14).get(0),puntos.get(0).get(0),puntos.get(20).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(14).get(1),puntos.get(0).get(1),puntos.get(20).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(0).get(0),puntos.get(4).get(0),puntos.get(22).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(4).get(1),puntos.get(22).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(44).get(0),puntos.get(0).get(0),puntos.get(20).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(44).get(1),puntos.get(0).get(1),puntos.get(20).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(42).get(0),puntos.get(5).get(0),puntos.get(23).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(42).get(1),puntos.get(5).get(1),puntos.get(23).get(1)));
        Caracter F = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(F);
        
        ix = new ArrayList(Arrays.asList(puntos.get(3).get(0),puntos.get(28).get(0),puntos.get(44).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(3).get(1),puntos.get(28).get(1),puntos.get(44).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(28).get(0),puntos.get(44).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(28).get(1),puntos.get(44).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(0).get(0),puntos.get(34).get(0),puntos.get(37).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(34).get(1),puntos.get(37).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(36).get(0),puntos.get(45).get(0),puntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(36).get(1),puntos.get(45).get(1),puntos.get(34).get(1)));
        Caracter G = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(G);
        
        ix = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(37).get(0),puntos.get(4).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(37).get(1),puntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(37).get(0),puntos.get(4).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(37).get(1),puntos.get(4).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(8).get(0),puntos.get(24).get(0),puntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(8).get(1),puntos.get(24).get(1),puntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(32).get(0),puntos.get(17).get(0),puntos.get(40).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(32).get(1),puntos.get(17).get(1),puntos.get(40).get(1)));
        Caracter H = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(H);
        
        ix = new ArrayList(Arrays.asList(puntos.get(13).get(0),puntos.get(9).get(0),puntos.get(36).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(13).get(1),puntos.get(9).get(1),puntos.get(36).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(11).get(0),puntos.get(38).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(11).get(1),puntos.get(38).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(6).get(0),puntos.get(15).get(0),puntos.get(37).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(6).get(1),puntos.get(15).get(1),puntos.get(37).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(11).get(0),puntos.get(32).get(0),puntos.get(41).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(11).get(1),puntos.get(32).get(1),puntos.get(41).get(1)));
        Caracter I = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(I);
        
        ix = new ArrayList(Arrays.asList(puntos.get(20).get(0),puntos.get(4).get(0),puntos.get(43).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(20).get(1),puntos.get(4).get(1),puntos.get(43).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(4).get(0),puntos.get(43).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(4).get(1),puntos.get(43).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(13).get(0),puntos.get(3).get(0),puntos.get(42).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(13).get(1),puntos.get(3).get(1),puntos.get(42).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(5).get(0),puntos.get(45).get(0),puntos.get(14).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(5).get(1),puntos.get(45).get(1),puntos.get(14).get(1)));
        Caracter J = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(J);
        
        ix = new ArrayList(Arrays.asList(puntos.get(6).get(0),puntos.get(25).get(0),puntos.get(25).get(0),puntos.get(39).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(6).get(1),puntos.get(25).get(1),puntos.get(25).get(1),puntos.get(39).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(37).get(0),puntos.get(10).get(0),puntos.get(39).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(37).get(1),puntos.get(10).get(1),puntos.get(39).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(33).get(0),puntos.get(26).get(0),puntos.get(40).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(33).get(1),puntos.get(26).get(1),puntos.get(40).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(16).get(0),puntos.get(33).get(0),puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(16).get(1),puntos.get(33).get(1),puntos.get(35).get(1)));
        Caracter K = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,4);
        letras.add(K);
        
        ix = new ArrayList(Arrays.asList(puntos.get(6).get(0),puntos.get(1).get(0),puntos.get(37).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(6).get(1),puntos.get(1).get(1),puntos.get(37).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(37).get(0),puntos.get(28).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(37).get(1),puntos.get(28).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(8).get(0),puntos.get(7).get(0),puntos.get(47).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(8).get(1),puntos.get(7).get(1),puntos.get(47).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(37).get(0),puntos.get(22).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(37).get(1),puntos.get(22).get(1)));
        Caracter L = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(L);
        
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0),puntos.get(37).get(0),puntos.get(39).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1),puntos.get(37).get(1),puntos.get(39).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(37).get(0),puntos.get(39).get(0),puntos.get(41).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(37).get(1),puntos.get(39).get(1),puntos.get(41).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(2).get(0),puntos.get(1).get(0),puntos.get(3).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(0).get(1),puntos.get(0).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(37).get(0),puntos.get(4).get(0),puntos.get(5).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(37).get(1),puntos.get(0).get(1),puntos.get(0).get(1)));
        Caracter M = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(M);
        
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0),puntos.get(38).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1),puntos.get(38).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(38).get(0),puntos.get(40).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(38).get(1),puntos.get(40).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(3).get(0),puntos.get(2).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(0).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(38).get(0),puntos.get(5).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(38).get(1),puntos.get(0).get(1)));
        Caracter N = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,2);
        letras.add(N);
        
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0),puntos.get(22).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1),puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(22).get(0),puntos.get(13).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(22).get(1),puntos.get(13).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(42).get(0),puntos.get(4).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(47).get(1),puntos.get(0).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(46).get(0),puntos.get(1).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(47).get(1),puntos.get(0).get(1)));
        Caracter O = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,2);
        letras.add(O);
        
        ix = new ArrayList(Arrays.asList(puntos.get(6).get(0),puntos.get(12).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(6).get(1),puntos.get(12).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(37).get(0),puntos.get(24).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(37).get(1),puntos.get(24).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(5).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(5).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(35).get(1)));
        Caracter P = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,2);
        letras.add(P);
        
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0),puntos.get(22).get(0),puntos.get(31).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1),puntos.get(22).get(1),puntos.get(31).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(22).get(0),puntos.get(31).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(22).get(1),puntos.get(31).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(42).get(0),puntos.get(4).get(0),puntos.get(26).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(47).get(1),puntos.get(0).get(1),puntos.get(26).get(0)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(46).get(0),puntos.get(1).get(0),puntos.get(40).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(47).get(1),puntos.get(0).get(1),puntos.get(40).get(1)));
        Caracter Q = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(Q);
        
        ix = new ArrayList(Arrays.asList(puntos.get(6).get(0),puntos.get(13).get(0),puntos.get(25).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(6).get(1),puntos.get(13).get(1),puntos.get(25).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(37).get(0),puntos.get(25).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(37).get(1),puntos.get(25).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(5).get(0),puntos.get(25).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(5).get(1),puntos.get(25).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(35).get(0),puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(35).get(1),puntos.get(35).get(1)));
        Caracter R = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(R);
        
        ix = new ArrayList(Arrays.asList(puntos.get(36).get(0),puntos.get(1).get(0),puntos.get(33).get(0),puntos.get(38).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(36).get(1),puntos.get(1).get(1),puntos.get(33).get(1),puntos.get(38).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(33).get(0),puntos.get(38).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(33).get(1),puntos.get(38).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(2).get(0),puntos.get(25).get(0),puntos.get(39).get(0),puntos.get(31).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(2).get(1),puntos.get(25).get(1),puntos.get(39).get(1),puntos.get(31).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(21).get(0),puntos.get(38).get(0),puntos.get(41).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(21).get(1),puntos.get(38).get(1),puntos.get(41).get(1)));
        Caracter S = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,4);
        letras.add(S);
        
        ix = new ArrayList(Arrays.asList(puntos.get(7).get(0),puntos.get(5).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(7).get(1),puntos.get(5).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(5).get(0),puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(5).get(1),puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(0).get(0),puntos.get(13).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(13).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(45).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(45).get(1)));
        Caracter T = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,2);
        letras.add(T);
        
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0),puntos.get(44).get(0),puntos.get(7).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1),puntos.get(44).get(1),puntos.get(7).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(44).get(0),puntos.get(46).get(0),puntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(44).get(1),puntos.get(46).get(1),puntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(3).get(0),puntos.get(2).get(0),puntos.get(2).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(0).get(1),puntos.get(2).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(44).get(0),puntos.get(5).get(0),puntos.get(15).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(44).get(1),puntos.get(0).get(1),puntos.get(15).get(1)));
        Caracter Ni = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(Ni);
        
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0),puntos.get(20).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1),puntos.get(20).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(35).get(0),puntos.get(16).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(35).get(1),puntos.get(16).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(14).get(0),puntos.get(36).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(14).get(1),puntos.get(36).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(16).get(0),puntos.get(39).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(16).get(1),puntos.get(39).get(1)));
        Caracter a = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,2);
        letras.add(a);
        return letras;
    }
    
    @FXML
    public void dibuja() throws IOException {
        int x = 0;
        int y = 0;
        Pane pane = new Pane();
        String frase=(this.cuadroTexto.getText());
        
        for (int i = 0; i < frase.length(); i++) {
            ArrayList<Caracter> letras=Empezar(x,y);
            letras.get((int)frase.charAt(i)-65).dibujar();
            pane.getChildren().add(letras.get((int)frase.charAt(i)-65).getPanel());
            x+=100;
            if(x>500){
                x=0;
                y+=140;
            }
        }
        
        canvas.setGraphic(pane);
        
        
        
        
        
        System.out.println(frase);
    }
}
