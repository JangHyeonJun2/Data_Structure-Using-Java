package 변수_배열_반복문;

import java.util.Scanner;

public class Code3 {
    public static void main(String[] args) {
        String str = "Hello World";
        String input = null;

        Scanner sb = new Scanner(System.in);

        System.out.print("Please enter a String: ");

        input = sb.nextLine();

        if(str.equals(input)){
            System.out.println("String match!");
        }else {
            System.out.println("String do not match!");
        }

        sb.close();
    }
}
