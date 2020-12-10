
package View;

import Controller.ControllerPartie;
import Model.Grille;
import Model.Partie;




public class VuePartie {
    
    private static final String VIOLET = "\u001B[35m";
    
    public void affichage(Partie partie){
        
        String grille = "";
        String icone = "";
        
        Grille grilleJoueur = partie.getJ1().getGrille();
        Grille grilleOrdi = partie.getOrdi().getGrille();
        int tailleX = grilleJoueur.getTailleX();
        int tailleY = grilleJoueur.getTailleY();
        
        System.out.println("---------- Grille du Joueur ----------");
        
        grille = "    ";
        
        for(int k = 0; k < tailleY; k++ ){
            grille += k;
            
            if (k >= 9){
                grille += " ";
                
            }else{
                grille += "  ";
            }
        }
        
        for(int i=0; i < tailleX; i++){
            
            grille += "\n" + i;
            
            if (i < 10 ){
                 grille+= "  ";
            }else{
                grille += " ";
            }
       
            
            for(int j=0; j < tailleY; j++) {
                
                icone = grilleJoueur.getCase(i,j).icone(partie.getJ1());
                grille +=  "[" + icone + "]";
                
            }
        }
        
        grille += "\n";
        System.out.println(grille);
        
        System.out.println("---------- Grille Adversaire ----------");
        
                grille = "    ";
        
        for(int k = 0; k < tailleY; k++ ){
            grille += k;
            
            if (k >= 9){
                grille += " ";
                
            }else{
                grille += "  ";
            }
        }
        
        for(int i=0; i < tailleX; i++){
            
            grille += "\n" + i;
            
            if (i < 10 ){
                 grille+= "  ";
            }else{
                grille += " ";
            }
       
            
            for(int j=0; j < tailleY; j++) {
                
                icone = grilleOrdi.getCase(i,j).icone(partie.getJ1());
                grille +=  "[" + icone + "]";
                
            }
        }
        
        grille += "\n";
        System.out.println(grille);
        
    }

    
}
