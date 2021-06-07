package ires.corso.partone;

import ires.corso.partone.geometric.Quadrato;
import ires.corso.partone.geometric.Trapezio;
import ires.corso.partone.geometric.Triangolo;

import java.util.Scanner;

/**
 * Scrivere un programma Java che esegua le seguenti operazioni:
 * 1. chiede all'utente per che tipo di forma geometrica desidera calcolare l'area
 * 2. le figure da trattare sono 3: Quadrato, Triangolo, Trapezio
 * 3. per la figura prescelta, chiede i parametri necessari al calcolo dell'area
 * 4. calcola l'area utilizzando l'apposita formula geometrica
 * 5. stampa il risultato
 *
 * Utilizzare per le parti di codice spcifiche di una figura tre classi,
 * implementando i relativi metodi come "static": Quadrato.java, Trapezio.java, Triangolo.java
 *
 * Per l'input utilizzare la classe Scanner; per discriminare tra le classi da chiamare usate un'istruzione switch
 */

public class ShapeTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci la forma geometrica: ");
        String s = in.next();

        switch(s){
            case "quadrato":
                System.out.println("lunghezza lato ");
                int l = in.nextInt();

                double aQuad= Quadrato.computerArea(l);

                System.out.println("L'area e': " + aQuad);
                break;

            case "triangolo":
                System.out.println("base: ");
                double basTr = in.nextDouble();

                System.out.println("Altezza: ");
                double altTr = in.nextDouble();
                double aTri = Triangolo.computerArea(basTr,altTr);

                System.out.println("L'area e': " + aTri);
                break;

            case "trapezio":
                System.out.println("Base maggiore ");
                double bmajTra = in.nextDouble();

                System.out.println("Base minore ");
                double bminTra = in.nextDouble();

                System.out.println("Altezza ");
                double heightTra = in.nextDouble();

                double aTrap = Trapezio.computerArea(bmajTra,bminTra,heightTra);

                System.out.println("l'area e' : " + aTrap);
                break;

            default:
                System.out.println("Non hai inserito una forma corretta ");
        }


    }
}
