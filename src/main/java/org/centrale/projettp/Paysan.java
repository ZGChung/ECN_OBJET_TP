/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 * la class du paysan, sous class de Personnage
 * @version 1.0
 * @author uble
 */
public class Paysan extends Personnage implements TypeBonus{
/**
     * Construteur avec tous les parametres
     * @param nom   nom du personnage
     * @param ptV   point de vie
     * @param ptM   point de Mana
     * @param pA    pourcentage de réussite de l'attaque physique
     * @param pP    pourcentage de réussite de parer
     * @param pM    pourcentage de réussite de l'attaque magique
     * @param rM    resistance magique
     * @param dA    distance attaque physique
     * @param dM    distance attaque magique
     * @param distMax   distance attaque maximum
     * @param pos   position
     */
    public Paysan(String nom, int ptV, int ptM, int pA, int pP, 
            int pM, int rM, int dA, int dM, int distMax, int ptP, Point2D pos){
        super(nom, ptV,ptM, pA,pP, 
            pM, rM, dA, dM, distMax, ptP, pos);
    }
    public Paysan(){
        super();
    }
    public Paysan(Paysan p){
        super((Personnage)p);
    }
    
    //getters and setters -> empty 
    //methodes
    public void setTypeBonus(){
        this.ptVie = this.ptVie + 0;
        this.ptMana = this.ptMana + 0;
        this.distAttMax = this.distAttMax + 0;
    }
    
}
