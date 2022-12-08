package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;



public class Plateau extends JPanel   {




private JoueurHumain eva ;
    public Plateau(JoueurHumain Jou){
        eva = Jou;

    }

    public void paint (Graphics g)
    {


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
        int l = 610;
        for (char c = 'A'; c <= 'O'; c++) {
            g.drawString(String.valueOf(c), l, 45);
            l = l + 31;
        }
        int m = 67;
        for (int d = 1; d <= 15; d++) {
            g.drawString(String.valueOf(d), 580, m);
            m = m + 31;

        }


        for (Integer i : eva.getMapDeCasesHumain().keySet()) {
            if (eva.getMapDeCasesHumain().get(i).getGetID() == 1) {
                g.setColor(Color.YELLOW);
                g.fillRect(eva.getMapDeCasesHumain().get(i).getX() * 31 + 50, eva.getMapDeCasesHumain().get(i).getY() * 31 + 50, 31, 31);

            }
            if (eva.getMapDeCasesHumain().get(i).getGetID() == 3) {
                g.setColor(Color.ORANGE);
                g.fillRect(eva.getMapDeCasesHumain().get(i).getX() * 31 + 50, eva.getMapDeCasesHumain().get(i).getY() * 31 + 50, 31, 31);

            }
            if (eva.getMapDeCasesHumain().get(i).getGetID() == 5) {
                g.setColor(Color.PINK);
                g.fillRect(eva.getMapDeCasesHumain().get(i).getX() * 31 + 50, eva.getMapDeCasesHumain().get(i).getY() * 31 + 50, 31, 31);

            }
            if (eva.getMapDeCasesHumain().get(i).getGetID() == 7) {
                g.setColor(Color.RED);
                g.fillRect(eva.getMapDeCasesHumain().get(i).getX() * 31 + 50, eva.getMapDeCasesHumain().get(i).getY() * 31 + 50, 31, 31);

            }
            if (eva.getMapDeCasesHumain().get(i).EtatCase() == true) {
                g.setColor(Color.BLACK);
                g.fillRect(eva.getMapDeCasesHumain().get(i).getX() * 31 + 50, eva.getMapDeCasesHumain().get(i).getY() * 31 + 50, 31, 31);

            }
            //pareil pour ordinateur
        /*   if (joueurHS.getMapDeCasesHumain().get(i).EtatCase() == true) {
               g.setColor(Color.BLACK);
               g.fillRect(joueurHS.getMapDeCasesHumain().get(i).getX() * 31 + 600, joueurHS.getMapDeCasesHumain().get(i).getY() * 31 + 600, 31, 31);

           }*/


        }
        g.setColor(Color.BLACK);
        for (int i = 50; i < 520; i++) {
            g.drawLine(i, 50, i, 515);
            g.drawLine(50, i, 515, i);
            g.drawLine(600, i, 1070, i);
            i = i + 30;
        }
        for (int i = 600; i < 1070; i++) {
            g.drawLine(i, 50, i, 515);
            // g.drawLine(6, i, 515, i);
            i = i + 30;
        }
        g.setColor(Color.BLACK);

    }

}
