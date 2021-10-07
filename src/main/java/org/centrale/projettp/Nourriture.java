/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;

/**
 * Classe nourriture, sous classe d'objet
 * @author uble
 */
public class Nourriture extends Objet{
    private int point;
    private int duree;
    private boolean altere;

    /**
     * getter de Altere
     * @return
     */
    public boolean isAltere() {
        return altere;
    }

    /**
     *setter de altere
     * @param altere
     */
    public void setAltere(boolean altere) {
        this.altere = altere;
    }

    /**
     *getter de Point pour la nourriture
     * @return
     */
    public int getPoint() {
        return point;
    }

    /**
     *Setter de point
     * @param point
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * getter de durée
     * @return
     */
    public int getDuree() {
        return duree;
    }

    /**
     *setter de duree
     * @param duree
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }
    Random generateurAleatoire = new Random();

    /**
     *cnstructeur aléatoire
     */
    public Nourriture(){
        point = generateurAleatoire.nextInt(10);
        duree = generateurAleatoire.nextInt(5);
        altere = false;
    }

    /**
     * constructeur de nourriture
     * @param dur
     * @param pt
     */
    public Nourriture(int dur, int pt){
        point = pt;
        duree = dur;
        altere = false;
    }
    
    /**
     * alterer pour overwrite
     * @param p
     */
    public void alterer(Personnage p){
        
    }
    
}
