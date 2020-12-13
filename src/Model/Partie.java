
package Model;

import java.time.LocalDate;


public class Partie {
    
    private J1 j1;
    private Ordinateur ordi;
    private int id;
    private LocalDate date;
    
    //CONSTRUCTEUR
    
    public Partie(int tailleX, int tailleY){
        
        this.j1 = new J1(tailleX, tailleY);
        this.ordi = new Ordinateur(tailleX, tailleY);
        this.id = (int) Math.random()*100;
        
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
    
    
}
