package ires.corso.partthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

public class LambdaExpressions {
    public static void main(String[] args) {
        // 1. Data una lista di nomi:
        //    - Agnese Stefano, Niki, Veronica, GabrieleM, Davide, GabrieleG, Alessandor, Albnerto, Fabiola, Alessio, Daniele
        //    - ...partire con un ArrayList che li contiene;
        //    - trasformarlo in stream
        //    - filtrare (escludendoli) i nomi che hanno lunghezza < 5 lettere
        //    - trasformare con UPPERCASE i rimanenti
        //    - stamparli su schermo
        //    ...concatenando il più possibile le varie operazioni

        // 2. Fare un programma Java che:
        //    - chiede all'utente una lista di numeri (separati da virgola) <== RIUSATE IL CODICE DEL SORTING GAME
        //    - li trasforma in stream
        //    - filtra i duplicati (HINT: guardate bene i metodi dell'interfaccia Stream...)
        //    - eleva al quadrato i numeri filtrati
        //    - calcola la media (HINT: operazione terminale chiamata "average": https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/stream/IntStream.html#average())


        ArrayList<String> nomi = new ArrayList<>();

        nomi.addAll(Arrays.asList("Agnese","Stefano","Niki","Veronica","GabrieleM","Davide","GabrieleG","Alessandro","Alberto","Fabiola","Alessio","Daniele"));

        System.out.println(nomi);

        Stream<String> nomiStream = nomi.stream();

        nomiStream.filter(i -> i.length()>5).map(i -> i.toUpperCase(Locale.ROOT)).forEach(i -> System.out.print(i+ " "));

    }
}
