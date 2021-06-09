package ires.corso.partone;
import java.util.Scanner;

public class LoopTestTwo {
        public static void main(String[] args){
            int i, j, n;
            int contSpace;
            int contStars=1;

            Scanner in = new Scanner(System.in);
            System.out.println("Inserisci un numero: ");
            n = in.nextInt();


            for(i=1; i<=n; i++) {

                computeAndPrint(i, n);
            }

            for(i=n-1 ; i>=1; i--){

                computeAndPrint(i,n);
            }
        }

        public static void computeAndPrint(int lineIndex,int diamondSize){
            int indexSpace = diamondSize - lineIndex;
            int indexChar = (lineIndex * 2)-1;

            printStars(indexSpace, indexChar);
        }

        public static void printStars(int sp, int st){
            for(int j=1; j<=sp; j++){
                System.out.print(" ");
            }

            printNumber(st);

            System.out.println("");
        }

        public static void printNumber(int st) {
            int contD = (st/2) +1;
            int contC = 2;

            for (int j = 1; j <= st; j++) {

                if (contD > 0) {
                    System.out.print(contD);
                    contD--;
                } else {
                    System.out.print(contC);
                    contC++;
                }
            }
        }
}
