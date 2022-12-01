package org.example;

import java.util.*;

public class JoueurHumain //initialisation de la classe joueur humain
{
   // public JavaIOFileDescriptorAccess getMapDeCases;
    //public HashMap<Object, Object> mapDeCases;
    private String pseudo;
    private int score;
    private HashMap<Integer, Case> mapDeCasesHumain = new HashMap<Integer,Case>();
    private HashMap<Integer,Bateau> mapDeBateauxHumain = new HashMap<Integer, Bateau>();

    public HashMap<Integer, Bateau> getMapDeBateauxHumain() {
        return mapDeBateauxHumain;
    }

    public void setMapDeBateauxHumain(HashMap<Integer, Bateau> mapDeBateaux) {
        this.mapDeBateauxHumain = mapDeBateaux;
    }

    private Scanner scan1 = new Scanner(System.in);
    private Scanner scan = new Scanner(System.in);


    public void setMapDeCasesHumain(HashMap<Integer, Case> mapDeCases) {
        this.mapDeCasesHumain = mapDeCases;
    }

    public HashMap<Integer, Case> getMapDeCasesHumain() {
        return mapDeCasesHumain;
    }

    //Déclaration du constructeur
    public JoueurHumain(String pseudo, int score) {
        this.pseudo = pseudo;
        this.score = score;
    }

    //Déclaration des getters
    public String getPseudo() {
        return pseudo;
    }

    public int getScore() {
        return score;
    }

    //Déclaration des setters
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setScore(int score) {
        this.score = score;
    }

    protected HashMap<Integer, Case> PlacementCasesHumain(HashMap<Integer,Case>MapDeCases, HashMap<Integer,Bateau>MapDeBateaux) {

       //Initialisation de la fonction aléatoire
        Random alea = new Random();

        //On déclare des listes
        List<Integer> lesTailles = new ArrayList<>(List.of(7,5,5,3,3,3,1,1,1,1));
        List<String> lesNoms = new ArrayList<>(List.of("Cruisarde","Croiseur","Croiseur", "Destroyer","Destroyer","Destroyer","Sous-marin","Sous-marin","Sous-marin","Sous-marin","Sous-marin"));
        ArrayList<Case> listeCases = new ArrayList<Case>();
        List<Integer> NoDoublonX = new ArrayList<>();
        List<Integer> NoDoublonY = new ArrayList<>();
        int y=0;
        int x=0;
        int compx = x;
        int compy = y;
        NoDoublonX.add(0);
        NoDoublonY.add(0);
        //On boucle 10 fois pour les 10 bateaux
        for (int i = 0; i< 10; i++) {
            int int_random = alea.nextInt(2);
            boolean Horizontal;
            int taille_bateau = lesTailles.get(i);
            int limite = 15 - taille_bateau;
            int test = 0;
           /* Bateau B = new Bateau(lesTailles.get(i), i,lesNoms.get(i));
            B.setNom_navire(lesNoms.get(i));
            mapDeBateaux.put(i,B);*/

                if (int_random == 0) {
                    Horizontal = true;
                    // dans ce cas y reste le meme et x varie
                    // il faut s'assurer que la taille du bateau ne dépasse pas de la  grille
                   // x = alea.nextInt(limite++) +1;
                   // y = alea.nextInt(16)+1;
                    x = (int) (Math.random()*(15-limite))+1;
                    y = (int)(Math.random()*(15))+1;
                    x = alea.nextInt(limite++) +1;
                    y = alea.nextInt(14)+1;

                   for (int a=0;a<=taille_bateau;a++){
                    for (int w=0;w<listeCases.size();w++){
                        while(listeCases.get(w).getX() == x  + a && listeCases.get(w).getY() == y){
                            x = (int) (Math.random()*(15-limite))+1;
                            y = (int)(Math.random()*(15))+1;
                            System.out.println("\n\nerrorororororororo");
                            a=0;
                            break;

                        }
                    }}
                    Bateau B = new Bateau(lesTailles.get(i), i,lesNoms.get(i), Horizontal, x+1, y);

                    MapDeBateaux.put(i,B);


                    test = 1;
                }
                else {
                    Horizontal = false;
                    // x reste la meme et y varie
                    //x = alea.nextInt(16)+1;
                    //y = alea.nextInt(limite++)+1;

                    x = (int) (Math.random()*(15))+1;
                    y = (int)(Math.random()*(15-limite))+1;
                    System.out.println("X  : "+ x + " Y : "+ y);
                     for (int a=0;a<=taille_bateau;a++){
                     for (int w=0;w<listeCases.size();w++){
                    while(listeCases.get(w).getX() == x && listeCases.get(w).getY() == y+ a){

                        x = (int) (Math.random()*(15))+1;
                        y = (int)(Math.random()*(15-limite))+1;
                        System.out.println("\n\nERRor");
                        a=0;
                        break;


                    }}
                }


                    Bateau B = new SousMarin(lesTailles.get(i), i,lesNoms.get(i), Horizontal, x, y+1);

                    MapDeBateaux.put(i,B);}

                    test = 1;

                //Case C  = new Case(x,y);
                int compte = i;
                compte = compte +1;
                if (lesTailles.get(i)== 7){
                    System.out.println("\nPlacement du " + lesNoms.get(i)+ " " + compte);
                    for(int z=0; z<7;z++){
                        if(Horizontal == true){
                            Case c = new Case(x=x+1,y,lesTailles.get(i));
                            System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());

                            listeCases.add(c);


                        }
                        if(Horizontal == false){
                            Case c = new Case(x,y=y+1,lesTailles.get(i));
                            System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());

                            listeCases.add(c);

                        }
                        //NoDoublonX.add(x);
                       // NoDoublonY.add(y);
                    }
                }
                if (lesTailles.get(i)== 5){
                    System.out.println("\nPlacement du " + lesNoms.get(i) + " " + compte++);
                    for(int z=7; z<12;z++){
                        if(Horizontal == true){
                            Case c = new Case(x=x+1,y,lesTailles.get(i));
                            System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                            listeCases.add(c);
                        }
                        if(Horizontal == false){
                            Case c = new Case(x,y=y+1,lesTailles.get(i));
                            System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                            listeCases.add(c);
                        }
                        //NoDoublonX.add(x);
                        //NoDoublonY.add(y);


                    }
                }
                if (lesTailles.get(i)== 3){
                    System.out.println("\nPlacement du " + lesNoms.get(i) + " " +compte++);
                    for(int z=12; z<15;z++){
                        if(Horizontal == true){
                            Case c = new Case(x=x+1,y,lesTailles.get(i));
                            System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                            listeCases.add(c);
                        }
                        if(Horizontal == false){
                            Case c = new Case(x,y=y+1,lesTailles.get(i));
                            System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                            listeCases.add(c);
                        }
                        //NoDoublonX.add(x);
                        //NoDoublonY.add(y);
                    }
                }
                if (lesTailles.get(i)== 1){
                    System.out.println("\nPlacement du " + lesNoms.get(i) + " " +compte++);
                    for(int z=15; z<16;z++){
                        if(Horizontal == true){
                            Case c = new Case(x=x+1,y,lesTailles.get(i));
                            System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                            listeCases.add(c);
                        }
                        if(Horizontal == false){
                            Case c = new Case(x,y=y+1,lesTailles.get(i));
                            System.out.println("Nouvelle case de coordonnée: X :" + c.getX() + " & Y:" + c.getY());
                            listeCases.add(c);
                        }
                        //NoDoublonX.add(x);
                        //NoDoublonY.add(y);

                    }
                }


// continuer cette fonction pour bien prendre en compte l'absence de voisins et le non chevauchement
        }
        for (int i = 0; i<listeCases.size();i++){
            //System.out.println(i + " Avec X = " + listeCases.get(i).getX() + " et Y = " + listeCases.get(i).getY() + "\n et d'ID = " + listeCases.get(i).getGetID());
            MapDeCases.put(i, listeCases.get(i));


        }
        setMapDeBateauxHumain(MapDeBateaux);
        setMapDeCasesHumain(MapDeCases);
        return MapDeCases; }

        protected HashMap<Integer,Bateau> PlacementBateauxHumain (HashMap<Integer,Bateau>MapDeBateaux) {
            MapDeBateaux  = getMapDeBateauxHumain();
           /* for (Integer TY : mapDeBateaux.keySet()) {
                System.out.println("Bateau n." + TY + " de nom = " + mapDeBateaux.get(TY).getNom_navire()  +" D'id : " +  mapDeBateaux.get(TY).getId_navire() + " de taille = " + mapDeBateaux.get(TY).getTaille_navire()+  "\n, de direction horizontale : "  + mapDeBateaux.get(TY).isHorizontal() + "\n, de coordonnées debut x = " + mapDeBateaux.get(TY).getCoordonneeDebutX()+ " et y = " + mapDeBateaux.get(TY).getCoordonneeDebutY() + "\n\n" );

            }*/

            return MapDeBateaux;
        }
        // Trouver moyen de retourner coordonnée de début

    void DeplacerBateau(HashMap<Integer, Bateau>MapDeBateaux, HashMap<Integer,Case>MapDeCases )
    {
        Integer choix=0;
        int x=0;
        int reponse=0;
        Integer i=0;

        //on initialise un objet pour la classe bateau et la map
        Bateau B= new Bateau();

        //affichage de départ
        System.out.println("Vous avez choisi de déplacer votre bateau\n");
        System.out.println("Veuillez selectionner le bateau souhaite:\n");

       for(Integer n : mapDeBateauxHumain.keySet())
        {
            System.out.println(" " + mapDeBateauxHumain.get(n).getNom_navire() + " et d'id : "+ mapDeBateauxHumain.get(n).getId_navire());
        }
        System.out.println("Veuillez selectionner le bateau souhaite dans la liste ci-dessous:\n");

        choix = scan1.nextInt();

    //on blinde l'entrée
     while( choix <0 || choix>9 )
     {
         System.out.print("Saisie incorrecte: Veulliez saisir un bon id :");
         choix = scan1.nextInt();
     }

     //on demande les coordonnées
        System.out.print("Vous avez choisi le bateau : "+ MapDeBateaux.get(choix).getNom_navire()+"\n");

     if(B.isHorizontal()==true) //si le bateau n'est pas horizontale
     {
        System.out.print("Souhaitez vous deplacer le bateau vers la droite ou vers la gauche? Repondez pour droite 1 ou pour gauche 0\n");
        reponse=scan.nextInt();

            if(reponse==1 && choix==0)
            {
                boolean flag = true;
                for(i=0; i<7; i++)
            {
                Case c = new Case(mapDeCasesHumain.get(i).getX()+1,mapDeCasesHumain.get(i).getY(),7);

                if(15 >= mapDeCasesHumain.get(i).getX() + 1 && mapDeCasesHumain.get(i).getX()+1 != mapDeCasesHumain.get(i).getX() && mapDeCasesHumain.get(i).getX()+1 != mapDeCasesHumain.get(i+7).getX() && mapDeCasesHumain.get(i).getX()+1 != mapDeCasesHumain.get(i+14).getX() && mapDeCasesHumain.get(i).getX()+1 != mapDeCasesHumain.get(i+21).getX() && mapDeCasesHumain.get(i).getX()+1 != mapDeCasesHumain.get(i+28).getX())
                {mapDeCasesHumain.replace(i,c);
                setMapDeCasesHumain(mapDeCasesHumain);
                System.out.println("Coordonnées bateau X:"+mapDeCasesHumain.get(i).getX()+" Y:"+mapDeCasesHumain.get(i).getY());
                flag = false;}

                else {System.out.println("Erreur, la coordonnee saisie est fausse");}

                }
                if( flag = false)
                {Bateau b= new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(),B.isHorizontal(), mapDeBateauxHumain.get(choix).getCoordonneeDebutX()+1, mapDeBateauxHumain.get(choix).getCoordonneeDebutY());
                    mapDeBateauxHumain.replace(i,b);
                    setMapDeBateauxHumain(mapDeBateauxHumain);
                    System.out.println("Coordonnées bateau X:"+mapDeBateauxHumain.get(choix).getCoordonneeDebutX()+" Y:"+MapDeBateaux.get(choix).getCoordonneeDebutY());}

                else {System.out.println("Coordonnées bateau X:"+mapDeBateauxHumain.get(choix).getCoordonneeDebutX()+" Y:"+MapDeBateaux.get(choix).getCoordonneeDebutY());}

            }

         if(reponse==0 && choix==0)
         {
             boolean flag = true;
             for(i=0; i<7; i++)
             {
                 Case c = new Case(mapDeCasesHumain.get(i).getX()-1,mapDeCasesHumain.get(i).getY(),7);

                 if(15 >= mapDeCasesHumain.get(i).getX() - 1 && mapDeCasesHumain.get(i).getX()-1 != mapDeCasesHumain.get(i).getX() && mapDeCasesHumain.get(i).getX()-1 != mapDeCasesHumain.get(i+7).getX() && mapDeCasesHumain.get(i).getX()-1 != mapDeCasesHumain.get(i+14).getX() && mapDeCasesHumain.get(i).getX()-1 != mapDeCasesHumain.get(i+21).getX() && mapDeCasesHumain.get(i).getX()-1 != mapDeCasesHumain.get(i+28).getX())
                 {mapDeCasesHumain.replace(i,c);
                     setMapDeCasesHumain(mapDeCasesHumain);
                     System.out.println("Coordonnées bateau X:"+mapDeCasesHumain.get(i).getX()+" Y:"+mapDeCasesHumain.get(i).getY());
                     flag = false;}

                 else {System.out.println("Erreur, la coordonnee saisie est fausse");}

             }
             if( flag = false)
             {Bateau b= new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(),B.isHorizontal(), mapDeBateauxHumain.get(choix).getCoordonneeDebutX()-1, mapDeBateauxHumain.get(choix).getCoordonneeDebutY());
                 mapDeBateauxHumain.replace(i,b);
                 setMapDeBateauxHumain(mapDeBateauxHumain);
                 System.out.println("Coordonnées bateau X:"+mapDeBateauxHumain.get(choix).getCoordonneeDebutX()+" Y:"+MapDeBateaux.get(choix).getCoordonneeDebutY());}

             else {System.out.println("Coordonnées bateau X:"+mapDeBateauxHumain.get(choix).getCoordonneeDebutX()+" Y:"+MapDeBateaux.get(choix).getCoordonneeDebutY());}

         }
         }


        if(B.isHorizontal()==false)
        {

            System.out.print("Souhaitez vous deplacer le bateau vers le haut ou vers le bas? Repondez pour haut 1 ou pour bas 0\n");
            reponse=scan.nextInt();

            if(reponse==1 && choix==0)
            {
                boolean flag = true;
                for(i=0; i<7; i++)
                {
                    Case c = new Case(mapDeCasesHumain.get(i).getX(),mapDeCasesHumain.get(i).getY()+1,7);

                    if(15 >= mapDeCasesHumain.get(i).getY() + 1 && mapDeCasesHumain.get(i).getY()+1 != mapDeCasesHumain.get(i).getY() && mapDeCasesHumain.get(i).getY()+1 != mapDeCasesHumain.get(i+7).getY() && mapDeCasesHumain.get(i).getY()+1 != mapDeCasesHumain.get(i+14).getY() && mapDeCasesHumain.get(i).getY()+1 != mapDeCasesHumain.get(i+21).getY() && mapDeCasesHumain.get(i).getY()+1 != mapDeCasesHumain.get(i+28).getY())
                    {mapDeCasesHumain.replace(i,c);
                        setMapDeCasesHumain(mapDeCasesHumain);
                        System.out.println("Coordonnées bateau X:"+mapDeCasesHumain.get(i).getX()+" Y:"+mapDeCasesHumain.get(i).getY());
                        flag = false;}

                    else {System.out.println("Erreur, la coordonnee saisie est fausse");}

                }
                if( flag = false)
                {Bateau b= new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(),B.isHorizontal(), mapDeBateauxHumain.get(choix).getCoordonneeDebutX(), mapDeBateauxHumain.get(choix).getCoordonneeDebutY()+1);
                    mapDeBateauxHumain.replace(i,b);
                    setMapDeBateauxHumain(mapDeBateauxHumain);
                    System.out.println("Coordonnées bateau X:"+mapDeBateauxHumain.get(choix).getCoordonneeDebutX()+" Y:"+MapDeBateaux.get(choix).getCoordonneeDebutY());}

                else {System.out.println("Coordonnées bateau X:"+mapDeBateauxHumain.get(choix).getCoordonneeDebutX()+" Y:"+MapDeBateaux.get(choix).getCoordonneeDebutY());}

            }


            if(reponse==0 && choix==0)
            {
                boolean flag = true;
                for(i=0; i<7; i++)
                {
                    Case c = new Case(mapDeCasesHumain.get(i).getX(),mapDeCasesHumain.get(i).getY()-1,7);

                    if(15 >= mapDeCasesHumain.get(i).getY() - 1 && mapDeCasesHumain.get(i).getY()-1 != mapDeCasesHumain.get(i).getY() && mapDeCasesHumain.get(i).getY()-1 != mapDeCasesHumain.get(i+7).getY() && mapDeCasesHumain.get(i).getY()-1 != mapDeCasesHumain.get(i+14).getY() && mapDeCasesHumain.get(i).getY()-1 != mapDeCasesHumain.get(i+21).getY() && mapDeCasesHumain.get(i).getY()-1 != mapDeCasesHumain.get(i+28).getY())
                    {mapDeCasesHumain.replace(i,c);
                        setMapDeCasesHumain(mapDeCasesHumain);
                        System.out.println("Coordonnées bateau X:"+mapDeCasesHumain.get(i).getX()+" Y:"+mapDeCasesHumain.get(i).getY());
                        flag = false;}

                    else {System.out.println("Erreur, la coordonnee saisie est fausse");}

                    }
                if( flag = false)
                {Bateau b= new Bateau(MapDeBateaux.get(choix).getTaille_navire(), choix, MapDeBateaux.get(choix).getNom_navire(),B.isHorizontal(), mapDeBateauxHumain.get(choix).getCoordonneeDebutX(), mapDeBateauxHumain.get(choix).getCoordonneeDebutY()-1);
                    mapDeBateauxHumain.replace(i,b);
                    setMapDeBateauxHumain(mapDeBateauxHumain);
                    System.out.println("Coordonnées bateau X:"+mapDeBateauxHumain.get(choix).getCoordonneeDebutX()+" Y:"+MapDeBateaux.get(choix).getCoordonneeDebutY());}

                else {System.out.println("Coordonnées bateau X:"+mapDeBateauxHumain.get(choix).getCoordonneeDebutX()+" Y:"+MapDeBateaux.get(choix).getCoordonneeDebutY());}

            }

        }
    }


}

//j'ai du coup changer le nom de placementBateau vers placementcase
