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
 * @author zgchung uble
 */
public class World4 {
    
    //attributs
    
    HashMap<Integer, Creature> listCreature; 
    HashMap<Integer, Objet> listObjet; 
    HashMap<Integer, Joueur> listJoueurs;
    Integer mondeLongueur;
    Integer mondeLargeur;

    public HashMap<Integer, Joueur> getListJoueurs() {
        return listJoueurs;
    }

    public void setListJoueurs(HashMap<Integer, Joueur> listJoueurs) {
        this.listJoueurs = listJoueurs;
    }

    public Integer getMondeLongueur() {
        return mondeLongueur;
    }

    public void setMondeLongueur(Integer mondeLongueur) {
        this.mondeLongueur = mondeLongueur;
    }

    public Integer getMondeLargeur() {
        return mondeLargeur;
    }

    public void setMondeLargeur(Integer mondeLargeur) {
        this.mondeLargeur = mondeLargeur;
    }
    
    
    Random generateurAleatoire = new Random();
    //methodes
    public World4(int nbArcher, int nbPaysan, int nbLapin, int nbGuerrier, int nbMage, int nbLoup, int nbPotion, int mondeLongueur, int mondeLargeur, int nbJoueur){
        // créer les arrayLists
        this.listCreature = new HashMap<Integer, Creature>();
        this.listObjet= new HashMap<Integer, Objet>(); 
        int longeur = this.listCreature.size();
        for (int i  = 0 ; i < nbArcher; i ++){
            listCreature.put(longeur+i,new Archer());
        }
        longeur = this.listCreature.size();
        for (int i  = 0 ; i < nbPaysan; i ++){
            listCreature.put(longeur+i,new Paysan());
        }
        longeur = this.listCreature.size();
        for (int i  = 0 ; i < nbLapin; i ++){
            listCreature.put(longeur+i,new Lapin());
        }
        longeur = this.listCreature.size();
        for (int i  = 0 ; i < nbGuerrier; i ++){
            listCreature.put(longeur+i,new Guerrier());
        }
        longeur = this.listCreature.size();
        for (int i  = 0 ; i < nbMage; i ++){
            listCreature.put(longeur+i,new Mage());
        }
        longeur = this.listCreature.size();
        for (int i  = 0 ; i < nbLoup; i ++){
            listCreature.put(longeur+i,new Loup());
        }
        longeur = this.listCreature.size();
        for (int i  = 0 ; i < nbPaysan; i ++){
            listCreature.put(longeur+i,new Paysan());
        }
        
        int longeur2 = this.listObjet.size();
        for (int i  = 0 ; i < nbPotion; i ++){
            listObjet.put(longeur2+i, new Potion());
        }
        
        int longeur3 = this.listJoueurs.size();
        for (int i  = 0 ; i < nbJoueur; i ++){
            listJoueurs.put(longeur3+i, new Joueur());
        }
        // générer les créatures au hasard
        this.mondeLargeur= mondeLargeur;
        this.mondeLongueur = mondeLongueur;
    }
    
    
    

    public void tourDeJeu(){
        System.out.println("Jsp la fonctionnalité de cette méthode...");
    }

    public boolean caseOccupee(Point2D pt){
        boolean res = false;
        for (Creature c: this.listCreature.values()){
            if (c.pos.equals(pt)){
                res = true;
            }
        }
        return res;
        }
}

