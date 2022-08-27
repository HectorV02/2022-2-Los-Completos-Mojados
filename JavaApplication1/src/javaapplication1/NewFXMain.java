/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

/**
 *
 * @author PC GAMER
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 500);
        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: blue;");
        canvas.setPrefSize(100, 100);
        canvas.relocate(0, 0);
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
        
        letras.get(0).dibujar();
        
        root.getChildren().add(canvas);
        primaryStage.setTitle("Probando");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
