package Model;


public class ModelGrille {
    
    private int[][] grille;
    
    
    public ModelGrille(){
        this.grille = new int[15][15];       
    }
    
    public int[][] getGrille(){
        return this.grille;
    }
    
}
