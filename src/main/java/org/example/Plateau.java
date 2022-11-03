package org.example;

public class Plateau {
    private int nbligne;
    private int nbcol;
    private char[][] grille;
    public void plateau(int n,int p)
    {
        nbligne=n;
        nbcol=p;
        grille = new char[nbligne][nbcol];

        for(int i=0; i<15;i++)
        {
            for(int j=0; j<15;j++)
            {
                grille[i][j] = ' ';
            }

            //System.out.println(----);
        }
        System.out.println();
        for(int i=0; i<15;i++)
        {
            for (int j = 0; j < 15; j++)
            {

                System.out.print(" | "+grille[i][j]);


            }
            System.out.println(" | ");
        }
        System.out.println();



    }

}
