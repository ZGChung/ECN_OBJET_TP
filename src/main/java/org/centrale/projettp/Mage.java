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
/**
 * class de Mage, sous class de Personnage
 * @author zgchung
 * @version 1.0
 */
public class Mage extends Personnage implements Combattant{
    //attributs
    
    //constructeurs

    /**
     *Constructeur avec tous les paramètres
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
    public Mage(String nom, int ptV, int ptM, int pA, int pP, 
        int pM, int rM, int dA, int dM, int distMax, int ptP, Point2D pos,int nbF){
        super(nom, ptV,ptM, pA,pP, 
            pM, rM, dA, dM, distMax, ptP, pos);
    }

    /**
     *Constructeur vide
     */
    public Mage(){
        super();
    }

    /**
     *Copie d'un autre mage
     * @param m
     */
    public Mage(Guerrier m){
    }
    //setters
    
    //getter

    /**
     *Combat magique à distance
     * @param c
     */
    @Override
    public void combattre(Creature c){
        if (this.getPos().distance(c.getPos())<=1){
            System.out.println("vous n'avez pas la portée");
        }
        else if (this.pos.distance(c.pos)>(getDistAttMax()+0.5)){
            System.out.println("vous n'avez pas la portée");
        }
        else{
            
            Random genAlea= new Random();
            int rand = genAlea.nextInt(101);
            this.setPtMana(this.getPtMana()-1);
            if (rand>this.getPourcentageMag()){
                System.out.println("Dans le mille, vous infligez "+this.getDegMag()+" dégâts à l'adversaire");
                c.setPtVie(c.getPtVie()-this.getDegMag());
            }
            else {
                System.out.println("Attaque ratée");
            }
          
            
            
        }
    }

    
    //methodes

    /**
     * Sauvegarde d'un Mage
     * @return
     */
    
    @Override
    public String creerSauvegarde() {
        return "Mage " + super.creerSauvegarde();
    }
    
}
