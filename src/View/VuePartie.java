
package View;

import Controller.ControllerPartie;
import Model.Grille;

import Model.Partie;
import java.util.Scanner;




public class VuePartie {
        
    private boolean debug;
    private ControllerPartie cPartie;
    
    public VuePartie(ControllerPartie cp, boolean debug){
        this.cPartie = cp;
        this.debug = debug;
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
        System.out.println("1 - Deplacer un bateau (Non Disponible)");
        System.out.println("2 - Tirer");
        
        
        
        do{
            
            choix = s.nextInt();
            
            if(choix == 1){
                //System.out.println("Fonctionnalité indisponible pour l'instant.");
               // System.out.println("Veuillez selectionner une autre option.");
                this.cPartie.J1Deplacer();
                
            }
            else if(choix == 2){
                this.cPartie.J1tirrer();
                choixValide = true;
            }
            else{
                System.out.println("Veuillez rentrer une valeur valide");
            }
            
        }while(!choixValide);
        
        if(!partie.getFinPartie()){
            this.cPartie.OrdiTirer();
        }
    }
    
    
    public void afficherGrilles(Partie partie){
        
        String grille;
        String icone;
        
        Grille grilleJoueur = partie.getJ1().getGrille();
        Grille grilleOrdi = partie.getOrdi().getGrille();
        int tailleX = grilleJoueur.getTailleX();
        int tailleY = grilleJoueur.getTailleY();
        
        System.out.println("\n" + "Legende : X - Bateau touché | o - coup dans l'eau " + "\n");
        
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
                
                
                icone = grilleOrdi.getCase(j,i).icone(partie.getOrdi(), !debug);
                grille +=  "[" + icone + "]";
                
            }
        }
        
        grille += "\n";
        System.out.println(grille);
        
        
    }
    
    public void afficherGrillesFusee(Partie partie){
        String grille;
        String icone;
        
        Grille grilleJoueur = partie.getJ1().getGrille();
        Grille grilleOrdi = partie.getOrdi().getGrille();
        int tailleX = grilleJoueur.getTailleX();
        int tailleY = grilleJoueur.getTailleY();
        
         boolean f = true;
        
        System.out.println("\n" + "Legende : X - Bateau touché | o - coup dans l'eau " + "\n");
        
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
                
               
                if(debug){
                    f = false;
                }else{
                    f=!(i < 5 && j < 5);
                }
                
                icone = grilleOrdi.getCase(j,i).icone(partie.getOrdi(), f);
                grille +=  "[" + icone + "]";
                
            }
        }
        
        grille += "\n";
        System.out.println(grille);
    }


    public void finPartie(int nTour, boolean victoire) {
        
        if(victoire){
            System.out.println("\n");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                          FELICITATION                                        ");
            System.out.println("              vous avez gagné en " + nTour + " tours. Bien joué !");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("\n" + " Merci d'avoir joué à notre projet Bataille Navale");
            
        }else{
            System.out.println("\n");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                          DOMMAGE                                        ");
            System.out.println("  L'adversaire vous as battu en " + nTour + " tours. Retentez votre chance !");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("\n" + " Merci d'avoir joué à notre projet Bataille Navale");            
        }
        
        
        
        
    }
    
    
}
