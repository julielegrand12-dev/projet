package org.example;
import javax.swing.*;
import java.awt.*;


public class Plateau extends JPanel {
    private JFrame fen;
    private JPanel p;
    private JButton b;
    private JLabel lab;

    public void Fenetre()

    {
        gui();


    }
    public void gui()
    {
        fen=new JFrame("XXX");
        fen.setVisible(true);
        fen.setSize(600,600);
        fen.setDefaultCloseOperation(fen.EXIT_ON_CLOSE);

        p= new JPanel();
        p.setBackground(Color.BLUE);

        //b= new JButton("test");
        lab = new JLabel("Joueur 1");

        //p.add(b);
        p.add(lab);

        fen.add(p,BorderLayout.NORTH);
        fen.add(new Panel());


    }


    private void setBackgroud(Color blue) {
    }

    private int nbligne;
    private int nbcol;
    private char[][] grille;
    public void plateau(int n,int p)
    {
        Fenetre();
        nbligne=n;
        nbcol=p;
        grille = new char[nbligne][nbcol];

        for(int i=0; i<15;i++)
        {
            for(int j=0; j<15;j++)
            {
                grille[i][j] = ' ';
            }

            //System.out.println(----);
        }
        System.out.println();
        for(int i=0; i<15;i++)
        {
            for (int j = 0; j < 15; j++)
            {

                System.out.print(" | "+grille[i][j]);


            }
            System.out.println(" | ");
        }
        System.out.println();



    }

    /*public Case[] generateBoatCoordinates(int x, int y, boolean Horizontal, int taille_bateau, int id_navire) {
        Case[] response = new Case[taille_bateau];
        for (int i = 0; i < taille_bateau; i++) {
            if (Horizontal == true) {
                response[i] = new Case(x + i, y);
            } else if (Horizontal == false) {
                response[i] = new Case(x, y + i);
            }
            response[i].addBoat(boatId);
        }
        return response;
    }*/

}
// test des branches idk what that is