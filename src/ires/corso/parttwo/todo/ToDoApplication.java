package ires.corso.parttwo.todo;

import javafx.util.converter.LocalDateStringConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import static ires.corso.parttwo.todo.ToDoImportExport.*;
import static ires.corso.parttwo.todo.ToDoList.*;
import static ires.corso.parttwo.todo.ToDoManager.*;
import static ires.corso.parttwo.todo.ToDoRepository.*;


// GRUPPO 3/4:
public class ToDoApplication
{
    // 1. Deserializza il repository da file (carica i dati dell'ultimo salvataggio)
    //    creando una classe Repository
    // 2. Gestione del MENU principale con un loop e due switch
    // 3. In corrispondenza di una scelta dell'utente (ramo dello switch) chiama
    //    le classi necessarie per svolgere l'azione
    // 4. quando l'utente sceglie dal meno di uscire, chiede conferma e serializza in uscita
    // 5. Fornisce anche i metodi della classe "lettore" di quiz... askForInput , display

    public static void main(String[] args) throws Exception {

        init("Repository.ser");
        _repository = getToDoRepository();

        Scanner in = new Scanner(System.in);

        //menu
        boolean esci= false;
        int menu = 0;
        int sottomenu = 0;

        while (!esci){
            System.out.println("1.Visualizza");
            System.out.println("2. Aggiungi/Rimuovi/Modifica");
            System.out.println("3. Import/Export");
            System.out.println("4. Esci");
            System.out.print("Inserisci il numero dell'operazione da svolgere: ");
            menu = in.nextInt();
            switch (menu){
                case 1:
                    System.out.println("\n\n1.Visualizza1");
                    System.out.println("---1.per priorità");
                    System.out.println("---2.per data");
                    System.out.println("---3.per stato");

                    System.out.println("---Inserisci il numero dell'operazione da svolgere: ");
                    sottomenu = in.nextInt();
                    switch(sottomenu) {
                        case 1:
                            viewByPriority();
                            break;
                        case 2:
                            viewByDate();
                            break;
                        case 3:
                            viewByState();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\n\n2. Aggiungi/Rimuovi/Modifica");
                    System.out.println("---1.aggiungi (titolo, descrizione, data consegna, priorità)");
                    System.out.println("---2.Rimuovi (si passa: id)");
                    System.out.println("---3.Modifica (si passa: id, data di consegna, priorità, stato)");

                    System.out.print("---Inserisci il numero dell'operazione da svolgere: ");
                    sottomenu = in.nextInt();
                    switch(sottomenu) {
                        case 1:
                            createNewToDo();
                        break;
                    case 2:
                            deleteToDo();
                        break;
                    case 3:
                        updateToDo();
                        break;
                    }
                    break;

                case 3:
                    System.out.println("\n\n3.Import/Export");
                    System.out.println("---1.Export su file");
                    System.out.println("---2.Import su file");

                    System.out.print("---Inserisci il numero dell'operazione da svolgere: ");
                    sottomenu = in.nextInt();
                    switch(sottomenu) {
                        case 1:
                                exportToFile();
                            break;
                        case 2:
                            importToFile();
                            break;
                        case 3:

                            break;
                    }
                    break;
                case 4:
                    System.out.println("Arrivederci");
                    esci = true;

                    _repository.writeToFile("Repository.ser");
                    break;

            }

        }
    }
}


