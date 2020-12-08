package Model;

import java.util.ArrayList;


public abstract class Joueur {
    
    protected Grille grillePerso;
    protected Joueur adversaire;
    protected ArrayList<Bateau> bateaux;

    
    //CONSTRUCTOR
    public Joueur(int tailleX, int tailleY){
        this.grillePerso = new Grille(tailleX, tailleY);
        this.bateaux = new ArrayList<Bateau>();
        
    }

    public Grille getGrillePerso() {
        return grillePerso;
    }

    public ArrayList<Bateau> getBateaux() {
        return bateaux;
    }
    
    public Joueur getAdversaire(){
        return this.adversaire;
    }

    public Grille getGrille() {
        return this.grillePerso;
    }

    public void initBateau(){
        
        ArrayList<Case> positionCroiseur = new ArrayList<Case>();
        
    }
    
}
