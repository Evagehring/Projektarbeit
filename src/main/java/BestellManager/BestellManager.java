package BestellManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BestellManager extends JFrame {

    private JComboBox KaffeArt;
    private JRadioButton jatogo;
    private JRadioButton neintogo;
    private JButton berechne;
    private JComboBox MilchSorte;
    private JTextField tfPreis;
    private JPanel myPanel;

    public BestellManager() {
       setVisible(true);
       setSize(500, 500);
       setContentPane(myPanel);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        berechne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
tfPreis.setText("preis");
            }
        });
    }

    public static void main(String[] args) {
        new BestellManager();
    }
    }

