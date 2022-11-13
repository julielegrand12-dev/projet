package org.example;

public class Bateau {
    private static int length;
    //attribut

    private int id_navire  ;
    private String nom_navire ;
    private Case[][] LesCases ;
    private int taille_navire ; // le nb de case du bateau
    private boolean Horizontal ; // dans le cas d'un navire vertical, ce sont les lignes x qui déterminent la taille

    public Bateau(String taille, String id, String nom) {
    }
    // dans le cas 'un navire horizontal,ce sont les colonnes y qui determinent la taille

    public boolean isHorizontal() {
        return Horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        Horizontal = horizontal;
    }
// getter et setter

    public int getTaille_navire() {
        return taille_navire;
    }

    public void setTaille_navire(int taille_navire) {
        this.taille_navire = taille_navire;
    }

    public int getId_navire() {
        return id_navire;
    }

    public void setId_navire(int id_navire) {
        this.id_navire = id_navire;
    }

    public String getNom_navire() {
        return nom_navire;
    }

    public void setNom_navire(String nom_navire) {
        this.nom_navire = nom_navire;
    }

    public Case[][] getLesCases() {
        return LesCases;
    }

    public void setLesCases(Case[][] lesCases) {
        LesCases = lesCases;
    }

    //methodes et constructeurs

    public boolean couler() {
        for (int i = 0 ; i<15 ; i++ )
            for (int j =0; j<15 ; j++ )
                if (this.LesCases[i][j].EtatCase()){
                    return true ;
                }
        return false ;
    }

    public void Bateau( int taille_navire,int id_navire, String nom_navire){
        this.id_navire = id_navire ;
        this.nom_navire = nom_navire ;
        this.taille_navire = taille_navire ;

    }

    public static void declaBateaux(String[][] Bateau) { // Declaration des bateaux
          Bateau B1 = new Bateau("7","1","Cruisarde");
          Bateau B2 = new Bateau("5", "2", "Croiseur");
          Bateau B3 = new Bateau("5", "3", "Croiseur");
          Bateau B4 = new Bateau("3", "4", "Destroyer");
          Bateau B5 = new Bateau("3", "5", "Destroyer");
          Bateau B6 = new Bateau("3", "6", "Destroyer");
          Bateau B7 = new Bateau("1", "7", "Sous-marin");
          Bateau B8 = new Bateau("1", "8", "Sous-marin");
          Bateau B9 = new Bateau("1", "9", "Sous-marin");
          Bateau B10 = new Bateau("1", "10", "Sous-marin");
    };

    public static String[] getconfigbateau(int id_navire) {
        if (id_navire < 0 || id_navire >= Bateau.length) {
            return new String[0];
        }
        return Bateau[id_navire];
    }

    public static int nombrebateaux() {
        return Bateau.length;
    }

}
