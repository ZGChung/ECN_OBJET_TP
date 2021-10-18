/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * la classe pour les personnages, on définit les attributs basiques ici 
 * @version 2.0
 * @author zgchung
 */
/**
 * la classe pour les personnages, on définit les attributs basiques ici 
 * @version 2.0
 * @author zgchung
 */
public class Personnage extends Creature {
    //attributs
    /**
     * le nom du personnage
     */
    private String nom;    
    /**
     * point de Mana
     */
    private int ptMana;
    /**
     * pourcentage de réussite d'un attaque magique
     */
    private int pourcentageMag;
    /**
     * pourcentage resistance de l'attaque magique
     */
    private int pourcentageResistMag;
    /**
     * degre de l'attaque magique
     */
    private int degMag;
    /**
     * distance d'attaque maximum
     */
    private int distAttMax;
    
    /**
     * Liste de nourriture
     */
    private List<Nourriture> listeNourriture;
    
    /**
     * Getter
     * @return 
     */
    public List<Nourriture> getListeNourriture() {
        return listeNourriture;
    }

    /**
     *setter
     * @param listeNourriture
     */
    public void setListeNourriture(List<Nourriture> listeNourriture) {
        this.listeNourriture = listeNourriture;
    }
   
    //constructeur 
    /**
     * constructeur avec tous les parametres
     * @param nom
     * @param ptV
     * @param ptM
     * @param pA
     * @param pP
     * @param pM
     * @param rM
     * @param dA
     * @param dM
     * @param distMax
     * @param ptP
     * @param pos 
     */
    public Personnage(String nom, int ptV, int ptM, int pA, int pP, 
            int pM, int rM, int dA, int dM, int distMax,int ptP, Point2D pos){
        super(ptV, pA, pP, dA, ptP, pos);
        this.nom = nom;
        this.ptMana = ptM;
        this.pourcentageMag = pM;
        this.pourcentageResistMag = rM;
        this.degMag = dM;
        this.distAttMax = distMax;
        this.listeNourriture = new ArrayList<>();
    }
    //generateur2

    /**
     *Constructeur copie d'un personnage
     * @param perso
     */
    public Personnage(Personnage perso){
        super(perso);
        this.nom = perso.nom;
        this.ptMana = perso.ptMana;
        this.pourcentageMag = perso.pourcentageMag;
        this.pourcentageResistMag = perso.pourcentageResistMag;
        this.degMag = perso.degMag;
        this.distAttMax = perso.distAttMax;
    }
    //generateur3
    Random generateurAleatoire = new Random();

    /**
     *Contructeur aléatoire
     */
    public Personnage(){
        super();
        this.nom = "RandomNom"+generateurAleatoire.nextInt(100);
        this.ptMana = generateurAleatoire.nextInt(100);
        this.pourcentageMag = generateurAleatoire.nextInt(100);
        this.pourcentageResistMag = generateurAleatoire.nextInt(100);
        this.degMag = generateurAleatoire.nextInt(100);
        this.distAttMax = generateurAleatoire.nextInt(100);
        this.listeNourriture = new ArrayList<>();
    }
    
    //getters

    /**
     *getters nom
     * @return
     */

    public String getNom() {
        return nom;
    }

    /**
     *getters Mana
     * @return
     */
    public int getPtMana() {
        return ptMana;
    }

    /**
     *Getters pourcentage mana
     * @return
     */
    public int getPourcentageMag() {
        return pourcentageMag;
    }

    /**
     *Getters pourcentage resistance magique
     * @return
     */
    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    /**
     *Getters dégâts magiques
     * @return
     */
    public int getDegMag() {
        return degMag;
    }

    /**
     *Getters distance attaque max
     * @return
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *gene aléatoire
     * @return
     */
    public Random getGenerateurAleatoire() {
        return generateurAleatoire;
    }
    
    //setters

    /**
     *setter nom
     * @param nom
     */

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *setter point mana
     * @param ptMana
     */
    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    /**
     *setter pourcentage magique
     * @param pourcentageMag
     */
    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    /**
     *setter pourcentage resistance magique
     * @param pourcentageResistMag
     */
    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    /**
     *stter dégâts magiques
     * @param degMag
     */
    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    /**
     *setter distance attaque maximale
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     *setter generateur aléatoire
     * @param generateurAleatoire
     */
    public void setGenerateurAleatoire(Random generateurAleatoire) {
        this.generateurAleatoire = generateurAleatoire;
    }
    
    
    //methodes
    //

    /**
     *affiche les attributs du personnage
     */
    public void affiche(){
        System.out.println("Les attributs de ce personnage :");
        System.out.println("-----------");
        System.out.println("nom : "+this.nom);
        System.out.println("ptVie : "+this.ptVie);
        System.out.println("ptMana : "+this.ptMana);
        System.out.println("pourcentageAtt : "+this.pourcentageAtt);
        System.out.println("pourcentagePar : "+this.pourcentagePar);
        System.out.println("pourcentageMag : "+this.pourcentageMag);
        System.out.println("pourcentageResistMag : "+this.pourcentageResistMag);
        System.out.println("degAtt : "+this.degAtt);
        System.out.println("degMag : "+this.degMag);
        System.out.println("distAttMax : "+this.distAttMax);
        System.out.println("ptPar : "+this.ptPar);
        System.out.println("pos : ");
        this.pos.Affiche();
        System.out.println("-----------");
    }
    /**
     * Deplacement d'un personnage
     * @param x
     * @param y
     */
    @Override
    public void deplacer(int x, int y) {
        pos.translate(x,y);
    }

    /**
     * Déplacement aléatoire
     */
    @Override
    public void deplacer() {
        pos.translate(-1+generateurAleatoire.nextInt(2),-1+generateurAleatoire.nextInt(2));
    }
    
    /**
     * pour ramasser de la nourriture
     * @param n
     */
    public void ramasser(Nourriture n){
        listeNourriture.add(n);
    }
    
    /**
     *Pour supprimer les nourritures de durée 0 dans la liste
     */
    public void verifier(){
        for(int i = 0; i < listeNourriture.size(); i++){
            if (listeNourriture.get(i).getDuree()==0){
                listeNourriture.remove(i);
            }
            
        }
    }
    
    public void malAffiche(){
        //System.out.println("Methode malAffiche()");
        malAffiche();
    }
    public String creerSauvegarde() {
        String texte = String.format("%s %d %d %d ", nom, ptVie, ptMana, pourcentageAtt);
        texte += String.format("%d %d %d ", pourcentagePar, pourcentageMag, pourcentageResistMag);
        texte += String.format("%d %d %d ", degAtt, degMag, distAttMax);
        return texte + super.creerSauvegarde();
    }
}
