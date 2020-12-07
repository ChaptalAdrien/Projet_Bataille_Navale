package Model;


public abstract class Joueur {
    
    protected Partie partie;
    protected Grille grillePerso;
    protected Joueur adversaire;
    
    
    
    //CONSTRUCTOR
    public Joueur(int tailleX, int tailleY){
        this.grillePerso = new Grille(tailleX, tailleY);
    }
    
    public Joueur getAdversaire(){
        return this.adversaire;
    }

    public Grille getGrille() {
        return this.grillePerso;
    }

    
    
}
