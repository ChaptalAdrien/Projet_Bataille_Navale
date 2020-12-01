
package Model;


public class Case {
    
    private int x;
    private int y;
    private boolean etat; // TRUE == Case non touchée / FALSE = Case touchée
    
    
    public Case(int x, int y){
        
        this.x = x;
        this.y = y;
        this.etat = true;
        
    }

    //public String auBord() {
        
        //if(this.x == 0 && y != 14 )
        
    //}

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setEtat(boolean b){
        this.etat = b;
    }

    boolean getEtat() {
        return etat;
    }
   
    
}
