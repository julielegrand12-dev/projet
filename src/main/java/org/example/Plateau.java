package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.ArrayList;

import java.awt.event.*;
import java.util.Scanner;


public class Plateau extends JPanel implements ActionListener  {


    private HashMap<Integer, Bateau> mapDeBateauxH = new HashMap<>();

    static JFrame frame2;
    static JFrame frame;
    ArrayList<JButton> lesBoutons = new ArrayList<JButton>(); // liste de boutons
    HashMap<Integer, Case> MapDeCasesDegat = new HashMap<Integer, Case>(); //hashmap
    ArrayList<Case> listeCasesDeg = new ArrayList<Case>();

    JButton btn[];
    private boolean sauvegarde;
    private JoueurHumain joueurHS;
    private JoueurOrdi joueurOS;

    public JoueurHumain getJoueurHS() {
        return joueurHS;
    }

    public void setJoueurHS(JoueurHumain joueurHS) {
        this.joueurHS = joueurHS;
    }

    public JoueurOrdi getJoueurOS() {
        return joueurOS;
    }

    public void setJoueurOS(JoueurOrdi joueurOS) {
        this.joueurOS = joueurOS;
    }


    public void PlateauDommage(JoueurHumain JoueurH, JoueurOrdi JoueurO, Plateau Ph)
    {

        HashMap<Integer, Bateau> mapDeBateauxHumain = new HashMap<>();
        HashMap<Integer, Case> mapDeCasesOrdi = new HashMap<Integer, Case>();


        System.out.println("Saisissez la coordonnée que vous souhaitez attaquer");
        Scanner scan = new Scanner(System.in);
        System.out.println("Saisissez X:");
        int choixX = scan.nextInt();
        System.out.println("Saisissez Y:");
        int choixY = scan.nextInt();




        frame2 = new JFrame("PLATEAU DOMMAGE ADVERSAIRE");
        // créer un objet
        Plateau obj = new Plateau();
        // créer un panneau
        JPanel panel2 = new JPanel();
        JButton btn[] = new JButton[225];

        for(int i=0;i<225;i++)
        {

            int cpt=1;
            int tempo = i+1;
            btn[i] =new JButton(" ");
            btn[i].addActionListener(obj);
            panel2.add(btn[i]);

            while(tempo>15)
            {
                tempo = tempo-15;
                cpt++;
            }
            Case ca = new Case(tempo,cpt,0);
            listeCasesDeg.add(ca);
        }
        mapDeBateauxHumain = JoueurH.getMapDeBateauxHumain();
        mapDeCasesOrdi = JoueurH.getMapDeCasesHumain();


        //if joueur actuel = joueur humain else inverser
        //ID du bateau avec lequel il attaque
        //if etat = treu gris
        mapDeBateauxHumain.get(9).AttaqueHumain(JoueurO,JoueurH,choixX, choixY);
        for(int i=0; i<mapDeCasesOrdi.size(); i++)
        {
            if(JoueurO.getMapDeCasesOrdi().get(i).EtatCase())
            {
                btn[i].setBackground(Color.BLACK);
            }

        }
        frame2.add(panel2);
        frame2.setSize(700, 700);
        frame2.show();
        Menu M = new Menu('0');
        M.MenuBateau(JoueurH,JoueurO,Ph);




    }


    public void PlateauJoueur(JoueurHumain JoueurH,JoueurOrdi JoueurO,Plateau Ph)
    {

        //------------------------------------------------------------------------------

        joueurHS = JoueurH;
        joueurOS = JoueurO;


        frame = new JFrame("PLATEAU NAVIRE");
        // créer un objet
        Plateau obj = new Plateau();
        // créer un panneau
        JPanel panel = new JPanel();

        JButton btn[] = new JButton[225];
        JButton boutonSauv = new JButton("Sauvegarder la partie");
        int test=43;

            char c = 'a';
        for(int i=0;i<225;i++)
        {

                int cpt=1;
                int tempo = i+1;
                btn[i] =new JButton("  ");
                btn[i].addActionListener(obj);
                panel.add(btn[i]);

                while(tempo>15)
                {
                    tempo = tempo-15;
                    cpt++;
                }
                    Case ca = new Case(tempo,cpt,0);
                    listeCasesDeg.add(ca);

                    for(int j=0;j<30;j++)
                    {
                        if((listeCasesDeg.get(i).getX() == JoueurH.getMapDeCasesHumain().get(j).getX())&&(listeCasesDeg.get(i).getY() == JoueurH.getMapDeCasesHumain().get(j).getY()))
                        {
                            if(JoueurH.getMapDeCasesHumain().get(j).getGetID()==1)
                            {
                                btn[i].setBackground(Color.YELLOW);
                            }
                            if(JoueurH.getMapDeCasesHumain().get(j).getGetID()==3)
                            {
                                btn[i].setBackground(Color.ORANGE);
                            }
                            if(JoueurH.getMapDeCasesHumain().get(j).getGetID()==5)
                            {
                                btn[i].setBackground(Color.PINK);
                            }
                            if(JoueurH.getMapDeCasesHumain().get(j).getGetID()==7)
                            {
                                btn[i].setBackground(Color.RED);
                            }

                        }
                    }



            }







        panel.add(boutonSauv);
        boutonSauv.addActionListener(this);
        Menu M = new Menu('0');



//------------------------------------------------------------------------------
        frame.add(panel);
        frame.setSize(700, 700);
        frame.show();

        M.MenuBateau(JoueurH,JoueurO,Ph);
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {

        String s = e.getActionCommand();
        Object source=e.getSource();
        if(s.equals("  "))
        {
            frame.setBackground(Color.BLACK);
            // Créer une boîte de dialogue
            JDialog d = new JDialog(frame, "Boite de dialogue");
            // Créer une étiquette
            JLabel l = new JLabel("Ceci est une boite de dialogue.");
            // Ajouter l'étiquette à la boîte de dialogue
            d.add(l);
            // Définir la taille de la boîte de dialogue
            d.setSize(200, 100);
            // Définir la visibilité de la boîte de dialogue
            d.setVisible(true);
        }


        if(s.equals("Sauvegarder la partie"))
        {
            System.out.println("Lancement sauvegarde");
            Sauvegarde S = new Sauvegarde();
            S.SauvegarderJeuHumain(joueurHS);
            S.SauvegarderJeuOrdi(joueurOS);
        }
    }



    private void setBackgroud(Color blue) {
    }



}


















