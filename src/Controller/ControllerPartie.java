
package Controller;

import Model.*;
import View.VuePartie;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerPartie {

    private VuePartie vue;
    private Partie model;
    
    public ControllerPartie(boolean debug){
        this.vue = new VuePartie(this, debug);
    }
    
    //TODO : Gerer les execptions pour les valeurs de la taille de la grille 
    
    public void creerPartie() throws InterruptedException {
        
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
                
        this.execPartie(); 
        
    }
    
    public void execPartie() throws InterruptedException{
        
        int nTour = 0;
        
        while(!model.estTermine()){
            this.vue.affichage(model);
            nTour++;
        }
        
        this.vue.finPartie(nTour, this.model.getvictoire());
        
    }
    
    public void J1Deplacer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void J1tirrer() throws InterruptedException {
        
        boolean fusee = false;
        boolean finPartie;
        Scanner s = new Scanner(System.in);
        J1 joueur = this.model.getJ1();
        int x;
        int y;
        int tailleX = joueur.getGrille().getTailleX();
        int tailleY = joueur.getGrille().getTailleY(); 
        ArrayList<Case> casesTouchee = new ArrayList<Case>();
        
        
        
        ArrayList<Bateau> bateaux = joueur.getBateaux();
        
        for(int i = 0; i < bateaux.size(); i++){
            
            if(bateaux.get(i).getType() == "Destroyer"){
                    
                    Destroyer d = (Destroyer) bateaux.get(i);
                    
                    fusee = d.getFusee();
                    
                }
            
            
            if(!bateaux.get(i).getCoule()){
            
                    System.out.println("Tir avec un " + bateaux.get(i).getType());
                    System.out.println(("Choissez la case visée : (X,Y)"));

                do{

                    System.out.println("X = ");
                    x = s.nextInt();

                    if(x < 0 || x > tailleX - 1){
                        System.out.println("Choissisez une valeur valide pour x");
                    }

                }while(x < 0 || x > tailleX - 1);    

                do{

                    System.out.println("Y = ");
                    y = s.nextInt();

                    if(y < 0 || y > tailleY - 1){
                        System.out.println("Choissisez une valeur valide pour Y");
                    }

                }while(y < 0 || y > tailleY - 1);         

                Case c = new Case(x,y);

                if(joueur.tirer(this.model, bateaux.get(i), c)){
                    this.model.setFinPartie(true);
                    this.model.setVictoire(true);
                    return;
                }
                
                if(bateaux.get(i).getType() == "Destroyer"){
                    
                    Destroyer d = (Destroyer) bateaux.get(i);
                    
                    if(d.getFusee()){
                        
                    }
                    
                }
                
                
                if(fusee){
                    this.vue.afficherGrillesFusee(this.model);
                }else{
                    this.vue.afficherGrilles(this.model);
                }
                
                
            }
        }
        
        
        
    }
    

    public void OrdiTirer() throws InterruptedException{
        
        int x;
        int y;
        int tailleX = model.getOrdi().getGrille().getTailleX();
        int tailleY = model.getOrdi().getGrille().getTailleY(); 
        
        ArrayList<Bateau> bateaux = model.getOrdi().getBateaux();
        
        for(int i = 0; i < bateaux.size(); i++){
            
            System.out.println("L'adversaire ajuste son tir ...");
            Thread.sleep(1000);
            
            x =(int) (Math.random() * (tailleX - 1)); 

            y = (int) (Math.random() * (tailleY - 1)); 
            
            System.out.println("L'Adversaire tirre avec un " + bateaux.get(i).getType() + " à la case : " + x + ", " + y);
            Thread.sleep(1000);
            
            Case c = new Case(x,y);
            
            this.model.getOrdi().tirer(this.model, bateaux.get(i), c);
           
        }
    }
    
    
}


