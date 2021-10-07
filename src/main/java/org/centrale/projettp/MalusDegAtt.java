/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 * Malus
 * @author uble
 */
public class MalusDegAtt extends Nourriture{
    public MalusDegAtt(){
        super();
    }

    /**
     * constructeur
     * @param pt
     * @param dur
     */
    public MalusDegAtt(int pt, int dur){
        super(pt,dur);
    }

    /**
     * alterer avec un malus
     * @param p
     */
    @Override
    public void alterer(Personnage p){
        if (getDuree()>0 & isAltere()==false){
            p.setDegAtt(p.getDegAtt()-getPoint());
            setAltere(true);
        }
        //Une fois utilisé, on réduit la durée à chaque fois
        setDuree(getDuree()-1);
        if (getDuree()==0 & isAltere()==true){
            p.setDegAtt(p.getDegAtt()+getPoint());
            setAltere(false);
        }
    }
}
