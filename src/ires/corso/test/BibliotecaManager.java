package ires.corso.test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


import static ires.corso.test.BibliotecaRepositry.*;


public class BibliotecaManager {

    public static void createNewLibro() {
        Libro l = new Libro();
        Scanner in = new Scanner(System.in);

        System.out.println("------Inserisci un nuovo Libro--------");

        System.out.print("Inserisci un Titolo: ");
        l.setTitolo(in.nextLine());

        System.out.print("Inserisci un Autore: ");
        l.setAutore(in.nextLine());

        System.out.print("inserisci una Sinossi: ");
        l.setSinossi(in.nextLine());

        System.out.print("inserisci un Codice ISBN: ");
        l.setIsbn(in.nextLine());

        System.out.print("inserisci Data pubblicazione: ");
        l.setDataPubblicazine(LocalDate.parse(in.nextLine()));

        System.out.print("inserisci Genere: ");
        l.setGenere(Libro.Genere.valueOf(in.nextLine()));

        repository.add(l);
    }

    public static void deleteLibro(){
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci l'ID del libro da eliminare: ");
        long id = in.nextLong();

        repository.delete(repository.Libri.get(id).getId());
    }

    public static void updateLibro() {

        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci l'ID del libro da modificare: ");
        long id = in.nextLong();

        Libro libroAppoggio = (repository.Libri.get(id)).cloneForUpdate();

        boolean exit = false;

        while(!exit) {
            System.out.println("---------UPDATE LIBRO--------");
            System.out.println("1. Titolo ");
            System.out.println("2. Autore");
            System.out.println("3. Sinossi ");
            System.out.println("4. Codice ISBN ");
            System.out.println("5. Data pubblicazione ");
            System.out.println("6. Genere ");
            System.out.println("7. Esci ");
            System.out.print("Fai la tua scelta: ");

            String modifica = in.nextLine();

            switch (modifica) {
                case "1":
                    System.out.println("Inserisci nuovo titolo: ");
                    libroAppoggio.setTitolo(in.nextLine());
                    break;

                case "2":
                    System.out.println("Inserisci nuovo autore: ");
                    libroAppoggio.setAutore(in.nextLine());
                    break;

                case "3":
                    System.out.println("Inserisci nuova sinossi: ");
                    libroAppoggio.setSinossi(in.nextLine());
                    break;

                case "4":
                    System.out.println("Inserisci nuovo ISBN: ");
                    libroAppoggio.setIsbn(in.nextLine());
                    break;

                case "5":
                    System.out.println("Inserisci nuova data di pubblicazione: ");
                    libroAppoggio.setDataPubblicazine(LocalDate.parse(in.nextLine()));
                    break;
                case "6":
                    System.out.println("Inserisci nuovo genere: ");
                    libroAppoggio.setGenere(Libro.Genere.valueOf(in.nextLine()));
                    break;

                case "7":
                    exit=true;
                    break;

                default:
                    System.out.println("Scelta non presente nel menu");

            }
        }

        repository.update(libroAppoggio);

    }

    public static void view() {

        ArrayList<Libro> libriList = new ArrayList<>();
        libriList = (ArrayList<Libro>) getLibroList();

        Comparator<Libro> compare = new Comparator<Libro>() {
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getTitolo().compareTo(l2.getTitolo());
            }
        };

        Collections.sort(libriList, compare);
        libriList.forEach(l -> System.out.println(l.prettyprint()));
    }

    public static void avanzamentoLettura(){
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci ID del libro: ");

        Libro l = repository.Libri.get(in.nextLine());
        System.out.println("----LIBRO SCELTO----");
        l.prettyprint();

        System.out.println("Inserisci la percentuale di avanzamento della lettura: ");
        Integer av = in.nextInt();

        if (av!=100 && av>l.getAvanzamento()){
            l.setAvanzamento(av);
        }else if (av == 100){
            System.out.println("Lettura completata, non può essere aggiornata");
        }else{
            System.out.println("Percentuale di lettura già raggiunta");
        }




    }

    public static void giudizioPersonale(){
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci ID del libro: ");

        Libro l = repository.Libri.get(in.nextLine());
        System.out.println("----LIBRO SCELTO----");
        l.prettyprint();
        if (l.getAvanzamento() == 100){
            System.out.println("Giudizio del libro(OTTIMO,BUONO,SUFFICIENTE,NON_SUFFIICIENTE,PESSIMO): ");
            l.setGiudizio(Libro.GiudizioPersonale.valueOf(in.nextLine()));
        }else{
            System.out.println("Non è possible inserire un giudizio prima della fine della lettura del libro");
        }
    }
}
