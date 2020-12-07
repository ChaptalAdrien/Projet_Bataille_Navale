package Model;

import java.util.ArrayList;


public class Grille {
    
    private ArrayList<Case> grille;
    private int tailleX;
    private int tailleY;
    
    public Grille(int tailleX, int tailleY){
        
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        
        for(int i = 0; i < this.tailleX; i++){
            for(int j = 0; j < this.tailleY; j++){
                Case c = new Case(i,j);        
                
                grille.add(c);
            }
        }
        
    }
    
    public ArrayList<Case> getGrille(){
        
        return this.grille;
        
    }

    public void fuseeEclairante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
