package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class Plateau extends JPanel implements ActionListener {
    private JFrame fen;
    private JPanel panel1;
    private JPanel panel2;
    private JButton b;
    private JLabel lab;

    public JButton getB() {
        return b;
    }

    public void gui()
    {
        
        fen=new JFrame("BATAILLE NAVALE");
        fen.setVisible(true);
        fen.setSize(800,650);
        fen.setDefaultCloseOperation(fen.EXIT_ON_CLOSE);

        panel1= new JPanel();
        panel2= new JPanel();
        panel1.setBackground(Color.ORANGE);
        panel2.setBackground(Color.ORANGE);

        lab = new JLabel("Joueur 1");
        b= new JButton("Sauvegarder la partie");
       // Sauvegarde S = new Sauvegarde();

        //b.addActionListener();
//actionperformed

        panel1.add(lab);
        panel2.add(b);


        fen.add(panel1,BorderLayout.NORTH);
        fen.add(panel2,BorderLayout.SOUTH);
        b.addActionListener(this);
        fen.add(new Panel());


    }
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource()==b)
        {
            Sauvegarde S = new Sauvegarde();
            S.SauvegarderJeu();
            //bmm

        }

    }


    private void setBackgroud(Color blue) {
    }






}

