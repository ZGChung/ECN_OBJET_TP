/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;

/**
 * super class de personnage et de monstre
 * @author zgchung
 * @version 2.0
 */
public abstract class Creature extends ElementDeJeu implements Deplacable {
    //attributs
    /**
     * point de vie
     */
    protected int ptVie;
    /**
     * pourcentage de réussite de l'attaque physique
     */
    protected int pourcentageAtt;
    
    /**
     * pourcentage de réussite de parer
     */
    protected int pourcentagePar;
    /**
     * degre de l'attaque magique
     */
    protected int degAtt;
    /**
     * point parer
     */
    protected int ptPar;

    /**
     *position
     */
    protected Point2D pos;
    
    //constructeurs
        /**
     * Construteur avec tous les parametres
     * @param pV point de vie 
     * @param pA pourcentage de réussite de l'attaque physique
     * @param pP pourcentage de réussite de parer
     * @param dA degre de l'attaque
     * @param ptP point de parer
     * @param position position
     */
    public Creature(int pV, int pA, int pP, int dA, int ptP, Point2D position){
        ptVie=pV;
        pourcentageAtt=pA;
        pourcentagePar=pP;
        degAtt=dA;
        ptPar = ptP;
        pos=position;
    }

    /**
     * Copie d'une créature
     * @param c
     */
    public Creature(Creature c){
        this.ptVie=c.ptVie;
        this.pourcentageAtt=c.pourcentageAtt;
        this.pourcentagePar=c.pourcentagePar;
        this.degAtt=c.degAtt;
        this.ptPar = c.ptPar;
        this.pos = new Point2D(c.pos.getX(),c.pos.getY());
    }
    
    Random generateurAleatoire = new Random();

    /**
     *créture aléatoire
     */
    public Creature(){
        this.ptVie=generateurAleatoire.nextInt(100);
        this.pourcentageAtt=generateurAleatoire.nextInt(100);
        this.pourcentagePar=generateurAleatoire.nextInt(100);
        this.degAtt=generateurAleatoire.nextInt(100);
        this.ptPar=generateurAleatoire.nextInt(100);
        this.pos=new Point2D(generateurAleatoire.nextInt(5),generateurAleatoire.nextInt(5));
    }
    //getters
    
    /**
     *
     * @return
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @return
     */
    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    /**
     *
     * @return
     */
    public int getPourcentagePar() {
        return pourcentagePar;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }
    
    //setters

    /**
     *
     * @param ptVie
     */

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @param pourcentageAtt
     */
    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    /**
     *
     * @param pourcentagePar
     */
    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }
    //methodes
    /**
     * deplacer le protagonist au hasard
     */
    public abstract void deplacer();
    
    /**
     * fonction de combat
     * @param c 
     */
    public void combattre(Creature c){
        System.out.println("AU combat !");
        if (this.getPos().distance(c.getPos())<=1){
            
            Random genAlea= new Random();
            int rand = genAlea.nextInt(101);
            if (rand>this.getPourcentageAtt()){
                rand = genAlea.nextInt(101);
                if (rand>c.getPourcentagePar()){
                    System.out.println("Beau coup, vous infligez "+this.getDegAtt()+" dégâts à l'adversaire");
                    c.setPtVie(c.getPtVie()-this.getDegAtt());
                }
                else{
                    System.out.println("L'adversaire parre, vous infligez "+(this.getDegAtt()-c.getPtPar())+" dégâts à l'adversaire");
                    c.setPtVie(c.getPtVie()-this.getDegAtt()+c.getPtPar());  
                    }
            }
          
            else{
                System.out.println("Attaque ratée");
            }
        }
        else{
            System.out.println("vous n'avez pas la portée d'une attaque corps à corps");
        }
    }
    
    public String creerSauvegarde() {
        String texte = String.format("%d ", this.getPtPar());
        texte+= String.format("%d %d", this.getPos().getX(), this.getPos().getY());
        return texte;
    }
}
