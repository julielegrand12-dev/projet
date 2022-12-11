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

    public int getEnvoi() {
        return envoi;
    }

    public void setEnvoi(int envoi) {
        this.envoi = envoi;
    }

    private int envoi=0;

    public void MenuGraphique()
    {
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

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = actionEvent.getActionCommand();
                if(s.equals("1 - Jouer une partie"))
                {
                    setEnvoi(1);
                    frame.dispose();
                }

            }
        });


     btn2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = actionEvent.getActionCommand();
            if(s.equals("2 - Charger une partie"))
            {
                setEnvoi(2);
                frame.dispose();
            }

        }
    });

        btn3.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = actionEvent.getActionCommand();
            if(s.equals("3 - Aide"))
            {
                int choix=6;
                int x=6;

                do {

                System.out.println("Aide\n");
                Aide a = new Aide();
                a.AideReglesJeu();
               System.out.println("Souhaitez-vous quitter le menu? 0: Oui/ 1:Non");

                do
                {do{try
                {choix= Integer.parseInt(scan.nextLine());
                    x=0;} catch (Exception e) {System.out.println("L'entrée doit être 0 ou 1.");
                    x=1;}
                }while(x!=0); }while((choix!= 0) && (choix != 1));

                }while(choix==1);

                MenuGraphique();
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

public void MenuBateauGraph()
{
    JFrame frame = new JFrame("Menu-Bateau");
    JLabel label = new JLabel("Menu pour la gestion des bateaux", JLabel.CENTER);
            frame.add(label);

    // Définition du panel
    JPanel panel = new JPanel();
    // Définir les boutons
    JButton btn1 = new JButton("1 - Tirer");
    JButton btn2 = new JButton("2 - Deplacer");
    JButton btn4 = new JButton("3 - Quitter");

    // Ajouter les boutons au frame
            panel.add(btn1);
            panel.add(btn2);
            panel.add(btn4);

    // Ajouter label et panel au frame
            frame.setLayout(new GridLayout(2, 1));
            frame.add(label);
            frame.add(panel);

            frame.pack();
            frame.setSize(1000, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

    btn1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = actionEvent.getActionCommand();
            if(s.equals("1 - Tirer"))
            {
                setEnvoi(1);
                frame.dispose();
            }

        }
    });

    btn2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = actionEvent.getActionCommand();
            if(s.equals("2 - Deplacer"))
            {
                setEnvoi(2);
                frame.dispose();
            }

        }
    });
    btn4.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String s = actionEvent.getActionCommand();
            if(s.equals("3 - Quitter"))
            {
                frame.dispose();
            }

        }
    });
}
}
