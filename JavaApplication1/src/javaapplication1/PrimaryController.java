package javaapplication1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class PrimaryController {

    @FXML
    public TextField cuadroTexto;
    @FXML
    public Label canvas;
    @FXML
    public ColorPicker colores;
    @FXML
    public CheckBox muestraPuntos;
    static int bandera;
    static ArrayList<Caracter> letras;

    @FXML
    public void Empezar(int x, int y) {
        Pane p = new Pane();
        p.setMaxSize(100, 140);
        p.setMinSize(100, 140);
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
        Pane smallP = new Pane();
        smallP.setMaxSize(75, 140);
        smallP.setMinSize(75, 140);
        smallP.setTranslateX(x);
        smallP.setTranslateY(y);
        ArrayList<ArrayList> smallPuntos = new ArrayList();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                ArrayList<Integer> xy = new ArrayList();
                xy.add(15 * j);
                xy.add(20 * i);
                smallPuntos.add(xy);
            }
        }
        creaCaracteres(p, puntos, smallP, smallPuntos);
    }

    public static void creaCaracteres(Pane p, ArrayList<ArrayList> puntos, Pane smallP, ArrayList<ArrayList> smallPuntos) {

        //vacio
        ArrayList<Integer> ix = new ArrayList();
        ArrayList<Integer> iy = new ArrayList();
        ArrayList<Integer> fx = new ArrayList();
        ArrayList<Integer> fy = new ArrayList();
        ArrayList<Integer> ch1x = new ArrayList();
        ArrayList<Integer> ch1y = new ArrayList();
        ArrayList<Integer> ch2x = new ArrayList();
        ArrayList<Integer> ch2y = new ArrayList();
        Caracter empty = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, -1);

        Caracter c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, 0);
        letras = new ArrayList();
        letras.add(c);

        // signo de exclamacion !
        ix = new ArrayList(Arrays.asList(smallPuntos.get(39).get(0), smallPuntos.get(33).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(39).get(1), smallPuntos.get(33).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(39).get(0), smallPuntos.get(9).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(39).get(1), smallPuntos.get(9).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(45).get(0), smallPuntos.get(33).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(45).get(1), smallPuntos.get(33).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(38).get(0), smallPuntos.get(9).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(38).get(1), smallPuntos.get(9).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //comillas dobles
        ix = new ArrayList(Arrays.asList(smallPuntos.get(12).get(0), smallPuntos.get(12).get(0), smallPuntos.get(14).get(0), smallPuntos.get(14).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(12).get(1), smallPuntos.get(12).get(1), smallPuntos.get(14).get(1), smallPuntos.get(14).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(12).get(0), smallPuntos.get(19).get(0), smallPuntos.get(14).get(0), smallPuntos.get(21).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(12).get(1), smallPuntos.get(19).get(1), smallPuntos.get(14).get(1), smallPuntos.get(21).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(13).get(0), smallPuntos.get(12).get(0), smallPuntos.get(15).get(0), smallPuntos.get(14).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(13).get(1), smallPuntos.get(12).get(1), smallPuntos.get(15).get(1), smallPuntos.get(14).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(6).get(0), smallPuntos.get(18).get(0), smallPuntos.get(8).get(0), smallPuntos.get(20).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(6).get(1), smallPuntos.get(18).get(1), smallPuntos.get(8).get(1), smallPuntos.get(20).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //padding
        for (int i2 = 0; i2 < 4; i2++) {
            letras.add(empty);
        }

        //comillas simples
        ix = new ArrayList(Arrays.asList(smallPuntos.get(14).get(0), smallPuntos.get(14).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(14).get(1), smallPuntos.get(14).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(14).get(0), smallPuntos.get(21).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(14).get(1), smallPuntos.get(21).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(15).get(0), smallPuntos.get(14).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(15).get(1), smallPuntos.get(14).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(8).get(0), smallPuntos.get(20).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(8).get(1), smallPuntos.get(20).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //parentesis (
        ix = new ArrayList(Arrays.asList(smallPuntos.get(3).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(3).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(45).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(45).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(12).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(12).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //parentesis )
        ix = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(44).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(44).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(17).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(17).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(35).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //padding
        for (int i2 = 0; i2 < 2; i2++) {
            letras.add(empty);
        }

        //coma
        ix = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(33).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(33).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(38).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(38).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(33).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(33).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(39).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(39).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //guion
        ix = new ArrayList(Arrays.asList(smallPuntos.get(25).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(25).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(28).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(28).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(25).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(25).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(28).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(28).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //punto
        ix = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //padding
        for (int i2 = 0; i2 < 11; i2++) {
            letras.add(empty);
        }

        //dos puntos
        ix = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(21).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(21).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(21).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(20).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(20).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(15).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(15).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //punto y coma
        ix = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(33).get(0), smallPuntos.get(21).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(33).get(1), smallPuntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(38).get(0), smallPuntos.get(21).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(38).get(1), smallPuntos.get(21).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(33).get(0), smallPuntos.get(20).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(33).get(1), smallPuntos.get(20).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(39).get(0), smallPuntos.get(15).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(39).get(1), smallPuntos.get(15).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //padding
        for (int i = 0; i < 3; i++) {
            letras.add(empty);
        }

        //interrogacion ?
        ix = new ArrayList(Arrays.asList(puntos.get(38).get(0), puntos.get(32).get(0), puntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(38).get(1), puntos.get(32).get(1), puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(38).get(0), puntos.get(22).get(0), puntos.get(13).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(38).get(1), puntos.get(22).get(1), puntos.get(13).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(37).get(0), puntos.get(26).get(0), puntos.get(10).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(37).get(1), puntos.get(26).get(1), puntos.get(10).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(44).get(0), puntos.get(28).get(0), puntos.get(8).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(44).get(1), puntos.get(28).get(1), puntos.get(8).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //padding     
        letras.add(empty);

        //letra A mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(13).get(0), puntos.get(22).get(0), puntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(13).get(1), puntos.get(22).get(1), puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(22).get(0), puntos.get(13).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(22).get(1), puntos.get(13).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(42).get(0), puntos.get(4).get(0), puntos.get(40).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(42).get(1), puntos.get(4).get(1), puntos.get(40).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(46).get(0), puntos.get(2).get(0), puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(46).get(1), puntos.get(2).get(1), puntos.get(35).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra B mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(13).get(0), puntos.get(12).get(0), puntos.get(2).get(0), puntos.get(19).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(13).get(1), puntos.get(12).get(1), puntos.get(2).get(1), puntos.get(19).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(12).get(0), puntos.get(2).get(0), puntos.get(19).get(0), puntos.get(37).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(12).get(1), puntos.get(2).get(1), puntos.get(19).get(1), puntos.get(37).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(43).get(0), puntos.get(6).get(0), puntos.get(4).get(0), puntos.get(23).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(43).get(1), puntos.get(6).get(1), puntos.get(4).get(1), puntos.get(23).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(42).get(0), puntos.get(0).get(0), puntos.get(22).get(0), puntos.get(41).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(42).get(1), puntos.get(0).get(1), puntos.get(22).get(1), puntos.get(41).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra C mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(16).get(0), puntos.get(18).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(16).get(1), puntos.get(18).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(18).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(18).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(4).get(0), puntos.get(42).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(4).get(1), puntos.get(42).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(0).get(0), puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(0).get(1), puntos.get(35).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra D mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(13).get(0), puntos.get(12).get(0), puntos.get(2).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(13).get(1), puntos.get(12).get(1), puntos.get(2).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(12).get(0), puntos.get(2).get(0), puntos.get(37).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(12).get(1), puntos.get(2).get(1), puntos.get(37).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(43).get(0), puntos.get(6).get(0), puntos.get(5).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(43).get(1), puntos.get(6).get(1), puntos.get(5).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(42).get(0), puntos.get(0).get(0), puntos.get(47).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(42).get(1), puntos.get(0).get(1), puntos.get(47).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra E mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(9).get(0), puntos.get(21).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(9).get(1), puntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(21).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(21).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(13).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(13).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(42).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(42).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra F mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(14).get(0), puntos.get(6).get(0), puntos.get(20).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(14).get(1), puntos.get(6).get(1), puntos.get(20).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(6).get(0), puntos.get(5).get(0), puntos.get(22).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(6).get(1), puntos.get(5).get(1), puntos.get(22).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(44).get(0), puntos.get(0).get(0), puntos.get(20).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(44).get(1), puntos.get(0).get(1), puntos.get(20).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(42).get(0), puntos.get(0).get(0), puntos.get(23).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(42).get(1), puntos.get(0).get(1), puntos.get(23).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra G mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(10).get(0), puntos.get(22).get(0), puntos.get(44).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(10).get(1), puntos.get(22).get(1), puntos.get(44).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(22).get(0), puntos.get(44).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(22).get(1), puntos.get(44).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(34).get(0), puntos.get(32).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(34).get(1), puntos.get(32).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(36).get(0), puntos.get(45).get(0), puntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(36).get(1), puntos.get(45).get(1), puntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra H mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(37).get(0), puntos.get(4).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(37).get(1), puntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(37).get(0), puntos.get(4).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(37).get(1), puntos.get(4).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(8).get(0), puntos.get(6).get(0), puntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(8).get(1), puntos.get(6).get(1), puntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(32).get(0), puntos.get(35).get(0), puntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(32).get(1), puntos.get(35).get(1), puntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra I mayuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(1).get(0), smallPuntos.get(4).get(0), smallPuntos.get(34).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(1).get(1), smallPuntos.get(4).get(1), smallPuntos.get(34).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(4).get(0), smallPuntos.get(34).get(0), smallPuntos.get(30).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(4).get(1), smallPuntos.get(34).get(1), smallPuntos.get(30).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(7).get(0), smallPuntos.get(22).get(0), smallPuntos.get(46).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(7).get(1), smallPuntos.get(22).get(1), smallPuntos.get(46).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(10).get(0), smallPuntos.get(28).get(0), smallPuntos.get(42).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(10).get(1), smallPuntos.get(28).get(1), smallPuntos.get(42).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //letra J mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(4).get(0), puntos.get(44).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(4).get(1), puntos.get(44).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(4).get(0), puntos.get(44).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(4).get(1), puntos.get(44).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(6).get(0), puntos.get(10).get(0), puntos.get(43).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(6).get(1), puntos.get(10).get(1), puntos.get(43).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(11).get(0), puntos.get(45).get(0), puntos.get(14).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(11).get(1), puntos.get(45).get(1), puntos.get(14).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra K mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(0).get(0), puntos.get(37).get(0), puntos.get(1).get(0), puntos.get(19).get(0), puntos.get(19).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(0).get(1), puntos.get(37).get(1), puntos.get(1).get(1), puntos.get(19).get(1), puntos.get(19).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(36).get(0), puntos.get(37).get(0), puntos.get(4).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(36).get(1), puntos.get(37).get(1), puntos.get(4).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(6).get(0), puntos.get(43).get(0), puntos.get(1).get(0), puntos.get(10).get(0), puntos.get(45).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(6).get(1), puntos.get(43).get(1), puntos.get(1).get(1), puntos.get(10).get(1), puntos.get(45).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(7).get(0), puntos.get(42).get(0), puntos.get(37).get(0), puntos.get(4).get(0), puntos.get(46).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(7).get(1), puntos.get(42).get(1), puntos.get(37).get(1), puntos.get(4).get(1), puntos.get(46).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra L mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(16).get(0), puntos.get(14).get(0), puntos.get(37).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(16).get(1), puntos.get(14).get(1), puntos.get(37).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(14).get(0), puntos.get(37).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(14).get(1), puntos.get(37).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(5).get(0), puntos.get(27).get(0), puntos.get(24).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(5).get(1), puntos.get(27).get(1), puntos.get(24).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(38).get(0), puntos.get(45).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(38).get(1), puntos.get(45).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra M mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0), puntos.get(37).get(0), puntos.get(38).get(0), puntos.get(39).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1), puntos.get(37).get(1), puntos.get(38).get(1), puntos.get(39).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(37).get(0), puntos.get(38).get(0), puntos.get(39).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(37).get(1), puntos.get(38).get(1), puntos.get(39).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(2).get(0), puntos.get(1).get(0), puntos.get(2).get(0), puntos.get(40).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(2).get(1), puntos.get(1).get(1), puntos.get(2).get(1), puntos.get(40).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(37).get(0), puntos.get(3).get(0), puntos.get(4).get(0), puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(37).get(1), puntos.get(3).get(1), puntos.get(4).get(1), puntos.get(35).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra N mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0), puntos.get(38).get(0), puntos.get(40).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1), puntos.get(38).get(1), puntos.get(40).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(38).get(0), puntos.get(40).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(38).get(1), puntos.get(40).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(1).get(0), puntos.get(41).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(1).get(1), puntos.get(41).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(8).get(0), puntos.get(5).get(0), puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(8).get(1), puntos.get(5).get(1), puntos.get(35).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra O mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0), puntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1), puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(22).get(0), puntos.get(13).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(22).get(1), puntos.get(13).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(42).get(0), puntos.get(4).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(47).get(1), puntos.get(0).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(46).get(0), puntos.get(1).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(47).get(1), puntos.get(0).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra P mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(14).get(0), puntos.get(6).get(0), puntos.get(3).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(14).get(1), puntos.get(6).get(1), puntos.get(3).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(6).get(0), puntos.get(3).get(0), puntos.get(20).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(6).get(1), puntos.get(3).get(1), puntos.get(20).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(44).get(0), puntos.get(0).get(0), puntos.get(5).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(44).get(1), puntos.get(0).get(1), puntos.get(5).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(42).get(0), puntos.get(0).get(0), puntos.get(23).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(42).get(1), puntos.get(0).get(1), puntos.get(23).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra Q mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0), puntos.get(22).get(0), puntos.get(31).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1), puntos.get(22).get(1), puntos.get(31).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(22).get(0), puntos.get(31).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(22).get(1), puntos.get(31).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(42).get(0), puntos.get(4).get(0), puntos.get(26).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(47).get(1), puntos.get(0).get(1), puntos.get(26).get(0)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(46).get(0), puntos.get(1).get(0), puntos.get(40).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(47).get(1), puntos.get(0).get(1), puntos.get(40).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra R mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(14).get(0), puntos.get(6).get(0), puntos.get(3).get(0), puntos.get(20).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(14).get(1), puntos.get(6).get(1), puntos.get(3).get(1), puntos.get(20).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(6).get(0), puntos.get(3).get(0), puntos.get(20).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(6).get(1), puntos.get(3).get(1), puntos.get(20).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(44).get(0), puntos.get(0).get(0), puntos.get(5).get(0), puntos.get(20).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(44).get(1), puntos.get(0).get(1), puntos.get(5).get(1), puntos.get(20).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(42).get(0), puntos.get(0).get(0), puntos.get(23).get(0), puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(42).get(1), puntos.get(0).get(1), puntos.get(23).get(1), puntos.get(35).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra S mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(36).get(0), puntos.get(1).get(0), puntos.get(33).get(0), puntos.get(38).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(36).get(1), puntos.get(1).get(1), puntos.get(33).get(1), puntos.get(38).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(33).get(0), puntos.get(38).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(33).get(1), puntos.get(38).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(2).get(0), puntos.get(25).get(0), puntos.get(39).get(0), puntos.get(31).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(2).get(1), puntos.get(25).get(1), puntos.get(39).get(1), puntos.get(31).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(21).get(0), puntos.get(38).get(0), puntos.get(41).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(21).get(1), puntos.get(38).get(1), puntos.get(41).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra T mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(7).get(0), puntos.get(5).get(0), puntos.get(20).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(7).get(1), puntos.get(5).get(1), puntos.get(20).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(5).get(0), puntos.get(35).get(0), puntos.get(22).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(5).get(1), puntos.get(35).get(1), puntos.get(22).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(0).get(0), puntos.get(36).get(0), puntos.get(19).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1), puntos.get(36).get(1), puntos.get(19).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(15).get(0), puntos.get(43).get(0), puntos.get(23).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(15).get(1), puntos.get(43).get(1), puntos.get(23).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra U mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(6).get(0), puntos.get(7).get(0), puntos.get(4).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(6).get(1), puntos.get(7).get(1), puntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(7).get(0), puntos.get(4).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(7).get(1), puntos.get(4).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(0).get(0), puntos.get(43).get(0), puntos.get(39).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1), puntos.get(43).get(1), puntos.get(39).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(46).get(0), puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(46).get(1), puntos.get(35).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra V mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(6).get(0), puntos.get(39).get(0), puntos.get(10).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(6).get(1), puntos.get(39).get(1), puntos.get(10).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(39).get(0), puntos.get(10).get(0), puntos.get(11).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(39).get(1), puntos.get(10).get(1), puntos.get(11).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(3).get(0), puntos.get(41).get(0), puntos.get(10).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(3).get(1), puntos.get(41).get(1), puntos.get(10).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(36).get(0), puntos.get(10).get(0), puntos.get(11).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(36).get(1), puntos.get(10).get(1), puntos.get(11).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra W mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(6).get(0), puntos.get(7).get(0), puntos.get(14).get(0), puntos.get(10).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(6).get(1), puntos.get(7).get(1), puntos.get(14).get(1), puntos.get(10).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(7).get(0), puntos.get(14).get(0), puntos.get(10).get(0), puntos.get(11).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(7).get(1), puntos.get(14).get(1), puntos.get(10).get(1), puntos.get(11).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(0).get(0), puntos.get(42).get(0), puntos.get(44).get(0), puntos.get(10).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1), puntos.get(42).get(1), puntos.get(44).get(1), puntos.get(10).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(45).get(0), puntos.get(47).get(0), puntos.get(11).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(45).get(1), puntos.get(47).get(1), puntos.get(11).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra x mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0), puntos.get(36).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1), puntos.get(36).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(40).get(0), puntos.get(11).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(40).get(1), puntos.get(11).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(0).get(0), puntos.get(36).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(0).get(1), puntos.get(36).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(40).get(0), puntos.get(11).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(40).get(1), puntos.get(11).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra Y mayuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(8).get(0), smallPuntos.get(21).get(0), smallPuntos.get(5).get(0), smallPuntos.get(44).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(8).get(1), smallPuntos.get(21).get(1), smallPuntos.get(5).get(1), smallPuntos.get(44).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(21).get(0), smallPuntos.get(5).get(0), smallPuntos.get(44).get(0), smallPuntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(21).get(1), smallPuntos.get(5).get(1), smallPuntos.get(44).get(1), smallPuntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(3).get(0), smallPuntos.get(22).get(0), smallPuntos.get(5).get(0), smallPuntos.get(43).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(3).get(1), smallPuntos.get(22).get(1), smallPuntos.get(5).get(1), smallPuntos.get(43).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(20).get(0), smallPuntos.get(22).get(0), smallPuntos.get(45).get(0), smallPuntos.get(15).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(20).get(1), smallPuntos.get(22).get(1), smallPuntos.get(45).get(1), smallPuntos.get(15).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //letra Z mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(7).get(0), puntos.get(3).get(0), puntos.get(26).get(0), puntos.get(44).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(7).get(1), puntos.get(3).get(1), puntos.get(26).get(1), puntos.get(44).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(3).get(0), puntos.get(26).get(0), puntos.get(44).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(3).get(1), puntos.get(26).get(1), puntos.get(44).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(7).get(0), puntos.get(5).get(0), puntos.get(23).get(0), puntos.get(43).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(7).get(1), puntos.get(5).get(1), puntos.get(23).get(1), puntos.get(43).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(29).get(0), puntos.get(45).get(0), puntos.get(21).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(29).get(1), puntos.get(45).get(1), puntos.get(21).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        // corchete [
        ix = new ArrayList(Arrays.asList(smallPuntos.get(4).get(0), smallPuntos.get(2).get(0), smallPuntos.get(38).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(4).get(1), smallPuntos.get(2).get(1), smallPuntos.get(38).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(38).get(0), smallPuntos.get(40).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(38).get(1), smallPuntos.get(40).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(4).get(0), smallPuntos.get(2).get(0), smallPuntos.get(38).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(4).get(1), smallPuntos.get(2).get(1), smallPuntos.get(38).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(38).get(0), smallPuntos.get(40).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(38).get(1), smallPuntos.get(40).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //padding
        letras.add(empty);

        // corchete ]
        ix = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(4).get(0), smallPuntos.get(40).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(4).get(1), smallPuntos.get(40).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(4).get(0), smallPuntos.get(40).get(0), smallPuntos.get(38).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(4).get(1), smallPuntos.get(40).get(1), smallPuntos.get(38).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(4).get(0), smallPuntos.get(40).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(4).get(1), smallPuntos.get(40).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(4).get(0), smallPuntos.get(40).get(0), smallPuntos.get(38).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(4).get(1), smallPuntos.get(40).get(1), smallPuntos.get(38).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //padding
        letras.add(empty);

        //guion bajo
        ix = new ArrayList(Arrays.asList(smallPuntos.get(36).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(36).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(41).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(41).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(36).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(36).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(41).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(41).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //padding
        letras.add(empty);

        //letra a minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(26).get(0), puntos.get(21).get(0), puntos.get(28).get(0), puntos.get(33).get(0), puntos.get(28).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(26).get(1), puntos.get(21).get(1), puntos.get(28).get(1), puntos.get(33).get(1), puntos.get(28).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(21).get(0), puntos.get(28).get(0), puntos.get(33).get(0), puntos.get(26).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(21).get(1), puntos.get(28).get(1), puntos.get(33).get(1), puntos.get(26).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(34).get(0), puntos.get(32).get(0), puntos.get(34).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(34).get(1), puntos.get(32).get(1), puntos.get(34).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(21).get(0), puntos.get(28).get(0), puntos.get(33).get(0), puntos.get(26).get(0), puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(21).get(1), puntos.get(28).get(1), puntos.get(33).get(1), puntos.get(26).get(1), puntos.get(35).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        // letra b minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(8).get(0), puntos.get(27).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(8).get(1), puntos.get(27).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(8).get(0), puntos.get(27).get(0), puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(8).get(1), puntos.get(27).get(1), puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(32).get(0), puntos.get(36).get(0), puntos.get(27).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(32).get(1), puntos.get(36).get(1), puntos.get(27).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(21).get(0), puntos.get(39).get(0), puntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(21).get(1), puntos.get(39).get(1), puntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        // letra c minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(22).get(0), smallPuntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(22).get(1), smallPuntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(19).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(19).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(19).get(0), smallPuntos.get(37).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(19).get(1), smallPuntos.get(37).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        // letra d minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(20).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(20).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(10).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(10).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(36).get(0), puntos.get(16).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(36).get(1), puntos.get(16).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(40).get(0), puntos.get(33).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(40).get(1), puntos.get(33).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra e minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(20).get(0), smallPuntos.get(21).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(20).get(1), smallPuntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(21).get(0), smallPuntos.get(35).get(0), smallPuntos.get(20).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(21).get(1), smallPuntos.get(35).get(1), smallPuntos.get(20).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(26).get(0), smallPuntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(26).get(1), smallPuntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(33).get(0), smallPuntos.get(14).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(33).get(1), smallPuntos.get(14).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //letra f minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(8).get(0), smallPuntos.get(44).get(0), smallPuntos.get(25).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(8).get(1), smallPuntos.get(44).get(1), smallPuntos.get(25).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(8).get(0), smallPuntos.get(44).get(0), smallPuntos.get(25).get(0), smallPuntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(8).get(1), smallPuntos.get(44).get(1), smallPuntos.get(25).get(1), smallPuntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(30).get(0), smallPuntos.get(45).get(0), smallPuntos.get(31).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(30).get(1), smallPuntos.get(45).get(1), smallPuntos.get(31).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(21).get(0), smallPuntos.get(43).get(0), smallPuntos.get(20).get(0), smallPuntos.get(38).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(21).get(1), smallPuntos.get(43).get(1), smallPuntos.get(20).get(1), smallPuntos.get(38).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //letra g minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(21).get(0), smallPuntos.get(27).get(0), smallPuntos.get(44).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(21).get(1), smallPuntos.get(27).get(1), smallPuntos.get(44).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(21).get(0), smallPuntos.get(27).get(0), smallPuntos.get(44).get(0), smallPuntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(21).get(1), smallPuntos.get(27).get(1), smallPuntos.get(44).get(1), smallPuntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(25).get(0), smallPuntos.get(19).get(0), smallPuntos.get(35).get(0), smallPuntos.get(37).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(25).get(1), smallPuntos.get(19).get(1), smallPuntos.get(35).get(1), smallPuntos.get(37).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(19).get(0), smallPuntos.get(31).get(0), smallPuntos.get(45).get(0), smallPuntos.get(27).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(19).get(1), smallPuntos.get(31).get(1), smallPuntos.get(45).get(1), smallPuntos.get(27).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //letra h minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(9).get(0), smallPuntos.get(32).get(0), smallPuntos.get(28).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(9).get(1), smallPuntos.get(32).get(1), smallPuntos.get(28).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(9).get(0), smallPuntos.get(32).get(0), smallPuntos.get(28).get(0), smallPuntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(9).get(1), smallPuntos.get(32).get(1), smallPuntos.get(28).get(1), smallPuntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(9).get(0), smallPuntos.get(20).get(0), smallPuntos.get(34).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(9).get(1), smallPuntos.get(20).get(1), smallPuntos.get(34).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(10).get(0), smallPuntos.get(14).get(0), smallPuntos.get(22).get(0), smallPuntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(10).get(1), smallPuntos.get(14).get(1), smallPuntos.get(22).get(1), smallPuntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //letra i minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(21).get(0), smallPuntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(21).get(1), smallPuntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(21).get(0), smallPuntos.get(35).get(0), smallPuntos.get(15).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(21).get(1), smallPuntos.get(35).get(1), smallPuntos.get(15).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(33).get(0), smallPuntos.get(16).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(33).get(1), smallPuntos.get(16).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(33).get(0), smallPuntos.get(9).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(33).get(1), smallPuntos.get(9).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        // letra j minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(21).get(0), puntos.get(15).get(0), puntos.get(44).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(21).get(1), puntos.get(15).get(1), puntos.get(44).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(21).get(0), puntos.get(44).get(0), puntos.get(15).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(21).get(1), puntos.get(44).get(1), puntos.get(15).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(32).get(0), puntos.get(28).get(0), puntos.get(16).get(0), puntos.get(37).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(32).get(1), puntos.get(28).get(1), puntos.get(16).get(1), puntos.get(37).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(27).get(0), puntos.get(45).get(0), puntos.get(9).get(0), puntos.get(33).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(27).get(1), puntos.get(45).get(1), puntos.get(9).get(1), puntos.get(33).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        // letra k minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(9).get(0), puntos.get(32).get(0), puntos.get(27).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(9).get(1), puntos.get(32).get(1), puntos.get(27).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(9).get(0), puntos.get(32).get(0), puntos.get(27).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(9).get(1), puntos.get(32).get(1), puntos.get(27).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(27).get(0), puntos.get(9).get(0), puntos.get(20).get(0), puntos.get(28).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(27).get(1), puntos.get(9).get(1), puntos.get(20).get(1), puntos.get(28).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(10).get(0), puntos.get(14).get(0), puntos.get(22).get(0), puntos.get(32).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(10).get(1), puntos.get(14).get(1), puntos.get(22).get(1), puntos.get(32).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra l minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(14).get(0), smallPuntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(14).get(1), smallPuntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(15).get(0), smallPuntos.get(35).get(0), smallPuntos.get(14).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(15).get(1), smallPuntos.get(35).get(1), smallPuntos.get(14).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(26).get(0), smallPuntos.get(3).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(26).get(1), smallPuntos.get(3).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(33).get(0), smallPuntos.get(2).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(33).get(1), smallPuntos.get(2).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //letra m minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(32).get(0), puntos.get(33).get(0), puntos.get(28).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(32).get(1), puntos.get(33).get(1), puntos.get(28).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(32).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(32).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(19).get(0), puntos.get(20).get(0), puntos.get(21).get(0), puntos.get(34).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(19).get(1), puntos.get(20).get(1), puntos.get(21).get(1), puntos.get(34).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(21).get(0), puntos.get(22).get(0), puntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(21).get(1), puntos.get(22).get(1), puntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra n minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(32).get(0), smallPuntos.get(28).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(32).get(1), smallPuntos.get(28).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(28).get(0), smallPuntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(28).get(1), smallPuntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(19).get(0), smallPuntos.get(20).get(0), smallPuntos.get(34).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(19).get(1), smallPuntos.get(20).get(1), smallPuntos.get(34).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(20).get(0), smallPuntos.get(22).get(0), smallPuntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(20).get(1), smallPuntos.get(22).get(1), smallPuntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //letra o minuscula;
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(26).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(21).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(26).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(21).get(0), puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(21).get(1), puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(32).get(0), puntos.get(34).get(0), puntos.get(22).get(0), puntos.get(20).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(32).get(1), puntos.get(34).get(1), puntos.get(22).get(1), puntos.get(20).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(21).get(0), puntos.get(31).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(21).get(1), puntos.get(31).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra p minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(20).get(0), smallPuntos.get(44).get(0), smallPuntos.get(28).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(20).get(1), smallPuntos.get(44).get(1), smallPuntos.get(28).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(20).get(0), smallPuntos.get(44).get(0), smallPuntos.get(28).get(0), smallPuntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(20).get(1), smallPuntos.get(44).get(1), smallPuntos.get(28).get(1), smallPuntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(31).get(0), smallPuntos.get(20).get(0), smallPuntos.get(25).get(0), smallPuntos.get(40).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(31).get(1), smallPuntos.get(20).get(1), smallPuntos.get(25).get(1), smallPuntos.get(40).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(26).get(0), smallPuntos.get(44).get(0), smallPuntos.get(16).get(0), smallPuntos.get(32).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(26).get(1), smallPuntos.get(44).get(1), smallPuntos.get(16).get(1), smallPuntos.get(32).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //letra q minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(21).get(0), puntos.get(21).get(0), puntos.get(45).get(0), puntos.get(33).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(21).get(1), puntos.get(21).get(1), puntos.get(45).get(1), puntos.get(33).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(21).get(0), puntos.get(27).get(0), puntos.get(45).get(0), puntos.get(33).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(21).get(1), puntos.get(27).get(1), puntos.get(45).get(1), puntos.get(33).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(25).get(0), puntos.get(19).get(0), puntos.get(27).get(0), puntos.get(45).get(0), puntos.get(27).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(25).get(1), puntos.get(19).get(1), puntos.get(27).get(1), puntos.get(45).get(1), puntos.get(27).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(19).get(0), puntos.get(31).get(0), puntos.get(45).get(0), puntos.get(40).get(0), puntos.get(38).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(19).get(1), puntos.get(31).get(1), puntos.get(45).get(1), puntos.get(40).get(1), puntos.get(38).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra r minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(26).get(0), puntos.get(27).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(26).get(1), puntos.get(27).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(28).get(0), puntos.get(33).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(28).get(1), puntos.get(33).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra s minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(33).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(33).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(33).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(33).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(28).get(0), puntos.get(33).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(28).get(1), puntos.get(33).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(34).get(0), puntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(34).get(1), puntos.get(35).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra t minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(9).get(0), smallPuntos.get(13).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(9).get(1), smallPuntos.get(13).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(9).get(0), smallPuntos.get(35).get(0), smallPuntos.get(17).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(9).get(1), smallPuntos.get(35).get(1), smallPuntos.get(17).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(21).get(0), smallPuntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(21).get(1), smallPuntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(21).get(0), smallPuntos.get(32).get(0), smallPuntos.get(21).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(21).get(1), smallPuntos.get(32).get(1), smallPuntos.get(21).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //letra u minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(37).get(0), puntos.get(34).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(37).get(1), puntos.get(34).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(40).get(0), puntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(40).get(1), puntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra v minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(33).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(33).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(33).get(0), puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(33).get(1), puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(21).get(0), puntos.get(34).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(21).get(1), puntos.get(34).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(19).get(0), puntos.get(32).get(0), puntos.get(15).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(19).get(1), puntos.get(32).get(1), puntos.get(15).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra w minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(21).get(0), puntos.get(28).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(21).get(1), puntos.get(28).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(21).get(0), puntos.get(28).get(0), puntos.get(29).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(21).get(1), puntos.get(28).get(1), puntos.get(29).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(38).get(0), puntos.get(39).get(0), puntos.get(22).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(38).get(1), puntos.get(39).get(1), puntos.get(22).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(39).get(0), puntos.get(40).get(0), puntos.get(29).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(39).get(1), puntos.get(40).get(1), puntos.get(29).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letras x minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(34).get(0), puntos.get(32).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(34).get(1), puntos.get(32).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(34).get(0), puntos.get(35).get(0), puntos.get(22).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(34).get(1), puntos.get(35).get(1), puntos.get(22).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(32).get(0), puntos.get(21).get(0), puntos.get(35).get(0), puntos.get(22).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(32).get(1), puntos.get(21).get(1), puntos.get(35).get(1), puntos.get(22).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(19).get(0), puntos.get(33).get(0), puntos.get(35).get(0), puntos.get(32).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(19).get(1), puntos.get(33).get(1), puntos.get(35).get(1), puntos.get(32).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra y minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(44).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(44).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(44).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(44).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(32).get(0), puntos.get(34).get(0), puntos.get(37).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(32).get(1), puntos.get(34).get(1), puntos.get(37).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(33).get(0), puntos.get(45).get(0), puntos.get(27).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(33).get(1), puntos.get(45).get(1), puntos.get(27).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //letra z minuscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(21).get(0), puntos.get(27).get(0), puntos.get(44).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(21).get(1), puntos.get(27).get(1), puntos.get(44).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(21).get(0), puntos.get(27).get(0), puntos.get(44).get(0), puntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(21).get(1), puntos.get(27).get(1), puntos.get(44).get(1), puntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(22).get(0), puntos.get(34).get(0), puntos.get(37).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(22).get(1), puntos.get(34).get(1), puntos.get(37).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(28).get(0), puntos.get(45).get(0), puntos.get(33).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(28).get(1), puntos.get(45).get(1), puntos.get(33).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //llave {
        ix = new ArrayList(Arrays.asList(smallPuntos.get(4).get(0), smallPuntos.get(20).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(4).get(1), smallPuntos.get(20).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(20).get(0), smallPuntos.get(40).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(20).get(1), smallPuntos.get(40).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(22).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(22).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(22).get(0), smallPuntos.get(38).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(22).get(1), smallPuntos.get(38).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //padding
        letras.add(empty);

        //llave }
        ix = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(22).get(0), smallPuntos.get(38).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(22).get(1), smallPuntos.get(38).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(4).get(0), smallPuntos.get(20).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(4).get(1), smallPuntos.get(20).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(20).get(0), smallPuntos.get(40).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(20).get(1), smallPuntos.get(40).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 35; i1++) {
            letras.add(empty);
        }

        //exclamacion ¡
        ix = new ArrayList(Arrays.asList(smallPuntos.get(9).get(0), smallPuntos.get(39).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(9).get(1), smallPuntos.get(39).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(9).get(0), smallPuntos.get(15).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(9).get(1), smallPuntos.get(15).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(3).get(0), smallPuntos.get(39).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(3).get(1), smallPuntos.get(39).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(10).get(0), smallPuntos.get(15).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(10).get(1), smallPuntos.get(15).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 9; i1++) {
            letras.add(empty);
        }

        //comillas españolas «
        ix = new ArrayList(Arrays.asList(puntos.get(38).get(0), puntos.get(24).get(0), puntos.get(40).get(0), puntos.get(26).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(38).get(1), puntos.get(24).get(1), puntos.get(40).get(1), puntos.get(26).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(14).get(0), puntos.get(26).get(0), puntos.get(16).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(14).get(1), puntos.get(26).get(1), puntos.get(16).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(38).get(0), puntos.get(24).get(0), puntos.get(40).get(0), puntos.get(26).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(38).get(1), puntos.get(24).get(1), puntos.get(40).get(1), puntos.get(26).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(14).get(0), puntos.get(26).get(0), puntos.get(16).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(14).get(1), puntos.get(26).get(1), puntos.get(16).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 15; i1++) {
            letras.add(empty);
        }

        //comillas españolas »
        ix = new ArrayList(Arrays.asList(puntos.get(37).get(0), puntos.get(27).get(0), puntos.get(39).get(0), puntos.get(29).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(37).get(1), puntos.get(27).get(1), puntos.get(39).get(1), puntos.get(29).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(27).get(0), puntos.get(13).get(0), puntos.get(29).get(0), puntos.get(15).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(27).get(1), puntos.get(13).get(1), puntos.get(29).get(1), puntos.get(15).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(37).get(0), puntos.get(27).get(0), puntos.get(39).get(0), puntos.get(29).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(37).get(1), puntos.get(27).get(1), puntos.get(39).get(1), puntos.get(29).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(27).get(0), puntos.get(13).get(0), puntos.get(29).get(0), puntos.get(15).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(27).get(1), puntos.get(13).get(1), puntos.get(29).get(1), puntos.get(15).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 3; i1++) {
            letras.add(empty);
        }

        //interrogacion ¿
        ix = new ArrayList(Arrays.asList(puntos.get(9).get(0), puntos.get(34).get(0), puntos.get(25).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(9).get(1), puntos.get(34).get(1), puntos.get(25).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(9).get(0), puntos.get(25).get(0), puntos.get(15).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(9).get(1), puntos.get(25).get(1), puntos.get(15).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(10).get(0), puntos.get(39).get(0), puntos.get(19).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(10).get(1), puntos.get(39).get(1), puntos.get(19).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(3).get(0), puntos.get(37).get(0), puntos.get(21).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(3).get(1), puntos.get(37).get(1), puntos.get(21).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 17; i1++) {
            letras.add(empty);
        }

        //letra Ñ mayuscula
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0), puntos.get(38).get(0), puntos.get(40).get(0), puntos.get(7).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1), puntos.get(38).get(1), puntos.get(40).get(1), puntos.get(7).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(38).get(0), puntos.get(40).get(0), puntos.get(35).get(0), puntos.get(4).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(38).get(1), puntos.get(40).get(1), puntos.get(35).get(1), puntos.get(4).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(7).get(0), puntos.get(1).get(0), puntos.get(41).get(0), puntos.get(2).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(7).get(1), puntos.get(1).get(1), puntos.get(41).get(1), puntos.get(2).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(8).get(0), puntos.get(5).get(0), puntos.get(35).get(0), puntos.get(15).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(8).get(1), puntos.get(5).get(1), puntos.get(35).get(1), puntos.get(15).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size());
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 31; i1++) {
            letras.add(empty);
        }

        //letra ñ minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(32).get(0), smallPuntos.get(13).get(0), smallPuntos.get(28).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(32).get(1), smallPuntos.get(13).get(1), smallPuntos.get(28).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(28).get(0), smallPuntos.get(16).get(0), smallPuntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(28).get(1), smallPuntos.get(16).get(1), smallPuntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(19).get(0), smallPuntos.get(20).get(0), smallPuntos.get(8).get(0), smallPuntos.get(34).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(19).get(1), smallPuntos.get(20).get(1), smallPuntos.get(8).get(1), smallPuntos.get(34).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(20).get(0), smallPuntos.get(22).get(0), smallPuntos.get(21).get(0), smallPuntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(20).get(1), smallPuntos.get(22).get(1), smallPuntos.get(21).get(1), smallPuntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size());
        letras.add(c);
    }

    @FXML
    public void dibuja() throws IOException {
        int x = 10;
        int y = 10;
        Pane pane = new Pane();
        String frase = (this.cuadroTexto.getText());
        if (bandera == 0) {
            Empezar(x, y);
            bandera++;
        }
        for (int i = 0; i < frase.length(); i++) {
            if (letras.get((int) frase.charAt(i) - 32).lineas != -1 && (0 <= ((int) frase.charAt(i) - 32)) && ((int) frase.charAt(i) - 32) <= 241) {
                Pane pp = new Pane();
                pp.setMaxSize(letras.get((int) frase.charAt(i) - 32).getPanel().getMaxWidth(), 140);
                pp.setMinSize(letras.get((int) frase.charAt(i) - 32).getPanel().getMaxWidth(), 140);
                pp.setTranslateX(x);
                pp.setTranslateY(y);
                letras.get((int) frase.charAt(i) - 32).root = pp;
                letras.get((int) frase.charAt(i) - 32).dibujar(colores.getValue());
                if (muestraPuntos.isSelected()) {
                    letras.get((int) frase.charAt(i) - 32).getCheckpoints();
                }
                x += letras.get((int) frase.charAt(i) - 32).getPanel().getMaxWidth();
                if (x > (canvas.getWidth() - 100)) {
                    x = 10;
                    y += 140;
                }
                pane.getChildren().add(letras.get((int) frase.charAt(i) - 32).getPanel());
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Caracter invalido");
                alert.showAndWait();
            }
        }
        canvas.setGraphic(pane);
    }
}
