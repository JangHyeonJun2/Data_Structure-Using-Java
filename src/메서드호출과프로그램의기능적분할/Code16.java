package 메서드호출과프로그램의기능적분할;

import java.util.Scanner;

public class Code16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int result = power(num1,num2);

        System.out.println(result);





        sc.close();
    }
    static int power(int n1,int n2){

        int prod = 1;
        for (int i=0; i<n2; i++){
            prod *= n1;
        }
        return prod;
    }

}
