/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;

/**
 * class de Guerrier, sous class de Personnage
 * @author zgchung
 * @version 1.0
 */
public class Guerrier extends Personnage implements Combattant{
    //attributs
    
    //constructeurs

    /**
     *
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
     * @param nbF
     */
    public Guerrier(String nom, int ptV, int ptM, int pA, int pP, 
        int pM, int rM, int dA, int dM, int distMax, int ptP, Point2D pos,int nbF){
        super(nom, ptV,ptM, pA,pP, 
            pM, rM, dA, dM, ptP, distMax, pos);
    }

    /**
     * guerrier de base
     */
    public Guerrier(){
        super();
    }

    /**
     *copie d'un guerrier
     * @param g
     */
    public Guerrier(Guerrier g){
        super((Personnage)g);
    }
    //setters
    
    //getter
    
    //methodes

    /**
     *Combat qui reprend un super
     * @param c
     */
    @Override
    public void combattre(Creature c){
        super.combattre(c);
    }
    
    
    //methodes
    
    public String creerSauvegarde() {
        return "Guerrier " + super.creerSauvegarde();
    }
}
