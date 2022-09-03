/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;


/**
 *  
 * @author PC GAMER
 */
public class Caracter{
    int lineas;
    ArrayList<Integer> Ix,Iy,Fx,Fy,ch1x,ch1y,ch2x,ch2y = new ArrayList();
    Pane root;
    public Caracter(ArrayList<Integer> Ix,ArrayList<Integer> Iy,ArrayList<Integer> Fx,ArrayList<Integer> Fy,ArrayList<Integer> ch1x,
            ArrayList<Integer> ch1y,ArrayList<Integer> ch2x,ArrayList<Integer> ch2y,Pane root, int lineas){
        this.Ix = Ix;
        this.Iy = Iy;
        this.Fx = Fx;
        this.Fy = Fy;
        this.ch1x = ch1x;
        this.ch1y = ch1y;
        this.ch2x = ch2x;
        this.ch2y = ch2y;
        this.root = root;
        this.lineas = lineas;
    }
    public void dibujar(){
        for (int i = 0; i < lineas; i++) {
            CubicCurve c = new CubicCurve(Ix.get(i),Iy.get(i),ch1x.get(i),ch1y.get(i),ch2x.get(i),ch2y.get(i),Fx.get(i),Fy.get(i));
             c.setFill(Color.TRANSPARENT);
             c.setStroke(Color.BLACK);
             root.getChildren().add(c);             
        }
    }
    public void getCheckpoints(){
        int i = 0;
        for (i = 0; i < lineas; i++) {
            Circle n = new Circle();
            n.setCenterX(Ix.get(i));
            n.setCenterY(Iy.get(i));
            n.setRadius(2);
            root.getChildren().add(n);
            n = new Circle();
            n.setCenterX(Fx.get(i));
            n.setCenterY(Fy.get(i));
            n.setRadius(2);
            root.getChildren().add(n);
        }
        
    }
    public Pane getPanel(){
        return root;
    }
}

