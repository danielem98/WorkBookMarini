package ires.corso.parttwo.todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static ires.corso.parttwo.todo.ToDoRepository.*;

// GRUPPO 1:
public class ToDoList
{
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia a un metodo di ToDoRepository per avere una lista (= copia dei TO-DO
    // originali) dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile

    public static void viewByPriority() {
        // Questa funzione è chiamata qunado l'utente sceglie di visualizzare i dati per priorità...
        //ToDoRepository tdr = ToDoRepository.getToDoRepository();
        ArrayList<ToDo> ToDoListP = new ArrayList<>();
        ToDoListP = (ArrayList<ToDo>) getToDoList();

        Comparator<ToDo> compareByPriority = new Comparator<ToDo>() {
            @Override
            public int compare(ToDo t1, ToDo t2) {
                return t1.getPriorita().compareTo(t2.getPriorita());
            }
        };

        Collections.sort(ToDoListP, compareByPriority);
        ToDoListP.forEach(t -> System.out.println(t.prettyPrint()));
    }

    public static void viewByDate(){
        ArrayList<ToDo> ToDoList = new ArrayList<>();
        ToDoList = (ArrayList<ToDo>) getToDoList();

        Collections.sort(ToDoList,
                ((Comparator<ToDo>)(ToDo t1, ToDo t2) -> t1.getDataConsegna().compareTo(t2.getDataConsegna())));
        ToDoList.forEach(t -> System.out.println(t.prettyPrint()));

    }

    public static void viewByState(){
        ArrayList<ToDo> ToDoList = new ArrayList<>();
        ToDoList = (ArrayList<ToDo>) getToDoList();

        Comparator<ToDo> compareByStatus = new Comparator<ToDo>() {
            @Override
            public int compare(ToDo t1, ToDo t2) {
                return t1.getPriorita().compareTo(t2.getPriorita());
            }
        };

        Collections.sort(ToDoList, compareByStatus);
        ToDoList.forEach(t -> System.out.println(t.prettyPrint()));
    }
}
