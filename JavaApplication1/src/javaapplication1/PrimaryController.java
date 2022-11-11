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

    //Metodo donde se crean los paneles en que se trabajaran y llama a crear los caracteres
    @FXML
    public ArrayList<Caracter> Empezar(int x, int y, int tam) {

        ArrayList<ArrayList> puntos = new ArrayList();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                //se crean puntos del Pane
                ArrayList<Integer> xy = new ArrayList();
                xy.add(tam * j);
                xy.add(tam * i);
                puntos.add(xy);
            }
        }
        //Panel estandar
        Pane p = new Pane();
        p.setMaxSize(tam * 5, tam * 7);
        p.setMinSize(tam * 5, tam * 7);
        p.setTranslateX(x);
        p.setTranslateY(y);

        ArrayList<ArrayList> smallPuntos = new ArrayList();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                //se crean puntos del smallPane
                ArrayList<Integer> xy = new ArrayList();
                xy.add((int) (3 * tam / 4) * j);
                xy.add(tam * i);
                smallPuntos.add(xy);
            }
        }
        //Panel más pequeño
        Pane smallP = new Pane();
        smallP.setMaxSize((int) (3 * tam / 4) * 5, tam * 7);
        smallP.setMinSize((int) (3 * tam / 4) * 5, tam * 7);
        smallP.setTranslateX(x);
        smallP.setTranslateY(y);
        //se crean caractereas
        return creaCaracteres(p, puntos, smallP, smallPuntos);
    }

    //Metodo que crea caracteres y los guarda en una lista de acuerdo al codigo ASCII, partiendo del 32(espacio)
    public ArrayList<Caracter> creaCaracteres(Pane p, ArrayList<ArrayList> puntos, Pane smallP, ArrayList<ArrayList> smallPuntos) {

        ArrayList<Caracter> letras;
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
        Caracter empty = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, -1, subP, ' ');

        Caracter c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, 0, subSP, ' ');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '!');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '"');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '\'');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '(');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, ')');
        letras.add(c);

        //padding
        letras.add(empty);

        //suma
        ix = new ArrayList(Arrays.asList(smallPuntos.get(25).get(0), smallPuntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(25).get(1), smallPuntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(29).get(0), smallPuntos.get(39).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(29).get(1), smallPuntos.get(39).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(25).get(0), smallPuntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(25).get(1), smallPuntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(29).get(0), smallPuntos.get(39).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(29).get(1), smallPuntos.get(39).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '+');
        letras.add(c);

        //coma
        ix = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(33).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(33).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(38).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(38).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(33).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(33).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(39).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(39).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, ',');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '-');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '.');
        letras.add(c);

        //padding
        letras.add(empty);

        //cero
        ix = new ArrayList(Arrays.asList(smallPuntos.get(3).get(0), smallPuntos.get(23).get(0), smallPuntos.get(3).get(0), smallPuntos.get(19).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(3).get(1), smallPuntos.get(23).get(1), smallPuntos.get(3).get(1), smallPuntos.get(19).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(23).get(0), smallPuntos.get(33).get(0), smallPuntos.get(19).get(0), smallPuntos.get(33).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(23).get(1), smallPuntos.get(33).get(1), smallPuntos.get(19).get(1), smallPuntos.get(33).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(4).get(0), smallPuntos.get(29).get(0), smallPuntos.get(2).get(0), smallPuntos.get(25).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(4).get(1), smallPuntos.get(29).get(1), smallPuntos.get(2).get(1), smallPuntos.get(25).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(11).get(0), smallPuntos.get(34).get(0), smallPuntos.get(7).get(0), smallPuntos.get(32).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(11).get(1), smallPuntos.get(34).get(1), smallPuntos.get(7).get(1), smallPuntos.get(32).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '0');
        letras.add(c);

        //uno
        ix = new ArrayList(Arrays.asList(smallPuntos.get(13).get(0), smallPuntos.get(3).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(13).get(1), smallPuntos.get(3).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(3).get(0), smallPuntos.get(33).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(3).get(1), smallPuntos.get(33).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(13).get(0), smallPuntos.get(3).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(13).get(1), smallPuntos.get(3).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(3).get(0), smallPuntos.get(33).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(3).get(1), smallPuntos.get(33).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '1');
        letras.add(c);

        //dos
        ix = new ArrayList(Arrays.asList(smallPuntos.get(13).get(0), smallPuntos.get(3).get(0), smallPuntos.get(17).get(0), smallPuntos.get(31).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(13).get(1), smallPuntos.get(3).get(1), smallPuntos.get(17).get(1), smallPuntos.get(31).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(3).get(0), smallPuntos.get(17).get(0), smallPuntos.get(31).get(0), smallPuntos.get(35).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(3).get(1), smallPuntos.get(17).get(1), smallPuntos.get(31).get(1), smallPuntos.get(35).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(7).get(0), smallPuntos.get(4).get(0), smallPuntos.get(23).get(0), smallPuntos.get(31).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(7).get(1), smallPuntos.get(4).get(1), smallPuntos.get(23).get(1), smallPuntos.get(31).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(11).get(0), smallPuntos.get(25).get(0), smallPuntos.get(35).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(11).get(1), smallPuntos.get(25).get(1), smallPuntos.get(35).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '2');
        letras.add(c);

        //tres
        ix = new ArrayList(Arrays.asList(smallPuntos.get(8).get(0), smallPuntos.get(11).get(0), smallPuntos.get(15).get(0), smallPuntos.get(23).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(8).get(1), smallPuntos.get(11).get(1), smallPuntos.get(15).get(1), smallPuntos.get(23).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(11).get(0), smallPuntos.get(15).get(0), smallPuntos.get(23).get(0), smallPuntos.get(26).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(11).get(1), smallPuntos.get(15).get(1), smallPuntos.get(23).get(1), smallPuntos.get(26).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(17).get(0), smallPuntos.get(16).get(0), smallPuntos.get(35).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(17).get(1), smallPuntos.get(16).get(1), smallPuntos.get(35).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(5).get(0), smallPuntos.get(16).get(0), smallPuntos.get(17).get(0), smallPuntos.get(32).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(5).get(1), smallPuntos.get(16).get(1), smallPuntos.get(17).get(1), smallPuntos.get(32).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '3');
        letras.add(c);

        //cuatro
        ix = new ArrayList(Arrays.asList(smallPuntos.get(1).get(0), smallPuntos.get(13).get(0), smallPuntos.get(4).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(1).get(1), smallPuntos.get(13).get(1), smallPuntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(13).get(0), smallPuntos.get(16).get(0), smallPuntos.get(34).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(13).get(1), smallPuntos.get(16).get(1), smallPuntos.get(34).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(1).get(0), smallPuntos.get(13).get(0), smallPuntos.get(4).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(1).get(1), smallPuntos.get(13).get(1), smallPuntos.get(4).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(13).get(0), smallPuntos.get(16).get(0), smallPuntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(13).get(1), smallPuntos.get(16).get(1), smallPuntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '4');
        letras.add(c);

        //cinco
        ix = new ArrayList(Arrays.asList(smallPuntos.get(5).get(0), smallPuntos.get(2).get(0), smallPuntos.get(14).get(0), smallPuntos.get(23).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(5).get(1), smallPuntos.get(2).get(1), smallPuntos.get(14).get(1), smallPuntos.get(23).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(14).get(0), smallPuntos.get(23).get(0), smallPuntos.get(32).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(14).get(1), smallPuntos.get(23).get(1), smallPuntos.get(32).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(5).get(0), smallPuntos.get(2).get(0), smallPuntos.get(16).get(0), smallPuntos.get(29).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(5).get(1), smallPuntos.get(2).get(1), smallPuntos.get(16).get(1), smallPuntos.get(29).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(14).get(0), smallPuntos.get(17).get(0), smallPuntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(14).get(1), smallPuntos.get(17).get(1), smallPuntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '5');
        letras.add(c);

        //seis
        ix = new ArrayList(Arrays.asList(smallPuntos.get(11).get(0), smallPuntos.get(19).get(0), smallPuntos.get(33).get(0), smallPuntos.get(23).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(11).get(1), smallPuntos.get(19).get(1), smallPuntos.get(33).get(1), smallPuntos.get(23).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(19).get(0), smallPuntos.get(33).get(0), smallPuntos.get(23).get(0), smallPuntos.get(19).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(19).get(1), smallPuntos.get(33).get(1), smallPuntos.get(23).get(1), smallPuntos.get(19).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(4).get(0), smallPuntos.get(25).get(0), smallPuntos.get(34).get(0), smallPuntos.get(17).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(4).get(1), smallPuntos.get(25).get(1), smallPuntos.get(34).get(1), smallPuntos.get(17).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(1).get(0), smallPuntos.get(32).get(0), smallPuntos.get(29).get(0), smallPuntos.get(13).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(1).get(1), smallPuntos.get(32).get(1), smallPuntos.get(29).get(1), smallPuntos.get(13).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '6');
        letras.add(c);

        //siete
        ix = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(5).get(0), smallPuntos.get(14).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(5).get(1), smallPuntos.get(14).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(5).get(0), smallPuntos.get(32).get(0), smallPuntos.get(17).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(5).get(1), smallPuntos.get(32).get(1), smallPuntos.get(17).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(5).get(0), smallPuntos.get(14).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(5).get(1), smallPuntos.get(14).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(5).get(0), smallPuntos.get(32).get(0), smallPuntos.get(17).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(5).get(1), smallPuntos.get(32).get(1), smallPuntos.get(17).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '7');
        letras.add(c);

        //ocho
        ix = new ArrayList(Arrays.asList(smallPuntos.get(13).get(0), smallPuntos.get(13).get(0), smallPuntos.get(16).get(0), smallPuntos.get(22).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(13).get(1), smallPuntos.get(13).get(1), smallPuntos.get(16).get(1), smallPuntos.get(22).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(16).get(0), smallPuntos.get(22).get(0), smallPuntos.get(19).get(0), smallPuntos.get(19).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(16).get(1), smallPuntos.get(22).get(1), smallPuntos.get(19).get(1), smallPuntos.get(19).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(1).get(0), smallPuntos.get(19).get(0), smallPuntos.get(22).get(0), smallPuntos.get(34).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(1).get(1), smallPuntos.get(19).get(1), smallPuntos.get(22).get(1), smallPuntos.get(34).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(4).get(0), smallPuntos.get(16).get(0), smallPuntos.get(13).get(0), smallPuntos.get(31).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(4).get(1), smallPuntos.get(16).get(1), smallPuntos.get(13).get(1), smallPuntos.get(31).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '8');
        letras.add(c);

        //nueve
        ix = new ArrayList(Arrays.asList(smallPuntos.get(14).get(0), smallPuntos.get(14).get(0), smallPuntos.get(17).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(14).get(1), smallPuntos.get(14).get(1), smallPuntos.get(17).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(17).get(0), smallPuntos.get(17).get(0), smallPuntos.get(32).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(17).get(1), smallPuntos.get(17).get(1), smallPuntos.get(32).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(2).get(0), smallPuntos.get(20).get(0), smallPuntos.get(23).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(2).get(1), smallPuntos.get(20).get(1), smallPuntos.get(23).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(5).get(0), smallPuntos.get(23).get(0), smallPuntos.get(34).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(5).get(1), smallPuntos.get(23).get(1), smallPuntos.get(34).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '9');
        letras.add(c);

        //dos puntos
        ix = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(21).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(21).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(33).get(0), smallPuntos.get(21).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(33).get(1), smallPuntos.get(21).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(20).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(20).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(15).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(15).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, ':');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, ';');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, '?');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'A');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'B');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'C');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'D');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'E');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'F');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'G');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'H');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'I');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'J');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'K');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'L');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'M');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'N');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'O');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'P');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'Q');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'R');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'S');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'T');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'U');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'V');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'W');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'X');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'Y');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'Z');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '[');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, ']');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, '^');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '_');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'a');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'b');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'c');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'd');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'e');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'f');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'g');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'h');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'i');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'j');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'k');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'l');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'm');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'n');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'o');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'p');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'q');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'r');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 's');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 't');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'u');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'v');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'w');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'x');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'y');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'z');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '{');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '}');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '~');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'Ç');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, '¡');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, '«');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, '»');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, '¿');
        letras.add(c);

        //padding
        letras.add(empty);

        //letra Á mayúscula
        ix = new ArrayList(Arrays.asList(puntos.get(13).get(0), puntos.get(22).get(0), puntos.get(22).get(0), puntos.get(4).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(13).get(1), puntos.get(22).get(1), puntos.get(22).get(1), puntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(22).get(0), puntos.get(13).get(0), puntos.get(35).get(0), puntos.get(4).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(22).get(1), puntos.get(13).get(1), puntos.get(35).get(1), puntos.get(4).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(42).get(0), puntos.get(10).get(0), puntos.get(40).get(0), puntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(42).get(1), puntos.get(10).get(1), puntos.get(40).get(1), puntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(46).get(0), puntos.get(2).get(0), puntos.get(35).get(0), puntos.get(9).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(46).get(1), puntos.get(2).get(1), puntos.get(35).get(1), puntos.get(9).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'Á');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 7; i1++) {
            letras.add(empty);
        }

        //letra É mayúscula
        ix = new ArrayList(Arrays.asList(puntos.get(9).get(0), puntos.get(21).get(0), puntos.get(4).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(9).get(1), puntos.get(21).get(1), puntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(21).get(0), puntos.get(35).get(0), puntos.get(4).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(21).get(1), puntos.get(35).get(1), puntos.get(4).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(1).get(0), puntos.get(13).get(0), puntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(1).get(1), puntos.get(13).get(1), puntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(24).get(0), puntos.get(42).get(0), puntos.get(9).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(24).get(1), puntos.get(42).get(1), puntos.get(9).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'É');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 3; i1++) {
            letras.add(empty);
        }

        //letra Í mayúscula
        ix = new ArrayList(Arrays.asList(smallPuntos.get(7).get(0), smallPuntos.get(10).get(0), smallPuntos.get(34).get(0), smallPuntos.get(4).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(7).get(1), smallPuntos.get(10).get(1), smallPuntos.get(34).get(1), smallPuntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(10).get(0), smallPuntos.get(34).get(0), smallPuntos.get(30).get(0), smallPuntos.get(4).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(10).get(1), smallPuntos.get(34).get(1), smallPuntos.get(30).get(1), smallPuntos.get(4).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(13).get(0), smallPuntos.get(22).get(0), smallPuntos.get(46).get(0), smallPuntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(13).get(1), smallPuntos.get(22).get(1), smallPuntos.get(46).get(1), smallPuntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(16).get(0), smallPuntos.get(28).get(0), smallPuntos.get(42).get(0), smallPuntos.get(9).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(16).get(1), smallPuntos.get(28).get(1), smallPuntos.get(42).get(1), smallPuntos.get(9).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'Í');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 3; i1++) {
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'Ñ');
        letras.add(c);

        //padding
        letras.add(empty);

        //letra Ó mayúscula
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0), puntos.get(22).get(0), puntos.get(4).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1), puntos.get(22).get(1), puntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(22).get(0), puntos.get(13).get(0), puntos.get(4).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(22).get(1), puntos.get(13).get(1), puntos.get(4).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(42).get(0), puntos.get(4).get(0), puntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(47).get(1), puntos.get(4).get(1), puntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(46).get(0), puntos.get(1).get(0), puntos.get(9).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(47).get(1), puntos.get(1).get(1), puntos.get(9).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'Ó');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 6; i1++) {
            letras.add(empty);
        }

        //letra Ú mayúscula
        ix = new ArrayList(Arrays.asList(puntos.get(12).get(0), puntos.get(13).get(0), puntos.get(10).get(0), puntos.get(4).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(12).get(1), puntos.get(13).get(1), puntos.get(10).get(1), puntos.get(4).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(13).get(0), puntos.get(10).get(0), puntos.get(35).get(0), puntos.get(4).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(13).get(1), puntos.get(10).get(1), puntos.get(35).get(1), puntos.get(4).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(6).get(0), puntos.get(43).get(0), puntos.get(39).get(0), puntos.get(9).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(6).get(1), puntos.get(43).get(1), puntos.get(39).get(1), puntos.get(9).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(7).get(0), puntos.get(46).get(0), puntos.get(35).get(0), puntos.get(9).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(7).get(1), puntos.get(46).get(1), puntos.get(35).get(1), puntos.get(9).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'Ú');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 6; i1++) {
            letras.add(empty);
        }

        //letra á minúscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(26).get(0), puntos.get(21).get(0), puntos.get(28).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(26).get(1), puntos.get(21).get(1), puntos.get(28).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(21).get(0), puntos.get(28).get(0), puntos.get(33).get(0), puntos.get(26).get(0), puntos.get(35).get(0), puntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(21).get(1), puntos.get(28).get(1), puntos.get(33).get(1), puntos.get(26).get(1), puntos.get(35).get(1), puntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(34).get(0), puntos.get(32).get(0), puntos.get(34).get(0), puntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(34).get(1), puntos.get(32).get(1), puntos.get(34).get(1), puntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(21).get(0), puntos.get(28).get(0), puntos.get(33).get(0), puntos.get(26).get(0), puntos.get(35).get(0), puntos.get(10).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(21).get(1), puntos.get(28).get(1), puntos.get(33).get(1), puntos.get(26).get(1), puntos.get(35).get(1), puntos.get(10).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'á');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 7; i1++) {
            letras.add(empty);
        }
        //letra é minúscula

        ix = new ArrayList(Arrays.asList(smallPuntos.get(30).get(0), smallPuntos.get(20).get(0), smallPuntos.get(21).get(0), smallPuntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(smallPuntos.get(30).get(1), smallPuntos.get(20).get(1), smallPuntos.get(21).get(1), smallPuntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(smallPuntos.get(21).get(0), smallPuntos.get(35).get(0), smallPuntos.get(20).get(0), smallPuntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(smallPuntos.get(21).get(1), smallPuntos.get(35).get(1), smallPuntos.get(20).get(1), smallPuntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(smallPuntos.get(32).get(0), smallPuntos.get(26).get(0), smallPuntos.get(15).get(0), smallPuntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(smallPuntos.get(32).get(1), smallPuntos.get(26).get(1), smallPuntos.get(15).get(1), smallPuntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(smallPuntos.get(27).get(0), smallPuntos.get(33).get(0), smallPuntos.get(14).get(0), smallPuntos.get(10).get(0)));
        ch2y = new ArrayList(Arrays.asList(smallPuntos.get(27).get(1), smallPuntos.get(33).get(1), smallPuntos.get(14).get(1), smallPuntos.get(10).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'é');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'í');
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
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, smallP, ix.size(), subSP, 'ñ');
        letras.add(c);

        //padding
        letras.add(empty);

        //letra ó minúscula;
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(26).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(21).get(0), puntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(26).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(21).get(1), puntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(21).get(0), puntos.get(29).get(0), puntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(21).get(1), puntos.get(29).get(1), puntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(32).get(0), puntos.get(34).get(0), puntos.get(22).get(0), puntos.get(20).get(0), puntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(32).get(1), puntos.get(34).get(1), puntos.get(22).get(1), puntos.get(20).get(1), puntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(33).get(0), puntos.get(28).get(0), puntos.get(21).get(0), puntos.get(31).get(0), puntos.get(10).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(33).get(1), puntos.get(28).get(1), puntos.get(21).get(1), puntos.get(31).get(1), puntos.get(10).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'ó');
        letras.add(c);

        //padding
        for (int i1 = 0; i1 < 6; i1++) {
            letras.add(empty);
        }

        //letra ú minúscula
        ix = new ArrayList(Arrays.asList(puntos.get(30).get(0), puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(15).get(0)));
        iy = new ArrayList(Arrays.asList(puntos.get(30).get(1), puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(15).get(1)));
        fx = new ArrayList(Arrays.asList(puntos.get(20).get(0), puntos.get(22).get(0), puntos.get(35).get(0), puntos.get(10).get(0)));
        fy = new ArrayList(Arrays.asList(puntos.get(20).get(1), puntos.get(22).get(1), puntos.get(35).get(1), puntos.get(10).get(1)));
        ch1x = new ArrayList(Arrays.asList(puntos.get(31).get(0), puntos.get(37).get(0), puntos.get(34).get(0), puntos.get(15).get(0)));
        ch1y = new ArrayList(Arrays.asList(puntos.get(31).get(1), puntos.get(37).get(1), puntos.get(34).get(1), puntos.get(15).get(1)));
        ch2x = new ArrayList(Arrays.asList(puntos.get(26).get(0), puntos.get(40).get(0), puntos.get(34).get(0), puntos.get(10).get(0)));
        ch2y = new ArrayList(Arrays.asList(puntos.get(26).get(1), puntos.get(40).get(1), puntos.get(34).get(1), puntos.get(10).get(1)));
        c = new Caracter(ix, iy, fx, fy, ch1x, ch1y, ch2x, ch2y, p, ix.size(), subP, 'ú');
        letras.add(c);
        return letras;
    }

    @FXML
    public void dibuja() throws IOException {
        int x = 10;
        int y = 10;
        int com = 0;
        int dcom = 0;
        int caracter;
        int b;
        int comas = 0;
        int tam = 20;
        int tamanio1;
        int tamanio2;
        int pos = -1;
        int max = 0;
        int posMax = 0;
        int reverse = 0;
        ArrayList<Palabra> palabras = new ArrayList();
        ArrayList<Integer> maximos = new ArrayList();
        maximos.add(0);
        Pane pane = new Pane();
        String frase = (this.cuadroTexto.getText());
        //solo si es primera vez en ejecucion crea caracteres

        ArrayList<Caracter> letras = Empezar(x, y, tam);

        //creamos una palabra inicial
        Palabra palabra = new Palabra();
        palabras.add(palabra);
        //estate y estate aux
        int stt;
        int sttx = 0;
        //recorremos toda la frase identificando las palabras 
        if (frase.length() > 0 && frase.charAt(0) == ' ') {
            sttx = 1;
        }
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
                if (stt != sttx && i > 0) {
                    palabra = new Palabra();
                    palabras.add(palabra);
                    sttx = stt;
                }
                palabras.get(palabras.size() - 1).addChar(letras.get(caracter));
                palabras.get(palabras.size() - 1).setT(tam);
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
        if (palabras.size() > 0 && palabras.get(0).getPalabra().size() > 0 && palabras.get(0).getPalabra().get(0).chr == ' ') {
            comas = 1;
        }
        for (int i = 0; i < palabras.size(); i++) {
            for (int j = 0; j < palabras.get(i).getPalabra().size(); j++) {
                //revisa si caracter es acento circunflejo
                if (palabras.get(i).getPalabra().get(j).chr == '^') {
                    pos = j;
                } //contamos las comas
                else if (palabras.get(i).getPalabra().get(j).chr == ',' && i == palabras.size() - 1 && pos > 0) {
                    comas += 2;
                } //revisa estilos combinados hacia atras
                else if (pos > 0 && comas < palabras.size() && (palabras.get(i).getPalabra().get(j - 1).chr == ',' || palabras.get(i).getPalabra().get(j - 1).chr == '+' || palabras.get(i).getPalabra().get(j - 1).chr == '^')) {
                    switch (palabras.get(i).getPalabra().get(j).chr) {
                        case 'K' -> {
                            palabras.get(comas).setK(1);
                        }
                        case 'S' -> {
                            palabras.get(comas).setS(1);
                        }
                        case 'N' -> {
                            palabras.get(comas).setN(1);
                        }
                        case 'T' -> {
                            if (palabras.get(i).getPalabra().size() > j + 2) {
                                tamanio1 = (int) palabras.get(i).getPalabra().get(j + 1).chr;
                                tamanio1 -= 48;
                                if (tamanio1 >= 0 && tamanio1 <= 9) {
                                    tamanio1 *= 10;
                                    tamanio2 = (int) palabras.get(i).getPalabra().get(j + 2).chr;
                                    tamanio2 -= 48;
                                    if (tamanio2 >= 0 && tamanio2 <= 9) {
                                        palabras.get(comas).setT(tamanio1 + tamanio2);
                                    }
                                }
                            }
                        }
                        default -> {
                        }
                    }

                } //revisa estilos hacia adelante
                else if (pos == 0 && j > 0 && (palabras.get(i).getPalabra().get(j - 1).chr == '^' || palabras.get(i).getPalabra().get(j - 1).chr == '+')) {
                    switch (palabras.get(i).getPalabra().get(j).chr) {
                        case 'K' -> {
                            palabras.get(i).setK(1);
                        }
                        case 'S' -> {
                            palabras.get(i).setS(1);
                        }
                        case 'N' -> {
                            palabras.get(i).setN(1);
                        }
                        case 'T' -> {
                            if (palabras.get(i).getPalabra().size() > j + 2) {
                                tamanio1 = (int) palabras.get(i).getPalabra().get(j + 1).chr;
                                tamanio1 -= 48;
                                if (tamanio1 >= 0 && tamanio1 <= 9) {
                                    tamanio1 *= 10;
                                    tamanio2 = (int) palabras.get(i).getPalabra().get(j + 2).chr;
                                    tamanio2 -= 48;
                                    if (tamanio2 >= 0 && tamanio2 <= 9) {
                                        palabras.get(i).setT(tamanio1 + tamanio2);
                                    }
                                }
                            }
                        }
                        default -> {
                        }
                    }
                }
                

            }
            pos = -1;

        }
        if (reverse == 0) {
            //ciclo para ver el tam max de cada linea
            for (int i = 0; i < palabras.size(); i++) {
                for (int j = 0; j < palabras.get(i).getPalabra().size(); j++) {
                    //revisa si caracter es acento circunflejo
                    if (palabras.get(i).getPalabra().get(j).chr == '^') {

                    } //contamos las comas
                    else if (palabras.get(i).getPalabra().get(j).chr == ',' && i == palabras.size() - 1 && pos > 0) {

                    } //revisa estilos combinados hacia atras
                    else if (pos > 0 && comas < palabras.size() && (palabras.get(i).getPalabra().get(j - 1).chr == ',' || palabras.get(i).getPalabra().get(j - 1).chr == '+' || palabras.get(i).getPalabra().get(j - 1).chr == '^')) {

                    } //revisa estilos hacia adelante
                    else if (pos == 0 && j > 0 && (palabras.get(i).getPalabra().get(j - 1).chr == '^' || palabras.get(i).getPalabra().get(j - 1).chr == '+')) {

                    } else {
                        //identificamos el tamaño maximo de cada linea
                        if (palabras.get(i).getT() > max) {
                            max = palabras.get(i).getT();
                            maximos.set(posMax, max);
                        }
                        if (palabras.get(i).getPalabra().get(j).width == 100) {

                            x += palabras.get(i).getT() * 5;
                        } else {

                            x += (int) (3 * palabras.get(i).getT() / 4) * 5;
                        }

                        if (x > (canvas.getWidth() - 200) && j + 1 < palabras.get(i).getPalabra().size() && palabras.get(i).getPalabra().get(j).chr != ' ') {
                            maximos.add(max);
                            posMax++;
                            x = 10;
                            max = 0;
                        }
                        if (x > (canvas.getWidth() - 150)) {
                            maximos.add(max);
                            posMax++;
                            x = 10;
                            max = 0;
                        }

                    }

                }
                pos = -1;

            }
            //fin ciclo anterior

            posMax = 0;
            pos = -1;
            x = 10;
            max = 0;
            //Ingresamos los caracteres en cada letra
            letras = Empezar(x, y, palabras.get(0).getT());
            for (int i = 0; i < palabras.size(); i++) {
                //crea caracteres
                if (i > 0 && palabras.get(i).getT() != palabras.get(i - 1).getT()) {
                    letras = Empezar(x, y, palabras.get(i).getT());
                }

                for (int j = 0; j < palabras.get(i).getPalabra().size(); j++) {

                    if (palabras.get(i).getT() > max) {
                        max = palabras.get(i).getT();
                    }
                    b = 0;
                    Pane pp = new Pane();

                    //if para revisar comillas de cierre simple
                    if ((int) palabras.get(i).getPalabra().get(j).chr == 199) {
                        palabras.get(i).getPalabra().get(j).replace(letras.get(95));
                    } else {
                        palabras.get(i).getPalabra().get(j).replace(letras.get((int) palabras.get(i).getPalabra().get(j).chr - 32));
                    }

                    pp.setMaxSize(palabras.get(i).getPalabra().get(j).getPanel().getMaxWidth(), palabras.get(i).getT() * 7);
                    pp.setMinSize(palabras.get(i).getPalabra().get(j).getPanel().getMaxWidth(), palabras.get(i).getT() * 7);
                    pp.setTranslateX(x);
                    pp.setTranslateY(y);

                    //subraya espacios entre palabras que lo esten
                    if (palabras.get(i).getS() == 1 && i > 1 && palabras.get(i - 2).getS() == 1 && j == 0) {
                        for (int k = 0; k < palabras.get(i - 1).getPalabra().size(); k++) {
                            if (maximos.get(posMax) > palabras.get(i - 1).getT()) {
                                palabras.get(i - 1).getPalabra().get(k).mover(maximos.get(posMax), palabras.get(i - 1).getT(), 1);
                            }

                            palabras.get(i - 1).getPalabra().get(k).subrayado(colores.getValue());

                            if (maximos.get(posMax) > palabras.get(i - 1).getT()) {
                                palabras.get(i - 1).getPalabra().get(k).regresar(maximos.get(posMax), palabras.get(i - 1).getT(), 1);
                            }
                        }
                    }
                    //revisa si caracter es acento circunflejo
                    if (palabras.get(i).getPalabra().get(j).chr == '^') {
                        pos = j;
                        b = 1;
                    } //contamos las comas
                    else if (palabras.get(i).getPalabra().get(j).chr == ',' && i == palabras.size() - 1 && pos > 0) {
                        b = 1;
                    } else if (palabras.get(i).getPalabra().get(j).chr == '+') {
                        b = 1;
                    } //revisa estilos combinados hacia atras
                    else if (pos > 0 && comas < palabras.size() && (palabras.get(i).getPalabra().get(j - 1).chr == ',' || palabras.get(i).getPalabra().get(j - 1).chr == '+' || palabras.get(i).getPalabra().get(j - 1).chr == '^')) {
                        switch (palabras.get(i).getPalabra().get(j).chr) {
                            case 'K' -> {
                                b = 1;
                            }
                            case 'S' -> {
                                b = 1;
                            }
                            case 'N' -> {
                                b = 1;
                            }
                            case 'T' -> {
                                b = 1;
                            }
                            default -> {
                            }
                        }
                    } //revisa estilos hacia adelante
                    else if (pos == 0 && j > 0 && (palabras.get(i).getPalabra().get(j - 1).chr == '^' || palabras.get(i).getPalabra().get(j - 1).chr == '+')) {
                        switch (palabras.get(i).getPalabra().get(j).chr) {
                            case 'K' -> {
                                b = 1;
                            }
                            case 'S' -> {
                                b = 1;
                            }
                            case 'N' -> {
                                b = 1;
                            }
                            case 'T' -> {
                                b = 1;
                            }
                            default -> {
                            }
                        }
                    } else if (pos >= 0 && (int) palabras.get(i).getPalabra().get(j).chr >= 48 && (int) palabras.get(i).getPalabra().get(j).chr <= 57 && ((int) palabras.get(i).getPalabra().get(j - 1).chr == 'T' || (int) palabras.get(i).getPalabra().get(j - 2).chr == 'T')) {
                        b = 1;
                    }
                    //si no es estilo dibuja
                    if (b == 0) {

                        //revisamos si tenemos que subir el caracter
                        if (j > 0 && ((int) palabras.get(i).getPalabra().get(j).chr >= 97 && (int) palabras.get(i).getPalabra().get(j).chr <= 122 || ((int) palabras.get(i).getPalabra().get(j).chr >= 225 && (int) palabras.get(i).getPalabra().get(j).chr <= 250)) && (palabras.get(i).getPalabra().get(j - 1).chr == 'ó' || palabras.get(i).getPalabra().get(j - 1).chr == 'b' || palabras.get(i).getPalabra().get(j - 1).chr == 'o' || palabras.get(i).getPalabra().get(j - 1).chr == 'v' || palabras.get(i).getPalabra().get(j - 1).chr == 'w')) {
                            palabras.get(i).getPalabra().get(j).subir(palabras.get(i).getT());
                        }

                        //revisamos si estan activadas las cursivas
                        if (palabras.get(i).getK() == 1) {
                            palabras.get(i).getPalabra().get(j).muevePuntos(palabras.get(i).getT());
                        }

                        //mueve puntos para alinearlos
                        if (maximos.get(posMax) > palabras.get(i).getT()) {
                            palabras.get(i).getPalabra().get(j).mover(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                        }

                        //dibujamos la letras
                        palabras.get(i).getPalabra().get(j).root = pp;
                        palabras.get(i).getPalabra().get(j).dibujar(colores.getValue());

                        //revisamos si esta activado el subrayado
                        if (palabras.get(i).getS() == 1) {
                            palabras.get(i).getPalabra().get(j).subrayado(colores.getValue());
                        }

                        //revisamos si mostramos checkpoints
                        if (muestraPuntos.isSelected()) {
                            palabras.get(i).getPalabra().get(j).getCheckpoints(palabras.get(i).getS());
                        }

                        //revisamos si estan activadas las negritas
                        if (palabras.get(i).getN() == 1) {
                            palabras.get(i).getPalabra().get(j).negritas(colores.getValue(), palabras.get(i).getS());
                        }

                        //avanzamos en la posicion
                        x += palabras.get(i).getPalabra().get(j).getPanel().getMaxWidth();

                        //revisamos si se llego al tope y si la palabra continua
                        if (x > (canvas.getWidth() - 200) && j + 1 < palabras.get(i).getPalabra().size() && palabras.get(i).getPalabra().get(j).chr != ' ' && palabras.get(i).getPalabra().get(j + 1).chr != '^') {
                            //colocamos un guion y hacemos un salto de linea
                            Pane sl = new Pane();
                            sl.setMaxSize(letras.get(13).getPanel().getMaxWidth(), palabras.get(i).getT() * 7);
                            sl.setMinSize(letras.get(13).getPanel().getMaxWidth(), palabras.get(i).getT() * 7);
                            sl.setTranslateX(x);
                            sl.setTranslateY(y);
                            letras.get(13).root = sl;

                            //revisamos si el tamaño de la palabra es menor al tamaño maximo de la linea
                            if (maximos.get(posMax) > palabras.get(i).getT()) {
                                letras.get(13).mover(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                            }

                            //dibuja guión
                            letras.get(13).dibujar(colores.getValue());

                            //muestra checkpoints
                            if (muestraPuntos.isSelected()) {
                                letras.get(13).getCheckpoints(palabras.get(i).getS());
                            }

                            //aplica negritas
                            if (palabras.get(i).getN() == 1) {
                                letras.get(13).negritas(colores.getValue(), 0);
                            }

                            pane.getChildren().add(letras.get(13).getPanel());

                            //regresa puntos de guión
                            if (maximos.get(posMax) > palabras.get(i).getT()) {
                                letras.get(13).regresar(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                            }

                            x = 10;
                            y += max * 7;

                            //regresa puntos de caracter
                            if (maximos.get(posMax) > palabras.get(i).getT()) {
                                palabras.get(i).getPalabra().get(j).regresar(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                            }

                            posMax++;
                            max = 0;
                        }
                        //revisamos si se llego al tope y hacemos salto de linea de ser necesario
                        if (x > (canvas.getWidth() - 150)) {
                            x = 10;
                            y += max * 7;
                            max = 0;
                            posMax++;
                        }
                        //colocamos el panel dentro 
                        pane.getChildren().add(palabras.get(i).getPalabra().get(j).getPanel());

                        //regresamos letras a su posicion
                        if (maximos.get(posMax) > palabras.get(i).getT() && max != 0) {
                            palabras.get(i).getPalabra().get(j).regresar(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                        }

                        //regresamos letras a tipografia original
                        if (palabras.get(i).getK() == 1) {
                            palabras.get(i).getPalabra().get(j).regresaPuntos(palabras.get(i).getT());
                        }
                        //bajamos la letra si se subio 
                        if (j > 0 && ((int) palabras.get(i).getPalabra().get(j).chr >= 97 && (int) palabras.get(i).getPalabra().get(j).chr <= 122 || ((int) palabras.get(i).getPalabra().get(j).chr >= 225 && (int) palabras.get(i).getPalabra().get(j).chr <= 250)) && (palabras.get(i).getPalabra().get(j - 1).chr == 'ó' || palabras.get(i).getPalabra().get(j - 1).chr == 'b' || palabras.get(i).getPalabra().get(j - 1).chr == 'o' || palabras.get(i).getPalabra().get(j - 1).chr == 'v' || palabras.get(i).getPalabra().get(j - 1).chr == 'w')) {
                            palabras.get(i).getPalabra().get(j).bajar(palabras.get(i).getT());
                        }
                    }
                }
                pos = -1;
            }
        } else {
            //ciclo para ver el tam max de cada linea
            for (int i = palabras.size() - 1; i >= 0; i--) {
                for (int j = 0; j < palabras.get(i).getPalabra().size(); j++) {
                    //revisa si caracter es acento circunflejo
                    if (palabras.get(i).getPalabra().get(j).chr == '^') {

                    } //contamos las comas
                    else if (palabras.get(i).getPalabra().get(j).chr == ',' && i == palabras.size() - 1 && pos > 0) {

                    } //revisa estilos combinados hacia atras
                    else if (pos > 0 && comas < palabras.size() && (palabras.get(i).getPalabra().get(j - 1).chr == ',' || palabras.get(i).getPalabra().get(j - 1).chr == '+' || palabras.get(i).getPalabra().get(j - 1).chr == '^')) {

                    } //revisa estilos hacia adelante
                    else if (pos == 0 && j > 0 && (palabras.get(i).getPalabra().get(j - 1).chr == '^' || palabras.get(i).getPalabra().get(j - 1).chr == '+')) {

                    } else {
                        //identificamos el tamaño maximo de cada linea
                        if (palabras.get(i).getT() > max) {
                            max = palabras.get(i).getT();
                            maximos.set(posMax, max);
                        }
                        if (palabras.get(i).getPalabra().get(j).width == 100) {

                            x += palabras.get(i).getT() * 5;
                        } else {

                            x += (int) (3 * palabras.get(i).getT() / 4) * 5;
                        }

                        if (x > (canvas.getWidth() - 200) && j + 1 < palabras.get(i).getPalabra().size() && palabras.get(i).getPalabra().get(j).chr != ' ') {
                            maximos.add(max);
                            posMax++;
                            x = 10;
                            max = 0;
                        }
                        if (x > (canvas.getWidth() - 150)) {
                            maximos.add(max);
                            posMax++;
                            x = 10;
                            max = 0;
                        }

                    }

                }
                pos = -1;

            }
            //fin ciclo anterior

            posMax = 0;
            pos = -1;
            x = 10;
            max = 0;
            //Ingresamos los caracteres en cada letra
            letras = Empezar(x, y, palabras.get(0).getT());
            for (int i = palabras.size() - 1; i >= 0; i--) {
                //crea caracteres
                if (i < palabras.size() - 1 && palabras.get(i).getT() != palabras.get(i + 1).getT()) {
                    letras = Empezar(x, y, palabras.get(i).getT());
                }

                for (int j = 0; j < palabras.get(i).getPalabra().size(); j++) {

                    if (palabras.get(i).getT() > max) {
                        max = palabras.get(i).getT();
                    }
                    b = 0;
                    Pane pp = new Pane();

                    //if para revisar comillas de cierre simple
                    if ((int) palabras.get(i).getPalabra().get(j).chr == 199) {
                        palabras.get(i).getPalabra().get(j).replace(letras.get(95));
                    } else {
                        palabras.get(i).getPalabra().get(j).replace(letras.get((int) palabras.get(i).getPalabra().get(j).chr - 32));
                    }

                    pp.setMaxSize(palabras.get(i).getPalabra().get(j).getPanel().getMaxWidth(), palabras.get(i).getT() * 7);
                    pp.setMinSize(palabras.get(i).getPalabra().get(j).getPanel().getMaxWidth(), palabras.get(i).getT() * 7);
                    pp.setTranslateX(x);
                    pp.setTranslateY(y);

                    //subraya espacios entre palabras que lo esten
                    if (palabras.get(i).getS() == 1 && i > 1 && palabras.get(i - 2).getS() == 1 && j == 0) {
                        for (int k = 0; k < palabras.get(i - 1).getPalabra().size(); k++) {
                            if (maximos.get(posMax) > palabras.get(i - 1).getT()) {
                                palabras.get(i - 1).getPalabra().get(k).mover(maximos.get(posMax), palabras.get(i - 1).getT(), 1);
                            }

                            palabras.get(i - 1).getPalabra().get(k).subrayado(colores.getValue());

                            if (maximos.get(posMax) > palabras.get(i - 1).getT()) {
                                palabras.get(i - 1).getPalabra().get(k).regresar(maximos.get(posMax), palabras.get(i - 1).getT(), 1);
                            }
                        }
                    }
                    //revisa si caracter es acento circunflejo
                    if (palabras.get(i).getPalabra().get(j).chr == '^') {
                        pos = j;
                        b = 1;
                    } //contamos las comas
                    else if (palabras.get(i).getPalabra().get(j).chr == ',' && i == palabras.size() - 1 && pos > 0) {
                        b = 1;
                    } else if (palabras.get(i).getPalabra().get(j).chr == '+') {
                        b = 1;
                    } //revisa estilos combinados hacia atras
                    else if (pos > 0 && comas < palabras.size() && (palabras.get(i).getPalabra().get(j - 1).chr == ',' || palabras.get(i).getPalabra().get(j - 1).chr == '+' || palabras.get(i).getPalabra().get(j - 1).chr == '^')) {
                        switch (palabras.get(i).getPalabra().get(j).chr) {
                            case 'K' -> {
                                b = 1;
                            }
                            case 'S' -> {
                                b = 1;
                            }
                            case 'N' -> {
                                b = 1;
                            }
                            case 'T' -> {
                                b = 1;
                            }
                            default -> {
                            }
                        }
                    } //revisa estilos hacia adelante
                    else if (pos == 0 && j > 0 && (palabras.get(i).getPalabra().get(j - 1).chr == '^' || palabras.get(i).getPalabra().get(j - 1).chr == '+')) {
                        switch (palabras.get(i).getPalabra().get(j).chr) {
                            case 'K' -> {
                                b = 1;
                            }
                            case 'S' -> {
                                b = 1;
                            }
                            case 'N' -> {
                                b = 1;
                            }
                            case 'T' -> {
                                b = 1;
                            }
                            default -> {
                            }
                        }
                    } else if (pos >= 0 && (int) palabras.get(i).getPalabra().get(j).chr >= 48 && (int) palabras.get(i).getPalabra().get(j).chr <= 57 && ((int) palabras.get(i).getPalabra().get(j - 1).chr == 'T' || (int) palabras.get(i).getPalabra().get(j - 2).chr == 'T')) {
                        b = 1;
                    }
                    //si no es estilo dibuja
                    if (b == 0) {

                        //revisamos si tenemos que subir el caracter
                        if (j > 0 && ((int) palabras.get(i).getPalabra().get(j).chr >= 97 && (int) palabras.get(i).getPalabra().get(j).chr <= 122 || ((int) palabras.get(i).getPalabra().get(j).chr >= 225 && (int) palabras.get(i).getPalabra().get(j).chr <= 250)) && (palabras.get(i).getPalabra().get(j - 1).chr == 'ó' || palabras.get(i).getPalabra().get(j - 1).chr == 'b' || palabras.get(i).getPalabra().get(j - 1).chr == 'o' || palabras.get(i).getPalabra().get(j - 1).chr == 'v' || palabras.get(i).getPalabra().get(j - 1).chr == 'w')) {
                            palabras.get(i).getPalabra().get(j).subir(palabras.get(i).getT());
                        }

                        //revisamos si estan activadas las cursivas
                        if (palabras.get(i).getK() == 1) {
                            palabras.get(i).getPalabra().get(j).muevePuntos(palabras.get(i).getT());
                        }

                        //mueve puntos para alinearlos
                        if (maximos.get(posMax) > palabras.get(i).getT()) {
                            palabras.get(i).getPalabra().get(j).mover(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                        }

                        //dibujamos la letras
                        palabras.get(i).getPalabra().get(j).root = pp;
                        palabras.get(i).getPalabra().get(j).dibujar(colores.getValue());

                        //revisamos si esta activado el subrayado
                        if (palabras.get(i).getS() == 1) {
                            palabras.get(i).getPalabra().get(j).subrayado(colores.getValue());
                        }

                        //revisamos si mostramos checkpoints
                        if (muestraPuntos.isSelected()) {
                            palabras.get(i).getPalabra().get(j).getCheckpoints(palabras.get(i).getS());
                        }

                        //revisamos si estan activadas las negritas
                        if (palabras.get(i).getN() == 1) {
                            palabras.get(i).getPalabra().get(j).negritas(colores.getValue(), palabras.get(i).getS());
                        }

                        //avanzamos en la posicion
                        x += palabras.get(i).getPalabra().get(j).getPanel().getMaxWidth();

                        //revisamos si se llego al tope y si la palabra continua
                        if (x > (canvas.getWidth() - 200) && j + 1 < palabras.get(i).getPalabra().size() && palabras.get(i).getPalabra().get(j).chr != ' ' && palabras.get(i).getPalabra().get(j + 1).chr != '^') {
                            //colocamos un guion y hacemos un salto de linea
                            Pane sl = new Pane();
                            sl.setMaxSize(letras.get(13).getPanel().getMaxWidth(), palabras.get(i).getT() * 7);
                            sl.setMinSize(letras.get(13).getPanel().getMaxWidth(), palabras.get(i).getT() * 7);
                            sl.setTranslateX(x);
                            sl.setTranslateY(y);
                            letras.get(13).root = sl;

                            //revisamos si el tamaño de la palabra es menor al tamaño maximo de la linea
                            if (maximos.get(posMax) > palabras.get(i).getT()) {
                                letras.get(13).mover(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                            }

                            //dibuja guión
                            letras.get(13).dibujar(colores.getValue());

                            //muestra checkpoints
                            if (muestraPuntos.isSelected()) {
                                letras.get(13).getCheckpoints(palabras.get(i).getS());
                            }

                            //aplica negritas
                            if (palabras.get(i).getN() == 1) {
                                letras.get(13).negritas(colores.getValue(), 0);
                            }

                            pane.getChildren().add(letras.get(13).getPanel());

                            //regresa puntos de guión
                            if (maximos.get(posMax) > palabras.get(i).getT()) {
                                letras.get(13).regresar(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                            }

                            x = 10;
                            y += max * 7;

                            //regresa puntos de caracter
                            if (maximos.get(posMax) > palabras.get(i).getT()) {
                                palabras.get(i).getPalabra().get(j).regresar(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                            }

                            posMax++;
                            max = 0;
                        }
                        //revisamos si se llego al tope y hacemos salto de linea de ser necesario
                        if (x > (canvas.getWidth() - 150)) {
                            x = 10;
                            y += max * 7;
                            max = 0;
                            posMax++;
                        }
                        //colocamos el panel dentro 
                        pane.getChildren().add(palabras.get(i).getPalabra().get(j).getPanel());

                        //regresamos letras a su posicion
                        if (maximos.get(posMax) > palabras.get(i).getT() && max != 0) {
                            palabras.get(i).getPalabra().get(j).regresar(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                        }

                        //regresamos letras a tipografia original
                        if (palabras.get(i).getK() == 1) {
                            palabras.get(i).getPalabra().get(j).regresaPuntos(palabras.get(i).getT());
                        }
                        //bajamos la letra si se subio 
                        if (j > 0 && ((int) palabras.get(i).getPalabra().get(j).chr >= 97 && (int) palabras.get(i).getPalabra().get(j).chr <= 122 || ((int) palabras.get(i).getPalabra().get(j).chr >= 225 && (int) palabras.get(i).getPalabra().get(j).chr <= 250)) && (palabras.get(i).getPalabra().get(j - 1).chr == 'ó' || palabras.get(i).getPalabra().get(j - 1).chr == 'b' || palabras.get(i).getPalabra().get(j - 1).chr == 'o' || palabras.get(i).getPalabra().get(j - 1).chr == 'v' || palabras.get(i).getPalabra().get(j - 1).chr == 'w')) {
                            palabras.get(i).getPalabra().get(j).bajar(palabras.get(i).getT());
                        }
                    }
                }
                pos = -1;
            }
        }
        //finalente colocamos el panel con toda las letras

        canvas.setGraphic(pane);
    }
}
