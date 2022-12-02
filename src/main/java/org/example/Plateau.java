package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import java.awt.BorderLayout;



public class Plateau extends JFrame implements ActionListener  {

    private HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
    private HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
    private JFrame fen;
    private JPanel panel2;
    private JPanel panel1;
    private JLabel lab;
    static JFrame frame;
    ArrayList<JButton> lesBoutons = new ArrayList<JButton>(); // liste de boutons
    HashMap<Integer, Case> MapDeCasesDegat = new HashMap<Integer, Case>(); //hashmap
    ArrayList<Case> listeCasesDeg = new ArrayList<Case>();

    public void PlateauDommage()
    {


        frame = new JFrame("PLATEAU DOMMAGE ADVERSAIRE");
        // créer un objet
        Plateau obj = new Plateau();
        // créer un panneau
        JPanel panel = new JPanel();
        JButton btn[] = new JButton[225];
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





        }


        for (int k = 0; k<224;k++)
        {
            //System.out.println(k + " Avec X = " + listeCasesDeg.get(k).getX() + " et Y = " + listeCasesDeg.get(k).getY() );
            //MapDeCasesDegat.put(k, listeCasesDeg.get(k));
        }


        frame.add(panel);
        frame.setSize(700, 700);
        frame.show();

        
       /* fen=new JFrame("BATAILLE NAVALE");
        fen.setVisible(true);
        fen.setSize(800,650);
        fen.setDefaultCloseOperation(fen.EXIT_ON_CLOSE);

        panel1= new JPanel();

        panel1.setBackground(Color.ORANGE);


        lab = new JLabel("Joueur 1");

       // Sauvegarde S = new Sauvegarde();
        panel2= new JPanel();
        panel2.setBackground(Color.ORANGE);

        fen.add(panel2,BorderLayout.SOUTH);

        panel1.add(lab);


        fen.add(panel1,BorderLayout.NORTH);



        //Graphics g = null;
        //fen.add(super.paintComponent(g));
        fen.add(new Panel());*/


    }





    public void PlateauJoueur()
    {
        JoueurHumain J = new JoueurHumain("ju", 0);
        System.out.println("Nouvelle partie");
        J.setMapDeCasesHumain(mapDeCases);
        J.setMapDeBateauxHumain(mapDeBateaux);
        J.PlacementCasesHumain(mapDeCases, mapDeBateaux);

        frame = new JFrame("PLATEAU NAVIRE");
        // créer un objet
        Plateau obj = new Plateau();
        // créer un panneau
        JPanel panel = new JPanel();
        JButton btn[] = new JButton[225];
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
                        if((listeCasesDeg.get(i).getX() == J.getMapDeCasesHumain().get(j).getX())&&(listeCasesDeg.get(i).getY() == J.getMapDeCasesHumain().get(j).getY()))
                        {
                            if(J.getMapDeCasesHumain().get(j).getGetID()==1)
                            {
                                btn[i].setBackground(Color.YELLOW);
                            }
                            if(J.getMapDeCasesHumain().get(j).getGetID()==3)
                            {
                                btn[i].setBackground(Color.ORANGE);
                            }
                            if(J.getMapDeCasesHumain().get(j).getGetID()==5)
                            {
                                btn[i].setBackground(Color.PINK);
                            }
                            if(J.getMapDeCasesHumain().get(j).getGetID()==7)
                            {
                                btn[i].setBackground(Color.RED);
                            }

                        }
                    }



            }


        for (int k = 0; k<224;k++)
        {
        System.out.println(k + " Avec X = " + listeCasesDeg.get(k).getX() + " et Y = " + listeCasesDeg.get(k).getY() );
        //MapDeCasesDegat.put(k, listeCasesDeg.get(k));
        }


        frame.add(panel);
        frame.setSize(700, 700);
        frame.show();
    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.equals(" "))
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
    }



//faire en appuyant sur un bouton du clavier la sauvegarde pour recuperer

    private void setBackgroud(Color blue) {
    }




    }









