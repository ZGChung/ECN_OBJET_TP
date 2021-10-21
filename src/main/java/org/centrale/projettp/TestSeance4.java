/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;
import java.util.*;
import java.lang.*;

/**
 *
 * @author zgchung
 */
public class TestSeance4 {
    public static void main(String[] args) {

        // creer un monde
        System.out.println("-------------------");
        System.out.println("   Hello World!");
        System.out.println("-------------------");
        // System.out.println(" Create a world");
        // System.out.println("-------------------");
        // World2 monde4 = new World2(30, 30);
        // monde4.creeMondeAlea(20, 5, 20, 1);
        // monde4.jouer();

        System.out.println("-------------------");
        System.out.println("   Save a world!");
        System.out.println("-------------------");

        System.out.println("-------------------");
        System.out.println("   Load a world!");
        System.out.println("-------------------");
        ChargementPartie charge = new ChargementPartie("Sauvegarde-WoE.txt");
        World2 world = charge.chargerPartie();
        world.jouer();
    }
}
