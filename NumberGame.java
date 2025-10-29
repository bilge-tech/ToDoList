import java.util.Scanner;
import java.util.Random;


public class NumberGame{



    public static void main(String[]args){

        Random random = new Random();
        int r = random.nextInt(100);
        System.out.println(r);


        Scanner sc = new Scanner(System.in);
        System.out.print("Guess the number: ");
        int entered = sc.nextInt();

        while(true){
            if(entered==r){
                System.out.println("CORRECT YOU WİN");
                break;
            }
            else if(entered<r){
                System.out.println("Number is too low");

            }
            else{
                System.out.println("Number is too high");



            }
            System.out.print("Enter a new number:  ");
            int newNumber = sc.nextInt();
            entered=newNumber;

        }







        sc.close();

    }

}



