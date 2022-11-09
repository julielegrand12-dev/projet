package org.example;
import javax.swing.*;
import java.awt.*;


public class Plateau extends JPanel {

    public void Fenetre()
    {
        JFrame fen = new JFrame();
        fen.setVisible(true); //pour ouvrir la fenetre
        fen.setSize(600,600);
        fen.setDefaultCloseOperation(fen.EXIT_ON_CLOSE);
        fen.setTitle("Fenetre 1");
        fen.add(this);
        //fen.setContentPane(fen);
        JLabel jla = new JLabel("Joueur 1");
        fen.add(jla);


    }
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);

        for(int i=50; i<550;i++ )
        {
            g.drawLine(i,50,i,550);
            g.drawLine(50,i,550,i);
            i=i+30;
        }

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

}
