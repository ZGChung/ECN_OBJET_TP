/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 * Bonus
 * @author uble
 */
public class BonusDegAtt extends Nourriture{

    /**
     *constructeur
     */
    public BonusDegAtt(){
        super();
    }

    /**
     * constructeur
     * @param pt
     * @param dur
     */
    public BonusDegAtt(int pt, int dur){
        super(pt,dur);
    }

    /**
     *alterer un personnage avec le bonus et la durée
     * @param p
     */
    @Override
    public void alterer(Personnage p){
        if (getDuree()>0 & isAltere()==false){
            p.setDegAtt(p.getDegAtt()+getPoint());
            setAltere(true);
        }
        //Une fois utilisé, on réduit la durée à chaque fois
        setDuree(getDuree()-1);
        if (getDuree()==0 & isAltere()==true){
            p.setDegAtt(p.getDegAtt()-getPoint());
            setAltere(false);
        }
    }
}
