package BestellManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BestellManager extends JFrame {

    private Kaffee kaffee;
    private JComboBox comboKaffeeArt;
    private JRadioButton jatogo;
    private JRadioButton neintogo;
    private JComboBox comboMilchSorte;
    private JTextField tfPreis;
    private JPanel myPanel;
    private JTextField tfAnzahl;
    private JButton bt_hinzufuegen;
    private JTextArea textArea1;
    private JButton bt_gesamtpreis;

    private ArrayList<Kaffee> kaffeeliste = new ArrayList<>();

    public BestellManager() {
        setTitle("Bestellmanager");
        setVisible(true);
        setSize(500, 500);
        setResizable(false);
        setContentPane(myPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initObjekte();

        ButtonGroup togoButtons = new ButtonGroup();
        togoButtons.add(jatogo);
        togoButtons.add(neintogo);


        bt_hinzufuegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hinzufuegen();
            }
        });
        bt_gesamtpreis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // berechnePreis();
            }
        });
    }

    public void initObjekte() {
        Kaffee k1 = new Kaffee("Espresso", false, "keine Milch", 1);
        Kaffee k2 = new Kaffee("Iced Latte", true, "Hafermilch", 2);
        Kaffee k3 = new Kaffee("Cappuccina", false, "Kuhmilch", 3);

        kaffeeliste.add(k1);
        kaffeeliste.add(k2);
        kaffeeliste.add(k3);

    }

    public void hinzufuegen() {
        String gewaehlteArt = comboKaffeeArt.getSelectedItem().toString();
        String gewaehlteMilch = comboMilchSorte.getSelectedItem().toString();
        boolean togo = jatogo.isSelected();
        int anzahl = Integer.parseInt(tfAnzahl.getText());

        Kaffee k = new Kaffee(gewaehlteArt, togo, gewaehlteMilch, anzahl);
        kaffeeliste.add(k);
        ausgeben();

    }

    public void ausgeben() {
        for (Kaffee kaffee1 : kaffeeliste) {
            textArea1.append(kaffee1.toString());
        }
    }

    /*private double berechnePreis(){


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


        public static void main (String[]args){
            new BestellManager();

        }
    }


