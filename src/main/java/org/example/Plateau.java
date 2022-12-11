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
import java.lang.Thread;


/**
 * Dans cette classe, nous implémentons le plateau avec les bateaux et les couelurs spécifiques.
 */

public class Plateau extends JPanel {


    private int a = 0;

    private JoueurHumain eva;
    private JoueurOrdi eve;


    public Plateau(JoueurHumain Jou, JoueurOrdi JouO) {
        eva = Jou;
        eve = JouO;


    }


    public void paint(Graphics g) {

        int j = 60;
        for (char c = 'A'; c <= 'O'; c++) {
            g.drawString(String.valueOf(c), j, 45);
            j = j + 31;
        }
        int k = 67;
        for (int d = 1; d <= 15; d++) {
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


        if (eva != null) {
            for (Integer i : eva.getMapDeCasesHumain().keySet()) {
                if (eva.getMapDeCasesHumain().get(i).getGetID() == 1) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(eva.getMapDeCasesHumain().get(i).getX() * 31 + 19, eva.getMapDeCasesHumain().get(i).getY() * 31 + 19, 31, 31);

                }
                if (eva.getMapDeCasesHumain().get(i).getGetID() == 3) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(eva.getMapDeCasesHumain().get(i).getX() * 31 + 19, eva.getMapDeCasesHumain().get(i).getY() * 31 + 19, 31, 31);

                }
                if (eva.getMapDeCasesHumain().get(i).getGetID() == 5) {
                    g.setColor(Color.PINK);
                    g.fillRect(eva.getMapDeCasesHumain().get(i).getX() * 31 + 19, eva.getMapDeCasesHumain().get(i).getY() * 31 + 19, 31, 31);

                }
                if (eva.getMapDeCasesHumain().get(i).getGetID() == 7) {
                    g.setColor(Color.RED);
                    g.fillRect(eva.getMapDeCasesHumain().get(i).getX() * 31 + 19, eva.getMapDeCasesHumain().get(i).getY() * 31 + 19, 31, 31);

                }
                if (eva.getMapDeCasesHumain().get(i).EtatCase() == true) {
                    g.setColor(Color.BLACK);
                    g.fillRect(eva.getMapDeCasesHumain().get(i).getX() * 31 + 19, eva.getMapDeCasesHumain().get(i).getY() * 31 + 19, 31, 31);

                }

            }
        }
        if (eve != null) {


            for (Integer i : eve.getMapDeCasesOrdi().keySet()) {


                if (eve.getMapDeCasesOrdi().get(i).getGetID() == 1) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(eve.getMapDeCasesOrdi().get(i).getX() * 31 + 569, eve.getMapDeCasesOrdi().get(i).getY() * 31 + 19, 31, 31);

                }
                if (eve.getMapDeCasesOrdi().get(i).getGetID() == 3) {
                    g.setColor(Color.ORANGE);
                    g.fillRect(eve.getMapDeCasesOrdi().get(i).getX() * 31 + 569, eve.getMapDeCasesOrdi().get(i).getY() * 31 + 19, 31, 31);

                }
                if (eve.getMapDeCasesOrdi().get(i).getGetID() == 5) {
                    g.setColor(Color.PINK);
                    g.fillRect(eve.getMapDeCasesOrdi().get(i).getX() * 31 + 569, eve.getMapDeCasesOrdi().get(i).getY() * 31 + 19, 31, 31);

                }
                if (eve.getMapDeCasesOrdi().get(i).getGetID() == 7) {
                    g.setColor(Color.RED);
                    g.fillRect(eve.getMapDeCasesOrdi().get(i).getX() * 31 + 569, eve.getMapDeCasesOrdi().get(i).getY() * 31 + 19, 31, 31);

                }
                if (eve.getMapDeCasesOrdi().get(i).EtatCase() == true) {
                    g.setColor(Color.BLACK);
                    g.fillRect(eve.getMapDeCasesOrdi().get(i).getX() * 31 + 569, eve.getMapDeCasesOrdi().get(i).getY() * 31 + 19, 31, 31);

                }
                if (eve.getMapDeCasesOrdi().get(i).getCaseEclairee() == true) {
                    g.setColor(Color.GREEN);
                    g.fillRect(eve.getMapDeCasesOrdi().get(i).getX() * 31 + 569, eve.getMapDeCasesOrdi().get(i).getY() * 31 + 19, 31, 31);
                }


            }


        }
        g.setColor(Color.BLACK);
        for (int u = 50; u < 520; u++) {
            g.drawLine(u, 50, u, 515);
            g.drawLine(50, u, 515, u);
            g.drawLine(600, u, 1070, u);
            u = u + 30;
        }
        for (int p = 600; p < 1070; p++) {
            g.drawLine(p, 50, p, 515);
            p = p + 30;
        }
        g.setColor(Color.BLACK);

        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int o = 1200;
        for (Integer i : eve.getMapDeCasesOrdi().keySet()) {
            eve.getMapDeCasesOrdi().get(i).OFFCaseEclairee();
        }

        setSize(o + 1, 1200);


    }
}
