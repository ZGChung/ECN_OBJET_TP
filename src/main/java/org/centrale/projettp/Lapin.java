/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 * class Lapin, sous class de la class Monstre
 * @version 1.0
 * @author uble
 */
public class Lapin extends Monstre{
    /**
     * Construteur avec tous les parametres
     * @param pV point de vie
     * @param pA poucentage de réussite de l'attaque physique
     * @param pP pourcentage de réussite pour parer
     * @param dA degre d'attaque
     * @param position position maintenant
     */
    public Lapin(int pV, int pA, int pP, int dA, int ptP, Point2D position){
        super(pV,pA,pP,dA,ptP,position);
    }
    public Lapin(){
        super();
    }
    public Lapin(Lapin l){
        super((Monstre)l);
    }
    public String creerSauvegarde() {
        return "Lapin " + super.creerSauvegarde();
    }
    
}
