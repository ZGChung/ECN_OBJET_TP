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
        Scanner sc = new Scanner(System.in);
        // creer un monde
        System.out.println("-------------------");
        System.out.println("   Hello World!");
        System.out.println("-------------------");
        System.out.println("\nVeuillez choisir un mode de commencer :");
        System.out.println(" 1 : Start a new game.");
        System.out.println(" 2 : Load a game.");
        int mode = 0;
        while (mode != 1 && mode != 2) {
            System.out.println("Veuillez entrer un numéro:");
            mode = sc.nextInt();
        }
        switch (mode) {
        case 1: // Start a new game
            System.out.println("-------------------");
            System.out.println(" Create a world");
            System.out.println("-------------------");
            World2 monde4 = new World2(30, 30);
            monde4.creeMondeAlea(20, 5, 20, 1);
            monde4.jouer();
            break;
        case 2: // Load a game
            System.out.println("-------------------");
            System.out.println("   Load a world!");
            System.out.println("-------------------");
            System.out.println("Please input the name of save file");
            String saveName;
            sc = new Scanner(System.in);
            saveName = sc.nextLine();
            System.out.println("The file you input is: " + saveName);
            try {
                ChargementPartie charge = new ChargementPartie(saveName);
                // ChargementPartie charge = new ChargementPartie("Sauvegarde-WoE.txt");
                World2 world = charge.chargerPartie();
                world.jouer();

            } catch (Exception e1) {
                System.out.println("The file name that you entered was wrong.");
            }
            break;

        }

        // System.out.println("-------------------");
        // System.out.println(" Save a world!");
        // System.out.println("-------------------");
        System.out.println("-------------------");
        System.out.println("  Game is closed.");
        System.out.println("-------------------");
    }
}
