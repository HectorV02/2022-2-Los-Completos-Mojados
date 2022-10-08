package javaapplication1;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;

public class Caracter {

    int lineas;
    ArrayList<Integer> Ix, Iy, Fx, Fy, ch1x, ch1y, ch2x, ch2y = new ArrayList();
    Pane root;

    public Caracter(ArrayList<Integer> Ix, ArrayList<Integer> Iy, ArrayList<Integer> Fx, ArrayList<Integer> Fy, ArrayList<Integer> ch1x,
            ArrayList<Integer> ch1y, ArrayList<Integer> ch2x, ArrayList<Integer> ch2y, Pane root, int lineas) {
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

    public void getCheckpoints() {
        
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

    }
    
    //metodo que sube la primera linea de una letra
    public void subir(Color color) {
        //borramos la letra que empieza desde abajo
        root.getChildren().clear();
        
        //dibujamos la primera linea desde mas arriba
        CubicCurve a = new CubicCurve(Ix.get(0), Iy.get(0) - 20, ch1x.get(0), ch1y.get(0) - 20, ch2x.get(0), ch2y.get(0), Fx.get(0), Fy.get(0));
        a.setFill(Color.TRANSPARENT);
        if (Ix.get(0) == Fx.get(0) && Iy.get(0) == Fy.get(0)) {
            a.setFill(color);
        }
        a.setStroke(color);
        root.getChildren().add(a);
        
        //Dibujamos el resto de la letra normalmente
        for (int i = 1; i < lineas; i++) {
            CubicCurve c = new CubicCurve(Ix.get(i), Iy.get(i), ch1x.get(i), ch1y.get(i), ch2x.get(i), ch2y.get(i), Fx.get(i), Fy.get(i));
            c.setFill(Color.TRANSPARENT);
            if (Ix.get(i) == Fx.get(i) && Iy.get(i) == Fy.get(i)) {
                c.setFill(color);
            }
            c.setStroke(color);
            root.getChildren().add(c);
        }
    }

    public void negritas(Color color, int aux) {
        
        //se necesita la ayuda de un auxiliar para saber si se aplico el metodo subir sobre la letra
        //dibujamos la primera linea tres veces
        CubicCurve a = new CubicCurve(Ix.get(0) + 1, Iy.get(0)-aux + 1, ch1x.get(0) + 1, ch1y.get(0) -aux + 1, ch2x.get(0) + 1, ch2y.get(0) + 1, Fx.get(0) + 1, Fy.get(0) + 1);
        a.setFill(Color.TRANSPARENT);
        if (Ix.get(0) == Fx.get(0) && Iy.get(0) == Fy.get(0)) {
            a.setFill(color);
        }
        a.setStroke(color);
        root.getChildren().add(a);

        CubicCurve b = new CubicCurve(Ix.get(0) + 1, Iy.get(0)-aux, ch1x.get(0) + 1, ch1y.get(0)-aux, ch2x.get(0) + 1, ch2y.get(0), Fx.get(0) + 1, Fy.get(0));
        b.setFill(Color.TRANSPARENT);
        if (Ix.get(0) == Fx.get(0) && Iy.get(0) == Fy.get(0)) {
            b.setFill(color);
        }
        b.setStroke(color);
        root.getChildren().add(b);

        CubicCurve f = new CubicCurve(Ix.get(0), Iy.get(0) -aux + 1, ch1x.get(0), ch1y.get(0) -aux + 1, ch2x.get(0), ch2y.get(0) + 1, Fx.get(0), Fy.get(0) + 1);
        f.setFill(Color.TRANSPARENT);
        if (Ix.get(0) == Fx.get(0) && Iy.get(0) == Fy.get(0)) {
            f.setFill(color);
        }
        f.setStroke(color);
        root.getChildren().add(f);
        
        //dibujamos multiples veces las lineas que faltan
        for (int i = 1; i < lineas; i++) {
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

    }

    public Pane getPanel() {
        return root;
    }
}
