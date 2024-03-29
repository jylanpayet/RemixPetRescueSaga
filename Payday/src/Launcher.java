import Jeu.Game;
import Jeu.Serialisation;
import Vue.Fenetre;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

import static java.awt.EventQueue.invokeLater;

public class Launcher implements Serializable {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("1 : Jouer en Terminal \n2 : Jouer en Interface \n3 : Faire jouer un bot \n0 : Exit");

            switch (sc.nextInt()) {
                case 0:
                    System.exit(0);
                    return;
                case 1:
                    playInConsole();
                    break;
                case 2:
                    playInInter();
                    break;
                case 3:
                    playBot();
                default:
                    System.exit(1);
                    return;
            }
        } catch (Exception e) {
            System.out.println("Une erreur a interrompu le jeu, Réessayez ...");
        }
    }

    public static void playInConsole() {
        Game game = Serialisation.lecture("./Ressource/game.ser");
        game.lanceurGame();
    }

    public static void playInInter() {
        EventQueue.invokeLater(() ->
        {
            String laf = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
            try {
                UIManager.setLookAndFeel(laf);
                Fenetre a = new Fenetre();
                a.setVisible(true);
            } catch (Exception e) {
                Fenetre a = new Fenetre();
                a.setVisible(true);
            }
        });
    }
    public static void playBot(){
        new Game().botGame();
    }
}
