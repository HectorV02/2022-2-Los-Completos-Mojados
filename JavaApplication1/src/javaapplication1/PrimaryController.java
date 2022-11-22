package javaapplication1;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.util.ArrayList;
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
        Dibujar d = new Dibujar();
        //se crean caractereas
        return d.creaCaracteres(p, puntos, smallP, smallPuntos);
    }
    //Metodo que crea caracteres y los guarda en una lista de acuerdo al codigo ASCII, partiendo del 32(espacio)
    @FXML
    public void dibuja() throws IOException {
        int x = 10;
        int xi = 10;
        int y = 10;
        int com = 0;
        int dcom = 0;
        int caracter;
        int b;
        int comas = 0;
        int tam = 20;
        int pos = -1;
        int max = 0;
        int posMax = 0;
        int reverse = -1;
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
        if (!palabras.isEmpty() && !palabras.get(0).getPalabra().isEmpty() && palabras.get(0).getPalabra().get(0).chr == ' ') {
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
                            int k = j + 1;
                            String tamanio = "";
                            while (palabras.get(i).getPalabra().size() > k && (int) palabras.get(i).getPalabra().get(k).chr <= 57 && (int) palabras.get(i).getPalabra().get(k).chr >= 48) {
                                tamanio += palabras.get(i).getPalabra().get(k).chr;
                                k += 1;
                            }
                            if (!"".equals(tamanio)) {
                                palabras.get(comas).setT(Integer.parseInt(tamanio));
                            }
                        }
                        case 'M' -> {
                            palabras.get(comas).setRY(1);
                        }
                        case 'P' -> {
                            palabras.get(comas).setRX(1);
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
                            int k = j + 1;
                            String tamanio = "";
                            while (palabras.get(i).getPalabra().size() > k && (int) palabras.get(i).getPalabra().get(k).chr <= 57 && (int) palabras.get(i).getPalabra().get(k).chr >= 48) {
                                tamanio += palabras.get(i).getPalabra().get(k).chr;
                                k += 1;
                            }
                            if (!"".equals(tamanio)) {
                                palabras.get(i).setT(Integer.parseInt(tamanio));
                            }
                        }
                        case 'X' -> {
                            int k = j + 1;
                            String posicion = "";
                            while (palabras.get(i).getPalabra().size() > k && (int) palabras.get(i).getPalabra().get(k).chr <= 57 && (int) palabras.get(i).getPalabra().get(k).chr >= 48) {
                                posicion += palabras.get(i).getPalabra().get(k).chr;
                                k += 1;
                            }
                            if (!"".equals(posicion)) {
                                xi = x + Integer.parseInt(posicion);
                            }
                        }
                        case 'Y' -> {
                            int k = j + 1;
                            String posicion = "";
                            while (palabras.get(i).getPalabra().size() > k && (int) palabras.get(i).getPalabra().get(k).chr <= 57 && (int) palabras.get(i).getPalabra().get(k).chr >= 48) {
                                posicion += palabras.get(i).getPalabra().get(k).chr;
                                k += 1;
                            }
                            if (!"".equals(posicion)) {
                                y = y + Integer.parseInt(posicion);
                            }
                        }
                        case 'R' -> {
                            reverse = i;
                        }
                        case 'M' -> {
                            palabras.get(i).setRY(1);
                        }
                        case 'P' -> {
                            palabras.get(i).setRX(1);
                        }
                        default -> {
                        }
                    }
                }
            }
            pos = -1;
        }
        if (reverse != -1) {
            ArrayList<Palabra> aux = new ArrayList();
            for (int i = 0; i < reverse; i++) {
                aux.add(palabras.get(i));
            }
            for (int i = palabras.size() - 1; i >= reverse; i--) {
                aux.add(palabras.get(i));
            }
            palabras = aux;
        }
        for (int j = 2; j < palabras.size(); j += 2) {
            if (palabras.get(j).getS() == 1 && palabras.get(j - 2).getS() == 1) {
                palabras.get(j - 1).setS(1);
            }
            if (palabras.get(j).getN() == 1 && palabras.get(j - 2).getN() == 1) {
                palabras.get(j - 1).setN(1);
            }
        }
        x = xi;
        //ciclo para ver el tam max de cada linea
        for (int i = 0; i < palabras.size(); i++) {
            for (int j = 0; j < palabras.get(i).getPalabra().size(); j++) {
                //revisa si caracter es acento circunflejo
                if (palabras.get(i).getPalabra().get(j).chr == '^') {
                    pos = j;
                } //contamos las comas
                else if (palabras.get(i).getPalabra().get(j).chr == ',' && pos > 0 && ((reverse != -1 && i == reverse) || (reverse == -1 && i == palabras.size() - 1))) {

                } else if (palabras.get(i).getPalabra().get(j).chr == '+') {

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
        x = xi;
        max = 0;
        //Ingresamos los caracteres en cada letra
        letras = Empezar(x, y, palabras.get(0).getT());
        //recorre palabras
        for (int i = 0; i < palabras.size(); i++) {
            //crea caracteres
            if (i > 0 && palabras.get(i).getT() != palabras.get(i - 1).getT()) {
                letras = Empezar(x, y, palabras.get(i).getT());
            }//reorganiza palabra si se aplica espejo segun eje X
            if (palabras.get(i).getRY() == 1) {
                palabras.get(i).reorganiza();
            } //recorre letras dentro de palabra
            for (int j = 0; j < palabras.get(i).getPalabra().size(); j++) {
                //si tamaño de palabra supera el maximo de linea
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
                //revisa si caracter es acento circunflejo
                if (palabras.get(i).getPalabra().get(j).chr == '^') {
                    pos = j;
                    b = 1;
                } //contamos las comas
                else if (palabras.get(i).getPalabra().get(j).chr == ',' && pos > 0) {
                    if (reverse != -1 && i == reverse) {
                        b = 1;
                    } else if (reverse == -1 && i == palabras.size() - 1) {
                        b = 1;
                    }
                }//no dibuja signo +
                else if (palabras.get(i).getPalabra().get(j).chr == '+') {
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
                        case 'X' -> {
                            b = 1;
                        }
                        case 'Y' -> {
                            b = 1;
                        }
                        case 'M' -> {
                            b = 1;
                        }
                        case 'P' -> {
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
                        case 'R' -> {
                            b = 1;
                        }
                        case 'X' -> {
                            b = 1;
                        }
                        case 'Y' -> {
                            b = 1;
                        }
                        case 'M' -> {
                            b = 1;
                        }
                        case 'P' -> {
                            b = 1;
                        }
                        default -> {
                        }
                    }
                }
                //no dibuja numeros
                if ((int) palabras.get(i).getPalabra().get(j).chr >= 48 && (int) palabras.get(i).getPalabra().get(j).chr <= 57) {
                    b = 1;
                }
                //si no es estilo dibuja
                if (b == 0) {
                    //revisamos si tenemos que subir el caracter
                    if (palabras.get(i).getRY() != 1 && j > 0 && ((int) palabras.get(i).getPalabra().get(j).chr >= 97 && (int) palabras.get(i).getPalabra().get(j).chr <= 122 || ((int) palabras.get(i).getPalabra().get(j).chr >= 225 && (int) palabras.get(i).getPalabra().get(j).chr <= 250)) && (palabras.get(i).getPalabra().get(j - 1).chr == 'ó' || palabras.get(i).getPalabra().get(j - 1).chr == 'b' || palabras.get(i).getPalabra().get(j - 1).chr == 'o' || palabras.get(i).getPalabra().get(j - 1).chr == 'v' || palabras.get(i).getPalabra().get(j - 1).chr == 'w')) {
                        palabras.get(i).getPalabra().get(j).subir(palabras.get(i).getT());
                    }
                    else if (palabras.get(i).getRY() == 1 && palabras.get(i).palabra.size() > j + 1 && ((int) palabras.get(i).getPalabra().get(j).chr >= 97 && (int) palabras.get(i).getPalabra().get(j).chr <= 122 || ((int) palabras.get(i).getPalabra().get(j).chr >= 225 && (int) palabras.get(i).getPalabra().get(j).chr <= 250)) && (palabras.get(i).getPalabra().get(j + 1).chr == 'ó' || palabras.get(i).getPalabra().get(j + 1).chr == 'b' || palabras.get(i).getPalabra().get(j + 1).chr == 'o' || palabras.get(i).getPalabra().get(j + 1).chr == 'v' || palabras.get(i).getPalabra().get(j + 1).chr == 'w')) {
                        palabras.get(i).getPalabra().get(j).subir(palabras.get(i).getT());
                    }
                    //revisamos si estan activadas las cursivas
                    if (palabras.get(i).getK() == 1) {
                        palabras.get(i).getPalabra().get(j).muevePuntos(palabras.get(i).getT());
                    }
                    //revisamos si hay que reflejar segun el eje Y
                    if (palabras.get(i).rY == 1) {
                        palabras.get(i).getPalabra().get(j).reflexY((int) pp.getMaxWidth());
                    }
                    //revisamos si hay que reflejar segun eje X
                    if (palabras.get(i).rX == 1) {
                        palabras.get(i).getPalabra().get(j).reflexX((int) pp.getMaxHeight(), palabras.get(i).getS());
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
                            letras.get(13).getCheckpoints(0);
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
                        //regresa puntos de caracter
                        if (maximos.get(posMax) > palabras.get(i).getT()) {
                            palabras.get(i).getPalabra().get(j).regresar(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                        }
                        max = 0;
                        posMax++;
                    }
                    //colocamos el panel dentro 
                    pane.getChildren().add(palabras.get(i).getPalabra().get(j).getPanel());
                    //regresamos letras a su posicion
                    if (maximos.get(posMax) > palabras.get(i).getT() && max != 0) {
                        palabras.get(i).getPalabra().get(j).regresar(maximos.get(posMax), palabras.get(i).getT(), palabras.get(i).getS());
                    }
                    //regresamos los puntos a su forma sin reflexion
                    if (palabras.get(i).rX == 1) {
                        palabras.get(i).getPalabra().get(j).reflexX((int) pp.getMaxHeight(), palabras.get(i).getS());
                    }
                    //regresamos los puntos a su forma sin reflexion
                    if (palabras.get(i).rY == 1) {
                        palabras.get(i).getPalabra().get(j).reflexY((int) pp.getMaxWidth());
                    }
                    //regresamos letras a tipografia original
                    if (palabras.get(i).getK() == 1) {
                        palabras.get(i).getPalabra().get(j).regresaPuntos(palabras.get(i).getT());
                    }
                    //bajamos la letra si se subio 
                    if (palabras.get(i).getRY() != 1 && j > 0 && ((int) palabras.get(i).getPalabra().get(j).chr >= 97 && (int) palabras.get(i).getPalabra().get(j).chr <= 122 || ((int) palabras.get(i).getPalabra().get(j).chr >= 225 && (int) palabras.get(i).getPalabra().get(j).chr <= 250)) && (palabras.get(i).getPalabra().get(j - 1).chr == 'ó' || palabras.get(i).getPalabra().get(j - 1).chr == 'b' || palabras.get(i).getPalabra().get(j - 1).chr == 'o' || palabras.get(i).getPalabra().get(j - 1).chr == 'v' || palabras.get(i).getPalabra().get(j - 1).chr == 'w')) {
                        palabras.get(i).getPalabra().get(j).bajar(palabras.get(i).getT());
                    }
                    if (palabras.get(i).getRY() == 1 && palabras.get(i).getPalabra().size() > j + 1 && ((int) palabras.get(i).getPalabra().get(j).chr >= 97 && (int) palabras.get(i).getPalabra().get(j).chr <= 122 || ((int) palabras.get(i).getPalabra().get(j).chr >= 225 && (int) palabras.get(i).getPalabra().get(j).chr <= 250)) && (palabras.get(i).getPalabra().get(j + 1).chr == 'ó' || palabras.get(i).getPalabra().get(j + 1).chr == 'b' || palabras.get(i).getPalabra().get(j + 1).chr == 'o' || palabras.get(i).getPalabra().get(j + 1).chr == 'v' || palabras.get(i).getPalabra().get(j + 1).chr == 'w')) {
                        palabras.get(i).getPalabra().get(j).bajar(palabras.get(i).getT());
                    }
                }
            }
            pos = -1;
        }
        //finalente colocamos el panel con toda las letras
        canvas.setGraphic(pane);
    }
}
