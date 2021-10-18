/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;
import java.util.Random;

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
    protected String nom;    
    /**
     * point de Mana
     */
    protected int ptMana;
    /**
     * pourcentage de réussite d'un attaque magique
     */
    protected int pourcentageMag;
    /**
     * pourcentage resistance de l'attaque magique
     */
    protected int pourcentageResistMag;
    /**
     * degre de l'attaque magique
     */
    protected int degMag;
    /**
     * distance d'attaque maximum
     */
    protected int distAttMax;
   
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
    }
    //generateur2
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
    public Personnage(){
        super();
        this.nom = "RandomNom"+generateurAleatoire.nextInt(100);
        this.ptMana = generateurAleatoire.nextInt(100);
        this.pourcentageMag = generateurAleatoire.nextInt(100);
        this.pourcentageResistMag = generateurAleatoire.nextInt(100);
        this.degMag = generateurAleatoire.nextInt(100);
        this.distAttMax = generateurAleatoire.nextInt(100);
    }
    
    //getters

    public String getNom() {
        return nom;
    }

    public int getPtMana() {
        return ptMana;
    }

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    public int getDegMag() {
        return degMag;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public Random getGenerateurAleatoire() {
        return generateurAleatoire;
    }
    
    //setters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public void setGenerateurAleatoire(Random generateurAleatoire) {
        this.generateurAleatoire = generateurAleatoire;
    }
    
    
    //methodes
    //affiche les attributs du personnage
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
