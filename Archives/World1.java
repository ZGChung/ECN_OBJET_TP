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
 * pour tester le fonctionnement de l'arrayList
 * @author zgchung
 */
public class World1 {
    //attributs
    
    ArrayList<Archer> arrayListArcher;
    ArrayList<Paysan> arrayListPaysan;
    ArrayList<Guerrier> arrayListGuerrier;
    ArrayList<Mage> arrayListMage;
    ArrayList<Lapin> arrayListLapin;
    ArrayList<Loup> arrayListLoup;  
    ArrayList<Potion> arrayListPotion;
    
    Random generateurAleatoire = new Random();
    //methodes
    public World1(int nbArcher, int nbPaysan, int nbLapin, int nbGuerrier, int nbMage, int nbLoup, int nbPotion){
        // créer les arrayLists
        this.arrayListArcher = new ArrayList<Archer>();
        this.arrayListPaysan = new ArrayList<Paysan>();
        this.arrayListGuerrier = new ArrayList<Guerrier>();
        this.arrayListMage = new ArrayList<Mage>();
        this.arrayListLapin = new ArrayList<Lapin>();
        this.arrayListLoup = new ArrayList<Loup>();
        this.arrayListPotion = new ArrayList<Potion>();
        
        // générer les créatures au hasard
        for(int i = 0 ; i < nbArcher ; i++ ){
            this.arrayListArcher.add(new Archer());
        }
        for(int i = 0 ; i < nbPaysan ; i++ ){
            this.arrayListPaysan.add(new Paysan());
        }
        for(int i = 0 ; i < nbGuerrier ; i++ ){
            this.arrayListGuerrier.add(new Guerrier());
        }
        for(int i = 0 ; i < nbMage ; i++ ){
            this.arrayListMage.add(new Mage());
        }
        
        for(int i = 0 ; i < nbLapin ; i++ ){
            this.arrayListLapin.add(new Lapin());
        }
        for(int i = 0 ; i < nbLoup ; i++ ){
            this.arrayListLoup.add(new Loup());
        }
        for(int i = 0 ; i < nbPotion ; i++ ){
            this.arrayListPotion.add(new Potion());
        }
        
    }

    public void tourDeJeu(){
        System.out.println("Jsp la fonctionnalité de cette méthode...");
    }
    public void testArrayList(){
        // parcours de tous les Personnages basée sur le nombre des éléments
        for (int i = 0 ; i < this.arrayListArcher.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Archer.");
            this.arrayListArcher.get(i).affiche();
        }
        // même parcours pour tous les Monstres
        for (int i = 0 ; i < this.arrayListPaysan.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Paysan.");
            this.arrayListPaysan.get(i).affiche();
        }
        for (int i = 0 ; i < this.arrayListMage.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Mage.");
            this.arrayListMage.get(i).affiche();
        }
        for (int i = 0 ; i < this.arrayListGuerrier.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Guerrier.");
            this.arrayListGuerrier.get(i).affiche();
        }
        
        for (int i = 0 ; i < this.arrayListLapin.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Lapin.");
            this.arrayListLapin.get(i).affiche();
        }
        for (int i = 0 ; i < this.arrayListLoup.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Loup.");
            this.arrayListLoup.get(i).affiche();
        }
        
        for (int i = 0 ; i < this.arrayListPotion.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Potion.");
            this.arrayListPotion.get(i).affiche();
        }
    }
        public Point2D barryCentre(ArrayList<Archer> list){
        int resX = 0;
        int resY = 0;
        for (int i = 0 ; i < list.size() ; i ++){
            resX += list.get(i).pos.getX();
            resY += list.get(i).pos.getY();
        }
        resX = (int)(resX/list.size());
        resY = (int)(resY/list.size());
        
        Point2D res = new Point2D(resX, resY);
        return res;
    }
    public Point2D barryCentre2(ArrayList<Archer> list){
        int resX = 0;
        int resY = 0;
        for (Archer a:list){
            resX += a.pos.getX();
            resY += a.pos.getY();
        }
        resX = (int)(resX/list.size());
        resY = (int)(resY/list.size());
        
        Point2D res = new Point2D(resX, resY);
        return res;
    }
}

