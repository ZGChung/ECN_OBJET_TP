/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;
import java.util.*;
import java.lang.*;
import java.lang.reflect.Constructor;

/**
 * TP5 classe Joueur Constructeurs, setters, getters
 * 
 * @version 1.0
 * @author zgchung
 * @param <T>
 */
public class Joueur<T extends Personnage> {
    // attributs
    private String nomJoueur;
    protected Personnage perso;
    private Class<T> type;
    private List<Personnage> listPerso;

    Random generateurAleatoire = new Random();

    // methodes
    // constructeur
    public Joueur() {
        super();
        this.nomJoueur = "JoueurAlea" + generateurAleatoire.nextInt(999);
        this.perso = new Personnage();
        this.type = null;
        this.listPerso = new ArrayList<Personnage>();
        this.listPerso.add(new Guerrier());
        this.listPerso.add(new Archer());
        this.listPerso.add(new Mage());
        this.listPerso.add(new Paysan());

    }

    public Joueur(String nomJoueur, String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM,
            int distMax, int ptP, Point2D pos, Class<T> type, List<Personnage> list) {
        super();
        this.nomJoueur = nomJoueur;
        this.perso = new Personnage(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, ptP, pos);

        Object obj = new Object();
        this.type = null;
        this.listPerso = list;
    }

    public Joueur(Joueur j) {
        super();
        this.nomJoueur = j.nomJoueur;
        this.perso = new Personnage(j.perso);
        this.type = j.type;
        this.listPerso = j.listPerso;
    }

    // getters and setters
    public List<Personnage> getListPerso() {
        return listPerso;
    }

    public void setListPerso(List<Personnage> listPerso) {
        this.listPerso = listPerso;
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

    // autres methodes
    public void choisirPersonnage() {
        Scanner sc = new Scanner(System.in); // standard input stream
        System.out.println("Choisir votre personnage en tapant le nom du type: ");
        String str = "org.centrale.projettp." + sc.nextLine(); // reads string

        ArrayList<String> list = new ArrayList<String>();
        this.listPerso.forEach(i -> {
            list.add(i.getClass().getName());
        });
        while (list.contains(str) == false) {
            System.out.println("Checkez votre input et reessayer, svp");
            str = sc.nextLine(); // reads string
        }
        System.out.println("Classe de personnage créée: " + str);
        try {
            Class cls = Class.forName(str);
            this.setType(cls);
            int indexList = 0;
            indexList = list.indexOf(str);
            this.perso = type.cast(listPerso.get(indexList));
            this.perso.affiche();
            // System.out.println("pt3"+ this.perso.getClass().getName());

        } catch (Exception e1) {
            System.out.println("Generation failed!");
        }
        // demander le nom
        System.out.println("Entrez le nom de votre personnage : ");
        String str2 = sc.nextLine();
        System.out.println("Le nom que vous avez choisi est : " + str2);
        this.nomJoueur = str2;

        // changer le range des nombres aléatoires

    }

    public String creerSauvegarde() {
        return "Joueur" + perso.creerSauvegarde();
    }
}
