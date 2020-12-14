package Model;

import java.util.ArrayList;

public class Destroyer extends Bateau {
    

    private boolean fusee;
    
    public Destroyer(String type){
        
        super(type);
        this.taille = 3;
        this.fusee = true;
        this.coule = false;
    }
    
    public ArrayList<Case> tirer(Case c, Grille g){
        
        if(fusee){
            this.fusee = false; //au premier tir on tire la fusée
        }
        
        return super.tirer(c, g);
    
    }
    
    public boolean getFusee(){
        return this.fusee;
    }
    
}
