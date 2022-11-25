package org.example;
import org.example.JoueurHumain;
import java.awt.*;
import javax.swing.*;

import java.util.HashMap;
public class Panel extends JPanel{


    public void paintComponent(Graphics g)
    {

        int j=60;
        for(char c = 'A'; c<='O';c++) {
            g.drawString(String.valueOf(c),j,45);
            j=j+31;
        }
        int k=67;
        for(int d = 0; d<= 14; d++) {
            g.drawString(String.valueOf(d),30,k);
            k=k+31;

        }

        for(int i=50; i<520;i++ )
        {
            g.drawLine(i,50,i,515);
            g.drawLine(50,i,515,i);
            i=i+30;
        }
        /*g.setColor(Color.BLACK);
        /*for(Integer i : mapDeCases.keySet())
        {

        }*/




    }
}
