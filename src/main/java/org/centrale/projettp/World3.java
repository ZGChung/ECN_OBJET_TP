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
 * pour tester le fonctionnement de le hashMap
 * @author zgchung
 */
public class World3 {
    //attributs
    
    HashMap<Integer, Archer> hashMapArcher;
    HashMap<Integer, Paysan> hashMapPaysan;
    HashMap<Integer, Guerrier> hashMapGuerrier;
    HashMap<Integer, Mage> hashMapMage;
    HashMap<Integer, Lapin> hashMapLapin;
    HashMap<Integer, Loup> hashMapLoup;  
    HashMap<Integer, Potion> hashMapPotion;
    
    Random generateurAleatoire = new Random();
    //methodes
    public World3(int nbArcher, int nbPaysan, int nbLapin, int nbGuerrier, int nbMage, int nbLoup, int nbPotion){
        // créer les arrayLists
        this.hashMapArcher = new HashMap<Integer, Archer>();
        this.hashMapPaysan = new HashMap<Integer, Paysan>();
        this.hashMapGuerrier = new HashMap<Integer, Guerrier>();
        this.hashMapMage = new HashMap<Integer, Mage>();
        this.hashMapLapin = new HashMap<Integer, Lapin>();
        this.hashMapLoup = new HashMap<Integer, Loup>();
        this.hashMapPotion = new HashMap<Integer, Potion>();
        
        // générer les créatures au hasard
        for(int i = 0 ; i < nbArcher ; i++ ){
            this.hashMapArcher.put(i, new Archer());
        }
        for(int i = 0 ; i < nbPaysan ; i++ ){
            this.hashMapPaysan.put(i, new Paysan());
        }
        for(int i = 0 ; i < nbGuerrier ; i++ ){
            this.hashMapGuerrier.put(i, new Guerrier());
        }
        for(int i = 0 ; i < nbMage ; i++ ){
            this.hashMapMage.put(i, new Mage());
        }
        
        for(int i = 0 ; i < nbLapin ; i++ ){
            this.hashMapLapin.put(i, new Lapin());
        }
        for(int i = 0 ; i < nbLoup ; i++ ){
            this.hashMapLoup.put(i, new Loup());
        }
        for(int i = 0 ; i < nbPotion ; i++ ){
            this.hashMapPotion.put(i, new Potion());
        }
        
    }

    public void tourDeJeu(){
        System.out.println("Jsp la fonctionnalité de cette méthode...");
    }
    public void testLinkedList(){
        // parcours de tous les Personnages basée sur le nombre des éléments
        for (int i = 0 ; i < this.hashMapArcher.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Archer.");
            this.hashMapArcher.get(i).affiche();
        }
        // même parcours pour tous les Monstres
        for (int i = 0 ; i < this.hashMapPaysan.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Paysan.");
            this.hashMapPaysan.get(i).affiche();
        }
        for (int i = 0 ; i < this.hashMapMage.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Mage.");
            this.hashMapMage.get(i).affiche();
        }
        for (int i = 0 ; i < this.hashMapGuerrier.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Guerrier.");
            this.hashMapGuerrier.get(i).affiche();
        }
        
        for (int i = 0 ; i < this.hashMapLapin.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Lapin.");
            this.hashMapLapin.get(i).affiche();
        }
        for (int i = 0 ; i < this.hashMapLoup.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Loup.");
            this.hashMapLoup.get(i).affiche();
        }
        
        for (int i = 0 ; i < this.hashMapPotion.size(); i ++){
            System.out.println("This is the "+(i+1)+"-th Potion.");
            this.hashMapPotion.get(i).affiche();
        }
    }
    
}

