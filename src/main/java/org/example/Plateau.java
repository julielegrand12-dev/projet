package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;




public class Plateau extends JPanel   {

    private HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
    private HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();

    private JFrame fen;

    private JPanel panel2;
    private JPanel panel1;


    private JLabel lab;



    public void gui()
    {

        
        fen=new JFrame("BATAILLE NAVALE");
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
        fen.add(new Panel());


    }



//faire en appuyant sur un bouton du clavier la sauvegarde pour recuperer

    private void setBackgroud(Color blue) {
    }




    }









