/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 *
 * @author uble
 */
public class Mana extends Potion{
    public Mana(){
        super();
    }
    public Mana(int pt, Point2D pos){
        super(pt,pos);
    }
    public Mana(Mana m){
        super((Potion)m);
    }
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
}
