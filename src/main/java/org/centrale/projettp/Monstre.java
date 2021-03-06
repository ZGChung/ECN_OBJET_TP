/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;
//import java.util.Random;
/**
 * class de Monstre, avec tous les attribust basiques
 * @version 2.0
 * @author uble zgchung
 */
/**
 * class de Monstre, avec tous les attribust basiques
 * @version 2.0
 * @author uble zgchung
 */
public class Monstre extends Creature {
    //attributs
    //Constructor with parameters
    
    /**
     * Construteur avec tous les parametres
     * @param pV
     * @param pA
     * @param pP
     * @param dA
     * @param ptP
     * @param pos 
     */
    public Monstre(int pV, int pA, int pP, int dA, int ptP, Point2D pos){
        super(pV, pA, pP, dA, ptP, pos);
    }
    //

    /**
     *Constructor which is a copy of another Monstre
     * @param m
     */
    public Monstre(Monstre m){
        super(m);
    }
    //

    /**
     *Constructor with no parameters
     */
    public Monstre(){
        super();
    }
    
    //

    /**
     *Afficheur des attributs
     */
    public void affiche(){
        System.out.println("Les attributs de ce monstre :");
        System.out.println("-----------");
        System.out.println("ptVie : "+this.ptVie);
        System.out.println("pourcentageAtt : "+this.pourcentageAtt);
        System.out.println("pourcentagePar : "+this.pourcentagePar);
        System.out.println("degAtt : "+this.degAtt);
        System.out.println("ptPar : "+this.ptPar);
        System.out.println("pos : ");
        this.pos.Affiche();
        System.out.println("-----------");
    
    }
  
    /**
     * Deplacement d'un monstre
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
     * Sauvegarde d'un mosntre
     * @return
     */
    @Override
    public String creerSauvegarde() {
        String texte = String.format("%d %d ", ptVie, pourcentageAtt);
        texte += String.format("%d %d ", pourcentagePar, degAtt);
        return texte + super.creerSauvegarde();
    }
}
