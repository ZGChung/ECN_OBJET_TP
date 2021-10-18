package org.centrale.projettp;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jean-Marie Normand (jean-marie.normand@ec-nantes.fr)
 */
import java.io.*;

public class TestBufferedReader {
  protected String source;

  public TestBufferedReader(String source) {
    this.source = source;
    lecture();
  }

  public void lecture() {
    try {
      String ligne;
      BufferedReader fichier = new BufferedReader(new FileReader(source));
      ligne = fichier.readLine();

      while (ligne != null) {
        System.out.println(ligne);
        ligne = fichier.readLine();

      }

      fichier.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}