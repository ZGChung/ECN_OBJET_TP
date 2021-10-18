/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

//import java.util.Random;
import java.util.*;

//import java.lang.*;
/**
 *
 * @author zgchung
 */
public class TestSeance4 {
    public static void main(String[] args) {
        // choisir un Personnage
        Joueur j = new Joueur();
        j.choisirPersonnage();
        System.out.println("Hello World");

        // creer un monde
        World4 monde4 = new World4(0, 0, 50, 0, 0, 30, 0);
        Personnage p = new Personnage();
        p = j.getPerso();
        // System.out.println(Arrays.asList(monde4.listCreature));

        int tours = 1; // counter of round of game
        Scanner sc = new Scanner(System.in); // standard input stream
        while (p.ptVie > 0 && tours < 51) {

            if (monde4.caseOccupee(p.pos) == true) {
                // meet a creature
                System.out.println("combattre ou deplacer: ");
                String str = sc.nextLine();
                while (!str.equals("combattre") && !str.equals("deplacer")) {
                    System.out.println("Please check your input and retry.");
                }
                if (str.equals("combattre")) {
                    System.out.println("Methodes combattre() not finished yet");
                } else if (str.equals("deplacer")) {
                    System.out.println("X for deplacer: ");
                    int comX = 0;
                    int comY = 0;
                    comX = sc.nextInt();
                    System.out.println("Y for deplacer: ");
                    comY = sc.nextInt();
                    Point2D comPt = new Point2D(comX, comY);
                    while (monde4.caseOccupee(comPt) == true) {
                        System.out.println("Case occupied, please choose another position");
                        System.out.println("X for deplacer: ");
                        comX = 0;
                        comY = 0;
                        comX = sc.nextInt();
                        System.out.println("Y for deplacer: ");
                        comY = sc.nextInt();
                        comPt = new Point2D(comX, comY);
                    }
                    p.deplacer(comX, comY);

                }

            } else // didn't meet anyone
            {
                System.out.println("Didn't meet anyone, please deplacer");
                System.out.println("X for deplacer: ");
                int comX = 0;
                int comY = 0;
                comX = sc.nextInt();
                System.out.println("Y for deplacer: ");
                comY = sc.nextInt();
                Point2D comPt = new Point2D(comX, comY);
                while (monde4.caseOccupee(comPt) == true) {
                    System.out.println("Case occupied, please choose another position");
                    System.out.println("X for deplacer: ");
                    comX = 0;
                    comY = 0;
                    comX = sc.nextInt();
                    System.out.println("Y for deplacer: ");
                    comY = sc.nextInt();
                    comPt = new Point2D(comX, comY);
                }
                p.deplacer(comX, comY);
            }
            // at the end of a round, count a round
            tours = tours + 1;
        }

    }
}
