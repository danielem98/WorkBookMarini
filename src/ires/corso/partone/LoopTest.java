package ires.corso.partone;

import java.util.Scanner;

public class LoopTest {
    public static void main(String[] args){
        int i,j,n;
        int c=1;

        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci il numero di righe: ");
        n = in.nextInt();

        for(i=1; i<=n; i++){
            for(j=1; j<=i; j++){
                System.out.print(c + " ");
                c++;
            }
            System.out.println("");
        }
    }
}
