
package Model;

public class Ordinateur extends Joueur {
    
   private int difficulty;
    
    public Ordinateur(int tailleX, int tailleY){
        
        super(tailleX, tailleY);
        this.difficulty = 1;
    }
    
    public Joueur getAdversaire(Partie p){
       return p.getJ1();
   }
}
