
package View;

import Controller.ControllerPartie;
import Model.Grille;

import Model.Partie;
import java.util.Scanner;




public class VuePartie {
        
    
    private ControllerPartie cPartie;
    
    public VuePartie(ControllerPartie cp){
        this.cPartie = cp;
    }
    
    public void affichage(Partie partie){
        
        Scanner s = new Scanner(System.in);
        int choix;
        
        this.afficherGrilles(partie);
        
        
        System.out.println("Choississez une action : ");
        System.out.println("1 - Deplacer un bateau");
        System.out.println("2 - Tirer");
        
        choix = s.nextInt();
        
        do{
            if(choix == 1){
                this.cPartie.J1Deplacer();
            }
            else if(choix == 2){
                this.cPartie.J1tirrer();
            }
            else{
                System.out.println("Veuillez rentrer une valeur valide");
            }
            
        }while(choix !=1 || choix!=2);
        
        this.cPartie.OrdiTirer();
        
    }
    
    
    public void afficherGrilles(Partie partie){
        
        String grille;
        String icone;
        
        Grille grilleJoueur = partie.getJ1().getGrille();
        Grille grilleOrdi = partie.getOrdi().getGrille();
        int tailleX = grilleJoueur.getTailleX();
        int tailleY = grilleJoueur.getTailleY();
        
        System.out.println("\n" + "Legende : o - bateau | ¤ - Bateau touché | x - case touchée " + "\n");
        
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
                
                icone = grilleJoueur.getCase(j,i).icone(partie.getJ1(), false);
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
                
                icone = grilleOrdi.getCase(j,i).icone(partie.getOrdi(), true);
                grille +=  "[" + icone + "]";
                
            }
        }
        
        grille += "\n";
        System.out.println(grille);
        
    }
    
}
