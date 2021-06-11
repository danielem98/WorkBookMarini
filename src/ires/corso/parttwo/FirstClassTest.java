package ires.corso.parttwo;

import ires.corso.parttwo.classes.*;

import java.util.Scanner;

public class FirstClassTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Car c = new Car("X54ZSTP", "Ferrari", 2);
        System.out.println("scegli il colore della macchina: ");
        String colore = in.nextLine();
        c.setColore(colore);
        c.prettyPrint();

        Tree b = new Tree("Pino", true);
        System.out.println("scegli l'eta dell'albero: ");
        int eta = in.nextInt();
        b.setEta(eta);

        Tree b2 = new Tree("Pino", true);
        Tree b3 = new Tree("Olmo", false);

        b.prettyPrint();
        b2.prettyPrint();
        b3.prettyPrint();
    }
}
