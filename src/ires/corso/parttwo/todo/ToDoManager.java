package ires.corso.parttwo.todo;

import java.time.LocalDate;
import java.util.Scanner;

import static ires.corso.parttwo.todo.ToDoRepository.*;

// GRUPPO 2:
public class ToDoManager
{
    // Classe responsabile per le operazioni sull'insieme dei TO-DO:
    // - metodi per creazione nuovo TO-DO
    // - metodi per la modifica, la rimozione
    // - gestisce input utente (cioè loop di richiesta di quali campi devono essere modificati)
    // - ha al suo interno funzioni di controllo sull'input utente

    public static void createNewToDo() {
        ToDo t = new ToDo();
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci un ToDo");

        System.out.print("Titolo: ");
        t.setTitolo(in.nextLine());

        System.out.print("Data consegna: ");
        t.setDataConsegna(LocalDate.parse(in.nextLine()));

        System.out.print("Descrizione: ");
        t.setDescrizione(in.nextLine());

        System.out.print("priorita: ");
        t.setPriorita(ToDo.Priorita.valueOf(in.nextLine()));

        System.out.print("stato: ");
        t.setStato(ToDo.Stato.valueOf(in.nextLine()));

        add(t);
    }

    public void updateToDo() {
        // Chiede quale Id si vuole modificare
        // Si chiede un "clone" del TO-DO
        // Loop di richiesta dati da modificare
        // Salvataggio delle modifiche tramite ToDoRepository (update...)
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci l'ID dell'oggetto da modificare: ");
        long id = in.nextLong();

        ToDo toDoAppoggio = (_repository.toDoMap.get(id)).cloneForUpdate();


        boolean exit = false;

        while(!exit) {
            System.out.println("1. Titolo: ");
            System.out.println("2. Data consegna: ");
            System.out.println("3. Descrizione: ");
            System.out.println("4. priorita: ");
            System.out.println("5. stato: ");
            System.out.println("6. esci: ");
            System.out.print("Fai la tua scelta: ");

            int modifica = in.nextInt();

            switch (modifica) {
                case 1:
                    System.out.println("Inserisci nuovo titolo: ");
                    toDoAppoggio.setTitolo(in.nextLine());
                    break;

                case 2:
                    System.out.println("Inserisci nuovo Data Consegna: ");
                    toDoAppoggio.setDataConsegna(LocalDate.parse(in.nextLine()));
                    break;

                case 3:
                    System.out.println("Inserisci nuova Descrizione: ");
                    toDoAppoggio.setDescrizione(in.nextLine());
                    break;

                case 4:
                    System.out.println("Inserisci nuova priorita: ");
                    toDoAppoggio.setPriorita(ToDo.Priorita.valueOf(in.nextLine()));
                    break;
                case 5:
                    System.out.println("Inserisci nuovo stato: ");
                    toDoAppoggio.setStato(ToDo.Stato.valueOf(in.nextLine()));
                    break;

                case 6:
                    exit=true;
                    break;

            }
        }

        update(toDoAppoggio);

    }
}