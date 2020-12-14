
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
        
        int tailleX = 15;
        int tailleY = 15;
        boolean tailleValide = false;
        Scanner sc = new Scanner(System.in);
        
        while(!tailleValide){
            System.out.println("Choisir la longueur du coté de la grille carrée (entier / minimum : 10) :");
            tailleX = sc.nextInt();
            tailleY = tailleX;
            
            if(tailleX < 10){
                System.out.println("Cette taille n'est pas valide. Entrez une autre valeur");
            }else{
                tailleValide = true;
            }
        
        }
        
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
    
    public void J1Deplacer() throws InterruptedException {
        ArrayList<Bateau> bateaux = this.model.getJ1().getBateaux();
        J1 joueur = this.model.getJ1();
        ArrayList<String> options = new ArrayList<String>();
        int nbateau = 0;
        int n = 0;
        
        for(int i = 0; i < bateaux.size(); i++){
            
            
            if(!bateaux.get(i).touche()){
                nbateau++;
                System.out.println("Deplacement du " + bateaux.get(i).getType());
                
                if(joueur.verifDeplacement(bateaux.get(i), true)){

                    if(bateaux.get(i).getOrientation()){
                        n++;
                        options.add("sud"); 
                        
                    }
                    if(!bateaux.get(i).getOrientation()){
                        options.add("gauche");
                    } 
                }
                if(joueur.verifDeplacement(bateaux.get(i), false)){

                    if(bateaux.get(i).getOrientation()){
                        n++;
                        options.add("nord");
                        
                    }
                    if(!bateaux.get(i).getOrientation()){
                        options.add("droite");
                    } 
                }    
            
                for(int j = 0; j < options.size(); j++){
                    System.out.println(j + 1 + " - " + options.get(j));
                }
                
                System.out.println("5 - Ne pas deplacer ce bateau");
                
                Scanner s = new Scanner(System.in);
                int choix = s.nextInt();
                
                if(choix != 5){
                    
                    if(options.get(choix).equalsIgnoreCase("sud") || options.get(choix).equalsIgnoreCase("gauche")){
                        joueur.deplacerBateau(bateaux.get(i), true);
                    }else{
                        joueur.deplacerBateau(bateaux.get(i), false);
                    }
                }
                
            }

        }
        
        if(nbateau == 0){
            System.out.println("Aucun Bateau ne peut être déplacé !");
        }else{
            System.out.println("Fin du déplacement des bateaux ! Vous allez pouvoir tirer !");
        }
            System.out.println("Vos bateaux chargent les canons ...");
            Thread.sleep(1500);
            
            this.J1tirrer();
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


