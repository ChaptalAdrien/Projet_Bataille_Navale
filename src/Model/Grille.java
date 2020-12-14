package Model;

import java.util.ArrayList;


public class Grille {
    
    private Case[][] grille;
    private int tailleX;
    private int tailleY;
    
    public Grille(int tailleX, int tailleY){
        
        this.grille = new Case[tailleX][tailleY];
        
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        
        for(int i = 0; i < this.tailleX; i++){
            for(int j = 0; j < this.tailleY; j++){
                Case c = new Case(i,j);        
                
                grille[i][j] = c;
            }
        }
        
    }

    //GETTERS
    public int getTailleX() {
        return tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }
    
    public Case[][] getGrille(){
        
        return this.grille;
        
    }
    
    public Case getCase(int X, int Y){
        
        if(X > this.tailleX || Y > this.tailleY){
            return null;
        }
        
        return grille[X][Y];
    }

    
    public void fuseeEclairante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Case> toArrayList(){
        
       ArrayList<Case> arrayList = new ArrayList<Case>(); 
       
       for(int i = 0; i < this.tailleX; i++){
           for(int j = 0; j < this.tailleY; j++){
               arrayList.add(this.getCase(i,j));
           }
       }
       
       return arrayList; 
    }
    
}
