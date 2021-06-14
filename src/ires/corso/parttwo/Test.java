package ires.corso.parttwo;
import java.util.Scanner;

import ires.corso.parttwo.classes.MasterShape;
import ires.corso.parttwo.classes.Triangolo;
import ires.corso.parttwo.classes.Quadrato;
import ires.corso.parttwo.classes.Trapezio;

public class Test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci i dati del trapezio ");
        System.out.print("Base maggiore: ");
        double tra1BM = in.nextDouble();
        System.out.print("Base minore: ");
        double tra1Bm = in.nextDouble();
        System.out.print("Altezza: ");
        double tra1H = in.nextDouble();
        System.out.print("Primo Lato: ");
        double tra1L1 = in.nextDouble();
        System.out.print("Secondo Lato: ");
        double tra1L2 = in.nextDouble();
        Trapezio tra1 = new Trapezio(tra1BM,tra1Bm,tra1H, tra1L1,tra1L2);
        //MasterShape tra1MS = (MasterShape) tra1;

        System.out.println("\nInserisci i dati del triangolo ");
        System.out.print("Base: ");
        double tri1B = in.nextDouble();
        System.out.print("Altezza: ");
        double tri1H = in.nextDouble();
        System.out.print("Primo lato: ");
        double tri1L1 = in.nextDouble();
        System.out.print("Secondo Lato: ");
        double tri1L2 = in.nextDouble();
        Triangolo tri1 = new Triangolo(tri1B,tri1H, tri1L1,tri1L2);
        //MasterShape tri1MS = (MasterShape) tri1;

        System.out.println("\nInserisci i dati del quadrato ");
        System.out.print("Lato: ");
        double q1L = in.nextDouble();
        Quadrato q1 = new Quadrato(q1L);
        //MasterShape q1MS = (MasterShape) q1;

        MasterShape[] MS = new MasterShape[3];
        MS[0] = tra1;
        MS[1] = tri1;
        MS[2] = q1;

        for(int i=0; i<MS.length; i++){
            MS[i].showArea();
        }
    }
}
