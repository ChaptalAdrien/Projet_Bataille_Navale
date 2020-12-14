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
        System.out.println(" 4 - Quitter ");
        
        Scanner s = new Scanner(System.in);
        
        boolean choix = false;
        int c = 0;
        
        
        while(!choix){
        
            c = s.nextInt();

            if(c >0 && c < 5){
                choix = true;
            }else{
                System.out.println("Choix non valide");
            }
        }
        ControllerMenu cMenu = new ControllerMenu(this); 
        cMenu.choixMenuConsole(c);
    }
    
}
