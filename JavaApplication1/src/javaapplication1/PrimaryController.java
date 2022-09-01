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
        p.setMaxSize(100, 100);
        p.setMinSize(100, 100);
        //p.setStyle("-fx-background-color: blue;");
        //p.relocate(x, y);
        p.setTranslateX(x);
        p.setTranslateY(y);
        ArrayList<ArrayList> puntos = new ArrayList();
        for (int i = 0; i < 6; i++) { 
            for (int j = 0; j < 6; j++) {
                ArrayList<Integer> xy = new ArrayList();
                xy.add(20 * j);
                xy.add(20 * i);
                puntos.add(xy);
            }   
        }
        //letra a minuscula
        ArrayList<Integer> ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(14).get(0)));  
        ArrayList<Integer> iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(14).get(1)));
        ArrayList<Integer> fx = new ArrayList(Arrays.asList(puntos.get(29).get(0),puntos.get(10).get(0)));
        ArrayList<Integer> fy = new ArrayList(Arrays.asList(puntos.get(29).get(1),puntos.get(10).get(1)));
        ArrayList<Integer> ch1x = new ArrayList(Arrays.asList(puntos.get(8).get(0),puntos.get(30).get(0)));
        ArrayList<Integer> ch1y = new ArrayList(Arrays.asList(puntos.get(8).get(1),puntos.get(30).get(1)));
        ArrayList<Integer> ch2x = new ArrayList(Arrays.asList(puntos.get(10).get(0),puntos.get(33).get(0)));
        ArrayList<Integer> ch2y = new ArrayList(Arrays.asList(puntos.get(10).get(1),puntos.get(33).get(1)));
        Caracter a = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,ix.size());
        ArrayList<Caracter> letras = new ArrayList();
        letras.add(a);
        
        // letra b minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(2).get(0),puntos.get(21).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(2).get(1),puntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(2).get(0),puntos.get(21).get(0),puntos.get(23).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(2).get(1),puntos.get(21).get(1),puntos.get(23).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(26).get(0),puntos.get(30).get(0),puntos.get(21).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(26).get(1),puntos.get(30).get(1),puntos.get(21).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(33).get(0),puntos.get(28).get(0)));
        ch2y= new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(33).get(1),puntos.get(28).get(1)));
        Caracter b = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,ix.size());
        letras.add(b);
        
        // letra c minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(16).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(16).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(16).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(16).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(26).get(0),puntos.get(13).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(26).get(1),puntos.get(13).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(13).get(0),puntos.get(31).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(13).get(1),puntos.get(31).get(1)));
        Caracter c = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,ix.size());
        letras.add(c);
        
        // letra d minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(14).get(0),puntos.get(21).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(14).get(1),puntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(21).get(0),puntos.get(4).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(21).get(1),puntos.get(4).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(8).get(0),puntos.get(30).get(0),puntos.get(27).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(8).get(1),puntos.get(30).get(1),puntos.get(27).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(10).get(0),puntos.get(33).get(0),puntos.get(27).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(10).get(1),puntos.get(33).get(1),puntos.get(27).get(1)));
        Caracter d = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,ix.size());
        letras.add(d);
        
        //letra e minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(14).get(0),puntos.get(15).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(14).get(1),puntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(29).get(0),puntos.get(14).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(29).get(1),puntos.get(14).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(26).get(0),puntos.get(20).get(0),puntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(26).get(1),puntos.get(20).get(1),puntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(21).get(0),puntos.get(27).get(0),puntos.get(8).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(21).get(1),puntos.get(27).get(1),puntos.get(8).get(1)));
        Caracter e = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,ix.size());
        letras.add(e);
        
        //letra f minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(2).get(0),puntos.get(32).get(0),puntos.get(19).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(2).get(1),puntos.get(32).get(1),puntos.get(19).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(2).get(0),puntos.get(32).get(0),puntos.get(19).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(2).get(1),puntos.get(32).get(1),puntos.get(19).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(26).get(0),puntos.get(24).get(0),puntos.get(33).get(0),puntos.get(25).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(26).get(1),puntos.get(24).get(1),puntos.get(33).get(1),puntos.get(25).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(31).get(0),puntos.get(14).get(0),puntos.get(32).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(31).get(1),puntos.get(14).get(1),puntos.get(32).get(1)));
        Caracter f = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,ix.size());
        letras.add(f);
        
        //letra g minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(15).get(0),puntos.get(21).get(0),puntos.get(32).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(15).get(1),puntos.get(21).get(1),puntos.get(32).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(21).get(0),puntos.get(32).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(21).get(1),puntos.get(32).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(19).get(0),puntos.get(13).get(0),puntos.get(28).get(0),puntos.get(25).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(19).get(1),puntos.get(13).get(1),puntos.get(28).get(1),puntos.get(25).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(13).get(0),puntos.get(25).get(0),puntos.get(33).get(0),puntos.get(21).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(13).get(1),puntos.get(25).get(1),puntos.get(33).get(1),puntos.get(21).get(1)));
        Caracter g = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,ix.size());
        letras.add(g);
        
        //letra h minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(3).get(0),puntos.get(26).get(0),puntos.get(22).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(3).get(1),puntos.get(26).get(1),puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(3).get(0),puntos.get(26).get(0),puntos.get(22).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(3).get(1),puntos.get(26).get(1),puntos.get(22).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(21).get(0),puntos.get(3).get(0),puntos.get(14).get(0),puntos.get(28).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(21).get(1),puntos.get(3).get(1),puntos.get(14).get(1),puntos.get(28).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(4).get(0),puntos.get(8).get(0),puntos.get(16).get(0),puntos.get(28).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(4).get(1),puntos.get(8).get(1),puntos.get(16).get(1),puntos.get(28).get(1)));
        Caracter h = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,ix.size());
        letras.add(h);
        
        //letra i minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(15).get(0),puntos.get(9).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(15).get(1),puntos.get(9).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(29).get(0),puntos.get(9).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(29).get(1),puntos.get(9).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(26).get(0),puntos.get(27).get(0),puntos.get(10).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(26).get(1),puntos.get(27).get(1),puntos.get(10).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(21).get(0),puntos.get(27).get(0),puntos.get(3).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(21).get(1),puntos.get(27).get(1),puntos.get(3).get(1)));
        Caracter i = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,ix.size());
        letras.add(i);
        
        // letra j minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(15).get(0),puntos.get(9).get(0),puntos.get(32).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(15).get(1),puntos.get(9).get(1),puntos.get(32).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(32).get(0),puntos.get(9).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(32).get(1),puntos.get(9).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(26).get(0),puntos.get(22).get(0),puntos.get(10).get(0),puntos.get(25).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(26).get(1),puntos.get(22).get(1),puntos.get(10).get(1),puntos.get(25).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(21).get(0),puntos.get(33).get(0),puntos.get(3).get(0),puntos.get(21).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(21).get(1),puntos.get(33).get(1),puntos.get(3).get(1),puntos.get(21).get(1)));
        Caracter j = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,ix.size());
        letras.add(j);
        
        // letra k minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(3).get(0), puntos.get(26).get(0), puntos.get(21).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(3).get(1), puntos.get(26).get(1), puntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(3).get(0), puntos.get(26).get(0), puntos.get(21).get(0), puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(3).get(1), puntos.get(26).get(1), puntos.get(21).get(1), puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(21).get(0), puntos.get(3).get(0), puntos.get(14).get(0), puntos.get(22).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(21).get(1), puntos.get(3).get(1), puntos.get(14).get(1), puntos.get(22).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(4).get(0), puntos.get(8).get(0), puntos.get(16).get(0), puntos.get(26).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(4).get(1), puntos.get(8).get(1), puntos.get(16).get(1), puntos.get(26).get(1)));
        Caracter k = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(k);
        
        //letra l minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(8).get(0), puntos.get(9).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(8).get(1), puntos.get(9).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(9).get(0), puntos.get(29).get(0), puntos.get(8).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(9).get(1), puntos.get(29).get(1), puntos.get(8).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(20).get(0), puntos.get(3).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(20).get(1), puntos.get(3).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(21).get(0), puntos.get(27).get(0), puntos.get(2).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(21).get(1), puntos.get(27).get(1), puntos.get(2).get(1)));
        Caracter l = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(l);
        
        //letra m minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(26).get(0), puntos.get(27).get(0), puntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(26).get(1), puntos.get(27).get(1), puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(27).get(0), puntos.get(22).get(0), puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(27).get(1), puntos.get(22).get(1), puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(13).get(0), puntos.get(14).get(0), puntos.get(15).get(0), puntos.get(28).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(13).get(1), puntos.get(14).get(1), puntos.get(15).get(1), puntos.get(28).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(14).get(0), puntos.get(15).get(0), puntos.get(16).get(0), puntos.get(28).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(14).get(1), puntos.get(15).get(1), puntos.get(16).get(1), puntos.get(28).get(1)));
        Caracter m = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(m);
        
        //letra n minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(26).get(0), puntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(26).get(1), puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(22).get(0), puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(22).get(1), puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(13).get(0), puntos.get(14).get(0), puntos.get(28).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(13).get(1), puntos.get(14).get(1), puntos.get(28).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(14).get(0), puntos.get(16).get(0), puntos.get(28).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(14).get(1), puntos.get(16).get(1), puntos.get(28).get(1)));
        Caracter n = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(n);
        
        //letra ñ minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(26).get(0), puntos.get(7).get(0), puntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(26).get(1), puntos.get(7).get(1), puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(22).get(0), puntos.get(10).get(0), puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(22).get(1), puntos.get(10).get(1), puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(13).get(0), puntos.get(14).get(0), puntos.get(2).get(0), puntos.get(28).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(13).get(1), puntos.get(14).get(1), puntos.get(2).get(1), puntos.get(28).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(14).get(0), puntos.get(16).get(0), puntos.get(15).get(0), puntos.get(28).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(14).get(1), puntos.get(16).get(1), puntos.get(15).get(1), puntos.get(28).get(1)));
        Caracter ñ = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size()); 
        //letras.add(ñ);
        
        //letra o minuscula;
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(15).get(0), puntos.get(26).get(0), puntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(15).get(1), puntos.get(26).get(1), puntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(15).get(0), puntos.get(26).get(0), puntos.get(15).get(0), puntos.get(23).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(15).get(1), puntos.get(26).get(1), puntos.get(15).get(1), puntos.get(23).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(13).get(0), puntos.get(28).get(0), puntos.get(13).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(13).get(1), puntos.get(28).get(1), puntos.get(13).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(13).get(0), puntos.get(25).get(0), puntos.get(16).get(0), puntos.get(26).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(13).get(1), puntos.get(25).get(1), puntos.get(16).get(1), puntos.get(26).get(1)));
        Caracter o = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(o);
        
        //letra p minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(14).get(0), puntos.get(32).get(0), puntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(14).get(1), puntos.get(32).get(1), puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(14).get(0), puntos.get(32).get(0), puntos.get(22).get(0), puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(14).get(1), puntos.get(32).get(1), puntos.get(22).get(1), puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(25).get(0), puntos.get(14).get(0), puntos.get(13).get(0), puntos.get(34).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(25).get(1), puntos.get(14).get(1), puntos.get(13).get(1), puntos.get(34).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(32).get(0), puntos.get(10).get(0), puntos.get(26).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(32).get(1), puntos.get(10).get(1), puntos.get(26).get(1)));
        Caracter pe = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(pe);
        
        //letra q minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(15).get(0),puntos.get(21).get(0),puntos.get(32).get(0),puntos.get(21).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(15).get(1),puntos.get(21).get(1),puntos.get(32).get(1),puntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(21).get(0),puntos.get(32).get(0),puntos.get(21).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(21).get(1),puntos.get(32).get(1),puntos.get(21).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(19).get(0),puntos.get(13).get(0),puntos.get(21).get(0),puntos.get(33).get(0),puntos.get(26).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(19).get(1),puntos.get(13).get(1),puntos.get(21).get(1),puntos.get(33).get(1),puntos.get(26).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(13).get(0),puntos.get(25).get(0),puntos.get(32).get(0),puntos.get(27).get(0),puntos.get(32).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(13).get(1),puntos.get(25).get(1),puntos.get(32).get(1),puntos.get(27).get(1),puntos.get(32).get(1)));
        Caracter q = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(q);
        
        //letra r minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(14).get(0),puntos.get(16).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(14).get(1),puntos.get(16).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(14).get(0),puntos.get(16).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(14).get(1),puntos.get(16).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(25).get(0),puntos.get(20).get(0),puntos.get(21).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(25).get(1),puntos.get(20).get(1),puntos.get(21).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(20).get(0),puntos.get(22).get(0),puntos.get(27).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(20).get(1),puntos.get(22).get(1),puntos.get(27).get(1)));
        Caracter r = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(r);
        
        //letra s minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(14).get(0),puntos.get(27).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(14).get(1),puntos.get(27).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(14).get(0),puntos.get(27).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(14).get(1),puntos.get(27).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(25).get(0),puntos.get(22).get(0),puntos.get(27).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(25).get(1),puntos.get(22).get(1),puntos.get(27).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(20).get(0),puntos.get(28).get(0),puntos.get(29).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(20).get(1),puntos.get(28).get(1),puntos.get(29).get(1)));
        Caracter s = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(s);
        
        //letra t minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(9).get(0),puntos.get(13).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(9).get(1),puntos.get(13).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(9).get(0),puntos.get(29).get(0),puntos.get(17).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(9).get(1),puntos.get(29).get(1),puntos.get(17).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(27).get(0),puntos.get(21).get(0),puntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(27).get(1),puntos.get(21).get(1),puntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(27).get(0),puntos.get(21).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(27).get(1),puntos.get(21).get(1)));
        Caracter t = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(t);
        
        //letra u minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(14).get(0),puntos.get(16).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(14).get(1),puntos.get(16).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(14).get(0),puntos.get(16).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(14).get(1),puntos.get(16).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(25).get(0),puntos.get(32).get(0),puntos.get(28).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(25).get(1),puntos.get(32).get(1),puntos.get(28).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(20).get(0),puntos.get(34).get(0),puntos.get(28).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(20).get(1),puntos.get(34).get(1),puntos.get(28).get(1)));
        Caracter u = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(u);
        
        //letra v minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(14).get(0),puntos.get(27).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(14).get(1),puntos.get(27).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(14).get(0),puntos.get(27).get(0),puntos.get(23).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(14).get(1),puntos.get(27).get(1),puntos.get(23).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(25).get(0),puntos.get(15).get(0),puntos.get(28).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(25).get(1),puntos.get(15).get(1),puntos.get(28).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(13).get(0),puntos.get(26).get(0),puntos.get(21).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(13).get(1),puntos.get(26).get(1),puntos.get(21).get(1)));
        Caracter v = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(v);
        
        //letra w minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(14).get(0), puntos.get(15).get(0), puntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(14).get(1), puntos.get(15).get(1), puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(14).get(0), puntos.get(15).get(0), puntos.get(22).get(0), puntos.get(23).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(14).get(1), puntos.get(15).get(1), puntos.get(22).get(1), puntos.get(23).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(25).get(0), puntos.get(32).get(0), puntos.get(33).get(0), puntos.get(16).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(25).get(1), puntos.get(32).get(1), puntos.get(33).get(1), puntos.get(16).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(33).get(0), puntos.get(34).get(0), puntos.get(23).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(33).get(1), puntos.get(34).get(1), puntos.get(23).get(1)));
        Caracter w = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(w);
        
        //letras x minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(14).get(0), puntos.get(28).get(0), puntos.get(26).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(14).get(1), puntos.get(28).get(1), puntos.get(26).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(14).get(0), puntos.get(28).get(0), puntos.get(23).get(0), puntos.get(16).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(14).get(1), puntos.get(28).get(1), puntos.get(23).get(1), puntos.get(16).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(15).get(0), puntos.get(29).get(0), puntos.get(16).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(15).get(1), puntos.get(29).get(1), puntos.get(16).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(13).get(0), puntos.get(27).get(0), puntos.get(23).get(0), puntos.get(26).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(13).get(1), puntos.get(27).get(1), puntos.get(23).get(1), puntos.get(26).get(1)));
        Caracter ex = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(ex);
        
        //letra y minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(14).get(0),puntos.get(16).get(0),puntos.get(32).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(14).get(1),puntos.get(16).get(1),puntos.get(32).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(14).get(0),puntos.get(16).get(0),puntos.get(32).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(14).get(1),puntos.get(16).get(1),puntos.get(32).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(25).get(0),puntos.get(26).get(0),puntos.get(28).get(0),puntos.get(25).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(25).get(1),puntos.get(26).get(1),puntos.get(28).get(1),puntos.get(25).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(20).get(0),puntos.get(27).get(0),puntos.get(33).get(0),puntos.get(21).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(20).get(1),puntos.get(27).get(1),puntos.get(33).get(1),puntos.get(21).get(1)));
        Caracter ye = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(ye);
        
        //letra z minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(15).get(0),puntos.get(21).get(0),puntos.get(32).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(15).get(1),puntos.get(21).get(1),puntos.get(32).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(21).get(0),puntos.get(32).get(0),puntos.get(23).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(21).get(1),puntos.get(32).get(1),puntos.get(23).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(25).get(0),puntos.get(16).get(0),puntos.get(28).get(0),puntos.get(25).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(25).get(1),puntos.get(16).get(1),puntos.get(28).get(1),puntos.get(25).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(14).get(0),puntos.get(22).get(0),puntos.get(33).get(0),puntos.get(21).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(14).get(1),puntos.get(22).get(1),puntos.get(33).get(1),puntos.get(21).get(1)));
        Caracter z = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(z);
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
            letras.get((int)frase.charAt(i)-97).dibujar();
            pane.getChildren().add(letras.get((int)frase.charAt(i)-97).getPanel());
            x = x + 100;
            if (x > 500 ) {
                x = 0;
                y = y +100;
            }
        }
        
        canvas.setGraphic(pane);
        
        
        
        
        
        System.out.println(frase);
    }
}
