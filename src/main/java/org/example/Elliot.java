package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Elliot {


    public void PlateauJoueur(JoueurHumain JoueurH, JoueurOrdi JoueurO, Elliot E) {


        JButton btn = new JButton("Sauvegarder la partie");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();

                if (s.equals("Sauvegarder la partie")) {
                    System.out.println("Lancement sauvegarde");
                    Sauvegarde S = new Sauvegarde();
                    S.SauvegarderJeuHumain(JoueurH);
                    S.SauvegarderJeuOrdi(JoueurO);
                }

            }
        });
        JPanel pan = new JPanel();
        pan.add(btn, BorderLayout.SOUTH);
        pan.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cpt=1;
                 int cpt2=1;
                int a=0,b=0;
                Menu m = new Menu(0);

                for(int u=45;u<=500;u++)
                {

                    if(e.getY()<u+30 && e.getY()>u)
                    {
                        b=cpt;
                        System.out.println("Y cpt " + cpt);
                        m.y(cpt);

                    }
                    u=u+30;
                    cpt++;
                }
                for(int h=600;h<=1100;h++)
                {

                    if(e.getX()<h+30 && e.getX()>h)
                    {
                        a=cpt;
                        System.out.println("X cpt " + cpt2);
                        m.x(cpt2);
                    }
                    h=h+30;
                    cpt2++;
                }


                  //  JoueurH.getMapDeBateauxHumain().get(9).AttaqueHumain(JoueurO,JoueurH, a, b);



            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        JFrame f = new JFrame("PLATEAU");
        f.getContentPane().add(new Plateau(JoueurH));
        f.setSize(1200, 1200);
        f.setVisible(true);

        f.add(pan);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}