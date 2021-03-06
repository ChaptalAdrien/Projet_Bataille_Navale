
package Model;

import java.util.ArrayList;


public class Case {
    
    private int x;
    private int y;
    private boolean etat; // TRUE == Case non touchée / FALSE = Case touchée
    private String icone;
    
    
    public Case(int x, int y){
        
        this.x = x;
        this.y = y;
        this.etat = true;
        this.icone = " ";
        
    }

    //public String auBord() {
        
        //if(this.x == 0 && y != 14 )
        
    //}

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setEtat(boolean b){
        this.etat = b;
    }

    public boolean getEtat() {
        return etat;
    }
   
    
    public boolean bateau(Joueur joueur){
        boolean b = false;
        ArrayList<Bateau> bateaux = joueur.getBateaux();
        ArrayList<Case> position = new ArrayList<Case>();
        
        
        for (int i = 0; i < bateaux.size(); i++){
            
            position = bateaux.get(i).getPosition();
            
            for(int j = 0; j < position.size(); j++){
                
                if(position.get(j).getX() == this.x && position.get(j).getY() == this.y){
                    b = true;
                    
                    //Icone selon la type de bateau
                    if(bateaux.get(i).getTaille() == 1){
                        this.icone = "M";
                    }
                    else if(bateaux.get(i).getTaille() == 3){
                        this.icone = "D";
                    }else if(bateaux.get(i).getTaille() == 5){
                        this.icone = "C";
                    }else if(bateaux.get(i).getTaille() == 7) {
                        this.icone = "R";
                    }               
                    
                }
                if(b){                 
                        break;
                    }
                }
                
                if(b){
                    break;
                }
            }
      
        
        return b;
    }
    
    public String icone(Joueur joueur, boolean flou){
        boolean bateau = this.bateau(joueur);
        
        if(bateau && this.etat == false){
            this.icone = "X";
        }else if(bateau && flou){
            this.icone = " ";
        }else if (this.etat == false){
            this.icone = "o";
        }
        
        return this.icone;
    }
    
    
    
    
}
