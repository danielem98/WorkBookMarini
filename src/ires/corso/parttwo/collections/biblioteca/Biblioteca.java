package ires.corso.parttwo.collections.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public static void main(String[] args) {

        Categoria c1 = new Categoria("Fantasy", " ");

        Libro l1 = new Libro("Giorgio", "2018", 180, 1, 15);
        Libro l2 = new Libro("Marco", "2013", 580, 1, 10);

        l1.getCategorie().add(c1);
        l2.getCategorie().add(c1);


        Prestito p1 = new Prestito();

        p1.getPrestito().add(l1);
        p1.getPrestito().add(l2);

        Utente u1 = new Utente("Daniele", "Marini");

        u1.setPrestito(p1);

        List<Utente> utenti = new ArrayList<>();
        utenti.add(u1);

        int fantasy = 0;

        for (Utente u : utenti) {
            Prestito p = u.getPrestito();
            for (Libro l : p.getPrestito()) {
                for (Categoria c : l.getCategorie()) {
                    if(c.getTitolo().equals("Fantasy"))
                        fantasy++;

                }
            }

        }

        System.out.println(fantasy);

    }
}
