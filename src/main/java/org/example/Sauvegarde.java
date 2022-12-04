package org.example;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;

import static java.lang.System.in;
import static java.lang.System.out;
import java.io.Serializable;

public class Sauvegarde implements Serializable {


    void SauvegarderJeuHumain(JoueurHumain J) {


        out.println("JEU - SAUVEGARDE HUMAIN");

        for (Object i : J.getMapDeCasesHumain().keySet()) {
            out.println("Case n." + i + " de Coordonnée X = " + J.getMapDeCasesHumain().get(i).getX() + " " + " et coordonnée Y = " + J.getMapDeCasesHumain().get(i).getY() + "   " + J.getMapDeCasesHumain().get(i).getGetID());
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
            FileOutputStream monfichiermapdecases=new FileOutputStream("SauvegardeMapDeCases.dat");
           // FileOutputStream fos=new FileOutputStream(monfichiermapdecases);
            ObjectOutputStream oos=new ObjectOutputStream(monfichiermapdecases);

            oos.writeObject(J.getMapDeCasesHumain());
            oos.flush();
            oos.close();
            monfichiermapdecases.close();

            FileOutputStream monfichiermapdebateaux=new FileOutputStream("SauvegardeMapDebateaux.dat");
            // FileOutputStream fos=new FileOutputStream(monfichiermapdecases);
            ObjectOutputStream oob=new ObjectOutputStream(monfichiermapdebateaux);

            oob.writeObject(J.getMapDeBateauxHumain());
            oob.flush();
            oob.close();
            monfichiermapdebateaux.close();

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
            out.println("impossible d'ecrire dans le fichier : " + e.toString());

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

    void SauvegarderJeuOrdi(JoueurOrdi O) {


        out.println("JEU - SAUVEGARDE ORDI");

        for (Object i : O.getMapDeCasesOrdi().keySet()) {
            out.println("Case n." + i + " de Coordonnée X = " + O.getMapDeCasesOrdi().get(i).getX() + " " + " et coordonnée Y = " + O.getMapDeCasesOrdi().get(i).getY() + "   " + O.getMapDeCasesOrdi().get(i).getGetID());
        }

        FileOutputStream monfichierID = null;
        FileOutputStream monfichierX = null;
        FileOutputStream monfichierY = null;
        FileOutputStream monfichierpseudo = null;
        FileOutputStream monfichierscore = null;


        try {
            //Sauvegarde des X
            monfichierID = new FileOutputStream("SauvegardeIDO.dat");
            monfichierX = new FileOutputStream("SauvegardeXO.dat");
            monfichierY = new FileOutputStream("SauvegardeYO.dat");
            monfichierpseudo = new FileOutputStream("SauvegardepseudoO.dat");
            monfichierscore = new FileOutputStream("SauvegardescoreO.dat");
            FileOutputStream monfichiermapdecases=new FileOutputStream("SauvegardeMapDeCasesO.dat");
            // FileOutputStream fos=new FileOutputStream(monfichiermapdecases);
            ObjectOutputStream oos=new ObjectOutputStream(monfichiermapdecases);

            oos.writeObject(O.getMapDeCasesOrdi());
            oos.flush();
            oos.close();
            monfichiermapdecases.close();

            FileOutputStream monfichiermapdebateaux=new FileOutputStream("SauvegardeMapDebateauxO.dat");
            // FileOutputStream fos=new FileOutputStream(monfichiermapdecases);
            ObjectOutputStream oob=new ObjectOutputStream(monfichiermapdebateaux);

            oob.writeObject(O.getMapDeBateauxOrdi());
            oob.flush();
            oob.close();
            monfichiermapdebateaux.close();

            for (Object j : O.getMapDeCasesOrdi().keySet()) {
                monfichierID.write(O.getMapDeCasesOrdi().get(j).getGetID());
            }

            for (Object j : O.getMapDeCasesOrdi().keySet()) {
                monfichierX.write(O.getMapDeCasesOrdi().get(j).getX());
            }
            for (Object j : O.getMapDeCasesOrdi().keySet()) {
                monfichierY.write(O.getMapDeCasesOrdi().get(j).getY());

            }

            monfichierpseudo.write(O.getPseudo().getBytes());




        } catch (IOException e) {
            out.println("impossible d'ecrire dans le fichier : " + e.toString());

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




    void RecupererJeuHumain( JoueurHumain J ) {
        out.println("RECUP SAUVEGARDE 1");
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
            out.println("RECUP SAUVEGARDE 2");
            FileInputStream toRead=new FileInputStream("SauvegardeMapDeCases.dat");
            ObjectInputStream ois=new ObjectInputStream(toRead);

            HashMap<Integer, Case> mapInFile=(HashMap<Integer,Case>)ois.readObject();


            //print All data in MAP
            for(Object k : mapInFile.keySet()){
                System.out.println(mapInFile.get(k).getX());
            }J.setMapDeCasesHumain(mapInFile);
            ois.close();
            toRead.close();


            FileInputStream toRead2=new FileInputStream("SauvegardeMapDebateaux.dat");
            ObjectInputStream oob=new ObjectInputStream(toRead2);

            HashMap<Integer, Bateau> mapBInFile=(HashMap<Integer,Bateau>)oob.readObject();


            //print All data in MAP
            for(Object k : mapBInFile.keySet()){
                System.out.println(mapBInFile.get(k).getCoordonneeDebutX());
            }J.setMapDeBateauxHumain(mapBInFile);
            oob.close();
            toRead2.close();

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
                out.println("RECUP SAUVEGARDE 3");

                for(int d=0; d<=TableauY.length-1;d++)
                {

                    Case c = new Case(TableauX[d], TableauY[d], TableauID[d]);
                    listeCases.add(c);
                }
                out.println("RECUP SAUVEGARDE 4");


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

                byte[] b = monfichierpseudo.readAllBytes();
                String valP = new String(b);
                J.setPseudo(valP);
                //SCORE
                int valS = monfichierscore.read();
                J.setScore(valS);
                break;
            }
        } catch (IOException e) {
            out.println("impossible de lire le fichier : " + e.toString());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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
            out.println("lecture de fichier terminee");
        }
        out.println("pseudo :" + J.getPseudo());
        out.println("score :" + J.getScore());
        for (int i = 0; i < listeCases.size(); i++) {

            mapDeCasesSauv.put(i, listeCases.get(i));

        }
      //  J.setMapDeCasesHumain(mapDeCasesSauv);




        /*    for (Object i : J.getMapDeCasesHumain().keySet()) {
                System.out.println("Case n." + i + " de Coordonnée X = " + mapDeCasesSauv.get(i).getX() + " " + " et coordonnée Y = " + J.getMapDeCases().get(i).getY() + "   " + J.getMapDeCases().get(i).getGetID());
            } */
    

    Plateau pat = new Plateau();


            


            J.setMapDeCasesHumain(mapDeCasesSauv);

  
    }

    void RecupererJeuOrdi(JoueurOrdi O) {
        out.println("RECUP SAUVEGARDE 1");
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
            monfichierID = new FileInputStream("SauvegardeIDO.dat");
            monfichierX = new FileInputStream("SauvegardeXO.dat");
            monfichierY = new FileInputStream("SauvegardeYO.dat");
            monfichierpseudo = new FileInputStream("SauvegardepseudoO.dat");
            monfichierscore = new FileInputStream("SauvegardescoreO.dat");
            out.println("RECUP SAUVEGARDE 2");
            FileInputStream toRead=new FileInputStream("SauvegardeMapDeCasesO.dat");
            ObjectInputStream ois=new ObjectInputStream(toRead);

            HashMap<Integer, Case> mapInFile=(HashMap<Integer,Case>)ois.readObject();


            //print All data in MAP
            for(Object k : mapInFile.keySet()){
                System.out.println(mapInFile.get(k).getX());
            }O.setMapDeCasesOrdi(mapInFile);
            ois.close();
            toRead.close();


            FileInputStream toRead2=new FileInputStream("SauvegardeMapDebateauxO.dat");
            ObjectInputStream oob=new ObjectInputStream(toRead2);

            HashMap<Integer, Bateau> mapBInFile=(HashMap<Integer,Bateau>)oob.readObject();


            //print All data in MAP
            for(Object k : mapBInFile.keySet()){
                System.out.println(mapBInFile.get(k).getCoordonneeDebutX());
            }O.setMapDeBateauxOrdi(mapBInFile);
            oob.close();
            toRead2.close();

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
                out.println("RECUP SAUVEGARDE 3");

                for(int d=0; d<=TableauY.length-1;d++)
                {

                    Case c = new Case(TableauX[d], TableauY[d], TableauID[d]);
                    listeCases.add(c);
                }
                out.println("RECUP SAUVEGARDE 4");


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

                byte[] b = monfichierpseudo.readAllBytes();
                String valP = new String(b);
                O.setPseudo(valP);
                //SCORE
                int valS = monfichierscore.read();
                O.setScore(valS);
                break;
            }
        } catch (IOException e) {
            out.println("impossible de lire le fichier : " + e.toString());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
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
            out.println("lecture de fichier terminee");
        }
        out.println("pseudo :" + O.getPseudo());
        out.println("score :" + O.getScore());
        for (int i = 0; i < listeCases.size(); i++) {

            mapDeCasesSauv.put(i, listeCases.get(i));

        }
        //  J.setMapDeCasesHumain(mapDeCasesSauv);




        /*    for (Object i : J.getMapDeCasesHumain().keySet()) {
                System.out.println("Case n." + i + " de Coordonnée X = " + mapDeCasesSauv.get(i).getX() + " " + " et coordonnée Y = " + J.getMapDeCases().get(i).getY() + "   " + J.getMapDeCases().get(i).getGetID());
            } */


        Plateau pat = new Plateau();





        O.setMapDeCasesOrdi(mapDeCasesSauv);


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








