package 변수_배열_반복문;

import java.util.Scanner;

public class Code8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("만들 배열 숫자를 입력하세요: ");
        int n = sc.nextInt();
        int sum = 0;
        int max = 0;


        int[] data = new int[n];

        for(int i = 0;i<data.length;i++){
            System.out.print("숫자를 입력하세요 : ");
            data[i] = sc.nextInt();
        }

        for(int i=0;i<data.length;i++){
            sum += data[i];
            if(data[i] > max)
                max = data[i];
        }

        System.out.println("합: "+ sum);
        System.out.println("최댓값: "+max);



        sc.close();
    }
}
