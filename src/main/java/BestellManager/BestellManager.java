package BestellManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestellManager extends JFrame {

    private Kaffee kaffee;
    private JComboBox KaffeArt;
    private JRadioButton jatogo;
    private JRadioButton neintogo;
    private JButton berechne;
    private JComboBox MilchSorte;
    private JTextField tfPreis;
    private JPanel myPanel;
    private JTextField tfAnzahl;

    public BestellManager() {
        setTitle("Bestellmanager");
        setVisible(true);
        setSize(500, 500);
        setResizable(false);
        setContentPane(myPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JComboBox<String> kaffeeArtBox = new JComboBox<>(new String[] {
    "Espresso", "Americano", "Cappuccino", "Iced Latte"
});
        JComboBox<String> milchBox = new JComboBox<>(new String[] {
                "Kuhmilch", "Hafermilch", "Sojamilch"
        });

        JTextField tfAnzahl = new JTextField();


        ButtonGroup togoButtons = new ButtonGroup();
        togoButtons.add(jatogo);
        togoButtons.add(neintogo);


        KaffeArt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String gewaehlteArt = KaffeArt.getSelectedItem().toString();
                String gewaehlteMilch = MilchSorte.getSelectedItem().toString();
                boolean togo = jatogo.isSelected();

                int anzahl = 1;


                Kaffee kaffee1 = new Kaffee(gewaehlteArt, togo, gewaehlteMilch, anzahl);
                double preis = kaffee1.getPreis();
                tfPreis.setText(String.format("%.2f €", kaffee1.getPreis()));
            }
        });

            }

            public static void main(String[] args) {
                new BestellManager();

    }
}

