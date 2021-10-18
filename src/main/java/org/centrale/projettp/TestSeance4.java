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
     public static void main(String[] args){
         
         
         // creer un monde
         World2 monde4 = new World2(200,200);
         monde4.creeMondeAlea(20, 5, 3);
         monde4.afficheMonde();
         SauvegardePartie save = new SauvegardePartie("sauve1");
         save.sauvegarderPartie(monde4);
         
         
         
         
     }
}
