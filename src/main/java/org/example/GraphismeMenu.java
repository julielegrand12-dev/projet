package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

public class GraphismeMenu extends JPanel
{
    private Scanner scan = new Scanner(System.in);
    private String pseudo;
    public void MenuGraphique()
    {
    JoueurHumain JoueurH = new JoueurHumain("Personne", 0);
    JoueurOrdi JoueurO = new JoueurOrdi("Ordinateur", 0);
    HashMap<Integer, Case> mapDeCasesHumain = new HashMap<Integer, Case>();
    HashMap<Integer, Bateau> mapDeBateauxHumain = new HashMap<>();
    HashMap<Integer, Case> mapDeCasesOrdi = new HashMap<Integer, Case>();
    HashMap<Integer, Bateau> mapDeBateauxOrdi = new HashMap<>();
    Elliot E = new Elliot();
    int x=6;

    JFrame frame = new JFrame("Menu");
    JLabel label = new JLabel("JEU - BATAILLE NAVALE", JLabel.CENTER);
        frame.add(label);

    // Définition du panel
    JPanel panel = new JPanel();
    // Définir les boutons
    JButton btn1 = new JButton("1 - Jouer une partie");
    JButton btn2 = new JButton("2 - Charger une partie");
    JButton btn3 = new JButton("3 - Aide");
    JButton btn4 = new JButton("4 - Quitter");

    // Ajouter les boutons au frame
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);

    // Ajouter label et panel au frame
        frame.setLayout(new GridLayout(2, 1));
        frame.add(label);
        frame.add(panel);

        frame.pack();
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JoueurH.setMapDeCasesHumain(mapDeCasesHumain);
        JoueurH.setMapDeBateauxHumain(mapDeBateauxHumain);
        JoueurH.PlacementCasesHumain(mapDeCasesHumain, mapDeBateauxHumain);
        JoueurH.PlacementBateauxHumain(mapDeBateauxHumain);

        JoueurO.setMapDeCasesOrdi(mapDeCasesOrdi);
        JoueurO.setMapDeBateauxOrdi(mapDeBateauxOrdi);
        JoueurO.PlacementCasesOrdi(mapDeCasesOrdi, mapDeBateauxOrdi);
        JoueurO.PlacementBateauxOrdi(mapDeBateauxOrdi);
        System.out.println("Veuillez selectionner votre pseudo:\n");
        pseudo= scan.nextLine();
        JoueurH.setPseudo(pseudo);
        System.out.println("Bonjour " + JoueurH.getPseudo() + "\n");
        System.out.println("Votre premier plateau "+JoueurH.getPseudo()+"(permet de positionner et visualiser les navires):\n");
        E.PlateauJoueur(JoueurH,JoueurO,E);
        //MenuBateau(JoueurH,JoueurO,E);



        btn2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = actionEvent.getActionCommand();
            if(s.equals("2 - Charger une partie"))
            {
                System.out.println("Redemarrer une partie\n");
                Sauvegarde S = new Sauvegarde();
                S.RecupererJeuHumain(JoueurH);
                S.RecupererJeuOrdi(JoueurO);
                E.PlateauJoueur(JoueurH, JoueurO, E);
                //MenuBateau(JoueurH,JoueurO,E);
            }

        }
    });

        btn3.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = actionEvent.getActionCommand();
            if(s.equals("3 - Aide"))
            {
                System.out.println("Aide\n");
            }

        }
    });

        btn4.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = actionEvent.getActionCommand();
            if(s.equals("4 - Quitter"))
            {
                frame.dispose();
            }

        }
    });
}
}
