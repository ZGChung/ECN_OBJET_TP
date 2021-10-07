/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

/**
 *
 * @author zgchung
 */
public class TestSeance3 {
    public static void main(String[] args){
        System.out.println("Hello World!");
        
        
        long time1 = 0;
        long time2 = 0;
        
        time1 = System.nanoTime();
        World1 monde1 = new World1(1000000, 0, 0, 0, 0, 0, 0);
        Point2D res = new Point2D();
        res = monde1.barryCentre2(monde1.arrayListArcher);
        //monde1.testArrayList();
        time2 = System.nanoTime();
        System.out.println("Execution time (ms): ");
        System.out.println((time2-time1)/1000000);
        System.out.println("The barrycenter is: ");
        res.Affiche();
        
        
        /**
        long time3 = 0;
        long time4 = 0;
        
        time3 = System.nanoTime();
        World2 monde2 = new World2(1000000, 0, 0, 0, 0, 0, 0);
        //monde2.testLinkedList();
        Point2D res = new Point2D();
        res = monde2.barryCentre2(monde2.linkedListArcher);
        time4 = System.nanoTime();
        System.out.println("Execution time (ms): ");
        System.out.println((time4-time3)/1000000);
        System.out.println("The barrycenter is: ");
        res.Affiche();
        */
        
        /**
        long time5 = 0;
        long time6 = 0;
        
        time5 = System.nanoTime();
        World3 monde3 = new World3(2, 1, 2, 1, 1, 2, 0);
        monde3.testLinkedList();
        time6 = System.nanoTime();
        System.out.println("Execution time (ms): ");
        System.out.println((time6-time5)/1000000);
        */
    }
}
