/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.centrale.projettp;

/**
 * class pour tester le fonctions de manipulation des point 2D
 * @version 1.0
 * @author uble
 */
public class TestPoint2D {
    public static void main1(String[] args){
    Point2D p1 = new Point2D();
    p1.Affiche();
    Point2D p2 = new Point2D(2,3);
    p2.Affiche();
    Point2D p3 = new Point2D(p2);
    p3.Affiche();
    p3.translate(1,2);
    p3.Affiche();
    p3.setX(3);
    p3.setY(9);
    p3.Affiche();
    
    } 
}

