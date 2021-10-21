/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;
import java.util.*; 

/**
 *classe world du tp4
 * @author uble, zgchung
 */
public class World2 {
    HashMap<Integer, Creature> listCreature; 
    HashMap<Integer, Objet> listObjet; 
    HashMap<Integer, Joueur> listJoueurs;
    Integer mondeLongueur;
    Integer mondeLargeur;
    public Creature[][] tabCreature;
    public LinkedList<Objet>[][] tabObj;
    public String[][] map;
    
    Random generateurAleatoire = new Random();

    public Integer getMondeLongueur() {
        return mondeLongueur;
    }

    public void setMondeLongueur(Integer mondeLongueur) {
        this.mondeLongueur = mondeLongueur;
    }

    public Integer getMondeLargeur() {
        return mondeLargeur;
    }

    public void setMondeLargeur(Integer mondeLargeur) {
        this.mondeLargeur = mondeLargeur;
    }

    /**
     *constructeur avec listes
     * @param tailleMonde
     */
    public World2(HashMap<Integer, Creature> listCreature, HashMap<Integer, Objet> listObjet,HashMap<Integer, Joueur> listJoueurs, int longueur, int largeur) {
        this.listCreature = listCreature;
        this.listObjet = listObjet;
        this.listJoueurs = listJoueurs;
        this.mondeLongueur = longueur;
        this.mondeLargeur = largeur;
        this.tabCreature = new Creature[longueur][largeur];
        this.map = new String[longueur][largeur];
        this.tabObj = new LinkedList[longueur][largeur];
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                this.tabObj[i][j] = new LinkedList<>();
            }
        }
    }
    
    /**
     *constructeur listes vides
     * @param tailleMonde
     */
    public World2(int longueur, int largeur) {
        this.listCreature = new HashMap<>();
        this.listObjet = new HashMap<>();
        this.listJoueurs = new HashMap<>();
        this.mondeLongueur = longueur;
        this.mondeLargeur = largeur;
        this.tabCreature = new Creature[longueur][largeur];
        this.map = new String[longueur][largeur];
        this.tabObj = new LinkedList[longueur][largeur];
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < largeur; j++) {
                this.tabObj[i][j] = new LinkedList<>();
            }
        }
    }
    
    /**
     *méthode pour vérifier la superposition
     * @param a
     * @param list
     * @return
     */
    public boolean estSuperpose(Point2D a, List<Point2D> list){
        for (int i = 0; i < list.size(); i++){
            if (a.equals(list.get(i))){
                return true;
                }
            }
        return false;
    }
    
    /**
     *création de monde aléatoire
     * @param nbPerso
     * @param nbMonstre
     * @param nbPotion
    
     */
    public void creeMondeAlea(int nbPerso, int nbMonstre, int nbObjet, int nbJoueur){
        //On crée 20% de chaque perso et 50% de chaque Monstre pour avoir un monde équilibré
        Point2D ptTemp = new Point2D();
        Point2D zero = new Point2D();
        zero.SetPosition(0, 0);
        for(int i = 0; i < Math.round(nbPerso*0.25); i++){
            System.out.println("Archer" +i);
            Archer crea = new Archer();
            
            ptTemp.Affiche();
            
            Point2D a = new Point2D(crea.getPos().getX(),
                crea.getPos().getY());
            // si la distance est trop grande, on refaire le generation du nombre aleatoir

            while(tabCreature[a.getX()][a.getY()] != null || a.distance(ptTemp)>5){
                // regenerer une position
                
                
                a.SetPosition(generateurAleatoire.nextInt(mondeLongueur),generateurAleatoire.nextInt(mondeLargeur));
                
                // parcourir tous les positions generees
            }

            crea.setPos(a);
            listCreature.put(listCreature.size()+i,crea);
            tabCreature[crea.getPos().getX()][crea.getPos().getY()] = crea;
            map[crea.getPos().getX()][crea.getPos().getY()] = " A ";
            ptTemp=crea.getPos();
            
        }
        for(int i = 0; i < Math.round(nbPerso*0.25); i++){
            System.out.println("Paysan" +i);
            Paysan crea = new Paysan();
            
            ptTemp.Affiche();
            
            Point2D a = new Point2D(crea.getPos().getX(),
                crea.getPos().getY());
            // si la distance est trop grande, on refaire le generation du nombre aleatoir

            while(tabCreature[a.getX()][a.getY()] != null || a.distance(ptTemp)>5){
                // regenerer une position
                
                a.SetPosition(generateurAleatoire.nextInt(mondeLongueur),generateurAleatoire.nextInt(mondeLargeur));
                // parcourir tous les positions generees
            }

            crea.setPos(a);
            listCreature.put(listCreature.size()+i,crea);
            tabCreature[crea.getPos().getX()][crea.getPos().getY()] = crea;
            map[crea.getPos().getX()][crea.getPos().getY()] = " P ";
            ptTemp=crea.getPos();
            
        }
        for(int i = 0; i < nbPerso-3*Math.round(nbPerso*0.25); i++){
            System.out.println("Mage" +i);
            Mage crea = new Mage();
            
            ptTemp.Affiche();
            
            Point2D a = new Point2D(crea.getPos().getX(),
                crea.getPos().getY());
            // si la distance est trop grande, on refaire le generation du nombre aleatoir

            while(tabCreature[a.getX()][a.getY()] != null || a.distance(ptTemp)>5){
                // regenerer une position
                
                a.SetPosition(generateurAleatoire.nextInt(mondeLongueur),generateurAleatoire.nextInt(mondeLargeur));
                // parcourir tous les positions generees
            }

            crea.setPos(a);
            listCreature.put(listCreature.size()+i,crea);
            tabCreature[crea.getPos().getX()][crea.getPos().getY()] = crea;
            map[crea.getPos().getX()][crea.getPos().getY()] = " M ";
            ptTemp=crea.getPos();
            
        }
        for(int i = 0; i < Math.round(nbPerso*0.25); i++){
            System.out.println("Guerrier" +i);
            Guerrier crea = new Guerrier();
            
            ptTemp.Affiche();
            
            Point2D a = new Point2D(crea.getPos().getX(),
                crea.getPos().getY());
            // si la distance est trop grande, on refaire le generation du nombre aleatoir

            while(tabCreature[a.getX()][a.getY()] != null || a.distance(ptTemp)>5){
                // regenerer une position
                
                a.SetPosition(generateurAleatoire.nextInt(mondeLongueur),generateurAleatoire.nextInt(mondeLargeur));
                // parcourir tous les positions generees
            }

            crea.setPos(a);
            listCreature.put(listCreature.size()+i,crea);
            tabCreature[crea.getPos().getX()][crea.getPos().getY()] = crea;
            map[crea.getPos().getX()][crea.getPos().getY()] = " G ";
            ptTemp=crea.getPos();
            
        }
        for(int i = 0; i < Math.round(nbMonstre*0.5); i++){
            System.out.println("Loup" +i);
            Loup crea = new Loup();
            
            ptTemp.Affiche();
            
            Point2D a = new Point2D(crea.getPos().getX(),
                crea.getPos().getY());
            // si la distance est trop grande, on refaire le generation du nombre aleatoir

            while(tabCreature[a.getX()][a.getY()] != null || a.distance(ptTemp)>5){
                // regenerer une position
                
                a.SetPosition(generateurAleatoire.nextInt(mondeLongueur),generateurAleatoire.nextInt(mondeLargeur));
                // parcourir tous les positions generees
            }

            crea.setPos(a);
            listCreature.put(listCreature.size()+i,crea);
            tabCreature[crea.getPos().getX()][crea.getPos().getY()] = crea;
            map[crea.getPos().getX()][crea.getPos().getY()] = " L ";
            ptTemp=crea.getPos();
            
        }
        for(int i = 0; i < nbMonstre-Math.round(nbMonstre*0.5); i++){
            Lapin crea = new Lapin();
            
            ptTemp.Affiche();
            
            Point2D a = new Point2D(crea.getPos().getX(),
                crea.getPos().getY());
            // si la distance est trop grande, on refaire le generation du nombre aleatoir

            while(tabCreature[a.getX()][a.getY()] != null || a.distance(ptTemp)>5){
                // regenerer une position
                
                a.SetPosition(generateurAleatoire.nextInt(mondeLongueur),generateurAleatoire.nextInt(mondeLargeur));
                // parcourir tous les positions generees
            }

            crea.setPos(a);
            listCreature.put(listCreature.size()+i,crea);
            tabCreature[crea.getPos().getX()][crea.getPos().getY()] = crea;
            map[crea.getPos().getX()][crea.getPos().getY()] = " l ";
            ptTemp=crea.getPos();
            
        }
        for(int i = 0; i < nbJoueur; i++){
            System.out.println("Joueur" +i);
            Joueur joueur = new Joueur();
            
            ptTemp.Affiche();
            
            Point2D a = new Point2D(joueur.getPerso().getPos().getX(),
                joueur.getPerso().getPos().getY());
            // si la distance est trop grande, on refaire le generation du nombre aleatoir

            while(tabCreature[a.getX()][a.getY()] != null || a.distance(ptTemp)>5){
                // regenerer une position
                
                a.SetPosition(generateurAleatoire.nextInt(mondeLongueur),generateurAleatoire.nextInt(mondeLargeur));
                // parcourir tous les positions generees
            }

            joueur.getPerso().setPos(a);
            listJoueurs.put(listJoueurs.size()+i,joueur);
            
            ptTemp=joueur.getPerso().getPos();
            
        }
        for(int i = 0; i < nbObjet; i++){
            int type = generateurAleatoire.nextInt(2);
            System.out.println("Objet" +i);
            Potion pot;
            if (type==1){
                 pot = new Soin();
            }
            else {
                pot = new Mana();
            }
            
            
            Point2D a = new Point2D(generateurAleatoire.nextInt(mondeLongueur),generateurAleatoire.nextInt(mondeLargeur));
            
            pot.setPos(a);
            listObjet.put(listObjet.size()+i,pot);
            tabObj[pot.getPos().getX()][pot.getPos().getY()].add(pot);
            
        }

    }
    
    /**
     *affichage du monde
     */
    public void afficheMonde(){
        int i;
        System.out.println("Constitution du monde :");
        System.out.println("Nombre de Créatures :");
        System.out.println(listCreature.size());
        
        
        String[][] grid = new String[mondeLongueur][mondeLargeur];
        for(int k = 0; k < mondeLongueur; k++){
            for(int j = 0; j < mondeLargeur; j++){
                if (map[k][j] == null){
                    if (tabObj[k][j].size()>1){
                        grid[k][j] = "-|-";
                    }
                    if (tabObj[k][j].size()==1 && tabObj[k][j].get(0) instanceof Soin){
                        grid[k][j] = "-s-";
                    }
                    if (tabObj[k][j].size()==1 && tabObj[k][j].get(0) instanceof Mana){
                        grid[k][j] = "-m-";
                    }
                    else{
                        grid[k][j] = " . ";
                    }
                    
                }
                else{
                    grid[k][j] = map[k][j];
                }
                grid[0][0] = " x ";
            }
        }
        for(int k = 0; k < mondeLongueur; k++){
            for(int j = 0; j < mondeLargeur; j++){
                System.out.print(grid[k][j]);
            }
            System.out.println(" ");
        }
        
        
    }
    
    /**
     * Méthode de protocole de jeu
     */
    public void jouer(){
        boolean finish = false;
        this.afficheMonde();
        if (this.listJoueurs.size()==0){
            System.out.println("Pas de joueurs ");
            finish=true;
        }
        else{
        this.listJoueurs.get(0).choisirPersonnage();
        tabCreature[this.listJoueurs.get(0).getPerso().getPos().getX()][this.listJoueurs.get(0).getPerso().getPos().getY()] = this.listJoueurs.get(0).getPerso();
        map[this.listJoueurs.get(0).getPerso().getPos().getX()][this.listJoueurs.get(0).getPerso().getPos().getY()] = "*J*";
            
        this.afficheMonde();
        int tours = 1; // counter of round of game
        Scanner sc= new Scanner(System.in); //standard input stream
        while (this.listJoueurs.get(0).perso.ptVie >0 && tours <51 && finish==false){
            Personnage p = this.listJoueurs.get(0).perso;

            System.out.println("\nVeuillez choisir une action :");
            System.out.println(" 1 : Se déplacer");
            System.out.println(" 2 : Combattre");
            System.out.println(" 3 : Arrêter la partie");
            int action = 0;
            while (action != 1 && action != 2 && action != 3) {
                System.out.println("Veuillez entrer une action :");
                action = sc.nextInt();
            }
            switch(action){
                case 1 : 
                    p.affiche();
                    System.out.println("X for deplacer: ");
                    int comX = 0;
                    int comY = 0;
                    comX = sc.nextInt();
                    System.out.println("Y for deplacer: ");
                    comY = sc.nextInt();
                    Point2D comPt = new Point2D(p.getPos().getX()+comX,p.getPos().getY()+comY);
                    while(this.tabCreature[comPt.getX()][comPt.getY()]!=null){
                        System.out.println("Case occupied, please choose another position");
                        System.out.println("X for deplacer: ");
                        comX = 0;
                        comY = 0;
                        comX = sc.nextInt();
                        System.out.println("Y for deplacer: ");
                        comY = sc.nextInt();
                        comPt = new Point2D(p.getPos().getX()+comX,p.getPos().getY()+comY);
                    }
                    Point2D pos = new Point2D(p.getPos().getX()+comX,p.getPos().getY()+comY);
                    deplacementCrea(pos);
                    p.deplacer(comX, comY);
                    p.affiche();
                    break;
                case 2 :
                    System.out.println("Visez la cible (ligne et colonne) grâce à la map, (0,0) est en haut à gauche");
                    System.out.println("Ligne (entre 0 et " + (this.mondeLongueur-1) + ") :");
                    int choixX = -1;
                    while (choixX < 0 || choixX >= this.mondeLongueur) {
                        choixX = sc.nextInt();
                    }
                    System.out.println("Colonne (entre 0 et " + (this.mondeLargeur-1) + ") :");
                    int choixY = -1;
                    while (choixY < 0 || choixY >= this.mondeLargeur) {
                        choixY = sc.nextInt();
                    }
                    if (tabCreature[choixX][choixY]==null){
                        System.out.println("Pas de créature en [" +choixX+ ","+choixY + "]" );
                    }
                    else{
                        p.combattre(tabCreature[choixX][choixY]);
                        if (tabCreature[choixX][choixY].getPtVie()<0){
                            tabCreature[choixX][choixY]=null; //créature morte
                        }
                    }
                    break;
                case 3 :
                    finish =true;
                    break;

            }
            this.afficheMonde();
            int choix = 0;
            while (choix != 1 && choix != 2 ) {
                System.out.println("Voulez vous sauvegarder la partie ? [oui : 1/non : 2]");
                choix = sc.nextInt();
            }
            
            if (choix==1){
                (new SauvegardePartie()).sauvegarderPartie(this);
            }
            

            //at the end of a round, count a round
            tours = tours + 1;
     }
    }
    }

    /**
     *Méthode pour actualiser la map et le tableau des créature lors d'un déplacement
     * @param pos
     */
    public void deplacementCrea(Point2D pos){
        tabCreature[pos.getX()][pos.getY()]=this.listJoueurs.get(0).getPerso();
        map[pos.getX()][pos.getY()]="*J*";
        tabCreature[this.listJoueurs.get(0).perso.getPos().getX()][this.listJoueurs.get(0).perso.getPos().getY()]=null;
        map[this.listJoueurs.get(0).perso.getPos().getX()][this.listJoueurs.get(0).perso.getPos().getY()]=null;
    }
}
