
package Controller;

import Model.*;
import View.VuePartie;
import java.util.Scanner;

public class ControllerPartie {

    private VuePartie vue;
    
    public ControllerPartie(){
        
    }
    
    //TODO : Gerer les execptions pour les valeurs de la taille de la grille 
    
    public void creerPartie() {
        
        int tailleX;
        int tailleY;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choisir la longueur de la grille (entier / recommandé : 15) :");
        tailleX = sc.nextInt();
        
        System.out.println("Choisir la hauteur de la grille (entier / recommandé : 15) :");
        tailleY = sc.nextInt();
        
        Partie partie = new Partie(tailleX, tailleY);
        
        this.vue.affichage(partie);
    }
    
}
