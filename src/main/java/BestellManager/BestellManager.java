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
        setSize(500, 600);
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
                berechne();
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

        try {
            int anzahl = Integer.parseInt(tfAnzahl.getText());
            if (anzahl <= 0 || anzahl > 10) {
                JOptionPane.showMessageDialog(this, "Bitte wähle eine Zahl von 1-10");
                tfAnzahl.setText("");
                return;
            }
            Kaffee k = new Kaffee(gewaehlteArt, togo, gewaehlteMilch, anzahl);
            kaffeeliste.add(k);
            ausgeben();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Bitte eine gültige Anzahl eingeben" );
            tfAnzahl.setText("");
        }
    }

    public void ausgeben() {
        textArea1.setText("");
        for (Kaffee kaffee1 : kaffeeliste) {
            textArea1.append(kaffee1.toString());
            textArea1.append("\n");
        }
    }

    private void berechne() {
        String kaffeeArt = comboKaffeeArt.getSelectedItem().toString();
        String MilchSorte = comboMilchSorte.getSelectedItem().toString();
        boolean togo = jatogo.isSelected();
        String txtAnzahl = tfAnzahl.getText();

        double grundpreis = 0.0;

        try {
            int anzahl = Integer.parseInt(txtAnzahl);
            if (anzahl <= 0 || anzahl > 10) {
                JOptionPane.showMessageDialog(this, "Bitte wähle eine Zahl von 1-10");
                tfAnzahl.setText("");
                return;
            }

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
                    JOptionPane.showMessageDialog(this, "Getränk nicht gefunden");
                    return;
            }
            if (MilchSorte.equals("Hafermilch") || MilchSorte.equals("Sojamilch")) {
                grundpreis += 0.30;
            }
            if (togo) {
                grundpreis += 0.50;
            }
            double gesamtpreis = grundpreis * anzahl;
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




