/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 *
 * class de Archer, sous class de Personnage
 * @version 1.0
 * @author uble
 */
public class Archer extends Personnage implements TypeBonus{
    //Attributs
    private int nbFleches;
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
     * @param nbF  nombre des fléches
     */
    public Archer(String nom, int ptV, int ptM, int pA, int pP, 
            int pM, int rM, int dA, int dM, int distMax,int ptP, Point2D pos,int nbF){
        super(nom, ptV, ptM, pA ,pP, 
            pM, rM, dA, dM, distMax, ptP, pos);
        nbFleches=nbF;
    }
    public Archer(){
        super();
        nbFleches=4;
    }
    public Archer(Archer a){
        super((Personnage)a);
        nbFleches=a.nbFleches;
    }
    //setters et getters pour NbFleches
    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    public void Affiche(){
        super.affiche();
        System.out.println("nombre Fleche : "+this.nbFleches);
        System.out.println("-----------");
    }
    
    public void setTypeBonus(){
        this.ptVie = this.ptVie + 50;
        this.ptMana = this.ptMana + 50;
        this.distAttMax = this.distAttMax + 100;
    }
}
