/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;
/**
 *
 * class de Archer, sous class de Personnage
 * @version 1.0
 * @author uble
 */
public class Archer extends Personnage {
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
    
    
    public String creerSauvegarde() {
        return "Archer " + super.creerSauvegarde();
    }
    
    @Override
    public void combattre(Creature c){
        if (this.getPos().distance(c.getPos())<=1){
            System.out.println("vous n'avez pas la portée");
        }
        else if (this.pos.distance(c.pos)>(getDistAttMax()+0.5)){
            System.out.println("vous n'avez pas la portée");
        }
        else{
            if (this.getNbFleches()>0){
                Random genAlea= new Random();
                int rand = genAlea.nextInt(101);
                if (rand>this.getPourcentageAtt()){
                    System.out.println("Dans le mille, vous infligez "+this.getDegAtt()+" dégâts à l'adversaire");
                    c.setPtVie(c.getPtVie()-this.getDegAtt());
                }
          
            }
            else {
                System.out.println("Pas de flèches");
            }
            this.setNbFleches(this.getNbFleches()-1);
        }
    }
}
