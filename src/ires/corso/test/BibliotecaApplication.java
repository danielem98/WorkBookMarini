package ires.corso.test;

import java.util.Scanner;

import static ires.corso.test.BibliotecaManager.*;
import static ires.corso.test.BibliotecaRepositry.*;
import static ires.corso.test.BibliotecaRepositry.getBibliotecaRepostory;
import static ires.corso.test.LibroIE.*;

public class BibliotecaApplication {
    public static void main(String[] args) throws Exception {
        BibliotecaRepositry.init("RepositoryLibro.ser");

        BibliotecaRepositry _repository = BibliotecaRepositry.getBibliotecaRepostory();


        Scanner in = new Scanner(System.in);

        boolean esci= false;
        String menu;

        while (!esci){
            System.out.println("------------MENU-------------");
            System.out.println("a. Visualizzazione dei volumi esistenti");
            System.out.println("b. Aggiunta di un volume");
            System.out.println("c. Modifica di un volume");
            System.out.println("d. Eliminaione di un volume");
            System.out.println("e. Avanzamento lettura");
            System.out.println("f. Giudizio personale");
            System.out.println("g. Import File");
            System.out.println("h. Export File");
            System.out.println("i. Uscita");

            System.out.print("Inserisci il numero dell'operazione da svolgere: ");
            menu = in.nextLine();
            switch (menu){
                case "a":
                    view();
                    break;
                case "b":
                    createNewLibro();
                    break;
                case "c":
                    updateLibro();
                    break;
                case "d":
                    deleteLibro();
                    break;
                case "e":
                    avanzamentoLettura();
                    break;
                case "f":
                    giudizioPersonale();
                    break;
                case "g":
                    importFromFile();
                    break;
                case "h":
                    exportToFile();
                    break;
                case "i":
                    System.out.println("Vuoi veramente uscire(si/no)");
                    String uscita = in.nextLine();
                    if(uscita.equals("si"))
                        esci = true;
                        System.out.println("Arrivederci");
                    break;
                default:
                    System.out.println("\n\nScelta non presente nel menu, riprova");
                    break;
            }

        }
        repository.writeToFile("RepositoryLibro.ser");
    }
}

