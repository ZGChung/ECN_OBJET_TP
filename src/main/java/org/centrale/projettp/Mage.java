/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;

/**
 * class de Mage, sous class de Personnage
 * @author zgchung
 * @version 1.0
 */
public class Mage extends Personnage implements TypeBonus{
    //attributs
    
    //constructeurs
    public Mage(String nom, int ptV, int ptM, int pA, int pP, 
        int pM, int rM, int dA, int dM, int distMax, int ptP, Point2D pos,int nbF){
        super(nom, ptV,ptM, pA,pP, 
            pM, rM, dA, dM, distMax, ptP, pos);
    }
    public Mage(){
        super();
    }
    public Mage(Mage m){
        
    }
    //setters
    //getter

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPtMana() {
        return ptMana;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    public int getDegMag() {
        return degMag;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public Random getGenerateurAleatoire() {
        return generateurAleatoire;
    }

    public void setGenerateurAleatoire(Random generateurAleatoire) {
        this.generateurAleatoire = generateurAleatoire;
    }
    
    //methodes
    public void setTypeBonus(){
        this.ptVie = this.ptVie + 10;
        this.ptMana = this.ptMana + 100;
        this.distAttMax = this.distAttMax + 50;
    }
    public String creerSauvegarde() {
        return "Mage " + super.creerSauvegarde();
    }
    
}
