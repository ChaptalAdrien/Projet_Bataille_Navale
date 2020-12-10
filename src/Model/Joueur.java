package Model;

import java.util.ArrayList;


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
        
        Croiseur croiseur = new Croiseur();
        Cuirasse cuirasse = new Cuirasse();
        Destroyer destroyer = new Destroyer();
        SousMarin sousMarin = new SousMarin();
        
        //Ajout des bateaux
        this.bateaux.add(croiseur);
        this.bateaux.add(cuirasse);
        this.bateaux.add(destroyer);
        this.bateaux.add(sousMarin);
        
        
        caseDisponibles = this.PositionnerBateau(croiseur, caseDisponibles);
        caseDisponibles = this.PositionnerBateau(cuirasse, caseDisponibles);
        caseDisponibles = this.PositionnerBateau(destroyer, caseDisponibles);
        caseDisponibles = this.PositionnerBateau(sousMarin, caseDisponibles);
    }
    
    public ArrayList<Case> PositionnerBateau(Bateau bateau, ArrayList<Case> casesDisponibles){
        
        Case origine;
        Case c;
        int n;
        int direction; //1 = vertical / 2= Horizontal
        ArrayList<Case> position = new ArrayList<Case>();
        
        direction = (int) (Math.random() * (1 - 0));
        n = (int) (Math.random() * ( casesDisponibles.size() - 1 ));
        
        origine = casesDisponibles.get(n);
        
          
        if(direction == 1 && bateau.taille > (this.grillePerso.getTailleY() - origine.getY())){
                
            for(int i = 0; i < bateau.getTaille(); i++){
                c =this.grillePerso.getCase(origine.getX(), origine.getY()-i);
                position.add(c);
                casesDisponibles.remove(c);
                
            }
        }else if (direction == 1){
            
            for(int i = 0; i < bateau.getTaille(); i++){
                
                c = this.grillePerso.getCase(origine.getX(), origine.getY()+i);
                position.add(c);
                casesDisponibles.remove(c);
            }
            
        }else if(direction == 0 && bateau.taille > (this.grillePerso.getTailleX() - origine.getX())){
                
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
