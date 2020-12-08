package Model;

import java.util.ArrayList;

public abstract class Bateau {
    
    protected ArrayList<Case> position;
    protected boolean coule;
    
    
    public ArrayList<Case> getPosition(){
        return this.position;
    }
    
    
    //Méthode de tir du bateau pour les bateau qui ne touchent qu'une seule case
    //La méthode prend en paramétre la case visée
    //Elle renvoie la case dans une ArrayList
    public ArrayList<Case> tirer(Case c){
        
        ArrayList<Case> caseTouchee = new ArrayList<Case>();
        caseTouchee.add(c);
        return caseTouchee;
    }
    
    //Méthode qui verifie si les cases du bateau ont été touchée par un tir
    //Paramètres : ArrayList des cases visées
    //Elle lance la méthode UpdateEtat qui va verifier si le bateau à été coulé ou non
    public void estTouchee(ArrayList<Case> casesTouchee){
        
        for(int i = 0; i < casesTouchee.size(); i++){
            
            for(int j = 0; j < this.position.size(); j++){
                
                if (casesTouchee.get(i).getX() == this.position.get(j).getX() && casesTouchee.get(i).getY() == this.position.get(j).getY()){ //Si la case touchee a les meme coordonées qu'une case du bateau
                
                    this.position.get(j).setEtat(false);
                
                }
            }
        }
        
        this.updateEtat();
        
    }
    
    //Passe le boolean coulé sur vrai si toute les cases du bateau ont été touchées
    public void updateEtat(){
        
        int n = 0; //compte les cases touchées
        
        for(int i = 0; i < this.position.size(); i++){    
            if(!this.position.get(i).getEtat()){
                n ++;
            }   
        }
        
        if(n == this.position.size()){
            this.coule = true;
        }
        
    }

}
