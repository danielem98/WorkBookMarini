package ires.corso.parttwo.todo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// GRUPPO 3:
public class ToDoImportExport
{
    // Gestisce import/export da file
    // Mantiene i formati di import e di export (conversione da/verso stringa)
    private static String convertToString(ToDo t) {
        String conversione = String.format("%s;%s;%s;%s;%s;%s;%s", t.getId() , t.getTitolo(), t, t.getDescrizione(),
                t.getDataInserimento().toString(), t.getDataConsegna().toString(), t.getPriorita().toString(),
                t.getStato().toString());

        return conversione;
    }

    public static void exportToFile() throws IOException
    {
        System.out.println("Inserisci il nome del file su cui esportare: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        try (PrintWriter outputStream = new PrintWriter(new FileWriter(fileName)))
        {
            List<ToDo> toDoList = ToDoRepository.getToDoRepository().getToDoList();
            Iterator<ToDo> tdi = toDoList.iterator();

            while (tdi.hasNext()) {
                String sToDo = convertToString(tdi.next());
                outputStream.println(sToDo);
            }
        } catch (Exception e) {
        }
    }

    public static void importToFile() throws Exception {
        // Chiede all'utente un nome file di import...

        System.out.println("Inserisci il nome del file dal quale importare: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();

        ArrayList<String> fileLines = new ArrayList<>();

        try (BufferedReader inputStream = new BufferedReader(new FileReader(fileName))) {
            String l;
            while ((l = inputStream.readLine()) != null) {
                fileLines.add(l);
            }
        }

        // Loop di conversione da stringhe (linne file) a oggetti TO-DO
        // 1: conversione da linea del file a array di stringhe
        // 2: loop in cui:
        //    - si validano i campi (es. titolo non nullo, descriizone non nulla...)
        //    - si invoca il costruttore di ToDo passando i dati
        //     - Repository.add()
        // 3. Se qualcosa va male ==> output su schermop ("Ho saltato una riga per nome nullo...")
        // 4. alla fine: ho importato XYZ nuovi TOOD
        Iterator<String> itr = fileLines.iterator();
        int numToDo = 0;
        while(itr.hasNext()){
            String[] splitString = itr.next().split(";");


            String titolo = null;
            LocalDate dataConsegna = null;
            String descrizione = null;
            ToDo.Priorita priorita = null;
            ToDo.Stato stato = null;


            //controlli sui valori delle properties
            if(splitString[1] != null)
                titolo = splitString[1];
            else
                System.out.println("titolo nullo");

            if(splitString[3] != null)
                dataConsegna = LocalDate.parse(splitString[3]);
            else
                System.out.println("data di creazione nulla");

            if(splitString[4] != null)
                descrizione = splitString[4];
            else
                System.out.println("descrizione nulla");

            if(splitString[5].equals("ALTA")){
                priorita = ToDo.Priorita.ALTA;
            }
            else if(splitString[5].equals("MEDIA")){
                priorita = ToDo.Priorita.MEDIA;
            }
            else if(splitString[5].equals("BASSA")){
                priorita = ToDo.Priorita.BASSA;
            }
            else
                System.out.println("priorità non valida");

            if(splitString[6].equals("DA_FARE")){
                stato = ToDo.Stato.DA_FARE;
            }
            else if(splitString[6].equals("IN_ESECUZIONE")){
                stato = ToDo.Stato.IN_ESECUZIONE;
            }
            else if(splitString[6].equals("COMPLETATA")){
                stato = ToDo.Stato.COMPLETATA;
            }
            else if(splitString[6].equals("ANNULLATA")){
                stato = ToDo.Stato.ANNULLATA;
            }
            else
                System.out.println("stato non valido");

            ToDo importToDo = new ToDo(titolo,dataConsegna, descrizione,  priorita, stato);


            ToDoRepository.getToDoRepository().add(importToDo);
            numToDo++;
        }
        System.out.printf("nuovi ToDo importati: " +numToDo);
    }

}
