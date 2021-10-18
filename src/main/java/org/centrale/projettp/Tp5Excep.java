/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

//import java.util.Random;
//import java.util.*;  
/**
 * class pour tester les exceptions
 * 
 * @author zgchung
 */
public class Tp5Excep {
    public static void main(String[] args) {
        /**
         * // ArrayIndexOutOfBoundsException ArrayList<Personnage> listPer = new
         * ArrayList<>(); Personnage p1 = new Personnage(); listPer.add(p1); for(int i =
         * 0 ; i <= listPer.size(); i++){ listPer.get(i); }
         */
        /**
         * // ClassCastException Personnage p = new Personnage(); Mage m = new Mage(); m
         * = (Mage)p; m.affiche();
         */

        // StackOverflowError
        /**
         * on écrit une fonction d'exemple pour la class Personnage : malAffiche()
         */
        Personnage p = new Personnage();
        p.malAffiche();

    }
}
