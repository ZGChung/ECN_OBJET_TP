/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 * class des coordonnes d'un point 2D
 * @author uble zgchung
 */
public class Point2D {
    //creation of the x axis and y axis attributes
    private int X;
    private int Y;
    //contructor with no parameters

    /**
     *Constructeur vide
     */
    public Point2D(){
        X=5;
        Y=6;
    }

    /**
     * getter X
     * @return
     */
    public int getX() {
        return X;
    }

    /**
     * setter X
     * @param X
     */
    public void setX(int X) {
        this.X = X;
    }

    /**
     * getter Y
     * @return
     */
    public int getY() {
        return Y;
    }

    /**
     * setter Y
     * @param Y
     */
    public void setY(int Y) {
        this.Y = Y;
    }
    //Constructor with parameters

    /**
     * constructeur Point2D à partir des 2 coo
     * @param x
     * @param y
     */
    public Point2D(int x, int y){
        X=x;
        Y=y;
    }
    //Constructor which copy another one

    /**
     * copie d'un point
     * @param pt
     */
    public Point2D(Point2D pt){
        X=pt.X;
        Y=pt.Y;
    }
    //Afficheur

    /**
     * Affichage
     */
    public void Affiche(){
        System.out.println("["+X+","+Y+"]");
    }

    /**
     * setter position
     * @param x1
     * @param y1
     */
    public void SetPosition(int x1, int y1){
        X=x1;
        Y=y1;
    }

    /**
     * Translation 
     * @param dx
     * @param dy
     */
    public void translate(int dx, int dy){
        X=X+dx;
        Y=Y+dy;
    }

    /**
     * Mesure de distance
     * @param p
     * @return
     */
    public double distance(Point2D p){
        double dist;
        
        dist = Math.sqrt(Math.pow((X - p.getX()), 2)+Math.pow((Y - p.getY()), 2));
        return dist;
        
    }
    
    /**
     * test d'égalité entre positions
     * @param pt
     * @return
     */
    public boolean equals (Point2D pt) {
        if (this==pt) return true;
        if (this == null) return false;
        if (this.getClass() != pt.getClass()) return false;
        return (this.X == pt.X)&&(this.Y == pt.Y);
    }
}

