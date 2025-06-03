package BestellManager;

import javax.swing.*;

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

   /* private double berechnePreis() {


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
                JOptionPane.showMessageDialog(null,"Getränk nicht gefunden");
                grundpreis = 0.0;

        }
        if (milch.equals("Hafermilch") || milch.equals("Sojamilch")) {
            grundpreis += 0.30;
        }
        if (togo) {
            preis = grundpreis += 0.50;
        }

        return grundpreis;
    }
    public double getPreis() {
        return preis;
    }
    public String toString() {
    return kaffeeArt;
    }*/
}
