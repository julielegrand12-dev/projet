package org.example;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class Plateau extends JPanel {
    private JFrame fen;
    private JPanel panel1;
    private JPanel panel2;
    private JButton b;
    private JLabel lab;


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


        panel1.add(lab);
        panel2.add(b);


        fen.add(panel1,BorderLayout.NORTH);
        fen.add(panel2,BorderLayout.SOUTH);
        fen.add(new Panel());


    }


    private void setBackgroud(Color blue) {
    }






}
