package 변수_배열_반복문;

import java.util.Scanner;

public class Code9 {
    public static void main(String[] args) {
        int number = 0 ;


        Scanner sc = new Scanner(System.in);
        System.out.print("배열 숫자를 입려해주세요: ");
        number = sc.nextInt();
        int[] data = new int[number];

        for(int i=0; i < data.length; i++){
            System.out.print("데이터를 입력하세요: ");
            data[i] = sc.nextInt();
//            System.out.println();
//            System.out.print(data[i]+", ");
        }

        int tmp = data[number-1];
        for(int i=number-2; i >= 0; i--){
            data[i+1] = data[i];
        }
        data[0] = tmp;

        System.out.println();
        System.out.println("-------------------");

        for(int i = 0;i < data.length; i++){
            System.out.print(data[i]);
        }
    }
}
