package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Plateaugraphique {
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    private int a;
    private int b;
    private JFrame f = new JFrame("PLATEAU");


    public void PlateauJoueur(JoueurHumain JoueurH, JoueurOrdi JoueurO, Plateaugraphique E) {


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
                Menu m = new Menu();

                for(int u=45;u<=500;u++)
                {

                    if(e.getY()<u+30 && e.getY()>u)
                    {
                        b=cpt;
                        setB(cpt);
                        System.out.println("Y cpt " + cpt);


                    }
                    u=u+30;
                    cpt++;
                }
                for(int h=600;h<=1100;h++)
                {

                    if(e.getX()<h+30 && e.getX()>h)
                    {
                        a=cpt2;
                        setA(cpt2);
                        System.out.println("X cpt " + cpt2);
                    }
                    h=h+30;
                    cpt2++;

                }
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

            f.getContentPane().add(new Plateau(JoueurH,JoueurO));



        f.setSize(1200, 1200);
        f.setVisible(true);

        f.add(pan);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void MiseajourGrap(JoueurHumain JoueurH, JoueurOrdi JoueurO,Plateaugraphique E)
    {
        f.setSize(1200+1, 1200);
    }
}