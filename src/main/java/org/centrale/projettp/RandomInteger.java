/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;
// Dans un fichier RandomInteger.java
import java.util.Random;

/**
 * classe pour generer les nombres aleatoirs
 * @author prof
 * @version 1.0
 */

// On genere 10 entiers pseudo-aleatoires dans l'intervalle [0,99]
public class RandomInteger {
  public static void main(String[] args) {
    System.out.println("Generation de 10 nombres entiers dans l'intervalle [0,99]");
    
    // NB : il est INUTILE de creer plusieurs objets de type Random
    // UN SEUL suffit pour generer plusieurs 
    // nombres pseudo-aleatoires
    Random generateurAleatoire = new Random();
    
    // Boucle de generation des 10 nombres
    for(int i=0; i<10; i++) {
      // 100 ici definit la borne sup de l'intervalle
      int entierAlea = generateurAleatoire.nextInt(100);
      System.out.println("On vient de generer : "+entierAlea);
    }
  }
}