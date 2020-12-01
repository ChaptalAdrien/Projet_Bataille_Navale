package Model;


public abstract class Joueur {
    
    private Partie partie;
    private Grille grillePerso;
    private Joueur adversaire;
    
    
    
    //CONSTRUCTOR
    public Joueur(){
        this.grillePerso = new Grille();
    }
    
    public Joueur getAdversaire(){
        return this.adversaire;
    }

    public Grille getGrille() {
        return this.grillePerso;
    }

    
    
}
