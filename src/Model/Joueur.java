package Model;

import java.util.ArrayList;
import java.util.Random;


public abstract class Joueur {
    
    protected Grille grillePerso;
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
    
    public abstract Joueur getAdversaire(Partie p);

    public Grille getGrille() {
        return this.grillePerso;
    }

    public void initBateau(){
        
        ArrayList<Case> caseDisponibles = this.grillePerso.toArrayList();
        
        //Creation cuirasse
        Cuirasse cuirasse = new Cuirasse("Cuirasse");
        this.bateaux.add(cuirasse);
        caseDisponibles = this.PositionnerBateau(cuirasse, caseDisponibles);
        
        //Creation croiseurs
        Croiseur croiseur1 = new Croiseur("Croiseur");
        //Croiseur croiseur2 = new Croiseur("Croiseur");
        
        this.bateaux.add(croiseur1);
        //this.bateaux.add(croiseur2);
        
        //Creation Destroyer
        Destroyer destroyer1 = new Destroyer("Destroyer");
        //Destroyer destroyer2 = new Destroyer("Destroyer");
        //Destroyer destroyer3 = new Destroyer("Destroyer");
        
        this.bateaux.add(destroyer1);
        //this.bateaux.add(destroyer2);
        //this.bateaux.add(destroyer3);
        
        caseDisponibles = this.PositionnerBateau(croiseur1, caseDisponibles);
        //caseDisponibles = this.PositionnerBateau(croiseur2, caseDisponibles);
        
        caseDisponibles = this.PositionnerBateau(destroyer1, caseDisponibles);
        //caseDisponibles = this.PositionnerBateau(destroyer2, caseDisponibles);
        //caseDisponibles = this.PositionnerBateau(destroyer3, caseDisponibles);
        
        //Creation sous marins
        SousMarin sousMarin1 = new SousMarin("Sous-Marin");
        //SousMarin sousMarin2 = new SousMarin("Sous-Marin");
        //SousMarin sousMarin3 = new SousMarin("Sous-Marin");
        //SousMarin sousMarin4 = new SousMarin("Sous-Marin");
        
        this.bateaux.add(sousMarin1);
        //this.bateaux.add(sousMarin2);
        //this.bateaux.add(sousMarin3);
        //this.bateaux.add(sousMarin4);
        
        caseDisponibles = this.PositionnerBateau(sousMarin1, caseDisponibles);
        //caseDisponibles = this.PositionnerBateau(sousMarin2, caseDisponibles);
        //caseDisponibles = this.PositionnerBateau(sousMarin3, caseDisponibles);
        //caseDisponibles = this.PositionnerBateau(sousMarin4, caseDisponibles);
        
    }
    
    public ArrayList<Case> PositionnerBateau(Bateau bateau, ArrayList<Case> casesDisponibles){
        
        Case origine;
        Case c;
        int n;
        boolean direction; //1 = vertical / 0 = Horizontal
        
        Random r = new Random();
        ArrayList<Case> position = new ArrayList<Case>();
        ArrayList<Case> copieCasesDispo = new ArrayList<Case>(); //
        boolean positionValide = false;
        
        while(!positionValide){
            
            position.clear();
            copieCasesDispo = (ArrayList<Case>) casesDisponibles.clone();

            direction = r.nextBoolean();
            bateau.setOrientation(direction);
            n = (int) (Math.random() * ( casesDisponibles.size() - 1 ));

            origine = casesDisponibles.get(n);
            

            if(direction == true && bateau.taille > (this.grillePerso.getTailleY() - origine.getY())){

                for(int i = 0; i < bateau.getTaille(); i++){
                    c = this.grillePerso.getCase(origine.getX(), origine.getY()-i);
                    position.add(c);
                    copieCasesDispo.remove(c);

                }
            }else if (direction == true){

                for(int i = 0; i < bateau.getTaille(); i++){

                    c = this.grillePerso.getCase(origine.getX(), origine.getY()+i);
                    position.add(c);
                    copieCasesDispo.remove(c);
                }

            }else if(direction == false && bateau.taille > (this.grillePerso.getTailleX() - origine.getX())){

                for(int i = 0; i < bateau.getTaille(); i++){

                    c = this.grillePerso.getCase(origine.getX()-i, origine.getY());
                    position.add(c);
                    copieCasesDispo.remove(c);
                }
            }else{

                for(int i = 0; i < bateau.getTaille(); i++){

                    c = this.grillePerso.getCase(origine.getX()+i, origine.getY());
                    position.add(c);
                    copieCasesDispo.remove(c);
                } 

            }

            
            for(int i = 0; i < bateau.getTaille(); i++){
                if(casesDisponibles.indexOf(position.get(i)) == -1){
                    positionValide = false;
                    break;
                }
                
                positionValide = true;
            }
            
            
        }
        
        bateau.setPosition(position);
        
        
        casesDisponibles = (ArrayList<Case>) copieCasesDispo.clone();
        
        return casesDisponibles;
    }
    
    public boolean tirer(Partie p, Bateau bateau, Case c) throws InterruptedException{
        boolean finPartie;
        int x;
        int y;
        
        Grille grilleVisee = this.getAdversaire(p).getGrille();
        
        ArrayList<Case> caseTouchees = bateau.tirer(c, grilleVisee);
        
        for(int i = 0; i < caseTouchees.size(); i++){
            x = caseTouchees.get(i).getX();
            y = caseTouchees.get(i).getY();
            
            grilleVisee.getCase(x, y).setEtat(false);
        }
        
       finPartie = this.impact(this.getAdversaire(p), caseTouchees); 
        
       return finPartie; 
        
    }
    
    public boolean impact(Joueur j, ArrayList<Case> casesTouchee) throws InterruptedException{
        ArrayList<Bateau> bateaux = j.getBateaux();
        int compteurTouche= 0;
        boolean finPartie = false;
        int compteurCoule = 0;
        
        
        for(int i = 0; i < bateaux.size(); i++){
            
            if(!bateaux.get(i).getCoule()){
                
                if(bateaux.get(i).estTouche(casesTouchee)){
                    System.out.println("Touché !");
                    compteurTouche ++;
                }
            
                if(bateaux.get(i).getCoule()){
                    
                    System.out.println(bateaux.get(i).getType() + " coulé !");
                    compteurCoule ++;
                    
                }

            }else{
                compteurCoule++;
            }
            
        }
        
        //aucun bateau touché
        if(compteurTouche == 0){
            System.out.println("Coup dans l'eau !");
        }
        
        if(compteurCoule == bateaux.size()){
            finPartie = true;
        }
        
        Thread.sleep(1500);
        
        return finPartie;
    }
    
    
}
