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

    //Metodo donde se crean los paneles en que se trabajaran y llama a crear los caracteres
    @FXML
    public void Empezar(int x, int y) {
        //Panel estandar
        Pane p = new Pane();
        p.setMaxSize(100, 140);
        p.setMinSize(100, 140);
        p.setTranslateX(x);
        p.setTranslateY(y);
        ArrayList<ArrayList> puntos = new ArrayList();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                //se crean puntos del Pane
                ArrayList<Integer> xy = new ArrayList();
                xy.add(20 * j);
                xy.add(20 * i);
                puntos.add(xy);
            }
        }
        //Panel más pequeño
        Pane smallP = new Pane();
        smallP.setMaxSize(75, 140);
        smallP.setMinSize(75, 140);
        smallP.setTranslateX(x);
        smallP.setTranslateY(y);
        ArrayList<ArrayList> smallPuntos = new ArrayList();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                //se crean puntos del smallPane
                ArrayList<Integer> xy = new ArrayList();
                xy.add(15 * j);
                xy.add(20 * i);
                smallPuntos.add(xy);
            }
        }
        //se deinen caractereas
        creaCaracteres(p, puntos, smallP, smallPuntos);
    }

    //Metodo que crea caracteres y los guarda en una lista de acuerdo al codigo ASCII, partiendo del 32(espacio)
    public static void creaCaracteres(Pane p, ArrayList<ArrayList> puntos, Pane smallP, ArrayList<ArrayList> smallPuntos) {

        //subrayado para SmallPane
        ArrayList<Integer> subSP = new ArrayList(Arrays.asList(smallPuntos.get(36).get(0), smallPuntos.get(36).get(1), smallPuntos.get(36).get(0), smallPuntos.get(36).get(1), smallPuntos.get(41).get(0), smallPuntos.get(41).get(1), smallPuntos.get(41).get(0), smallPuntos.get(41).get(1)));

        //subrayado para Pane
        ArrayList<Integer> subP = new ArrayList(Arrays.asList(puntos.get(36).get(0), puntos.get(36).get(1), puntos.get(36).get(0), puntos.get(36).get(1), puntos.get(41).get(0), puntos.get(41).get(1), puntos.get(41).get(0), puntos.get(41).get(1)));

        //vacio
        ArrayList<Integer> ix = new ArrayList();
        ArrayList<Integer> iy = new ArrayList();
        ArrayList<Integer> fx = new ArrayList();
        ArrayList<Integer> fy = new ArrayList();
        ArrayList<Integer> ch1x = new ArrayList();
        ArrayList<Integer> ch1y = new ArrayList();
        ArrayList<Integer> ch2x = new ArrayList();
        ArrayList<Integer> ch2y = new ArrayList();
        Caracter empty = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, -1, subP,' ');

        Caracter c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, 0, subSP,' ');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'!');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'"');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'\'');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'(');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,')');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,',');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'-');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'.');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,':');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,';');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'?');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'A');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'B');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'C');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'D');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'E');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'F');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'G');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'H');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'I');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'J');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'K');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'L');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'M');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'N');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'O');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'P');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'Q');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'R');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'S');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'T');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'U');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'V');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'W');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'X');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'Y');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'Z');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'[');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,']');
        letras.add(c);

        // simbolo de elevado para comandos 
        ix = new ArrayList(Arrays.asList(smallPuntos.get(19).get(0), smallPuntos.get(9).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(19).get(1), smallPuntos.get(9).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(9).get(0), smallPuntos.get(23).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(9).get(1), smallPuntos.get(23).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(19).get(0), smallPuntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(19).get(1), smallPuntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(9).get(0), smallPuntos.get(23).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(9).get(1), smallPuntos.get(23).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'^');
        letras.add(c);

        //guion bajo
        ix = new ArrayList(Arrays.asList(smallPuntos.get(36).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(36).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(41).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(41).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(36).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(36).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(41).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(41).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'_');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'a');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'b');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'c');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'d');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'e');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'f');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'g');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'h');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'i');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'j');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'k');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'l');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'m');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'n');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'o');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'p');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'q');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'r');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'s');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'t');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'u');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'v');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'w');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'x');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'y');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'z');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'{');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'}');
        letras.add(c);

        //comillas dobles de cierre (sobre el caracter de ~)
        ix = new ArrayList(Arrays.asList(smallPuntos.get(17).get(0), smallPuntos.get(17).get(0), smallPuntos.get(15).get(0), smallPuntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(17).get(1), smallPuntos.get(17).get(1), smallPuntos.get(15).get(1), smallPuntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(17).get(0), smallPuntos.get(10).get(0), smallPuntos.get(15).get(0), smallPuntos.get(8).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(17).get(1), smallPuntos.get(10).get(1), smallPuntos.get(15).get(1), smallPuntos.get(8).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(16).get(0), smallPuntos.get(17).get(0), smallPuntos.get(14).get(0), smallPuntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(16).get(1), smallPuntos.get(17).get(1), smallPuntos.get(14).get(1), smallPuntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(23).get(0), smallPuntos.get(11).get(0), smallPuntos.get(21).get(0), smallPuntos.get(9).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(23).get(1), smallPuntos.get(11).get(1), smallPuntos.get(21).get(1), smallPuntos.get(9).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'~');
        letras.add(c);

        //Comillas simples de cierre (sobre el caracter Ç)
        ix = new ArrayList(Arrays.asList(smallPuntos.get(15).get(0), smallPuntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(15).get(1), smallPuntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(15).get(0), smallPuntos.get(8).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(15).get(1), smallPuntos.get(8).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(14).get(0), smallPuntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(14).get(1), smallPuntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(21).get(0), smallPuntos.get(9).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(21).get(1), smallPuntos.get(9).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'Ç');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 33; i1++) {
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'¡');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'«');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'»');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'¿');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'Ñ');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 15; i1++) {
            letras.add(empty);
        }

        //letra á 
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(26).get(0), puntos.get(21).get(0), puntos.get(28).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(26).get(1), puntos.get(21).get(1), puntos.get(28).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(21).get(0), puntos.get(28).get(0), puntos.get(33).get(0), puntos.get(26).get(0), puntos.get(35).get(0), puntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(21).get(1), puntos.get(28).get(1), puntos.get(33).get(1), puntos.get(26).get(1), puntos.get(35).get(1), puntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(34).get(0), puntos.get(32).get(0), puntos.get(34).get(0), puntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(34).get(1), puntos.get(32).get(1), puntos.get(34).get(1), puntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(21).get(0), puntos.get(28).get(0), puntos.get(33).get(0), puntos.get(26).get(0), puntos.get(35).get(0), puntos.get(10).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(21).get(1), puntos.get(28).get(1), puntos.get(33).get(1), puntos.get(26).get(1), puntos.get(35).get(1), puntos.get(10).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'á');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 7; i1++) {
            letras.add(empty);
        }
        //letra é 

        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(20).get(0), smallPuntos.get(21).get(0), smallPuntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(20).get(1), smallPuntos.get(21).get(1), smallPuntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(21).get(0), smallPuntos.get(35).get(0), smallPuntos.get(20).get(0), smallPuntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(21).get(1), smallPuntos.get(35).get(1), smallPuntos.get(20).get(1), smallPuntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(26).get(0), smallPuntos.get(15).get(0), smallPuntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(26).get(1), smallPuntos.get(15).get(1), smallPuntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(33).get(0), smallPuntos.get(14).get(0), smallPuntos.get(10).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(33).get(1), smallPuntos.get(14).get(1), smallPuntos.get(10).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'é');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 3; i1++) {
            letras.add(empty);
        }

        //letra í minuscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(21).get(0), smallPuntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(21).get(1), smallPuntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(21).get(0), smallPuntos.get(35).get(0), smallPuntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(21).get(1), smallPuntos.get(35).get(1), smallPuntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(33).get(0), smallPuntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(33).get(1), smallPuntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(33).get(0), smallPuntos.get(10).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(33).get(1), smallPuntos.get(10).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'í');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 3; i1++) {
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP,'ñ');
        letras.add(c);

        //padding
        letras.add(empty);

        //letra ó;
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(26).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(21).get(0), puntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(26).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(21).get(1), puntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(21).get(0), puntos.get(29).get(0), puntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(21).get(1), puntos.get(29).get(1), puntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(32).get(0), puntos.get(34).get(0), puntos.get(22).get(0), puntos.get(20).get(0), puntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(32).get(1), puntos.get(34).get(1), puntos.get(22).get(1), puntos.get(20).get(1), puntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(21).get(0), puntos.get(31).get(0), puntos.get(10).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(21).get(1), puntos.get(31).get(1), puntos.get(10).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'ó');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 6; i1++) {
            letras.add(empty);
        }

        //letra ú
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(35).get(0), puntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(35).get(1), puntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(37).get(0), puntos.get(34).get(0), puntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(37).get(1), puntos.get(34).get(1), puntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(40).get(0), puntos.get(34).get(0), puntos.get(10).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(40).get(1), puntos.get(34).get(1), puntos.get(10).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP,'ú');
        letras.add(c);
    }

    @FXML
    public void dibuja() throws IOException {
        int x = 10;
        int y = 10;
        int n = 0, s = 0, k = 0;
        int aux = 0;
        int com = 0;
        int dcom = 0;
        int caracter;
        ArrayList<Palabra> palabras = new ArrayList();
        Pane pane = new Pane();
        String frase = (this.cuadroTexto.getText());
        if (bandera == 0) {
            Empezar(x, y);
            bandera++;
        }

        //creamos una palabra inicial
        Palabra palabra = new Palabra();
        palabras.add(palabra);
        
        int stt = 0;
        int sttx = 0;
       
        //recorremos toda la frase identificando las palabras 
        for (int i = 0; i < frase.length(); i++) {
            caracter = (int) frase.charAt(i) - 32;
            
            if ((0 <= caracter && caracter <= 250 && letras.get(caracter).lineas != -1)) {
                if ((int) frase.charAt(i) == 34 && dcom == 1) {
                    caracter = 94;
                    dcom = 0;
                }
                
                if ((int) frase.charAt(i) == 39 && com == 1) {
                    caracter = 95;
                    com = 0;
                }
                
                if (frase.charAt(i) == ' ') {
                    stt = 1;
                } else {
                    stt = 0;
                }
                
                if (frase.length() > i + 1 && stt != sttx) {
                    palabra = new Palabra();
                    palabras.add(palabra);
                    sttx = stt;
                    
                }
                
                palabras.get(palabras.size()-1).addChar(letras.get(caracter));
                
                //revisa las comillas
                //prepara las variables para escribir las comillas nuevas 
                if (caracter == 2) {
                    dcom = 1;
                }
                if (caracter == 7) {
                    com = 1;
                }
                
                
            } else {
                //tira un mensaje de error
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Caracter invalido");
                alert.showAndWait();
            }
        }
        
        //Ingresamos los caracteres en cada letra
        for (int i = 0; i < palabras.size(); i++) {
            for (int j = 0; j < palabras.get(i).getPalabra().size(); j++) {
                Pane pp = new Pane();
                pp.setMaxSize(palabras.get(i).getPalabra().get(j).getPanel().getMaxWidth(), 140);
                pp.setMinSize(palabras.get(i).getPalabra().get(j).getPanel().getMaxWidth(), 140);
                pp.setTranslateX(x);
                pp.setTranslateY(y);
                
                palabras.get(i).getPalabra().get(j).root = pp;
                palabras.get(i).getPalabra().get(j).dibujar(colores.getValue());
                    
                //revisamos si tenemos que subir el caracter
                
                if (j > 0 && ((int) palabras.get(i).getPalabra().get(j).chr >= 97 && (int) palabras.get(i).getPalabra().get(j).chr <= 122 || ((int) palabras.get(i).getPalabra().get(j).chr >= 225 && (int) palabras.get(i).getPalabra().get(j).chr <= 250)) && (palabras.get(i).getPalabra().get(j-1).chr == 'ó' || palabras.get(i).getPalabra().get(j-1).chr == 'b' || palabras.get(i).getPalabra().get(j-1).chr == 'o' || palabras.get(i).getPalabra().get(j-1).chr == 'v' || palabras.get(i).getPalabra().get(j-1).chr == 'w')) {
                    palabras.get(i).getPalabra().get(j).subir(colores.getValue());
                    aux = 20;
                }
                
                
                //palabras.get(i).getPalabra().get(j).subir(colores.getValue());
                
                if (muestraPuntos.isSelected()) {
                    palabras.get(i).getPalabra().get(j).getCheckpoints(s);
                }
                x += palabras.get(i).getPalabra().get(j).getPanel().getMaxWidth();
                if (x > (canvas.getWidth() - 200) && frase.length() > i+1) {
                    //colocamos un guion y hacemos un salto de linea
                    Pane sl = new Pane();
                    sl.setMaxSize(letras.get(13).getPanel().getMaxWidth(), 140);
                    sl.setMinSize(letras.get(13).getPanel().getMaxWidth(), 140);
                    sl.setTranslateX(x);
                    sl.setTranslateY(y);
                    letras.get(13).root = sl;
                    letras.get(13).dibujar(colores.getValue());
                    if (muestraPuntos.isSelected()) {
                        letras.get(13).getCheckpoints(s);
                    }
                    if (n == 1) {
                        letras.get(13).negritas(colores.getValue(),0, 0);
                    }
                    pane.getChildren().add(letras.get(13).getPanel());
                    x = 10;
                    y += 140;
                }
                //Revisamos si se llego al tope y hacemos salto de linea de ser necesario
                if (x > (canvas.getWidth() - 150)) {
                    x = 10;
                    y += 140;
                }
                
                
                //colocamos el panel dentro 
                pane.getChildren().add(palabras.get(i).getPalabra().get(j).getPanel());
                
                
            }
        }

//        for (int i = 0; i < frase.length(); i++) {
//            //caracter recibe el codigo ascii del caracter que se esta trabajando
//            caracter = (int) frase.charAt(i) - 32;
//            
//            //revisamos si es un caracter valido
//            if ((0 <= caracter && caracter <= 250 && letras.get(caracter).lineas != -1)) {
//                aux = 0;
//                
//                //Revisamos si hay algun comando
//                while (frase.charAt(i) == '^' && frase.length() > i + 2) {
//                    
//                    switch (frase.charAt(i + 1)) {
//                        //activamos negritas, cursivas o subrayado
//                        case 'N':
//                            n = 1;
//                            i += 2;
//                            break;
//                        case 'K':
//                            k = 1;
//                            i += 2;
//                            break;
//                        case 'S':
//                            s = 1;
//                            i+=2;
//                            break;
//                        default:
//                            i++;
//                    }
//                    
//                    // se actualiza para tomar el caracter nuevo despues de avanzar
//                    caracter = (int) frase.charAt(i) - 32;
//                         
//                }
//                //si hay un espacio desactivamos los estilos
//                if (frase.charAt(i) == ' ') {
//                    n = 0;
//                    s = 0;
//                    k = 0;
//                }
//                
//                
//                
//                //le asignamos un panel a la letra
//                Pane pp = new Pane();
//                pp.setMaxSize(letras.get(caracter).getPanel().getMaxWidth(), 140);
//                pp.setMinSize(letras.get(caracter).getPanel().getMaxWidth(), 140);
//                pp.setTranslateX(x);
//                pp.setTranslateY(y);
//                
//                // si el caracter son comillas dobles o simples cambiamos caracter por el codigo ascci de comillas dobles de cierre o de comillas simples de cierre
//                // no es necesario hacerlo antes ya que al tener las comillas de cierre el mismo tamaño que las de apertura podemos simplemente cambiar caracter ahora
//                if ((int) frase.charAt(i) == 34 && dcom == 1) {
//                    caracter = 94;
//                    dcom = 0;
//                }
//                
//                if ((int) frase.charAt(i) == 39 && com == 1) {
//                    caracter = 95;
//                    com = 0;
//                }
//                
//                //Revisamos si estan activadas las cursivas
//                if(k == 1){
//                    
//                    letras.get(caracter).muevePuntos();
//                    
//                }
//                letras.get(caracter).root = pp;
//                letras.get(caracter).dibujar(colores.getValue());
//                
//                //revisamos si tenemos que subir el caracter
//                if (i > 0 && ((int) frase.charAt(i) >= 97 && (int) frase.charAt(i) <= 122 || ((int) frase.charAt(i) >= 225 && (int) frase.charAt(i) <= 250)) && (frase.charAt(i - 1) == 'ó' || frase.charAt(i - 1) == 'b' || frase.charAt(i - 1) == 'o' || frase.charAt(i - 1) == 'v' || frase.charAt(i - 1) == 'w')) {
//                    letras.get((int) frase.charAt(i) - 32).subir(colores.getValue());
//                    aux = 20;
//                }
//                
//                //Revisamos si está activado el subrayado
//                if (s == 1) {
//                    letras.get((int) frase.charAt(i) - 32).subrayado(colores.getValue());
//                }
//                
//                //Revisamos si mostramos checkpoints
//                if (muestraPuntos.isSelected()) {
//                    letras.get(caracter).getCheckpoints(s);
//                }
//                
//                //Revisamos si estan activadas las negritas
//                if (n == 1) {
//                    letras.get(caracter).negritas(colores.getValue(), aux, s);
//                }
//                
//                //avanzamos en la posicion
//                x += letras.get(caracter).getPanel().getMaxWidth();
//                
//                //Revisamos si se llego al tope y si la palabra continua
//                if (x > (canvas.getWidth() - 200) && frase.length() > i+1 && caracter != 0 && frase.charAt(i+1) - 32 != 0) {
//                    //colocamos un guion y hacemos un salto de linea
//                    Pane sl = new Pane();
//                    sl.setMaxSize(letras.get(13).getPanel().getMaxWidth(), 140);
//                    sl.setMinSize(letras.get(13).getPanel().getMaxWidth(), 140);
//                    sl.setTranslateX(x);
//                    sl.setTranslateY(y);
//                    letras.get(13).root = sl;
//                    letras.get(13).dibujar(colores.getValue());
//                    if (muestraPuntos.isSelected()) {
//                        letras.get(13).getCheckpoints(s);
//                    }
//                    if (n == 1) {
//                        letras.get(13).negritas(colores.getValue(),0, 0);
//                    }
//                    pane.getChildren().add(letras.get(13).getPanel());
//                    x = 10;
//                    y += 140;
//                }
//                //Revisamos si se llego al tope y hacemos salto de linea de ser necesario
//                if (x > (canvas.getWidth() - 150)) {
//                    x = 10;
//                    y += 140;
//                }
//
//                //revisa las comillas
//                //prepara las variables para escribir las comillas nuevas 
//                if (caracter == 2) {
//                    dcom = 1;
//                }
//                if (caracter == 7) {
//                    com = 1;
//                }
//                
//                //colocamos el panel dentro 
//                pane.getChildren().add(letras.get(caracter).getPanel());
//                
//                //regresamos letras a tipografía original
//                if(k == 1){
//                    
//                    letras.get(caracter).regresaPuntos();
//                }
//
//            } else {
//                //tira un mensaje de error
//                Alert alert = new Alert(Alert.AlertType.WARNING);
//                alert.setHeaderText(null);
//                alert.setTitle("Error");
//                alert.setContentText("Caracter invalido");
//                alert.showAndWait();
//            }
//            
//        }

        //finalente colocamos el panel con toda las letras
        canvas.setGraphic(pane);
    }
}
