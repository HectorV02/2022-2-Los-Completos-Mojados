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
        p.setStyle("-fx-background-color: gray;");
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
        return mayusculas(p, puntos);
    }
    public static ArrayList<Caracter> mayusculas(Pane p, ArrayList<ArrayList
            > puntos){
        ArrayList<Integer> ix = new ArrayList(Arrays.asList(puntos.get(7).get(0),puntos.get(7).get(0)));  
        ArrayList<Integer> iy = new ArrayList(Arrays.asList(puntos.get(7).get(1),puntos.get(7).get(1)));
        ArrayList<Integer> fx = new ArrayList(Arrays.asList(puntos.get(21).get(0),puntos.get(29).get(0)));
        ArrayList<Integer> fy = new ArrayList(Arrays.asList(puntos.get(21).get(1),puntos.get(29).get(1)));
        ArrayList<Integer> ch1x = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(5).get(0)));
        ArrayList<Integer> ch1y = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(5).get(1)));
        ArrayList<Integer> ch2x = new ArrayList(Arrays.asList(puntos.get(32).get(0),puntos.get(31).get(0)));
        ArrayList<Integer> ch2y = new ArrayList(Arrays.asList(puntos.get(32).get(1),puntos.get(31).get(1)));
        Caracter A = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,2);
        ArrayList<Caracter> letras = new ArrayList();
        letras.add(A);
        
        ix = new ArrayList(Arrays.asList(puntos.get(6).get(0),puntos.get(7).get(0),puntos.get(19).get(0),puntos.get(31).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(6).get(1),puntos.get(7).get(1),puntos.get(19).get(1),puntos.get(31).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(31).get(0),puntos.get(19).get(0),puntos.get(31).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(31).get(1),puntos.get(19).get(1),puntos.get(31).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(4).get(0),puntos.get(11).get(0),puntos.get(34).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(4).get(1),puntos.get(11).get(1),puntos.get(34).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(16).get(0),puntos.get(35).get(0),puntos.get(29).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1),puntos.get(16).get(1),puntos.get(35).get(1),puntos.get(29).get(1)));
        Caracter B = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,4);
        letras.add(B);
        
        //arreglar
        ix = new ArrayList(Arrays.asList(puntos.get(4).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(0).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(30).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(30).get(1)));
        Caracter C = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,1);
        letras.add(C);
        
        ix = new ArrayList(Arrays.asList(puntos.get(0).get(0),puntos.get(30).get(0),puntos.get(27).get(0),puntos.get(27).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(30).get(1),puntos.get(27).get(1),puntos.get(27).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(30).get(0),puntos.get(27).get(0),puntos.get(0).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(30).get(1),puntos.get(27).get(1),puntos.get(0).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(25).get(0),puntos.get(24).get(0),puntos.get(17).get(0),puntos.get(32).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(25).get(1),puntos.get(24).get(1),puntos.get(17).get(1),puntos.get(32).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(25).get(0),puntos.get(32).get(0),puntos.get(2).get(0),puntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(25).get(1),puntos.get(32).get(1),puntos.get(2).get(1),puntos.get(34).get(1)));
        Caracter D = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,4);
        letras.add(D);
        
        ix = new ArrayList(Arrays.asList(puntos.get(10).get(0),puntos.get(15).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(10).get(1),puntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(15).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(15).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(2).get(0),puntos.get(24).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(2).get(1),puntos.get(25).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(19).get(0),puntos.get(33).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(19).get(1),puntos.get(33).get(1)));
        Caracter E = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,2);
        letras.add(E);
        
        ix = new ArrayList(Arrays.asList(puntos.get(8).get(0),puntos.get(0).get(0),puntos.get(14).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(8).get(1),puntos.get(0).get(1),puntos.get(14).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(0).get(0),puntos.get(4).get(0),puntos.get(16).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(4).get(1),puntos.get(16).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(32).get(0),puntos.get(0).get(0),puntos.get(14).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(32).get(1),puntos.get(0).get(1),puntos.get(14).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(30).get(0),puntos.get(5).get(0),puntos.get(17).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(30).get(1),puntos.get(5).get(1),puntos.get(17).get(1)));
        Caracter F = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(F);
        
        ix = new ArrayList(Arrays.asList(puntos.get(3).get(0),puntos.get(22).get(0),puntos.get(31).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(3).get(1),puntos.get(22).get(1),puntos.get(31).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(22).get(0),puntos.get(31).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(22).get(1),puntos.get(31).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(0).get(0),puntos.get(28).get(0),puntos.get(24).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(28).get(1),puntos.get(24).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(30).get(0),puntos.get(32).get(0),puntos.get(28).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(30).get(1),puntos.get(32).get(1),puntos.get(28).get(1)));
        Caracter G = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(G);
        
        ix = new ArrayList(Arrays.asList(puntos.get(1).get(0),puntos.get(31).get(0),puntos.get(4).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(0).get(1),puntos.get(31).get(1),puntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(31).get(0),puntos.get(4).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(31).get(1),puntos.get(4).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(2).get(0),puntos.get(24).get(0),puntos.get(3).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(2).get(1),puntos.get(24).get(1),puntos.get(3).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(32).get(0),puntos.get(11).get(0),puntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(32).get(1),puntos.get(11).get(1),puntos.get(34).get(1)));
        Caracter H = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(H);
        
        ix = new ArrayList(Arrays.asList(puntos.get(13).get(0),puntos.get(9).get(0),puntos.get(30).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(13).get(1),puntos.get(9).get(1),puntos.get(30).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(11).get(0),puntos.get(32).get(0),puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(11).get(1),puntos.get(32).get(1),puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(6).get(0),puntos.get(15).get(0),puntos.get(31).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(6).get(1),puntos.get(15).get(1),puntos.get(31).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(11).get(0),puntos.get(26).get(0),puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(11).get(1),puntos.get(26).get(1),puntos.get(35).get(1)));
        Caracter I = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,p,3);
        letras.add(I);
        
        ix = new ArrayList(Arrays.asList(puntos.get(24).get(0),puntos.get(14).get(0)));  
        iy = new ArrayList(Arrays.asList(puntos.get(24).get(1),puntos.get(14).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(29).get(0),puntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(29).get(1),puntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(8).get(0),puntos.get(30).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(8).get(1),puntos.get(30).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(10).get(0),puntos.get(33).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(10).get(1),puntos.get(33).get(1)));
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
            x = x + 100;
        }
        
        canvas.setGraphic(pane);
        
        
        
        
        
        System.out.println(frase);
    }
}
