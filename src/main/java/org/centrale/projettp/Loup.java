/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;

/**
 * class de loup, sous class de Monstre
 * @author zgchung
 */
public class Loup extends Monstre implements Combattant{
    // nouveaux attributs
    
    // construtors

    /**
     *Constructeur vide
     */
    public Loup() {
        super();
    }

    /**
     *Constructeur copie
     * @param l
     */
    public Loup(Lapin l){
        super((Monstre)l);
    }
    
    /**
     * constructor avec tous les parametres
     * @param pV point de vie
     * @param pA point de mana
     * @param pP pourcentage de parer
     * @param dA degre de l'attaque
     * @param ptP
     * @param position position
     */
    public Loup(int pV, int pA, int pP, int dA, int ptP, Point2D position){
        super(pV,pA,pP,dA,ptP,position);
    }
    
    /**
     *COmbat de l'extension
     * @param c
     */
    @Override
    public void combattre(Creature c){
        super.combattre(c);
    }
    
    public String creerSauvegarde() {
        return "Loup " + super.creerSauvegarde();
    }

    
}
