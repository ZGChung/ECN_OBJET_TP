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
public class Potion extends Objet {
    //attributs
    private int pt;
    private Point2D pos;
    private boolean use;

    public boolean isUse() {
        return use;
    }

    public void setUse(boolean use) {
        this.use = use;
    }

    public int getPt() {
        return pt;
    }

    public void setPt(int pt) {
        this.pt = pt;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    public Potion(){
        this.pt=0;
        this.pos= new Point2D(0,0);
        this.use=true;
    }
    public Potion(int point,Point2D position){
        this.pt=point;
        this.pos= position;
        this.use=true;
    }
    public Potion(Potion p){
        this.pt=p.pt;
        this.pos= new Point2D(p.pos.getX(),p.pos.getY());
        this.use=p.use;
    }
    
    public void affiche(){
        System.out.println("Le point de cette potion est:"+this.pt);
    }
    
}
