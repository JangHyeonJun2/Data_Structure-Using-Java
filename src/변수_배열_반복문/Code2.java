package 변수_배열_반복문;

import java.util.Scanner;

public class Code2 {
    public static void main(String[] args) {
        int number = 123;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter an integer: ");

        int input = keyboard.nextInt();

        if(input == number)
            System.out.println("Numbers match! :-");
        else
            System.out.println("Number do not match! :-(");

        keyboard.close();
    }
}
