/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 * class pour tester les fontions basiques de Personnage et de Monstre
 * @version 1.0
 * @author uble zgchung
 */
public class TestSeance1 {
    public static void main(String[] args){
    Point2D p1 = new Point2D();
    p1.Affiche();
    Point2D p2 = new Point2D(2,3);
    p2.Affiche();
    Point2D p3 = new Point2D(p2);
    p3.Affiche();
    p3.SetPosition(0,0);
    p3.Affiche();
    p3.translate(1, 2);
    p3.Affiche();
    Monstre m1 = new Monstre();
    m1.affiche();
    m1.deplacer(1,2);
    m1.affiche();
    Lapin lap= new Lapin();
    lap.affiche();
    Lapin lap2 = new Lapin(lap);
    lap2.affiche();
    System.out.println("pay1");
    Paysan pay= new Paysan();
    pay.affiche();
    System.out.println("pay2");
    Paysan pay2 = new Paysan(pay);
    pay2.affiche();
    System.out.println("ar1");
    Archer ar= new Archer();
    ar.Affiche();
    Archer ar2 = new Archer(ar);
    ar2.Affiche();
    World w = new World();
    w.afficheMonde();
    System.out.println("Hello world!");
    Personnage perso = new Personnage();
    perso.affiche();
    Point2D posTest = new Point2D(10,12);
    perso = new Personnage("pNonRandom",120,110,12,13,14,15,16,17,150,15, posTest);
    perso.affiche();
    System.out.println("Test des getters : ");
    System.out.println("getDegAtt(): "+perso.getDegAtt());
    System.out.println("getPourcentageAtt(): "+perso.getPourcentageAtt());
    System.out.println("-----------");
    System.out.println("Test des setters : ");
    perso.setDegAtt(30);
    System.out.println("DegAtt apres modification: "+perso.getDegAtt());
    perso.setPourcentageAtt(22);
    System.out.println("PourcentageAtt apres modification: "+perso.getPourcentageAtt());
    System.out.println("-----------");
    System.out.println("Test de deplace() : ");
    System.out.println("Current position : ");
    perso.getPos().Affiche();
    perso.deplacer(1,2);
    System.out.println("Position apres deplacement : ");
    perso.getPos().Affiche();
    System.out.println("-----------");   

    } 
}
