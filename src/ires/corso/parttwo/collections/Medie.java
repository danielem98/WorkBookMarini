package ires.corso.parttwo.collections;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Medie {

    public static void main(String[] args){

        Course c1 = new Course("Impero Romano","Storia"," ");
        Course c2 = new Course("Derivate","Matematica"," ");

        ArrayList<Course> courseList= new ArrayList<>();
        courseList.add(c1);
        courseList.add(c2);

        Assignment a1c1 = new Assignment("primo test di Storia"," ");
        Assignment a2c1 = new Assignment("secondo test di Storia"," ");

        Assignment a1c2 = new Assignment("primo test di Matematica"," ");
        Assignment a2c2 = new Assignment("secondo test di Matematica"," ");


        c1.getAssignment().put(a1c1, new HashMap<Student,Double>());
        c1.getAssignment().put(a2c1, new HashMap<Student,Double>());

        c2.getAssignment().put(a1c2, new HashMap<Student,Double>());
        c2.getAssignment().put(a2c2, new HashMap<Student,Double>());

        Student s1 = new Student("Albert", "Einstein", "123");
        Student s2 = new Student("Piero", "Angela", "456");

        //creo una lista di studenti
        ArrayList<Student> studentsList = new ArrayList<>();
        studentsList.add(s1);
        studentsList.add(s2);

        Random random = new Random();

        //creo la mappa dei voti
        HashMap<Student, Double> votes = new HashMap<>();

        /*
        for(Course c: courseList) {
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            //iterazione assignment
            for (Student s : studentsList) {

                for (Assignment as : c.getAssignment().keySet()) {
                    System.out.println("----------------------------------------------------------------------");
                    votes.put(s, random.nextDouble() * 10);
                    c.getAssignment().put(as, votes);
                    System.out.println(as.getTitolo());

                    System.out.println("Corso " + c.getTitolo() + " Lo studente " + s.getNome() + " Ha preso " + votes.get(s) + " nell' assignment " + as.getTitolo());
                }
            }
        }

         */


         /*
        //iterazione corsi
        for(Course c: courseList) {
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            //iterazione assignment
            for (Assignment as : c.getAssignment().keySet()) {
                System.out.println("----------------------------------------------------------------------");
                //Assegno a ogni studente un voto e lo inserisco nell mappa votes
                for (Student s : studentsList) {
                    votes.put(s, random.nextDouble()*10);
                    c.getAssignment().put(as, votes);
                    System.out.println(as.getTitolo());

                    System.out.println("Corso " +c.getTitolo()+" Lo studente " + s.getNome() + " Ha preso " + votes.get(s) + " nell' assignment " + as.getTitolo() );
                }
            }
        }

        Double media = 0.0;
        for(Course c: courseList) {
            System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            //iterazione assignment

            for (Student s : votes.keySet()) {
                media = 0.0;
                for (Assignment as : c.getAssignment().keySet()) {
                    System.out.println(as.getTitolo()+" " +s.getNome() +" "+ votes.get(s1));
                    media = votes.get(s) + media;


                }
                media= media/2;
                System.out.println("La media di " + s.getNome() + " e': " + media);
            }
        }

          */


    }


}
