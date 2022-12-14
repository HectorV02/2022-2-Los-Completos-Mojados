package javaapplication1;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;

public class Caracter {

    int lineas;
    char chr;
    ArrayList<Integer> Ix, Iy, Fx, Fy, ch1x, ch1y, ch2x, ch2y, subrayado= new ArrayList();
    Pane root;

    public Caracter(ArrayList<Integer> Ix, ArrayList<Integer> Iy, ArrayList<Integer> Fx, ArrayList<Integer> Fy, ArrayList<Integer> ch1x,
            ArrayList<Integer> ch1y, ArrayList<Integer> ch2x, ArrayList<Integer> ch2y, Pane root, int lineas, ArrayList<Integer> subrayado,char chr) {
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
        this.subrayado = subrayado;
        this.chr = chr;
    }
    

    public void dibujar(Color color) {
        //dibujamos las lineas una por una 
        for (int i = 0; i < lineas; i++) {
            CubicCurve c = new CubicCurve(Ix.get(i), Iy.get(i), ch1x.get(i), ch1y.get(i), ch2x.get(i), ch2y.get(i), Fx.get(i), Fy.get(i));
            c.setFill(Color.TRANSPARENT);
            if (Ix.get(i) == Fx.get(i) && Iy.get(i) == Fy.get(i)) {
                c.setFill(color);
            }
            c.setStroke(color);
            root.getChildren().add(c);
        }
    }

    public void getCheckpoints(int s) {
        
        //dibujamos los checkpoints
        for (int i = 0; i < lineas; i++) {
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
            n = new Circle();
            n.setCenterX(ch1x.get(i));
            n.setCenterY(ch1y.get(i));
            n.setRadius(2);
            root.getChildren().add(n);
            n = new Circle();
            n.setCenterX(ch2x.get(i));
            n.setCenterY(ch2y.get(i));
            n.setRadius(2);
            root.getChildren().add(n);
        }
        if(s == 1){
            Circle n = new Circle();
            n.setCenterX(subrayado.get(0));
            n.setCenterY(subrayado.get(1));
            n.setRadius(2);
            root.getChildren().add(n);
            n = new Circle();
            n.setCenterX(subrayado.get(6));
            n.setCenterY(subrayado.get(7));
            n.setRadius(2);
            root.getChildren().add(n);
        }

    }
    
    //metodo que sube la primera linea de una letra
    public void subir() {  
        Iy.set(0, Iy.get(0)-20);
        ch1y.set(0, ch1y.get(0)-20);

    }
    
    //metodo para bajar la primera linea de una letra
    public void bajar(){
        Iy.set(0, Iy.get(0)+20);
        ch1y.set(0, ch1y.get(0)+20);
    }
    
    public void subrayado (Color color){
        CubicCurve a = new CubicCurve(subrayado.get(0), subrayado.get(1), subrayado.get(2), subrayado.get(3), subrayado.get(4), subrayado.get(5), subrayado.get(6), subrayado.get(7));
        a.setFill(Color.TRANSPARENT);
        a.setStroke(color);
        root.getChildren().add(a);
    }
    
    public void muevePuntos (){
        for (int i = 0; i < Ix.size(); i++) {
            //movimiento puntos de inicio
            switch (Iy.get(i)) {
                case 0 -> Ix.set(i, Ix.get(i)+35);
                case 20 -> Ix.set(i, Ix.get(i)+30);
                case 40 -> Ix.set(i, Ix.get(i)+25);
                case 60 -> Ix.set(i, Ix.get(i)+20);
                case 80 -> Ix.set(i, Ix.get(i)+15);
                case 100 -> Ix.set(i, Ix.get(i)+10);
                case 120 -> Ix.set(i, Ix.get(i)+5);
                case 140 -> Ix.set(i, Ix.get(i));
                default -> {
                }
            }
            //movimiento puntos de fin
            switch (Fy.get(i)) {
                case 0 -> Fx.set(i, Fx.get(i)+35);
                case 20 -> Fx.set(i, Fx.get(i)+30);
                case 40 -> Fx.set(i, Fx.get(i)+25);
                case 60 -> Fx.set(i, Fx.get(i)+20);
                case 80 -> Fx.set(i, Fx.get(i)+15);
                case 100 -> Fx.set(i, Fx.get(i)+10);
                case 120 -> Fx.set(i, Fx.get(i)+5);
                case 140 -> Fx.set(i, Fx.get(i));
                default -> {
                }
            }
            //movimiento puntos de control 1
            switch (ch1y.get(i)) {
                case 0 -> ch1x.set(i, ch1x.get(i)+35);
                case 20 -> ch1x.set(i, ch1x.get(i)+30);
                case 40 -> ch1x.set(i, ch1x.get(i)+25);
                case 60 -> ch1x.set(i, ch1x.get(i)+20);
                case 80 -> ch1x.set(i, ch1x.get(i)+15);
                case 100 -> ch1x.set(i, ch1x.get(i)+10);
                case 120 -> ch1x.set(i, ch1x.get(i)+5);
                case 140 -> ch1x.set(i, ch1x.get(i));
                default -> {
                }
            }
            //movimiento puntos de control 2
            switch (ch2y.get(i)) {
                case 0 -> ch2x.set(i, ch2x.get(i)+35);
                case 20 -> ch2x.set(i, ch2x.get(i)+30);
                case 40 -> ch2x.set(i, ch2x.get(i)+25);
                case 60 -> ch2x.set(i, ch2x.get(i)+20);
                case 80 -> ch2x.set(i, ch2x.get(i)+15);
                case 100 -> ch2x.set(i, ch2x.get(i)+10);
                case 120 -> ch2x.set(i, ch2x.get(i)+5);
                case 140 -> ch2x.set(i, ch2x.get(i));
                default -> {
                }
            }
        }
    }
    
    public void regresaPuntos (){
        for (int i = 0; i < Ix.size(); i++) {
            //movimiento puntos de inicio
            switch (Iy.get(i)) {
                case 0 -> Ix.set(i, Ix.get(i)-35);
                case 20 -> Ix.set(i, Ix.get(i)-30);
                case 40 -> Ix.set(i, Ix.get(i)-25);
                case 60 -> Ix.set(i, Ix.get(i)-20);
                case 80 -> Ix.set(i, Ix.get(i)-15);
                case 100 -> Ix.set(i, Ix.get(i)-10);
                case 120 -> Ix.set(i, Ix.get(i)-5);
                case 140 -> Ix.set(i, Ix.get(i));
                default -> {
                }
            }
            //movimiento puntos de fin
            switch (Fy.get(i)) {
                case 0 -> Fx.set(i, Fx.get(i)-35);
                case 20 -> Fx.set(i, Fx.get(i)-30);
                case 40 -> Fx.set(i, Fx.get(i)-25);
                case 60 -> Fx.set(i, Fx.get(i)-20);
                case 80 -> Fx.set(i, Fx.get(i)-15);
                case 100 -> Fx.set(i, Fx.get(i)-10);
                case 120 -> Fx.set(i, Fx.get(i)-5);
                case 140 -> Fx.set(i, Fx.get(i));
                default -> {
                }
            }
            //movimiento puntos de control 1
            switch (ch1y.get(i)) {
                case 0 -> ch1x.set(i, ch1x.get(i)-35);
                case 20 -> ch1x.set(i, ch1x.get(i)-30);
                case 40 -> ch1x.set(i, ch1x.get(i)-25);
                case 60 -> ch1x.set(i, ch1x.get(i)-20);
                case 80 -> ch1x.set(i, ch1x.get(i)-15);
                case 100 -> ch1x.set(i, ch1x.get(i)-10);
                case 120 -> ch1x.set(i, ch1x.get(i)-5);
                case 140 -> ch1x.set(i, ch1x.get(i));
                default -> {
                }
            }
            //movimiento puntos de control 2
            switch (ch2y.get(i)) {
                case 0 -> ch2x.set(i, ch2x.get(i)-35);
                case 20 -> ch2x.set(i, ch2x.get(i)-30);
                case 40 -> ch2x.set(i, ch2x.get(i)-25);
                case 60 -> ch2x.set(i, ch2x.get(i)-20);
                case 80 -> ch2x.set(i, ch2x.get(i)-15);
                case 100 -> ch2x.set(i, ch2x.get(i)-10);
                case 120 -> ch2x.set(i, ch2x.get(i)-5);
                case 140 -> ch2x.set(i, ch2x.get(i));
                default -> {
                }
            }
        }
    }

    public void negritas(Color color, int s) {
        //dibujamos multiples veces las lineas que faltan
        for (int i = 0; i < lineas; i++) {
            CubicCurve c = new CubicCurve(Ix.get(i) + 1, Iy.get(i) + 1, ch1x.get(i) + 1, ch1y.get(i) + 1, ch2x.get(i) + 1, ch2y.get(i) + 1, Fx.get(i) + 1, Fy.get(i) + 1);
            c.setFill(Color.TRANSPARENT);
            if (Ix.get(i) == Fx.get(i) && Iy.get(i) == Fy.get(i)) {
                c.setFill(color);
            }
            c.setStroke(color);
            root.getChildren().add(c);

            CubicCurve d = new CubicCurve(Ix.get(i) + 1, Iy.get(i), ch1x.get(i) + 1, ch1y.get(i), ch2x.get(i) + 1, ch2y.get(i), Fx.get(i) + 1, Fy.get(i));
            d.setFill(Color.TRANSPARENT);
            if (Ix.get(i) == Fx.get(i) && Iy.get(i) == Fy.get(i)) {
                d.setFill(color);
            }
            d.setStroke(color);
            root.getChildren().add(d);

            CubicCurve e = new CubicCurve(Ix.get(i), Iy.get(i) + 1, ch1x.get(i), ch1y.get(i) + 1, ch2x.get(i), ch2y.get(i) + 1, Fx.get(i), Fy.get(i) + 1);
            e.setFill(Color.TRANSPARENT);
            if (Ix.get(i) == Fx.get(i) && Iy.get(i) == Fy.get(i)) {
                e.setFill(color);
            }
            e.setStroke(color);
            root.getChildren().add(e);
        }
        if(s == 1){
            CubicCurve a = new CubicCurve(subrayado.get(0) + 1, subrayado.get(1) + 1, subrayado.get(2) + 1, subrayado.get(3) + 1, subrayado.get(4) + 1, subrayado.get(5) + 1, subrayado.get(6) + 1, subrayado.get(7) + 1);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(color);
            root.getChildren().add(a);
            a = new CubicCurve(subrayado.get(0) + 1, subrayado.get(1), subrayado.get(2) + 1, subrayado.get(3), subrayado.get(4) + 1, subrayado.get(5), subrayado.get(6) + 1, subrayado.get(7));
            a.setFill(Color.TRANSPARENT);
            a.setStroke(color);
            root.getChildren().add(a);
            a = new CubicCurve(subrayado.get(0), subrayado.get(1) + 1, subrayado.get(2), subrayado.get(3) + 1, subrayado.get(4), subrayado.get(5) + 1, subrayado.get(6), subrayado.get(7) + 1);
            a.setFill(Color.TRANSPARENT);
            a.setStroke(color);
            root.getChildren().add(a);
        }
    }

    public Pane getPanel() {
        return root;
    }
}
