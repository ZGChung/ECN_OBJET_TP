package org.centrale.projettp;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import java.lang.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.*;

/**
 * Class de chargement
 * @author uble
 */
public class ChargementPartie {
    private String nomSauvegarde;
    // BufferedReader bfrd;
    protected List<String> listCreaturePossible;
    protected List<String> listObjetPossible;
    protected List<Creature> listCreature;
    protected List<Objet> listObjet;

    /**
     * Constructeur à partir d'un nom
     * @param nomSauvegarde
     */
    protected ChargementPartie(String nomSauvegarde) {
        this.nomSauvegarde = nomSauvegarde;
        this.listCreature = new ArrayList<Creature>();
        this.listCreature.add(new Archer());
        this.listCreature.add(new Paysan());
        this.listCreature.add(new Mage());
        this.listCreature.add(new Guerrier());
        this.listCreature.add(new Loup());
        this.listCreature.add(new Lapin());

        this.listObjet = new ArrayList<Objet>();
        this.listObjet.add(new Soin());
        this.listObjet.add(new Mana());
        this.listObjet.add(new NuageToxique());

        this.listCreaturePossible = new ArrayList<String>();
        this.listCreature.forEach(i -> {
            listCreaturePossible.add(i.getClass().getName());
        });

        this.listObjetPossible = new ArrayList<String>();
        this.listObjet.forEach(i -> {
            listObjetPossible.add(i.getClass().getName());
        });

    }

    /**
     *Méthode de chargement
     * @return
     */
    protected World2 chargerPartie() {

        World2 returnWorld = new World2(100, 100);
        String className;
        Class cls;
        int indexList = 0;
        String nameOfAClass = "Default_Class_Name";
        String nameOfAnElement = "Default_Element_Name";
        List<Integer> argList = new ArrayList<Integer>();
        List<String> stringOfAJoueur = new ArrayList<String>();
        Constructor c;
        // read the file
        String delimiteurs = " ,.;";

        System.out.println("---Loading---");
        try {
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader(this.nomSauvegarde));
            ligne = fichier.readLine();
            while (ligne != null) {

                // if read a line successfully
                StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);
                // deal with the first word in each line
                String mot = tokenizer.nextToken();
                // System.out.println(mot);
                if (this.listCreaturePossible.contains("org.centrale.projettp." + mot)) {
                    // line of info for a creature

                    // System.out.println("line of a creature");
                    nameOfAClass = mot;
                    className = "org.centrale.projettp." + mot;
                    cls = Class.forName(className);
                    indexList = listCreaturePossible.indexOf("org.centrale.projettp." + mot);
                    // read the parameters

                    // deal with the second input : the name (String)

                    while (tokenizer.hasMoreTokens()) {
                        mot = tokenizer.nextToken();
                        try {
                            argList.add(Integer.parseInt(mot));
                        } catch (NumberFormatException e1) {
                            nameOfAnElement = mot;
                        }

                    }

                    if (nameOfAClass.equals("Guerrier") || nameOfAClass.equals("Archer")
                            || nameOfAClass.equals("Mage")) {
                        Class paraClassList[] = new Class[] { String.class, int.class, int.class, int.class, int.class,
                                int.class, int.class, int.class, int.class, int.class, int.class, Point2D.class,
                                int.class, };

                        // Class paraClassList[] = new Class[] { Guerrier.class };
                        c = cls.getConstructor(paraClassList);

                        Object crea = c.newInstance(nameOfAnElement, argList.get(0), argList.get(1), argList.get(2),
                                argList.get(3), argList.get(4), argList.get(5), argList.get(6), argList.get(7),
                                argList.get(8), argList.get(9), new Point2D(argList.get(10), argList.get(11)), 0);
                        // after the creation of one Creature, reset the argList
                        // System.out.println("Show a class1 : " + crea.getClass().toString());
                        argList.clear();
                        returnWorld.listCreature.put(returnWorld.listCreature.size(), (Creature) crea);
                        // System.out.println("Show a class2 : " + ((Guerrier)
                        // crea).getClass().toString());

                        try {
                            returnWorld.map[((Guerrier) crea).pos.getX()][((Guerrier) crea).pos.getY()] = " G ";
                            returnWorld.tabCreature[((Guerrier) crea).pos.getX()][((Guerrier) crea).pos
                                    .getX()] = (Creature) crea;
                        } catch (ClassCastException e1) {
                            try {
                                returnWorld.map[((Mage) crea).pos.getX()][((Mage) crea).pos.getY()] = " M ";
                                returnWorld.tabCreature[((Mage) crea).pos.getX()][((Mage) crea).pos
                                        .getX()] = (Creature) crea;
                            } catch (ClassCastException e2) {
                                try {
                                    returnWorld.map[((Archer) crea).pos.getX()][((Archer) crea).pos.getY()] = " A ";
                                    returnWorld.tabCreature[((Archer) crea).pos.getX()][((Archer) crea).pos
                                            .getX()] = (Creature) crea;
                                } catch (ClassCastException e3) {
                                    System.out.println("Cast Error");
                                }
                            }
                        }

                        // System.out.println(returnWorld.listCreature);

                    } else if (nameOfAClass.equals("Paysan")) {
                        // separate the case for Paysan because we didn't add the attribut nbFleche for
                        // Paysan
                        // In the example given by the prof, nbFleche is not saved
                        // So I set this attribut to 0 for all the related objects.
                        Class paraClassList[] = new Class[] { String.class, int.class, int.class, int.class, int.class,
                                int.class, int.class, int.class, int.class, int.class, int.class, Point2D.class };

                        // Class paraClassList[] = new Class[] { Guerrier.class };
                        c = cls.getConstructor(paraClassList);

                        Object crea = c.newInstance(nameOfAnElement, argList.get(0), argList.get(1), argList.get(2),
                                argList.get(3), argList.get(4), argList.get(5), argList.get(6), argList.get(7),
                                argList.get(8), argList.get(9), new Point2D(argList.get(10), argList.get(11)));
                        // after the creation of one Creature, reset the argList
                        argList.clear();
                        returnWorld.listCreature.put(returnWorld.listCreature.size(), (Creature) crea);
                        returnWorld.map[((Paysan) crea).pos.getX()][((Paysan) crea).pos.getY()] = " P ";
                        returnWorld.tabCreature[((Paysan) crea).pos.getX()][((Paysan) crea).pos
                                .getX()] = (Creature) crea;
                        // System.out.println(returnWorld.listCreature);

                    } else if (nameOfAClass.equals("Loup") || nameOfAClass.equals("Lapin")) {
                        Class paraClassList[] = new Class[] { int.class, int.class, int.class, int.class, int.class,
                                Point2D.class };

                        // Class paraClassList[] = new Class[] { Guerrier.class };
                        c = cls.getConstructor(paraClassList);

                        Object crea = c.newInstance(argList.get(0), argList.get(1), argList.get(2), argList.get(3),
                                argList.get(4), new Point2D(argList.get(5), argList.get(6)));
                        // after the creation of one Creature, reset the argList
                        argList.clear();
                        returnWorld.listCreature.put(returnWorld.listCreature.size(), (Creature) crea);
                        // System.out.println(returnWorld.listCreature);

                        try {
                            returnWorld.map[((Loup) crea).pos.getX()][((Loup) crea).pos.getY()] = " L ";
                            returnWorld.tabCreature[((Loup) crea).pos.getX()][((Loup) crea).pos
                                    .getX()] = (Creature) crea;
                        } catch (ClassCastException e1) {
                            try {
                                returnWorld.map[((Lapin) crea).pos.getX()][((Lapin) crea).pos.getY()] = " l ";
                                returnWorld.tabCreature[((Lapin) crea).pos.getX()][((Lapin) crea).pos
                                        .getX()] = (Creature) crea;
                            } catch (ClassCastException e2) {

                                System.out.println("Cast Error");

                            }
                        }
                    }

                } else if (this.listObjetPossible.contains("org.centrale.projettp." + mot)) {
                    // line of an object

                    // System.out.println("line of an object");
                    nameOfAClass = mot;
                    className = "org.centrale.projettp." + mot;
                    cls = Class.forName(className);
                    indexList = listObjetPossible.indexOf("org.centrale.projettp." + mot);

                    // load the parameters
                    while (tokenizer.hasMoreTokens()) {
                        mot = tokenizer.nextToken();
                        try {
                            argList.add(Integer.parseInt(mot));
                        } catch (NumberFormatException e1) {
                            nameOfAnElement = mot;
                        }

                    }

                    if (nameOfAClass.equals("Soin") || nameOfAClass.equals("Mana")) {
                        Class paraClassList[] = new Class[] { int.class, Point2D.class };

                        // Class paraClassList[] = new Class[] { Guerrier.class };
                        c = cls.getConstructor(paraClassList);

                        Object obj = c.newInstance(argList.get(0), new Point2D(argList.get(1), argList.get(2)));
                        // after the creation of one Objet, reset the argList
                        argList.clear();
                        returnWorld.listObjet.put(returnWorld.listObjet.size(), (Objet) obj);
                        // System.out.println(returnWorld.listObjet);
                        try {
                            // returnWorld.map[((Soin) obj).pos.getX()][((Soin) obj).pos.getY()] = " L ";
                            returnWorld.tabObj[((Soin) obj).pos.getX()][((Soin) obj).pos.getY()].add((Soin) obj);

                        } catch (ClassCastException e1) {
                            try {
                                // returnWorld.map[((Mana) obj).pos.getX()][((Mana) obj).pos.getY()] = " l ";
                                returnWorld.tabObj[((Mana) obj).pos.getX()][((Mana) obj).pos.getY()].add((Mana) obj);
                            } catch (ClassCastException e2) {

                                System.out.println("Cast Error");

                            }
                        }

                    } else if (nameOfAClass.equals("NuageToxique")) {
                        Class paraClassList[] = new Class[] { int.class, new ArrayList<Point2D>().getClass() };

                        // Class paraClassList[] = new Class[] { Guerrier.class };
                        c = cls.getConstructor(paraClassList);
                        Point2D p = new Point2D(argList.get(1), argList.get(2));
                        ArrayList<Point2D> tempList = new ArrayList<Point2D>();
                        tempList.add(p);
                        for (int i = 1; i < Math.round(argList.get(3)/ 4); i++) {
                                // On étend le nuage en carré
                                for (int j = 0; j <= i; j++) {
                                    tempList.add(new Point2D(p.getX() + i, p.getY() + j));
                                    tempList.add(new Point2D(p.getX() + j, p.getY() + i));

                                }

                            }
                        Object obj = c.newInstance(argList.get(0), tempList);
                        // after the creation of one Objet, reset the argList
                        argList.clear();
                        returnWorld.listObjet.put(returnWorld.listObjet.size(), (Objet) obj);
                        // System.out.println(returnWorld.listObjet);
                        // returnWorld.map[((NuageToxique) obj).pos.getX()][((NuageToxique)
                        // obj).pos.getX()] = " n ";
                        returnWorld.tabObj[((NuageToxique) obj).listeCase.get(0).getX()][((NuageToxique) obj).listeCase
                                .get(0).getY()].add((NuageToxique) obj);
                        for (int i = 0; i < tempList.size(); i++) {
                            if (tempList.get(i).getX()>0 && tempList.get(i).getX()<returnWorld.mondeLongueur && tempList.get(i).getY()>0 && tempList.get(i).getY()<returnWorld.mondeLargeur){
                                returnWorld.tabObj[tempList.get(i).getX()][tempList.get(i).getY()].add((NuageToxique) obj) ;
                            }
        }
                    }

                } else if (mot.equals("Largeur")) {
                    // lien of L
                    // System.out.println("line of L");
                    mot = tokenizer.nextToken();
                    returnWorld.mondeLargeur = Integer.parseInt(mot);

                } else if (mot.equals("Hauteur")) {
                    // line of H
                    // System.out.println("line of H");
                    mot = tokenizer.nextToken();
                    returnWorld.mondeLongueur = Integer.parseInt(mot);

                    // System.out.println(mot);
                } else if (mot.equals("Joueur")) {
                    // a line of joueur
                    // System.out.println("line of a player");
                    nameOfAClass = mot;
                    className = "org.centrale.projettp." + mot;
                    cls = Class.forName(className);
                    indexList = listObjetPossible.indexOf("org.centrale.projettp." + mot);

                    // load the parameters
                    while (tokenizer.hasMoreTokens()) {
                        mot = tokenizer.nextToken();
                        try {
                            argList.add(Integer.parseInt(mot));
                        } catch (NumberFormatException e1) {
                            stringOfAJoueur.add(mot);
                        }

                    }
                    // System.out.println(mot);
                    // different loading according to its type of character
                    if (stringOfAJoueur.get(0).equals("Guerrier") || stringOfAJoueur.get(0).equals("Archer")
                            || stringOfAJoueur.get(0).equals("Mage")) {
                        cls = Class.forName("org.centrale.projettp." + stringOfAJoueur.get(0));
                        Joueur j = new Joueur(nameOfAClass, stringOfAJoueur.get(1), argList.get(0), argList.get(1),
                                argList.get(2), argList.get(3), argList.get(4), argList.get(5), argList.get(6),
                                argList.get(7), argList.get(8), argList.get(9),
                                new Point2D(argList.get(10), argList.get(11)), cls);
                        returnWorld.listJoueurs.put(returnWorld.listJoueurs.size(), j);
                        // after the creation of one Creature, reset the argList
                        argList.clear();
                        System.out.println("listJoueurs" + returnWorld.listJoueurs);

                    } else if (stringOfAJoueur.get(0).equals("Paysan")) {
                        cls = Class.forName("org.centrale.projettp." + stringOfAJoueur.get(0));
                        Joueur j = new Joueur(nameOfAClass, stringOfAJoueur.get(1), argList.get(0), argList.get(1),
                                argList.get(2), argList.get(3), argList.get(4), argList.get(5), argList.get(6),
                                argList.get(7), argList.get(8), argList.get(9),
                                new Point2D(argList.get(10), argList.get(11)), cls);
                        returnWorld.listJoueurs.put(returnWorld.listJoueurs.size(), j);
                        // after the creation of one Creature, reset the argList
                        argList.clear();
                        System.out.println("listJoueurs" + returnWorld.listJoueurs);
                        // returnWorld.map

                    }

                } else {
                    System.out.println("Loading Error.");
                    System.out.println("The error is caused by: " + mot);
                }
                // System.out.println("FIRST WORD!" + mot);
                // end of the process of the first word of the line

                // the end of the process of a line

                ligne = fichier.readLine();
            }
            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
         * System.out.print("End 1"); for (int i = 0; i <
         * returnWorld.listCreature.size(); i++) {
         * System.out.print(returnWorld.listCreature.get(i).getClass().getName()); } for
         * (int i = 0; i < returnWorld.listObjet.size(); i++) {
         * System.out.print(returnWorld.listObjet.get(i).getClass().getName()); }
         * System.out.print("End 2");
         */

        System.out.println("---Loading Finished---");
        return returnWorld;

    }
}
