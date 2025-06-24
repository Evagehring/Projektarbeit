package BestellManager;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Kaffee {
    private String kaffeeArt;
    private String milch;
    private boolean togo;
    private int anzahl;
    private double preis;

    public Kaffee(String kaffeeArt, boolean togo, String milch, int anzahl) {
        this.kaffeeArt = kaffeeArt;
        this.milch = milch;
        this.togo = togo;
        this.anzahl = anzahl;
    }

    @Override
    public String toString() {
        return "Kaffee Art: " + kaffeeArt + "Milch Sorte: " + milch + "Togo? " + togo + "Anzahl: " + anzahl;
    }
}