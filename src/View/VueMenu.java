package View;

import java.util.Scanner;
import Controller.ControllerMenu;

public class VueMenu {
    
    
   
    
    public void afficherMenuConsole(){
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("                       << BIENVENUE SUR LE JEU BATAILLE NAVALE >>                      ");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("                                Choisissez une action                                  ");
        System.out.println("");
        System.out.println(" 1 - Lancer une Partie ");
        System.out.println(" 2 - Charger une Partie ");
        System.out.println(" 3 - Quitter ");
        
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        
        ControllerMenu cMenu = new ControllerMenu(this); 
        cMenu.choixMenuConsole(c);
    }
    
}
