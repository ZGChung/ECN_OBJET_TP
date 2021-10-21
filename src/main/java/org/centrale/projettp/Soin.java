/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 *Class de potion de soin
 * @author uble
 */
public class Soin extends Potion{

    /**
     *potion vide
     */
    public Soin(){
        super();
    }

    /**
     * avec paramètres
     * @param pt
     * @param pos
     */
    public Soin(int pt, Point2D pos){
        super(pt,pos);
    }

    /**
     *copie d'une potion de soin
     * @param s
     */
    public Soin(Soin s){
        super((Potion)s);
    }

    /**
     *Altération d'un personnage par le soin
     * @param p
     */
    public void modifier(Personnage p){
        if (this.getPos().getX()==p.getPos().getX() && this.getPos().getY()==p.getPos().getY() && this.isUse()){
            System.out.println("Tu es tombé sur une potion qui va te rendre : "+this.getPt()+"points de vie");
            p.setPtVie(p.getPtVie()+this.getPt());
            //on détruit la potion
            this.setUse(false);
        } 
        else{
            System.out.println("Pas de potion sur cette case");
        }
    }
    /**
     *Sauvegarde du soin
     */
    @Override
    public String creerSauvegarde() {
        
        return "Soin " + super.creerSauvegarde();
    }
}
