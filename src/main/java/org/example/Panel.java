package org.example;

import java.awt.*;
import javax.swing.*;
import java.util.HashMap;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {


    private HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
    private HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();

    private int tempo;

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    JoueurHumain J = new JoueurHumain("Sara", 0);
    JoueurOrdi O = new JoueurOrdi("Ordi", 0);


    public Panel() {
    }

    public Panel(int tempo) {
        this.tempo = tempo;
    }

    public HashMap<Integer, Case> getMapDeCasesHumain() {
        return mapDeCases;
    }

    public void setMapDeCasesHumain(HashMap<Integer, Case> mapDeCases) {
        this.mapDeCases = mapDeCases;
    }
    public void testsauvegarde()
    {
        /*int tempo2=0;
        //appeler sauvegarde et si vide alor créer
        Sauvegarde Sauv = new Sauvegarde();
        tempo2=Sauv.testsauv();
        System.out.println("tempo recupJ :" + tempo);
        if(tempo2==0)
        {
            System.out.println("Nouvelle partie");
            J.setMapDeCases(mapDeCases);
            J.setMapDeBateaux(mapDeBateaux);
            J.PlacementCases(mapDeCases, mapDeBateaux);

        }
        if(tempo2==1)
        {
            System.out.println("Reprise de Sauvegarde");

        }*/

    }

    public void paintComponent(Graphics g) {
        JoueurHumain J = new JoueurHumain("Sara", 0);
        System.out.println("tempo recupJ :" + tempo);

        Plateau P = new Plateau();

        Sauvegarde Sauv = new Sauvegarde();
      //  tempo2=Sauv.testsauv();
       // if(tempo==0)
       // {
            mapDeCases=J.getMapDeCasesHumain();
            System.out.println("Nouvelle partie");
            J.setMapDeCasesHumain(mapDeCases);
            J.setMapDeBateauxHumain(mapDeBateaux);
            //J.PlacementCasesHumain(mapDeCases, mapDeBateaux);

       // }
       /* if(tempo==1)
        {
            System.out.println("Reprise de Sauvegarde");

        }*/


        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());




        int j = 60;
        for (char c = 'A'; c <= 'O'; c++) {
            g.drawString(String.valueOf(c), j, 45);
            j = j + 31;
        }
        int k = 67;
        for (int d = 0; d <= 14; d++) {
            g.drawString(String.valueOf(d), 30, k);
            k = k + 31;

        }
        int a = 0;


        for (Integer i : J.getMapDeCasesHumain().keySet()) {
            if (J.getMapDeCasesHumain().get(i).getGetID() == 1) {
                g.setColor(Color.YELLOW);
                g.fillRect(J.getMapDeCasesHumain().get(i).getX() * 31 + 50, J.getMapDeCasesHumain().get(i).getY() * 31 + 50, 31, 31);

            }
            if (mapDeCases.get(i).getGetID() == 3) {
                g.setColor(Color.ORANGE);
                g.fillRect(mapDeCases.get(i).getX() * 31 + 50, mapDeCases.get(i).getY() * 31 + 50, 31, 31);

            }
            if (mapDeCases.get(i).getGetID() == 5) {
                g.setColor(Color.PINK);
                g.fillRect(mapDeCases.get(i).getX() * 31 + 50, mapDeCases.get(i).getY() * 31 + 50, 31, 31);

            }
            if (mapDeCases.get(i).getGetID() == 7) {
                g.setColor(Color.RED);
                g.fillRect(mapDeCases.get(i).getX() * 31 + 50, mapDeCases.get(i).getY() * 31 + 50, 31, 31);

            }


        }


        g.setColor(Color.BLACK);
        for (int i = 50; i < 520; i++) {
            g.drawLine(i, 50, i, 515);
            g.drawLine(50, i, 515, i);
            i = i + 30;
        }
        g.setColor(Color.BLACK);

    }
        private class MyDispatcher implements KeyEventDispatcher {

            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                switch (e.getID()) {
                    case KeyEvent.KEY_PRESSED:

                        setTempo(1);

                            Sauvegarde S = new Sauvegarde();
                            S.SauvegarderJeuHumain(J);
                            S.SauvegarderJeuOrdi(O);



                        // System.out.println("Vous venez d'appuyer sur la touche "+ e.getKeyChar() +" (code "+ e.getKeyCode() +")");

                        break;
                    case KeyEvent.KEY_RELEASED:
                        // System.out.println("Vous venez de relacher la touche "+ e.getKeyChar() +" (code "+ e.getKeyCode() +")");
                        break;
                    case KeyEvent.KEY_TYPED:
                        //System.out.println("Vous venez de taper sur la touche "+ e.getKeyChar());
                        break;
                }
                return false;
            }
        }

    }






