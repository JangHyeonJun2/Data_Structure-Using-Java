package 변수_배열_반복문;

import java.util.Scanner;

public class Code12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] data = new int[num];

        for(int i=0; i<data.length; i++){
            data[i] = sc.nextInt();
        }
        int max = 0;
        for(int i=0; i<data.length; i++){
            for(int j=i; j<data.length; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum+=data[k];
                }
                if(sum > max)
                    max = sum;
            }
        }
        System.out.println(max);
    }
}
