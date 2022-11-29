package org.example;

import java.awt.*;
import javax.swing.*;
import java.util.HashMap;

public class Panel extends JPanel{


private int tempo =0;


    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void paintComponent(Graphics g)
    {



        if(tempo == 0 || tempo ==1)
        {
            JoueurHumain J = new JoueurHumain("Sara",0);
            HashMap<Integer, Case> mapDeCases = new HashMap<Integer, Case>();
            HashMap<Integer, Bateau> mapDeBateaux = new HashMap<>();
        if(tempo==0)
            {
                HashMap<Integer, Case> mapDeCasesP = new HashMap<Integer, Case>();
                HashMap<Integer, Bateau> mapDeBateauxP = new HashMap<>();
                mapDeCasesP = mapDeCases;
                mapDeBateauxP = mapDeBateaux;
                setTempo(1);


            }
            if(tempo==1)
            {
                HashMap<Integer, Case> mapDeCasesO = new HashMap<Integer, Case>();
                HashMap<Integer, Bateau> mapDeBateauxO = new HashMap<>();
                mapDeCasesO = mapDeCases;
                mapDeBateauxO = mapDeBateaux;
                setTempo(2);
            }
            J.setMapDeCasesHumain(mapDeCases);
            J.PlacementCasesHumain(mapDeCases,mapDeBateaux);


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
            int a=0;



            for(Integer i : mapDeCases.keySet())
            {
                if(mapDeCases.get(i).getGetID()==1)
                {
                    g.setColor(Color.YELLOW);
                    g.fillRect(mapDeCases.get(i).getX()*31+50,mapDeCases.get(i).getY()*31+50,31,31);

                }
                if(mapDeCases.get(i).getGetID()==3)
                {
                    g.setColor(Color.ORANGE);
                    g.fillRect(mapDeCases.get(i).getX()*31+50,mapDeCases.get(i).getY()*31+50,31,31);

                }
                if(mapDeCases.get(i).getGetID()==5)
                {
                    g.setColor(Color.PINK);
                    g.fillRect(mapDeCases.get(i).getX()*31+50,mapDeCases.get(i).getY()*31+50,31,31);

                }
                if(mapDeCases.get(i).getGetID()==7)
                {
                    g.setColor(Color.RED);
                    g.fillRect(mapDeCases.get(i).getX()*31+50,mapDeCases.get(i).getY()*31+50,31,31);

                }


            }



            g.setColor(Color.BLACK);
            for(int i=50; i<520;i++ )
            {
                g.drawLine(i,50,i,515);
                g.drawLine(50,i,515,i);
                i=i+30;
            }
            g.setColor(Color.BLACK);



        }






    }
}
