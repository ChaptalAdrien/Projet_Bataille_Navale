package View;

import java.util.Scanner;
import Controller.ControllerMenu;

public class VueMenu {
    
    
   
    
    public void afficherMenuConsole() throws InterruptedException{
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("                       << BIENVENUE SUR LE JEU BATAILLE NAVALE >>                      ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                                Choisissez une action                                  ");
        System.out.println("");
        System.out.println(" 1 - Lancer une Partie ");
        System.out.println(" 2 - Charger une Partie (Non disponible)");
        System.out.println(" 3 - Mode Demo ");
        System.out.println(" 4 - Aide ");
        System.out.println(" 5 - Quitter ");
        
        Scanner s = new Scanner(System.in);
        
        boolean choix = false;
        int c = 0;
        
        
        while(!choix){
        
            c = s.nextInt();

            if(c >0 && c < 6){
                choix = true;
            }else{
                System.out.println("Choix non valide");
            }
        }
        ControllerMenu cMenu = new ControllerMenu(this); 
        cMenu.choixMenuConsole(c);
    }
 
    
    public void aide() throws InterruptedException{
        
        System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("                             AIDE                                    ");
            System.out.println("              Bienvenue sur le jeu Bataille Navale !");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------");
            
            System.out.println("Ce jeu utilise les reègles classique  d'une bataille navale.");
            System.out.println("\n" + "Au début de chaque partie, vous pouvez choisir la taille de la grille.");
            
            System.out.println("Vous jouez contre un adversaire controllé par l'ordinateur. Chacun des joueurs possède une grille sur laquelle ses bateaux sont placés aleatoirement en début de partie.");
            System.out.println("");
            System.out.println("Le but du jeu est de couler la flotte de votre adversaire. Pour cela, vous pouvez tirer avec l'ensemble de votre flotte, à chaque tour.");
            System.out.println("Votre flotte est composée des bateaux suivant : ");
            System.out.println("1 Cuirassé : de taille 7, il a une puissance de feu de 9 cases. Il est affiché par le signe R dans la grille.");
            System.out.println("2 Croiseur : de taille 5, il a une puissance de feu de 5 cases. Il sont affichés par le signe C dans la grille.");
            System.out.println("4 Destroyer : de taille 3, il a une puissance de feu de 1 case. Il sont affichés par le signe D dans la grille.");
            System.out.println("4 Sous-Marins : de taille 1, il a une puissance de feu de 1 case. Il sonts affichés par le signe M sur la grille.");
            System.out.println("Au premier tir du premier destroyer, une Fusée éclérante est envoyé par le bateau pour afficher une partie de la grille de l'adversaire.");
            
            System.out.println("Une fois que vous avez tiré avec votre flotte, c'est au tour de l'adversire de tirer avec ses bateaux.");
            System.out.println("La partie est terminée lorsque la flotte d'un des deux joueurs à été completement coulée.");
            
            int c = -1;
            Scanner s = new Scanner(System.in);
            System.out.println("");
            System.out.println("Bonne Chance !");
            System.out.println("");
            System.out.println("Entrez 0 pour retourner au menu");
            
            while(c != 0){
                c = s.nextInt();
                if(c !=0){
                    System.out.print("Entrez 0 pour revenir au menu");
                }
            }
            
            this.afficherMenuConsole();
            
    }
    
}
