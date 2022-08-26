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
import javafx.scene.*;
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
        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 500, 500);
        /*CubicCurve c = new CubicCurve(100,200,160,120,175,200,200,200);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        CubicCurve c1 = new CubicCurve(150,150,120,180,150,200,200,150);
        c1.setFill(Color.TRANSPARENT);
        c1.setStroke(Color.BLACK);
        c1.setStrokeWidth(3);
        c.setStrokeWidth(3);*/
        ArrayList<Integer> ix = new ArrayList(Arrays.asList(100,150));  
        ArrayList<Integer> iy = new ArrayList(Arrays.asList(200,150));
        ArrayList<Integer> fx = new ArrayList(Arrays.asList(200,200));
        ArrayList<Integer> fy = new ArrayList(Arrays.asList(200,150));
        ArrayList<Integer> ch1x = new ArrayList(Arrays.asList(160,120));
        ArrayList<Integer> ch1y = new ArrayList(Arrays.asList(120,180));
        ArrayList<Integer> ch2x = new ArrayList(Arrays.asList(175,150));
        ArrayList<Integer> ch2y = new ArrayList(Arrays.asList(200,200));
        Caracter a = new Caracter(ix,iy,fx,fy,ch1x,ch1y,ch2x,ch2y,root,2);
        ArrayList<Caracter> letras = new ArrayList();
        letras.add(a);
        
        letras.get(0).dibujar();
        /*        root.getChildren().add(c);
        root.getChildren().add(c1);*/
        primaryStage.setTitle("Matenme");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
