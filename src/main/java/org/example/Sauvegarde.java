package org.example;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.ArrayList;



public class Sauvegarde {


    void SauvegarderJeu(JoueurHumain J) {


        System.out.println("JEU - SAUVEGARDE");

        for (Object i : J.getMapDeCasesHumain().keySet()) {
            System.out.println("Case n." + i + " de Coordonnée X = " + J.getMapDeCasesHumain().get(i).getX() + " " + " et coordonnée Y = " + J.getMapDeCasesHumain().get(i).getY() + "   " + J.getMapDeCasesHumain().get(i).getGetID());
        }

        FileOutputStream monfichierID = null;
        FileOutputStream monfichierX = null;
        FileOutputStream monfichierY = null;
        FileOutputStream monfichierpseudo = null;
        FileOutputStream monfichierscore = null;


        try {
            //Sauvegarde des X
            monfichierID = new FileOutputStream("SauvegardeID.dat");
            monfichierX = new FileOutputStream("SauvegardeX.dat");
            monfichierY = new FileOutputStream("SauvegardeY.dat");
            monfichierpseudo = new FileOutputStream("Sauvegardepseudo.dat");
            monfichierscore = new FileOutputStream("Sauvegardescore.dat");

            for (Object j : J.getMapDeCasesHumain().keySet()) {
                monfichierID.write(J.getMapDeCasesHumain().get(j).getGetID());


            }

            for (Object j : J.getMapDeCasesHumain().keySet()) {
                monfichierX.write(J.getMapDeCasesHumain().get(j).getX());
            }
            for (Object j : J.getMapDeCasesHumain().keySet()) {
                monfichierY.write(J.getMapDeCasesHumain().get(j).getY());

            }

            monfichierpseudo.write(J.getPseudo().getBytes());




        } catch (IOException e) {
            System.out.println("impossible d'ecrire dans le fichier : " + e.toString());

        } finally {
            try {
                monfichierID.close();
                monfichierX.close();
                monfichierY.close();
                monfichierpseudo.close();
                monfichierscore.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }


    }


    void RecupererJeu() {
        System.out.println("RECUP SAUVEGARDE 1");
        JoueurHumain J = new JoueurHumain("Elo", 0);
        HashMap<Integer, Case> mapDeCasesSauv = new HashMap<>();
        ArrayList<Case> listeCases = new ArrayList<>();
        int []TableauX = new int [30];
        int []TableauY = new int [30];
        int []TableauID = new int [30];

        FileInputStream monfichierID = null;
        FileInputStream monfichierX = null;
        FileInputStream monfichierY = null;
        FileInputStream monfichierpseudo = null;
        FileInputStream monfichierscore = null;


        try {
            monfichierID = new FileInputStream("SauvegardeID.dat");
            monfichierX = new FileInputStream("SauvegardeX.dat");
            monfichierY = new FileInputStream("SauvegardeY.dat");
            monfichierpseudo = new FileInputStream("Sauvegardepseudo.dat");
            monfichierscore = new FileInputStream("Sauvegardescore.dat");
            System.out.println("RECUP SAUVEGARDE 2");


            while (true) {



                for(int a=0; a<= TableauID.length-1;a++)
                {
                     TableauID[a] = monfichierID.read();
                }
                for(int b=0; b<= TableauX.length-1;b++)
                {
                      TableauX[b] = monfichierX.read();
                }
                for(int c=0; c<= TableauY.length-1;c++)
                {
                      TableauY[c] = monfichierY.read();
                }
                System.out.println("RECUP SAUVEGARDE 3");

                for(int d=0; d<=TableauY.length-1;d++)
                {

                    Case c = new Case(TableauX[d], TableauY[d], TableauID[d]);
                    listeCases.add(c);
                }
                System.out.println("RECUP SAUVEGARDE 4");


               // int valID = monfichierID.read();

                // System.out.print(" " + valID);

              /*  if (valID == -1) {
                    break;
                }  */

                   /*  int valX = monfichierID.read();
                     System.out.print(" " + valX);
                     if (valX == -1) {
                         break;
                     }

                     int valY = monfichierY.read();
                     System.out.print(" " + valY);
                     if (valY == -1) {
                         break;
                     }    */
                     
                 //PSEUDO
                String valP = String.valueOf(monfichierpseudo.read());
                J.setPseudo(valP);
                //SCORE
                int valS = monfichierscore.read();
                J.setScore(valS);
                break;
            }
        } catch (IOException e) {
            System.out.println("impossible de lire le fichier : " + e.toString());
        } finally {
            try {
                monfichierID.close();
                monfichierX.close();
                monfichierY.close();
                monfichierpseudo.close();
                monfichierscore.close();

            } catch (Exception e1) {
                e1.printStackTrace();
            }
            System.out.println("lecture de fichier terminee");
        }
        System.out.println("pseudo :" + J.getPseudo());
        System.out.println("score :" + J.getScore());
        for (int i = 0; i < listeCases.size(); i++) {

            mapDeCasesSauv.put(i, listeCases.get(i));

        }
        J.setMapDeCasesHumain(mapDeCasesSauv);




        /*    for (Object i : J.getMapDeCasesHumain().keySet()) {
                System.out.println("Case n." + i + " de Coordonnée X = " + mapDeCasesSauv.get(i).getX() + " " + " et coordonnée Y = " + J.getMapDeCases().get(i).getY() + "   " + J.getMapDeCases().get(i).getGetID());
            } */
    

    Plateau pat = new Plateau();
            Panel pan = new Panel();
            System.out.println("tempo :" + pan.getTempo());
            pan.setTempo(1);
            System.out.println("tempo :" +pan.getTempo());
    JoueurHumain Ju = new JoueurHumain("Juju", 1);
            Ju.setMapDeCasesHumain(mapDeCasesSauv);

  
    }

    public int testsauv()
    {
       /* int []TableauX = new int [30];
        int a =0;
        FileInputStream monfichierX = null;
        try {
            monfichierX = new FileInputStream("SauvegardeX.dat");


                // TableauX[a] = monfichierX.read();

            if(monfichierX)
            {
                System.out.println("fichier est nulle");
                return 0;

            }
            else
            {
                return 1;
            }

    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }    */
        return 0;
}}








