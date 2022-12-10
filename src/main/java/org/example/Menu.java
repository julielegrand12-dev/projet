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

public class Menu extends JPanel
{
    public void setChoix(int choix) {
        this.choix = choix;
    }
    private int choix;

    public int getChoix() {
        return choix;
    }
    public Menu(int coordoX, int coordoY) {
        this.coordoX= coordoX;
        this.coordoY = coordoY;
    }

    public int getChoixbateau() {
        return choixbateau;
    }

    public void setChoixbateau(int choixbateau) {
        this.choixbateau = choixbateau;
    }

    private int choixbateau;
    private Scanner scan = new Scanner(System.in);

    private String pseudo;
    private Scanner scan1 = new Scanner(System.in);
    Bateau b=new Bateau();
    Elliot E = new Elliot();
    private int coordoY;
    private int coordoX;
    public int getCoordoX() {
        return coordoX;
    }

    public int getCoordoY() {
        return coordoY;
    }

    public void setCoordoX(int coordoX) {
        this.coordoX = coordoX;
    }

    public void setCoordoY(int coordoY) {
        this.coordoY = coordoY;
    }



    public int coordoy(int coordoY)
    {
        return coordoY;
    }

    public int coordoX(int coordoX)
    {
        return coordoX;
    }

    public void MenuDebut()  {


      /* JoueurHumain JoueurH = new JoueurHumain("Personne", 0);
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

        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = actionEvent.getActionCommand();
                if(s.equals("1 - Jouer une partie"))
                {
                    setChoix(1);
                    System.out.println(getChoix());
                }

            }
        });

        if(getChoix()==1)
        {
        JoueurH.setMapDeCasesHumain(mapDeCasesHumain);
        JoueurH.setMapDeBateauxHumain(mapDeBateauxHumain);
        JoueurH.PlacementCasesHumain(mapDeCasesHumain, mapDeBateauxHumain);
        JoueurH.PlacementBateauxHumain(mapDeBateauxHumain);

        JoueurO.setMapDeCasesOrdi(mapDeCasesOrdi);
        JoueurO.setMapDeBateauxOrdi(mapDeBateauxOrdi);
        JoueurO.PlacementCasesOrdi(mapDeCasesOrdi, mapDeBateauxOrdi);
        JoueurO.PlacementBateauxOrdi(mapDeBateauxOrdi);
        System.out.println("Veuillez selectionner votre pseudo:\n");
        pseudo= scan1.nextLine();
        JoueurH.setPseudo(pseudo);
        System.out.println("Bonjour " + JoueurH.getPseudo() + "\n");
        System.out.println("Votre premier plateau "+JoueurH.getPseudo()+"(permet de positionner et visualiser les navires):\n");
        E.PlateauJoueur(JoueurH,JoueurO,E);
        //MenuBateau(JoueurH,JoueurO,E);
        }



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
                    MenuBateau(JoueurH,JoueurO,E);
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

*/
        JoueurHumain JoueurH = new JoueurHumain("Personne", 0);
        JoueurOrdi JoueurO = new JoueurOrdi("Ordinateur", 0);
        HashMap<Integer, Case> mapDeCasesHumain = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateauxHumain = new HashMap<>();
        HashMap<Integer, Case> mapDeCasesOrdi = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateauxOrdi = new HashMap<>();
        Elliot EO = new Elliot();
        int x=6;
        int choixX=0;

        System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
        System.out.println("1- Jouer une partie\n");
        System.out.println("2- Charger une partie\n");
        System.out.println("3- Aide\n");
        System.out.println("4- Quitter\n");

        do             //blindage exception pour le choix du premier menu
        {do{try
        {choixX = Integer.parseInt(scan.nextLine());
            x=0;} catch (Exception e) {System.out.println("L'entrée doit être un chiffre compris entre 1 et 4.");
            x=1;}
        }while(x!=0 ); }while(choixX!=1 && choixX!=2 && choixX!=3 && choixX!=4);


        switch(choixX)
        {
            case 1 :
                JoueurH.setMapDeCasesHumain(mapDeCasesHumain);
                JoueurH.setMapDeBateauxHumain(mapDeBateauxHumain);
                JoueurH.PlacementCasesHumain(mapDeCasesHumain, mapDeBateauxHumain);
                JoueurH.PlacementBateauxHumain(mapDeBateauxHumain);

                JoueurO.setMapDeCasesOrdi(mapDeCasesOrdi);
                JoueurO.setMapDeBateauxOrdi(mapDeBateauxOrdi);
                JoueurO.PlacementCasesOrdi(mapDeCasesOrdi, mapDeBateauxOrdi);
                JoueurO.PlacementBateauxOrdi(mapDeBateauxOrdi);
                System.out.println("Veuillez selectionner votre pseudo:\n");
                pseudo= scan1.nextLine();
                JoueurH.setPseudo(pseudo);
                System.out.println("Bonjour " + JoueurH.getPseudo() + "\n");
                System.out.println("Votre premier plateau "+JoueurH.getPseudo()+"(permet de positionner et visualiser les navires):\n");
                E.PlateauJoueur(JoueurH,JoueurO,E);
                MenuBateau(JoueurH,JoueurO,E);

                break;
            case 2 : System.out.println("Redemarrer une partie\n");
                Sauvegarde S = new Sauvegarde();
                S.RecupererJeuHumain(JoueurH);
                S.RecupererJeuOrdi(JoueurO);
                E.PlateauJoueur(JoueurH,JoueurO,E);
                MenuBateau(JoueurH,JoueurO,E);
                break;
            case 3 : System.out.println("Aide\n");
                break;
            case 4 : System.out.println("Quitter\n");
                return;

        }
    }



    public void MenuBateau(JoueurHumain JoueurH, JoueurOrdi JoueurO, Elliot E)
    {
        HashMap<Integer, Case> mapDeCasesHumain = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateauxHumain = new HashMap<>();
        HashMap<Integer, Case> mapDeCasesOrdi = new HashMap<Integer, Case>();
        HashMap<Integer, Bateau> mapDeBateauxOrdi = new HashMap<>();

        mapDeBateauxHumain = JoueurH.getMapDeBateauxHumain();
        mapDeCasesHumain = JoueurH.getMapDeCasesHumain();
        mapDeBateauxOrdi = JoueurO.getMapDeBateauxOrdi();
        mapDeCasesOrdi = JoueurO.getMapDeCasesOrdi();
        int compteur=0;
        int x=6;
        int xB=0;
        int yB=0;
        int ll=0;

        do
        {
        if(compteur%2==0)
        {
            System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
            System.out.println("1- Tirer\n");
            System.out.println("2- Déplacer un bateau de sa flotte\n");

            do             //blindage exception pour le choix du menu bateau
            {do{try
            {choix = Integer.parseInt(scan.nextLine());
                x=0;} catch (Exception e) {System.out.println("L'entrée doit être un chiffre compris entre 1 et 3.");
                x=1;}
            }while(x!=0 ); }while(choix!=1 && choix!=2);

            mapDeBateauxHumain = JoueurH.getMapDeBateauxHumain();
            mapDeCasesHumain = JoueurH.getMapDeCasesHumain();
            mapDeBateauxOrdi = JoueurO.getMapDeBateauxOrdi();
            mapDeCasesOrdi = JoueurO.getMapDeCasesOrdi();

            switch(choix)
            {
                case 1:

                   ArrayList<Case> mapdecaseseclairees = new ArrayList<Case>();
                    int choixbateau =12;
                    System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
                    System.out.println("1- Tirer avec le cuirasse d'id 0\n");
                    System.out.println("2- Tirer avec le croiseur d'id 1\n");
                    System.out.println("3- Tirer avec le croiseur d'id 2\n");
                    System.out.println("4- Tirer avec le destroyer d'id 3\n");
                    System.out.println("5- Tirer avec le destroyer d'id 4\n");
                    System.out.println("6- Tirer avec le destroyer d'id 5\n");
                    System.out.println("7- Tirer avec le sous-marin d'id 6\n");
                    System.out.println("8- Tirer avec le sous-marin d'id 7\n");
                    System.out.println("9- Tirer avec le sous-marin d'id 8\n");
                    System.out.println("10- Tirer avec le sous-marin d'id 9\n");

                    do             //blindage exception pour le choix du menu bateau
                    {do{try
                    {choixbateau = Integer.parseInt(scan.nextLine());
                        x=0;} catch (Exception e) {System.out.println("L'entrée doit être un chiffre compris entre 1 et 9.");
                        x=1;}
                    }while(x!=0 ); }while((choixbateau!= 1) && (choixbateau != 2) && (choixbateau != 3) && (choixbateau != 4) && (choixbateau != 5) && (choixbateau != 6) && (choixbateau != 7) && (choixbateau != 8) && (choixbateau != 9));

                    while(E.getA()==0)
                    {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    mapDeBateauxHumain.get(choixbateau).AttaqueHumain(JoueurO,JoueurH, E.getA(), E.getB());
                    compteur++;
                    break;

                case 2:

                    JoueurH.DeplacerBateauHumain(mapDeBateauxHumain, mapDeCasesHumain);
                    E.PlateauJoueur(JoueurH,JoueurO,E);
                    compteur++;
                    break;

            }
           /* JFrame frame = new JFrame("Menu-Bateau");
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

       /* System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
        System.out.println("1- Tirer\n");
        System.out.println("2- Déplacer un bateau de sa flotte\n");

        do             //blindage exception pour le choix du menu bateau
        {do{try
        {choix = Integer.parseInt(scan.nextLine());
            x=0;} catch (Exception e) {System.out.println("L'entrée doit être un chiffre compris entre 1 et 3.");
            x=1;}
        }while(x!=0 ); }while(choix!=1 && choix!=2);



        switch(choix)
        {
            case 1:

                ArrayList<Case> mapdecaseseclairees = new ArrayList<Case>();
            int choixbateau =12;
            int x=13;

            System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
            System.out.println("1- Tirer avec le cuirasse d'id 0\n");
            System.out.println("2- Tirer avec le croiseur d'id 1\n");
            System.out.println("3- Tirer avec le croiseur d'id 2\n");
            System.out.println("4- Tirer avec le destroyer d'id 3\n");
            System.out.println("5- Tirer avec le destroyer d'id 4\n");
            System.out.println("6- Tirer avec le destroyer d'id 5\n");
            System.out.println("7- Tirer avec le sous-marin d'id 6\n");
            System.out.println("8- Tirer avec le sous-marin d'id 7\n");
            System.out.println("9- Tirer avec le sous-marin d'id 8\n");
            System.out.println("10- Tirer avec le sous-marin d'id 9\n");

               // mapDeBateauxHumain.get(choixbateau).AttaqueHumain(JoueurO,JoueurH, xB, yB);

                //mapDeBateauxHumain.get(choixbateau).AttaqueHumain(JoueurO,JoueurH, xB, yB);
            }


                compteur++;
            break;

            case 2:

                JoueurH.DeplacerBateauHumain(mapDeBateauxHumain, mapDeCasesHumain);
                E.PlateauJoueur(JoueurH,JoueurO,E,compteur);
                compteur++;
                break;
*/
        }


        if(compteur%2==1)
        {
            mapDeBateauxHumain = JoueurH.getMapDeBateauxHumain();
            mapDeCasesHumain = JoueurH.getMapDeCasesHumain();
            mapDeBateauxOrdi = JoueurO.getMapDeBateauxOrdi();
            mapDeCasesOrdi = JoueurO.getMapDeCasesOrdi();

            Random r = new Random();
            int n = r.nextInt(2);

            System.out.println("Joueur Ordinateur - A votre tour"); //Nous affichons les choix possibles


        if(n==0) {System.out.println("L'odinateur a choisi: 1 - Tirer\n");}
        else if(n==1) {System.out.println("L'odinateur a choisi: 2 - Deplacer un bateau de sa flotte\n");}

        switch(n)
        {
            case 0:

            ArrayList<Case> mapdecaseseclairees = new ArrayList<Case>();

                System.out.println("Veuillez faire un choix"); //Nous affichons les choix possibles
                System.out.println("1- Tirer avec le cuirasse d'id 0\n");
                System.out.println("2- Tirer avec le croiseur d'id 1\n");
                System.out.println("3- Tirer avec le croiseur d'id 2\n");
                System.out.println("4- Tirer avec le destroyer d'id 3\n");
                System.out.println("5- Tirer avec le destroyer d'id 4\n");
                System.out.println("6- Tirer avec le destroyer d'id 5\n");
                System.out.println("7- Tirer avec le sous-marin d'id 6\n");
                System.out.println("8- Tirer avec le sous-marin d'id 7\n");
                System.out.println("9- Tirer avec le sous-marin d'id 8\n");
                System.out.println("10- Tirer avec le sous-marin d'id 9\n");

                Random v = new Random();
                int j = v.nextInt(10);

            if(j==3 || j==4 ||j==5)
            {
                mapDeBateauxOrdi.get(j).AttaqueOrdiDestroyer(JoueurO,JoueurH,mapdecaseseclairees);
            }
            else
            {
                mapDeBateauxOrdi.get(j).AttaqueOrdi(JoueurO,JoueurH);
            }


            compteur++;
            break;

            case 1:
            JoueurO.DeplacerBateauOrdi(mapDeBateauxOrdi, mapDeCasesOrdi);

          //  E.PlateauOrdi(JoueurH,JoueurO,E);
            E.PlateauJoueur(JoueurH,JoueurO,E);
            compteur++;
            break;
        }
        }
        } while(b.flotteACouler(mapDeCasesHumain,mapDeBateauxHumain)!=true || b.flotteACouler(mapDeCasesOrdi, mapDeBateauxOrdi)!=true);


    }

}

