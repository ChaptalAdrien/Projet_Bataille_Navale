
package Controller;

import Model.*;
import View.VuePartie;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerPartie {

    private VuePartie vue;
    private Partie model;
    
    public ControllerPartie(){
        this.vue = new VuePartie(this);
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
        this.model = partie;
        
        partie.getJ1().initBateau();
        partie.getOrdi().initBateau();
                
        
        this.vue.affichage(partie);
    }

    public void J1Deplacer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void J1tirrer() {
        Scanner s = new Scanner(System.in);
        int x;
        int y;
        int tailleX = model.getJ1().getGrille().getTailleX();
        int tailleY = model.getJ1().getGrille().getTailleY(); 
        
        ArrayList<Bateau> bateaux = model.getJ1().getBateaux();
        
        for(int i = 0; i < bateaux.size(); i++){
            
            System.out.println("Tir avec un " + bateaux.get(i).getType());
            System.out.println(("Choissez la case visée : (X,Y)"));
            
            do{
            
                System.out.println("X = ");
                x = s.nextInt();
                
                if(x < 0 || x > tailleX){
                    System.out.println("Choissisez une valeur valide pour x");
                }
                
            }while(x < 0 || x > tailleX);    
                
            do{
            
                System.out.println("Y = ");
                y = s.nextInt();
                
                if(y < 0 || y > tailleY){
                    System.out.println("Choissisez une valeur valide pour Y");
                }
                
            }while(y < 0 || y > tailleY);         

            Case c = new Case(x,y);
            
            this.model.getJ1().tirer(this.model, bateaux.get(i), c);
            vue.afficherGrilles(model);
        }
        
        
    }

    public void OrdiTirer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
