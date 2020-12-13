package Model;

import java.util.ArrayList;
import java.util.Random;


public abstract class Joueur {
    
    protected Grille grillePerso;
    protected Joueur adversaire;
    protected ArrayList<Bateau> bateaux;

    
    //CONSTRUCTOR
    public Joueur(int tailleX, int tailleY){
        this.grillePerso = new Grille(tailleX, tailleY);
        this.bateaux = new ArrayList<Bateau>();
        
        
    }

    public Grille getGrillePerso() {
        return grillePerso;
    }

    public ArrayList<Bateau> getBateaux() {
        return bateaux;
    }
    
    public Joueur getAdversaire(){
        return this.adversaire;
    }

    public Grille getGrille() {
        return this.grillePerso;
    }

    public void initBateau(){
        
        ArrayList<Case> caseDisponibles = this.grillePerso.toArrayList();
        
        //Creation cuirasse
        Cuirasse cuirasse = new Cuirasse();
        this.bateaux.add(cuirasse);
        caseDisponibles = this.PositionnerBateau(cuirasse, caseDisponibles);
        
        //Creation croiseurs
        Croiseur croiseur1 = new Croiseur();
        Croiseur croiseur2 = new Croiseur();
        
        this.bateaux.add(croiseur1);
        this.bateaux.add(croiseur2);
        
        //Creation Destroyer
        Destroyer destroyer1 = new Destroyer();
        Destroyer destroyer2 = new Destroyer();
        Destroyer destroyer3 = new Destroyer();
        
        this.bateaux.add(destroyer1);
        this.bateaux.add(destroyer2);
        this.bateaux.add(destroyer3);
        
        caseDisponibles = this.PositionnerBateau(croiseur1, caseDisponibles);
        caseDisponibles = this.PositionnerBateau(croiseur2, caseDisponibles);
        
        caseDisponibles = this.PositionnerBateau(destroyer1, caseDisponibles);
        caseDisponibles = this.PositionnerBateau(destroyer2, caseDisponibles);
        caseDisponibles = this.PositionnerBateau(destroyer3, caseDisponibles);
        
        //Creation sous marins
        SousMarin sousMarin1 = new SousMarin();
        SousMarin sousMarin2 = new SousMarin();
        SousMarin sousMarin3 = new SousMarin();
        SousMarin sousMarin4 = new SousMarin();
        
        this.bateaux.add(sousMarin1);
        this.bateaux.add(sousMarin2);
        this.bateaux.add(sousMarin3);
        this.bateaux.add(sousMarin4);
        
        caseDisponibles = this.PositionnerBateau(sousMarin1, caseDisponibles);
        caseDisponibles = this.PositionnerBateau(sousMarin2, caseDisponibles);
        caseDisponibles = this.PositionnerBateau(sousMarin3, caseDisponibles);
        caseDisponibles = this.PositionnerBateau(sousMarin4, caseDisponibles);
        
    }
    
    public ArrayList<Case> PositionnerBateau(Bateau bateau, ArrayList<Case> casesDisponibles){
        
        Case origine;
        Case c;
        int n;
        boolean direction; //1 = vertical / 2= Horizontal
        Random r = new Random();
        ArrayList<Case> position = new ArrayList<Case>();
        
        direction = r.nextBoolean();
        n = (int) (Math.random() * ( casesDisponibles.size() - 1 ));
        
        origine = casesDisponibles.get(n);
        
          
        if(direction == true && bateau.taille > (this.grillePerso.getTailleY() - origine.getY())){
                
            for(int i = 0; i < bateau.getTaille(); i++){
                c =this.grillePerso.getCase(origine.getX(), origine.getY()-i);
                position.add(c);
                casesDisponibles.remove(c);
                
            }
        }else if (direction == true){
            
            for(int i = 0; i < bateau.getTaille(); i++){
                
                c = this.grillePerso.getCase(origine.getX(), origine.getY()+i);
                position.add(c);
                casesDisponibles.remove(c);
            }
            
        }else if(direction == false && bateau.taille > (this.grillePerso.getTailleX() - origine.getX())){
                
            for(int i = 0; i < bateau.getTaille(); i++){
                
                c = this.grillePerso.getCase(origine.getX()-i, origine.getY());
                position.add(c);
                casesDisponibles.remove(c);
            }
        }else{
            
            for(int i = 0; i < bateau.getTaille(); i++){
                
                c = this.grillePerso.getCase(origine.getX()+i, origine.getY());
                position.add(c);
                casesDisponibles.remove(c);
            } 
 
        }
        
        bateau.setPosition(position);
        return casesDisponibles;
    }
    
}
