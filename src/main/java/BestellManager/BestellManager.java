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
    private JButton bt_speichern;
    private JTextArea textArea1;
    private JButton bt_gesamtpreis;
    private JButton filter_button;
    private JButton bt_alleAnzeigen;

    private ArrayList<Kaffee> kaffeeliste = new ArrayList<>();


    public BestellManager() {
        setTitle("Bestellmanager");
        setVisible(true);
        setSize(600, 900);
        setResizable(false);
        setContentPane(myPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initObjekte();

        ButtonGroup togoButtons = new ButtonGroup();
        togoButtons.add(jatogo);
        togoButtons.add(neintogo);
        neintogo.setSelected(true);


        bt_speichern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speichern();
            }
        });
        bt_gesamtpreis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                berechnePreis();
            }
        });
        filter_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtern();
            }
        });
        bt_alleAnzeigen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ausgeben();
            }
        });
    }

    public void initObjekte() {
        Kaffee k1 = new Kaffee("Espresso", false, "keine Milch", 1);
        Kaffee k2 = new Kaffee("Iced Latte", true, "Hafermilch", 2);
        Kaffee k3 = new Kaffee("Cappuccino", false, "Kuhmilch", 3);

        kaffeeliste.add(k1);
        kaffeeliste.add(k2);
        kaffeeliste.add(k3);

    }

    public void speichern() {
        String gewaehlteArt = comboKaffeeArt.getSelectedItem().toString();
        String gewaehlteMilch = comboMilchSorte.getSelectedItem().toString();
        boolean togo = jatogo.isSelected();

        if (gewaehlteArt.equals("-- Kaffeesorte auswählen --") || gewaehlteMilch.equals("-- Milchsorte auswählen --")) {
            JOptionPane.showMessageDialog(this, "Bitte wähle eine Kaffee- und Milchsorte aus.");
            return;
        }

        try {
            int anzahl = Integer.parseInt(tfAnzahl.getText());
            if (anzahl <= 0 || anzahl > 10) {
                JOptionPane.showMessageDialog(this, "Bitte wähle eine Zahl von 1-10");
                tfAnzahl.setText("");
                return;
            }
            Kaffee k = new Kaffee(gewaehlteArt, togo, gewaehlteMilch, anzahl);
            kaffeeliste.add(k);
            textArea1.setText("");
            textArea1.append(k.toString());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Bitte eine gültige Anzahl eingeben");
            tfAnzahl.setText("");
        }
    }

    public void ausgeben() {
        textArea1.setText("");
        for (Kaffee kaffee1 : kaffeeliste) {
            textArea1.append(kaffee1.toString());
            textArea1.append("\n\n");

        }
    }

    public void filtern() {
        textArea1.setText("");
        for (Kaffee kaffee1 : kaffeeliste) {
            if (kaffee1.isTogo() == true) {
                textArea1.append(kaffee1.toString());
                textArea1.append("\n\n");
            }
        }
    }

    private void berechnePreis() {

        String kaffeeArt = comboKaffeeArt.getSelectedItem().toString();
        String milch = comboMilchSorte.getSelectedItem().toString();
        boolean togo = jatogo.isSelected();

        if (kaffeeArt.equals("-- Kaffeesorte auswählen --") || milch.equals("-- Milchsorte auswählen --")) {
            JOptionPane.showMessageDialog(this, "Bitte wähle eine Kaffee- und Milchsorte aus.");
            return;
        }

        try {
        int anzahl = Integer.parseInt(tfAnzahl.getText());
            if (anzahl <= 0 || anzahl > 10) {
                JOptionPane.showMessageDialog(this, "Bitte wähle eine Zahl von 1-10");
                tfAnzahl.setText("");
                return;
            }

            Kaffee kaffee = new Kaffee(kaffeeArt, togo, milch, anzahl);
            double gesamtpreis = kaffee.berechne();
            tfPreis.setText(String.format("%.2f €",gesamtpreis));

        } catch (NumberFormatException e) {
            tfAnzahl.setText("");
            JOptionPane.showMessageDialog(this, "Bitte eine gültige Anzahl eingeben");
        }

    }
        public static void main (String[]args){
        new BestellManager();

    }
}




