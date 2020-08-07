package 변수_배열_반복문;

import java.util.Scanner;

public class Code11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int[] data = new int[n];

        for(int i=0; i<data.length;i++){
            data[i] = sc.nextInt();
        }
        sc.close();

        for(int i=0; i<data.length; i++){
            for(int j=i+1; j<data.length; j++){
                if( data[i] == data[j])
                    count++;
            }
        }
        System.out.println(count);
    }
}
