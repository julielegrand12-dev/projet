package java.org.example;
import java.util.ArrayList;

public class Jeu {
    ArrayList<Integer> navires = new ArrayList<Integer>();
    int taille_1 = 7;
    int taille_2 = 5;
    int taille_3 = 3;
    int taille_4 = 1;
    int Joueur1=0;
    int Joueur2=0;

    //grille
    private int nbligne;
    private int nbcol;
    private int [][][][] plateau;



    public ArrayList<Integer> getNavires() {
        return navires;
    }

    public void setNavires(ArrayList<Integer> navires) {
        this.navires = navires;
    }

    public Jeu() {

    }

    public void positionnement_navire()
    {
        int hori = 0;
        int verti = 1;
        //grille de 15 * 15 - placer 4 navires
        int tempo = 0;
        


    }

    public void plateau(int n,int p)
    {
        nbligne=n;
        nbcol=p;
        plateau = new int[nbligne][nbcol][1][1];

        for(int i=0; i<10;i++)
        {
            for(int j=0; j<10;j++)
            {
                plateau[i][j][0][0]='x';
            }
            //System.out.println(----);
        }
        System.out.println();
        for(int i=0; i<10;i++)
        {
            for (int j = 0; j < 10; j++)
            {

                System.out.print(" | "+plateau[i][j][0][0]);


            }
            System.out.println(" | ");
        }
        System.out.println();



    }
}
