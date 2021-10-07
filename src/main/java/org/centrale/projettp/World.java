/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;
import java.util.*;  

/**
 * class du monde, où les personnages et les monstres interagissent
 * @author zgchung
 */
public class World {
    //attributs
    Archer robin;
    Paysan peon;
    Lapin bugs1;
    Lapin bugs2;
    Archer guillaumeT;
    Guerrier grosBill;
    Mage merlin;
    Loup wolfie;
    
    Random generateurAleatoire = new Random();
    //methodes
    public World(){
        this.robin = new Archer();
        this.peon = new Paysan();
        this.bugs1 = new Lapin();
        this.bugs2 = new Lapin();
        this.guillaumeT = new Archer();
        this.grosBill = new Guerrier();
        this.merlin = new Mage();
        this.wolfie = new Loup();
    }
    
    /**
     * fonction pour generer un mode aleatoir
     * @author uble
     */
    /**
    public void creeMondeAlea(){
        System.out.println("Positionnement des personnages ");
        Point2D a = new Point2D(robin.getPos().getX()+generateurAleatoire.nextInt(5),robin.getPos().getY()+generateurAleatoire.nextInt(5));
        peon.setPos(a);
        while (peon.getPos()==robin.getPos()) {
            Point2D b = new Point2D(robin.getPos().getX()+generateurAleatoire.nextInt(5),robin.getPos().getY()+generateurAleatoire.nextInt(5));
            peon.setPos(b);
        }
        
        while (bugs1.getPos()==robin.getPos()) {
            Point2D b = new Point2D(robin.getPos().getX()+generateurAleatoire.nextInt(5),robin.getPos().getY()+generateurAleatoire.nextInt(5));
            bugs1.setPos(b);
        }
        
    }
    */
    
    public boolean estSuperpose(Point2D a, List<Point2D> list){
        for (Point2D pt:list){
            if (a.equals(pt)){
                return true;
                }
            }
        return false;
    } 
    /**
     * fonction pour generer un mode aleatoir
     * on doit assurer que tous les personnages sont né sur positions differentes
     * on assure que la distance entre un charactere et son voisin est < 5
     * @author zgchung
     */
    public void creeMondeAlea(){
        List<Point2D> listCreated=new ArrayList<Point2D>();
        System.out.println("----------");
        System.out.println("Methode : creeMondeAlea()");
        System.out.println("----------");
        
        Point2D ptTemp = new Point2D();
        ptTemp = this.robin.pos;
        listCreated.add(ptTemp);
        
        Point2D a = new Point2D(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
        // si la distance est trop grande, on refaire le generation du nombre aleatoir
        
        while(a.distance(ptTemp)>5 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
            // parcourir tous les positions generees
        }
        peon.setPos(a);
        
        ptTemp = this.peon.pos;
        listCreated.add(ptTemp);
        
        a = new Point2D(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
        // si la distance est trop grande, on refaire le generation du nombre aleatoir
        
        while(a.distance(ptTemp)>5 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
            // parcourir tous les positions generees
        }
        bugs1.setPos(a);
        
        
        ptTemp = this.bugs1.pos;
        listCreated.add(ptTemp);
        
        a = new Point2D(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
        // si la distance est trop grande, on refaire le generation du nombre aleatoir
        
        while(a.distance(ptTemp)>5 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
            // parcourir tous les positions generees
        }
        bugs2.setPos(a);
        
        ptTemp = this.bugs2.pos;
        listCreated.add(ptTemp);
        
        a = new Point2D(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
        // si la distance est trop grande, on refaire le generation du nombre aleatoir
        
        while(a.distance(ptTemp)>5 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
            // parcourir tous les positions generees
        }
        guillaumeT.setPos(a);
        
        ptTemp = this.guillaumeT.pos;
        listCreated.add(ptTemp);
        
        a = new Point2D(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
        // si la distance est trop grande, on refaire le generation du nombre aleatoir
        
        while(a.distance(ptTemp)>5 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
            // parcourir tous les positions generees
        }
        grosBill.setPos(a);
        
        
        ptTemp = this.grosBill.pos;
        listCreated.add(ptTemp);
        
        a = new Point2D(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
        // si la distance est trop grande, on refaire le generation du nombre aleatoir
        
        while(a.distance(ptTemp)>5 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
            // parcourir tous les positions generees
        }
        merlin.setPos(a);
        
        ptTemp = this.merlin.pos;
        listCreated.add(ptTemp);
        
        a = new Point2D(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
        // si la distance est trop grande, on refaire le generation du nombre aleatoir
        
        while(a.distance(ptTemp)>5 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(robin.getPos().getX()+generateurAleatoire.nextInt(5),
                robin.getPos().getY()+generateurAleatoire.nextInt(5));
            // parcourir tous les positions generees
        }
        wolfie.setPos(a);
       
    }
    
    public void afficheMonde(){
        /**
        System.out.println("Le monde est le suivant: ");
        robin.affiche();
        peon.affiche();
        bugs1.affiche();
        */
        String[][] grid = new String[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                grid[i][j] = "          |";
            }
        }
        grid[robin.pos.getX()][robin.pos.getY()] = "robin     |";
        grid[peon.pos.getX()][peon.pos.getY()] = "peon      |";
        grid[bugs1.pos.getX()][bugs1.pos.getY()] = "bugs1     |";
        grid[bugs2.pos.getX()][bugs2.pos.getY()] = "bugs2     |";
        grid[guillaumeT.pos.getX()][guillaumeT.pos.getY()] = "guillaumeT|";
        grid[grosBill.pos.getX()][grosBill.pos.getY()] = "grosBill  |";
        grid[merlin.pos.getX()][merlin.pos.getY()] = "merlin    |";
        grid[wolfie.pos.getX()][wolfie.pos.getY()] = "wolfie    |";
        
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }
    
    }
    public void tourDeJeu(){
        System.out.println("Jsp la fonctionnalité de cette méthode...");
    }
    

}
