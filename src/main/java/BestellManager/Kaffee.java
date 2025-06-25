package BestellManager;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Kaffee {
    private String kaffeeArt;
    private String milch;
    private boolean togo;
    private int anzahl;

    public Kaffee(String kaffeeArt, boolean togo, String milch, int anzahl) {
        this.kaffeeArt = kaffeeArt;
        this.milch = milch;
        this.togo = togo;
        this.anzahl = anzahl;
    }

    //Berechnung des Gesamtpreises auf Basis der Objektattribute
    public double berechne() {
        double grundpreis = 0.0;

        switch (kaffeeArt) {
            case "Espresso":
                grundpreis += 2.20;
                break;

            case "Americano":
                grundpreis += 2.70;
                break;

            case "Cappuccino":
                grundpreis += 3.30;
                break;

            case "Iced Latte":
                grundpreis += 4.20;
                break;

            default:
                grundpreis = 0.0;

        }
        if (milch.equals("Hafermilch") || milch.equals("Sojamilch")) {
            grundpreis += 0.30;
        }
        if (togo) {
            grundpreis += 0.50;
        }
        return grundpreis * anzahl;
    }

    public boolean isTogo() {
        return togo;
    }

    //Rückgabe der Eigenschaften des Kaffee-Objekts
    @Override
    public String toString() {
        String togoText = "Nein";
        if (togo) {
            togoText = "Ja";
        }
        return "Kaffee Art: " + kaffeeArt + "\n Milch Sorte: " + milch + "\n Togo? " + togoText + "\n Anzahl: " + anzahl;
    }
}