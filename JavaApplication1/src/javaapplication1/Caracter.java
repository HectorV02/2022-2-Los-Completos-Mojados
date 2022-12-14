package javaapplication1;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;

public class Caracter {

    int lineas, width;
    char chr;
    ArrayList<Integer> Ix, Iy, Fx, Fy, ch1x, ch1y, ch2x, ch2y, subrayado = new ArrayList();
    Pane root;

    public Caracter(ArrayList<Integer> Ix, ArrayList<Integer> Iy, ArrayList<Integer> Fx, ArrayList<Integer> Fy, ArrayList<Integer> ch1x,
            ArrayList<Integer> ch1y, ArrayList<Integer> ch2x, ArrayList<Integer> ch2y, Pane root, int lineas, ArrayList<Integer> subrayado, char chr) {
        this.Ix = Ix;
        this.Iy = Iy;
        this.Fx = Fx;
        this.Fy = Fy;
        this.ch1x = ch1x;
        this.ch1y = ch1y;
        this.ch2x = ch2x;
        this.ch2y = ch2y;
        this.root = root;
        width = (int) root.getMaxWidth();
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
        if (s == 1) {
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
    public void subir(int tam) {
        Iy.set(0, Iy.get(0) - tam);
        ch1y.set(0, ch1y.get(0) - tam);

    }

    //metodo para bajar la primera linea de una letra
    public void bajar(int tam) {
        Iy.set(0, Iy.get(0) + tam);
        ch1y.set(0, ch1y.get(0) + tam);
    }

    public void subrayado(Color color) {
        CubicCurve a = new CubicCurve(subrayado.get(0), subrayado.get(1), subrayado.get(2), subrayado.get(3), subrayado.get(4), subrayado.get(5), subrayado.get(6), subrayado.get(7));
        a.setFill(Color.TRANSPARENT);
        a.setStroke(color);
        root.getChildren().add(a);
    }

    public void muevePuntos(int tam) {
        for (int i = 0; i < Ix.size(); i++) {
            //movimiento puntos de inicio
            for (int j = 0; j < 8; j++) {
                if (Iy.get(i) == tam * j) {
                    Ix.set(i, Ix.get(i) + (int) ((tam * (7 - j)) / 4));
                }

                if (Fy.get(i) == tam * j) {
                    Fx.set(i, Fx.get(i) + (int) ((tam * (7 - j)) / 4));
                }

                if (ch1y.get(i) == tam * j) {
                    ch1x.set(i, ch1x.get(i) + (int) ((tam * (7 - j)) / 4));
                }

                if (ch2y.get(i) == tam * j) {
                    ch2x.set(i, ch2x.get(i) + (int) ((tam * (7 - j)) / 4));
                }
            }
        }
    }

    public void regresaPuntos(int tam) {
        for (int i = 0; i < Ix.size(); i++) {
            //movimiento puntos de inicio
            for (int j = 0; j < 8; j++) {
                if (Iy.get(i) == tam * j) {
                    Ix.set(i, Ix.get(i) - (int) ((tam * (7 - j)) / 4));
                }

                if (Fy.get(i) == tam * j) {
                    Fx.set(i, Fx.get(i) - (int) ((tam * (7 - j)) / 4));
                }

                if (ch1y.get(i) == tam * j) {
                    ch1x.set(i, ch1x.get(i) - (int) ((tam * (7 - j)) / 4));
                }

                if (ch2y.get(i) == tam * j) {
                    ch2x.set(i, ch2x.get(i) - (int) ((tam * (7 - j)) / 4));
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

            c = new CubicCurve(Ix.get(i) + 1, Iy.get(i), ch1x.get(i) + 1, ch1y.get(i), ch2x.get(i) + 1, ch2y.get(i), Fx.get(i) + 1, Fy.get(i));
            c.setFill(Color.TRANSPARENT);
            if (Ix.get(i) == Fx.get(i) && Iy.get(i) == Fy.get(i)) {
                c.setFill(color);
            }
            c.setStroke(color);
            root.getChildren().add(c);

            c = new CubicCurve(Ix.get(i), Iy.get(i) + 1, ch1x.get(i), ch1y.get(i) + 1, ch2x.get(i), ch2y.get(i) + 1, Fx.get(i), Fy.get(i) + 1);
            c.setFill(Color.TRANSPARENT);
            if (Ix.get(i) == Fx.get(i) && Iy.get(i) == Fy.get(i)) {
                c.setFill(color);
            }
            c.setStroke(color);
            root.getChildren().add(c);
        }
        if (s == 1) {
            CubicCurve c = new CubicCurve(subrayado.get(0) + 1, subrayado.get(1) + 1, subrayado.get(2) + 1, subrayado.get(3) + 1, subrayado.get(4) + 1, subrayado.get(5) + 1, subrayado.get(6) + 1, subrayado.get(7) + 1);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(color);
            root.getChildren().add(c);
            c = new CubicCurve(subrayado.get(0) + 1, subrayado.get(1), subrayado.get(2) + 1, subrayado.get(3), subrayado.get(4) + 1, subrayado.get(5), subrayado.get(6) + 1, subrayado.get(7));
            c.setFill(Color.TRANSPARENT);
            c.setStroke(color);
            root.getChildren().add(c);
            c = new CubicCurve(subrayado.get(0), subrayado.get(1) + 1, subrayado.get(2), subrayado.get(3) + 1, subrayado.get(4), subrayado.get(5) + 1, subrayado.get(6), subrayado.get(7) + 1);
            c.setFill(Color.TRANSPARENT);
            c.setStroke(color);
            root.getChildren().add(c);
        }
    }

    public void replace(Caracter a) {
        Ix = a.Ix;
        Iy = a.Iy;
        Fx = a.Fx;
        Fy = a.Fy;
        ch1x = a.ch1x;
        ch1y = a.ch1y;
        ch2x = a.ch2x;
        ch2y = a.ch2y;
        subrayado = a.subrayado;
        chr = a.chr;
        root = a.root;
        lineas = a.lineas;

    }

    //movemos una letra hacia abajo 
    public void mover(int max, int size, int s) {
        for (int i = 0; i < lineas; i++) {
            Iy.set(i, Iy.get(i) + (max - size) * 5);
            Fy.set(i, Fy.get(i) + (max - size) * 5);
            ch1y.set(i, ch1y.get(i) + (max - size) * 5);
            ch2y.set(i, ch2y.get(i) + (max - size) * 5);
        }
        if (s == 1) {
            subrayado.set(1, subrayado.get(1) + (max - size) * 6);
            subrayado.set(3, subrayado.get(3) + (max - size) * 6);
            subrayado.set(5, subrayado.get(5) + (max - size) * 6);
            subrayado.set(7, subrayado.get(7) + (max - size) * 6);
        }
    }

    //regresamos una letra a su posicion original
    public void regresar(int max, int size, int s) {
        for (int i = 0; i < lineas; i++) {
            Iy.set(i, Iy.get(i) - (max - size) * 5);
            Fy.set(i, Fy.get(i) - (max - size) * 5);
            ch1y.set(i, ch1y.get(i) - (max - size) * 5);
            ch2y.set(i, ch2y.get(i) - (max - size) * 5);
        }
        if (s == 1) {
            subrayado.set(1, subrayado.get(1) - (max - size) * 6);
            subrayado.set(3, subrayado.get(3) - (max - size) * 6);
            subrayado.set(5, subrayado.get(5) - (max - size) * 6);
            subrayado.set(7, subrayado.get(7) - (max - size) * 6);
        }
    }

    //reflejamos caracter seg??n eje Y
    public void reflexY(int size) {
        int mid = (int) (size / 2);
        for (int i = 0; i < lineas; i++) {
            Ix.set(i, 2 * mid - Ix.get(i));
            Fx.set(i, 2 * mid - Fx.get(i));
            ch1x.set(i, 2 * mid - ch1x.get(i));
            ch2x.set(i, 2 * mid - ch2x.get(i));
        }
    }

    //reflejamos caracter seg??n eje X
    public void reflexX(int size, int s) {
        int mid = (int) (size / 2);
        for (int i = 0; i < lineas; i++) {
            Iy.set(i, 2 * mid - Iy.get(i));
            Fy.set(i, 2 * mid - Fy.get(i));
            ch1y.set(i, 2 * mid - ch1y.get(i));
            ch2y.set(i, 2 * mid - ch2y.get(i));
        }
        if (s == 1) {
            subrayado.set(1, 2 * mid - subrayado.get(1));
            subrayado.set(3, 2 * mid - subrayado.get(3));
            subrayado.set(5, 2 * mid - subrayado.get(5));
            subrayado.set(7, 2 * mid - subrayado.get(7));
        }
    }

    public void rotar(double x, double y, double ang, int s) {
        double x1;
        double y1;
        ang = Math.toRadians(ang);
        //rotamos puntos del caracter
        for (int i = 0; i < lineas; i++) {
            x1 = ((Ix.get(i) - x) * Math.cos(ang)) - ((Iy.get(i) - y) * Math.sin(ang));
            y1 = ((Ix.get(i) - x) * Math.sin(ang)) + ((Iy.get(i) - y) * Math.cos(ang));
            Ix.set(i, (int) (x + x1));
            Iy.set(i, (int) (y + y1));
            x1 = ((Fx.get(i) - x) * Math.cos(ang)) - ((Fy.get(i) - y) * Math.sin(ang));
            y1 = ((Fx.get(i) - x) * Math.sin(ang)) + ((Fy.get(i) - y) * Math.cos(ang));
            Fx.set(i, (int) (x + x1));
            Fy.set(i, (int) (y + y1));
            x1 = ((ch1x.get(i) - x) * Math.cos(ang)) - ((ch1y.get(i) - y)  * Math.sin(ang));
            y1 = ((ch1x.get(i) - x) * Math.sin(ang)) + ((ch1y.get(i) - y) * Math.cos(ang));
            ch1x.set(i, (int) (x + x1));
            ch1y.set(i, (int) (y + y1));
            x1 = ((ch2x.get(i) - x) * Math.cos(ang)) - ((ch2y.get(i) - y) * Math.sin(ang));
            y1 = ((ch2x.get(i) - x) * Math.sin(ang)) + ((ch2y.get(i) - y) * Math.cos(ang));
            ch2x.set(i, (int) (x + x1));
            ch2y.set(i, (int) (y + y1));
        }
        //rotamos subrayado
        if (s == 1) {
            x1 = subrayado.get(0);
            y1 = subrayado.get(1);
            subrayado.set(0, (int) (x + (x1 - x) * Math.cos(ang) - ((y1 - y) * Math.sin(ang))));
            subrayado.set(1, (int) (y + ((x1 - x) * Math.sin(ang)) + (y1 - y) * Math.cos(ang)));
            x1 = subrayado.get(2);
            y1 = subrayado.get(3);
            subrayado.set(2, (int) (x + (x1 - x) * Math.cos(ang) - ((y1 - y) * Math.sin(ang))));
            subrayado.set(3, (int) (y + ((x1 - x) * Math.sin(ang)) + (y1 - y) * Math.cos(ang)));
            x1 = subrayado.get(4);
            y1 = subrayado.get(5);
            subrayado.set(4, (int) (x + (x1 - x) * Math.cos(ang) - ((y1 - y) * Math.sin(ang))));
            subrayado.set(5, (int) (y + ((x1 - x) * Math.sin(ang)) + (y1 - y) * Math.cos(ang)));
            x1 = subrayado.get(6);
            y1 = subrayado.get(7);
            subrayado.set(7, (int) (y + ((x1 - x) * Math.sin(ang)) + (y1 - y) * Math.cos(ang)));
            subrayado.set(6, (int) (x + (x1 - x) * Math.cos(ang) - ((y1 - y) * Math.sin(ang))));

        }
    }

    public Pane getPanel() {
        return root;
    }
}
