package Model;


public abstract class ModelJoueur {
    
    private ModelPartie Model;
    private ModelGrille grillePerso;
    
    
    
    //CONSTRUCTOR
    public ModelJoueur(){
        this.grillePerso = new ModelGrille();
    }
    
    
    
}
