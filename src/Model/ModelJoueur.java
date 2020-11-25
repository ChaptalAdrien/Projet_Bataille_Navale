package Model;


public abstract class ModelJoueur {
    
    private ModelPartie ModelPartie;
    private ModelGrille grillePerso;
    
    
    
    //CONSTRUCTOR
    public ModelJoueur(){
        this.grillePerso = new ModelGrille();
    }
    
    
    
}
