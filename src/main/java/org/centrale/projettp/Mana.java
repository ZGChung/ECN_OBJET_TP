/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 * Potion de Mana
 * @author uble
 */
public class Mana extends Potion{

    /**
     * constructeur vide
     */
    public Mana(){
        super();
    }

    /**
     * COnstructeur avec points de mana
     * @param pt
     * @param pos
     */
    public Mana(int pt, Point2D pos){
        super(pt,pos);
    }

    /**
     * Copie d'une potion de mana
     * @param m
     */
    public Mana(Mana m){
        super((Potion)m);
    }

    /**
     * Altération d'un personnage par la potion de Mana
     * @param p
     */
    public void modifier(Personnage p){
       
        if (this.getPos().getX()==p.getPos().getX() && this.getPos().getY()==p.getPos().getY() && this.isUse()){
            System.out.println("Tu es tombé sur une potion qui va te rendre : "+this.getPt()+"points de mana");
            p.setPtMana(p.getPtMana()+this.getPt());
            //on détruit la potion
            this.setUse(false);
        } 
        else{
            System.out.println("Pas de potion sur cette case");
        }
    }
    
    /**
     * Sauvegarde de la pot de mana
     * @return
     */
    @Override
    public String creerSauvegarde() {
        
        return "Mana " + super.creerSauvegarde();
    }
}
