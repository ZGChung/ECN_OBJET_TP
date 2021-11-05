/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 * Class de potion
 * @author uble
 */
public class Potion extends Objet {
    // attributs
    protected int pt;
    protected Point2D pos;
    protected boolean use;

    /**
     * getter boolean use
     * @return
     */
    public boolean isUse() {
        return use;
    }

    /**
     * setter use
     * @param use
     */
    public void setUse(boolean use) {
        this.use = use;
    }

    /**
     * getter point
     * @return
     */
    public int getPt() {
        return pt;
    }

    /**
     * setter point
     * @param pt
     */
    public void setPt(int pt) {
        this.pt = pt;
    }

    /**
     * getter position
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * setter position
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     *constructeur de potion
     */
    public Potion() {
        this.pt = 0;
        this.pos = new Point2D(0, 0);
        this.use = true;
    }

    /**
     * constructeur
     * @param point
     * @param position
     */
    public Potion(int point, Point2D position) {
        this.pt = point;
        this.pos = position;
        this.use = true;
    }

    /**
     * copie d'une potion
     * @param p
     */
    public Potion(Potion p) {
        this.pt = p.pt;
        this.pos = new Point2D(p.pos.getX(), p.pos.getY());
        this.use = p.use;
    }

    /**
     * affichage potion
     */
    public void affiche() {
        System.out.println("Le point de cette potion est:" + this.pt);
    }

    /**
     * création de sauvegarde d'une potion
     * @return
     */
    @Override
    public String creerSauvegarde() {
        String texte = String.format("%d ", this.getPt());
        texte += String.format("%d %d", this.getPos().getX(), this.getPos().getY());
        return texte;
    }
}
