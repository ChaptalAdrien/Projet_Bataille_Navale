
package Model;

import java.time.LocalDate;


public class Partie {
    
    private J1 j1;
    private Ordinateur ordi;
    private int id;
    private LocalDate date;
    private boolean finPartie;
    private boolean victoire;
    
    //CONSTRUCTEUR
    
    public Partie(int tailleX, int tailleY){
        
        this.j1 = new J1(tailleX, tailleY);
        this.ordi = new Ordinateur(tailleX, tailleY);
        this.id = (int) Math.random()*100;
        this.finPartie = false;
        
    }
    
    //GETTERS
    public J1 getJ1() {
        return j1;
    }

    public Ordinateur getOrdi() {
        return ordi;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean estTermine() {
        return finPartie;
    }
    
    public boolean getvictoire(){
        return victoire;
    }
    
    public boolean getFinPartie(){
        return this.finPartie;
    }
    
    public void setFinPartie(boolean finPartie){
        this.finPartie = finPartie;
    }
    
    public void setVictoire(boolean b){
        this.victoire = b;
    }
    
}
