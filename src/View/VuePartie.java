
package View;

import Controller.ControllerPartie;
import Model.Grille;

import Model.Partie;
import java.util.Scanner;




public class VuePartie {
        
    private boolean debug;
    private ControllerPartie cPartie;
    
    public VuePartie(ControllerPartie cp){
        this.cPartie = cp;
        this.debug = false;
    }
    
    public void setDebug(boolean b){
        this.debug = b;
    }
    
    public void affichage(Partie partie) throws InterruptedException{
        
        Scanner s = new Scanner(System.in);
        int choix;
        boolean choixValide = false;
        
        this.afficherGrilles(partie);
        
        
        System.out.println("Choississez une action : ");
        System.out.println("1 - Deplacer un bateau");
        System.out.println("2 - Tirer");
        
        choix = s.nextInt();
        
        do{
            if(choix == 1){
                this.cPartie.J1Deplacer();
                choixValide = true;
            }
            else if(choix == 2){
                this.cPartie.J1tirrer();
                choixValide = true;
            }
            else{
                System.out.println("Veuillez rentrer une valeur valide");
            }
            
        }while(!choixValide);
        
        this.cPartie.OrdiTirer();
        
    }
    
    
    public void afficherGrilles(Partie partie){
        
        String grille;
        String icone;
        
        Grille grilleJoueur = partie.getJ1().getGrille();
        Grille grilleOrdi = partie.getOrdi().getGrille();
        int tailleX = grilleJoueur.getTailleX();
        int tailleY = grilleJoueur.getTailleY();
        
        System.out.println("\n" + "Legende : X - Bateau touché | ° - coup dans l'eau " + "\n");
        
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
