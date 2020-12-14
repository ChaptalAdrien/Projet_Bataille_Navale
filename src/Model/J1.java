
package Model;


public class J1 extends Joueur {
    
    
    public J1(int tailleX, int tailleY){
        super(tailleX, tailleY);
    }
    
   public Joueur getAdversaire(Partie p){
       return p.getOrdi();
   }
    
}
